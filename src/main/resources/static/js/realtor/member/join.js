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
  const inputEmail = e.target.value;

  if (inputEmail.trim().length == 0) {
    emailMessage.innerText = "이용 가능한 이메일을 입력하세요.";
    checkJoin.memberEmail = false;
    return;
  }

  const regExp = /^[a-zA-Z0-9._%+-]+@(naver\.com|gmail\.com|hanmail\.net)$/;

  if (!regExp.test(inputEmail)) {
    emailMessage.innerText = "올바른 이메일을 입력해주세요";
    checkJoin.memberEmail = false;
    return;
  }

  if (regExp.test(inputEmail)) {
    fetch("/realtor/member/checkEmail?memberEmail=" + inputEmail)
      .then(resp => resp.text())
      .then(count => {
        if (count == 1) {
          emailMessage.innerText = "이미 사용중인 이메일입니다.";
          checkJoin.memberEmail = false;
        } else {
          emailMessage.innerText = "사용 가능한 이메일입니다.";
          checkJoin.memberEmail = true;
        }
      }).catch(e => console.log(e));
  }
});

// 유효한 이메일에 인증 메세지 보내기
const sendAuthKey = document.getElementById("sendAuthKey");
const authKeyMessage = document.querySelector("#authKeyMessage");

// 인증번호 받기 버튼 클릭 시 메일로 인증번호 보내기
sendAuthKey.addEventListener("click", e => {
  if (!checkJoin.memberEmail) {
    alert("올바른 메일을 작성해 주세요");
    return;
  }

  fetch("/realtor/member/sendAuthKey", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify({ memberEmail: memberEmail.value, htmlName: "signUp" })
  }).then(resp => resp.text())
  .then(result => {
    if (result == 1) {
      console.log("인증번호 발송 성공");
    } else {
      console.log("인증번호 발송 실패..");
    }
  });
});

// 가입하기 버튼 클릭 시
const signUpForm = document.querySelector("#signUpForm");
signUpForm.addEventListener("submit", e => {
  e.preventDefault();

  if (!checkJoin.memberName || !checkJoin.memberEmail || !checkJoin.authKey || !checkJoin.memberPw || !checkJoin.memberKind) {
    alert("모든 필드를 올바르게 입력해 주세요.");
    return;
  }

  fetch("/realtor/member/signUp", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify({
      memberName: document.getElementById("memberName").value,
      memberPhone: document.getElementById("memberPhone").value,
      memberEmail: document.getElementById("memberEmail").value,
      memberPw: document.getElementById("password").value,
      memberKind: document.getElementById("memberKind").value
    })
  }).then(resp => resp.text())
  .then(result => {
    if (result == 1) {
      alert("회원 가입 성공");
      window.location.href = "/realtor/member/login";
    } else {
      alert("회원 가입 실패");
    }
  });
});
