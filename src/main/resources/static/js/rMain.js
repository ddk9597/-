
// 현재 날짜를 기준으로 하루 동안 저장하는 함수
function setModalDontShowToday() {
  const now = new Date();
  const tomorrow = new Date();
  tomorrow.setDate(now.getDate() + 1); // 현재 날짜에 하루를 더함
  localStorage.setItem('dontShowModal', tomorrow.getTime()); // 종료 시간 저장
}

// 모달 열기
function openModal() {
  const dontShowModal = localStorage.getItem('dontShowModal');

  if (dontShowModal && new Date().getTime() < dontShowModal) {
    // '오늘 하루 열지 않기'가 설정된 경우 모달을 열지 않음
    return;
  }

  const modal = document.getElementById('myModal');
  modal.style.display = 'block';
}

// 모달 닫기
function closeModal() {
  const modal = document.getElementById('myModal');
  modal.style.display = 'none';
}

// DOM이 로드된 후 모달 열기 설정
document.addEventListener('DOMContentLoaded', (event) => {
  openModal();

  const closeBtn = document.querySelector('.close');
  const dontShowTodayBtn = document.getElementById('dontShowToday');

  // X 버튼 클릭 시 모달 닫기
  closeBtn.addEventListener('click', closeModal);

  // "오늘 하루 열지 않기" 버튼 클릭 시 모달 닫고 localStorage에 값 저장
  dontShowTodayBtn.addEventListener('click', () => {
    setModalDontShowToday();
    closeModal();
  });
});


