

// 미접수 버튼 클릭 시 -> 처리중 상태로 변경하기
function changeReceiveStatus(event) {
  const contactNo = event.currentTarget.getAttribute('data-contactNo');
  const curProcessStat = event.currentTarget.getAttribute('data-processStat');
  console.log("contactNo : ", contactNo, "curProcessStat : ", curProcessStat);

  // confirm 진행
  const gogo = confirm("의뢰를 접수하시겠습니까?");

  // ㄱㄱ
  if (gogo) {
    fetch('/realtor/contact/updateContactProcess', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ contactNo, processStat: curProcessStat })
    })
    .then(response => response.json())  // JSON 응답을 기대
    .then(data => {
      if (data.success) {
        alert('업데이트가 완료되었습니다.');
        // 필요 시 페이지를 리로드하거나 다른 동작 수행
        window.location.reload();
      } else {
        alert(data.message || '업데이트 실패');
      }
    })
    .catch(error => {
      console.error('Error:', error);
    });
  }

  else {
    alert("의뢰가 접수되었습니다.");
  }
}

const notReceived = document.querySelectorAll('.notReceived');
const received = document.querySelectorAll('.received');
// 각 요소에 이벤트 리스너 추가
notReceived.forEach(item => {
  item.addEventListener('click', changeReceiveStatus);
});

received.forEach(item => {
  item.addEventListener('click', changeReceiveStatus);
});