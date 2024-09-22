const notReceived = document.getElementById('notReceived');
notReceived.addEventListener('click', changeReceiveStatus);

function changeReceiveStatus(event) {
  const contactNo = event.currentTarget.getAttribute('data-contactNo');

  fetch(`/realtor/contact/updateContactProcess?contactNo=${contactNo}`, {
    method: 'PUT',
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
