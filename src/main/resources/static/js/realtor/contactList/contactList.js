function changeReceiveStatus(event) {
  const contactNo = event.currentTarget.getAttribute('data-contactNo');
  console.log(contactNo);

  fetch(`/realtor/contact/updateContactProcess?contactNo=${contactNo}`, {
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

let notReceived = document.querySelectorAll('.notReceived');

// 각 요소에 이벤트 리스너 추가
notReceived.forEach(item => {
  item.addEventListener('click', changeReceiveStatus);
});
