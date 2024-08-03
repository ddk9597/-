// ------------ 헤더에서 사용하는 기능 ---------- //

// 홈으로 이동하기
function toRealtorHome() {
  window.location.href = '/rMain';
}

// 매물 목록이동
function toAllList() {
  window.location.href = '/rMain/list';
}

// 문의하기 이동


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

// 중개사 회원 : 매물등록페이지로 이동하기
function toRegisterProperty() {
  fetch('/rMain/product/register', {
      method: 'GET',
      credentials: 'include' // 세션 정보가 포함된 요청을 보냅니다.
  })
  .then(response => {
      if (!response.ok) {
          if (response.status === 401) {
              alert("로그인이 필요합니다.");
          } else if (response.status === 403) {
              alert("중개사 회원만 이용 가능합니다.");
          } else {
              alert("오류가 발생했습니다. 다시 시도해 주세요.");
          }
          throw new Error('Network response was not ok');
      }
      return response.text();
  })
  .then(html => {
      document.open();
      document.write(html);
      document.close();
  })
  .catch(error => {
      console.error('fetch 과정에서 오류 발생:', error);
  });
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