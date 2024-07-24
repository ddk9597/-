// 가짜 부동산 페이지 회원 가입 js


// 회원가입 유효성 검사하기

const checkJoin = {
  "memberName": false,
  "memberEmail": false,
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

// 3.4. 유효한 이메일 인증 보내기
const sendAuthKey = document.getElementById("sendAuthKey");



// 3. 비밀번호 유효성 검사

// 4. 회원 종류 유효성 검사

// 4.1. 중개업 종사자일 경우
// 4.1.1. 근무중인 중개업소 확인하기

//what is Going On?!!
