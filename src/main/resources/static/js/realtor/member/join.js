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
const memberNameMessage = document.createElement("span");
memberNameMessage.className = "signUpMessage";
memberName.parentNode.appendChild(memberNameMessage);

memberName.addEventListener("input", e => {
  const inputName = e.target.value;
  const regExp = /^[가-힣]{2,}$/;

  if (regExp.test(inputName)) {
    memberNameMessage.innerText = "유효한 이름입니다.";
    memberNameMessage.style.color = "green";
    checkJoin.memberName = true;
  } else {
    memberNameMessage.innerText = "이름은 한글로 2글자 이상이어야 합니다.";
    memberNameMessage.style.color = "red";
    checkJoin.memberName = false;
  }
});

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
        if (count => 1) {
          emailMessage.innerText = "이미 사용중인 이메일입니다.";
          checkJoin.memberEmail = false;
        } else {
          emailMessage.innerText = "사용 가능한 이메일입니다.";
          checkJoin.memberEmail = true;
        }
      }).catch(e => console.log(e));
  }
});

// 3.유효한 이메일에 인증 메세지 보내기
const sendAuthKey = document.getElementById("sendAuthKey");
const authKeyMessage = document.querySelector("#authKeyMessage");
const timerElement = document.getElementById("timer");

let timerInterval;

// 타이머 함수
function startTimer(duration, display) {
  let timer = duration, minutes, seconds;
  timerInterval = setInterval(() => {
    minutes = parseInt(timer / 60, 10);
    seconds = parseInt(timer % 60, 10);

    minutes = minutes < 10 ? "0" + minutes : minutes;
    seconds = seconds < 10 ? "0" + seconds : seconds;

    display.textContent = minutes + ":" + seconds;

    if (--timer < 0) {
      clearInterval(timerInterval);
      display.textContent = "인증시간이 초과되었습니다.";
    }
  }, 1000);
}

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
      // 타이머 시작
      clearInterval(timerInterval);
      startTimer(300, timerElement); // 5분 (300초)
    } else {
      console.log("인증번호 발송 실패..");
    }
  });
});

// 인증하기 버튼 클릭 시
const checkAuthKeyBtn = document.getElementById("checkAuthKeyBtn");
checkAuthKeyBtn.addEventListener("click", e => {
  const inputAuthKey = document.getElementById("authKey").value;
  const memberEmailValue = memberEmail.value;

  if (inputAuthKey.trim().length === 0) {
    authKeyMessage.innerText = "인증번호를 입력해 주세요.";
    return;
  }

  fetch("/realtor/member/checkAuthKey", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify({ memberEmail: memberEmailValue, authKey: inputAuthKey })
  }).then(resp => resp.text())
  .then(result => {
    if (result == 1) {
      authKeyMessage.innerText = "인증에 성공했습니다.";
      checkJoin.authKey = true;
      clearInterval(timerInterval); // 타이머 정지
    } else {
      authKeyMessage.innerText = "인증번호가 일치하지 않습니다.";
      checkJoin.authKey = false;
    }
  });
});

// 4. 비밀번호와 비밀번호 확인 검사
const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirm-password");
const passwordMessage = document.createElement("span");
passwordMessage.className = "signUpMessage";
confirmPassword.parentNode.appendChild(passwordMessage);

function validatePassword() {
  if (password.value === confirmPassword.value) {
    passwordMessage.innerText = "비밀번호가 일치합니다.";
    passwordMessage.style.color = "green";
    checkJoin.memberPw = true;
  } else {
    passwordMessage.innerText = "비밀번호가 일치하지 않습니다.";
    passwordMessage.style.color = "red";
    checkJoin.memberPw = false;
  }
}

password.addEventListener("input", validatePassword);
confirmPassword.addEventListener("input", validatePassword);

// 5. 회원 종류 설정했는지 검사
const memberKind = document.getElementById("memberKind");
const memberKindMessage = document.createElement("span");
memberKindMessage.className = "signUpMessage";
memberKind.parentNode.appendChild(memberKindMessage);

memberKind.addEventListener("change", e => {
  if (memberKind.value === "99") {
    memberKindMessage.innerText = "회원 종류를 선택해 주세요.";
    memberKindMessage.style.color = "red";
    checkJoin.memberKind = false;
  } else {
    memberKindMessage.innerText = "";
    checkJoin.memberKind = true;
  }
});

// 가입하기 버튼 클릭 시
const signUpForm = document.querySelector("#signUpForm");
signUpForm.addEventListener("submit", e => {
  e.preventDefault(); // 기본 폼 제출 동작을 막음

  // 유효성 검사를 통과했는지 확인
  if (!checkJoin.memberName || !checkJoin.memberEmail || !checkJoin.authKey || !checkJoin.memberPw || !checkJoin.memberKind) {
    alert("모든 필드를 올바르게 입력해 주세요.");
    return;
  }

  // 회원 가입 요청
  fetch("/realtor/member/signUp", {
    method: "POST",
    headers: {"Content-Type": "application/json"},
    body: JSON.stringify({
      memberName: document.getElementById("memberName").value,
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
