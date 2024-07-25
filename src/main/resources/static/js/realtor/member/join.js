// 가짜 부동산 페이지 회원 가입 js


// 회원가입 유효성 검사하기

const checkJoin = {
  "memberName": false,
  "memberEmail": false,
  "authKey": false,
  "memberPw": false,
  "memberKind": false
}

// 1. 이름 유효성 검사
const memberName = document.getElementById("memberName");

// 2. 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");
memberEmail.addEventListener("input", e => {

  // 1) 입력된 이메일 값 얻어오기
  const inputEmail = e.target.value;

  // 2) 이메일이 입력되지 않은 경우 이메일 입력 알림 설정
  if (inputEmail.trim().length == 0) {
    alert("이용 가능한 이메일을 입력하세요.");
    return;
  }

  // 3) 이메일이 입력 된 경우

  // 3.1.) 이메일 정규식 검사
  const regExp = /^[a-zA-Z0-9._%+-]+@(naver\.com|gmail\.com|hanmail\.net)$/;

  // 3.2.) 정규식과 일치하지 않을 경우
  if (!regExp.test(inputEmail)) {
    emailMessage.innerText = "올바른 이메일을 입력해주세요";
    checkJoin.memberEmail = false;
    return;
  }

  // 3.3.) 유효한 이메일일 경우
  // 3.3.1. 이메일 중복검사 실행
  if (regExp.test(inputEmail)) {
    fetch("/realtor/member/checkEmail?memberEmail=" + inputEmail)
      .then(resp => resp.text())
      .then(count => {
        // count = 1 -> 중복
        if (count == 1) { // 중복일 경우
          emailMessage.innerText = "이미 사용중인 이메일입니다."
          checkJoin.memberEmail = false;
          return;
        }

        if (count == 0) { // 중복이 아닐 경우
          emailMessage.innerText = "사용 가능한 이메일입니다."
          checkJoin.memberEmail = true;
        }
      }).catch(e => {
        console.log(e);
      });
  }
});

// 3.4. 유효한 이메일에 인증 메세지 보내기
// 3.4.0. 필요한 변수 선언
const sendAuthKey = document.getElementById("sendAuthKey");
const authKey = document.querySelector("#authKey");
const authKeyMessage = document.querySelector("#authKeyMessage");

// 3.4.1. 타이머 설정
let authTimer;
let authMin = 4;
let authSec = 59;
const initTimeSet = "5:00"; // 맨 처음 화면에 보여질 숫자

// 실제 줄어드는 시간을 저장할 함수
let min = authMin;
let sec = authSec;

// 인증번호 받기 버튼 클릭 시 메일로 인증번호 보내기
sendAuthKey.addEventListener("click", e => {
  
  // checkJoin.memberEmail = false;
  document.querySelector("#emailMessage").innerText = "";

  // 유효한 메일 입력 시에만 확인 메일 전송하기
  if(!checkJoin.memberEmail){
    alert("올바른 메일을 작성해 주세요");
    return;
  }

  // 클릭 시 타이머 숫자 초기화
  min = initMin;	
	sec = initSec;	
	checkJoin.authKey = false; // 인증 유효성 검사 여부 false
  
  // 중복 클릭 시 이전 동작중인 제한시간 초기화\
  clearInterval(authTimer);

  // 비동기로 서버에서 메일 보내기
  fetch("/realtor/member/checkEmail", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body : memberEmail.value
  }).then(resp => resp.text())
  .then(result=>{
    if(result == 1){
      console.log("인증번호 발송 성공");
    } else{
      console.log("인증번호 발송 실패..");
    }
  })

})


// 3. 비밀번호 유효성 검사

// 4. 회원 종류 유효성 검사

// 4.1. 중개업 종사자일 경우
// 4.1.1. 근무중인 중개업소 확인하기

