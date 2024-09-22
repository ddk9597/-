

// 미접수 버튼 클릭 시 -> 처리중 상태로 변경하기
function changeReceiveStatus(event) {
  const contactNo = event.currentTarget.getAttribute('data-contactNo');
  const curProcessStat = event.currentTarget.getAttribute('data-processStat');
  console.log("contactNo : ", contactNo, "curProcessStat : ", curProcessStat);

  // confirm 진행
  const gogo = confirm("의뢰를 접수하시겠습니까?");

  // ㄱㄱ
  if (gogo) {
    fetch(`/realtor/contact/updateContactProcess?contactNo=${contactNo}&process=${curProcessStat}`, {
      method: 'POST',
      headers: { "Content-Type": "application/json" },
    })
      .then(response => { 
        if (response.ok) {
          return response.text();
        }
        throw new Error('업데이트 실패');
      })
      .then(data => {
        console.log(data);
      })
      .catch(error => {
        console.error("Error:", error);
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