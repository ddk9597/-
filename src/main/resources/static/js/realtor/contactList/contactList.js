function changeReceiveStatus(event) {
  const contactNo = event.currentTarget.getAttribute('data-contactNo');
  fetch('/realtor/contact/updateContactProcess?contactNo=' + contactNo, {
    method: 'PUT', 
    headers: { "Content-Type": "application/json" },
  })
    .then(response => {
      if (response.ok) {
        return response.json();
      }
      throw new Error('업데이트 실패');
    })
    .then(data => {
      console.log(data);
      // 페이지 새로 고침 또는 리다이렉트
      window.location.href = '/rMain/toContactList'; // 추가된 부분
    })
    .catch(error => {
      console.error("Error:", error);
    });
}
