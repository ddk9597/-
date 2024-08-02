// ------------ 헤더에서 사용하는 기능 ---------- //

// 홈으로 이동하기
function toRealtorHome(){
  window.location.href = '/rMain';
}

// 회원 가입 페이지로 이동하기
function toJoinRealtor() {
  window.location.href = '/rMain/member/join';
}

// 로그인 페이지로 이동하기
function toRealtorLogin() {
  window.location.href = '/rMain/member/login';
}

// 마이페이지로 이동하기
function toRealtorMyPage() {
  window.location.href = '/realtor/member/myPage'
}

function toAllList() {
  window.location.href = '/rMain/list';
}

// 로그아웃 기능
function toLogOut() {
  fetch('/rMain/member/logout', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    },
    redirect: 'follow'
  })
    .then(response => {
      if (response.redirected) {
        window.location.href = response.url;
      } else {
        // 로그아웃 실패 시 처리할 작업
        console.error('로그아웃 실패');
      }
    })
    .catch(error => {
      // 네트워크 에러 시 처리할 작업
      console.error('네트워크 에러:', error);
    });
}

// ------------ 헤더에서 사용하는 기능 ---------- //