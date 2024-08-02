// 모달 열기 및 닫기 스크립트
window.onload = function () {
  var modal = document.getElementById("myModal");
  var span = document.getElementsByClassName("close")[0];

  // 페이지 로드 시 모달 열기
  modal.style.display = "block";

  // 닫기 버튼 클릭 시 모달 닫기
  span.onclick = function () {
    modal.style.display = "none";
  }

  // 모달 외부 클릭 시 모달 닫기
  window.onclick = function (event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
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