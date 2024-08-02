// 모달 열기
function openModal(modalId, triggerElement) {
  const modal = document.getElementById(modalId);
  modal.style.display = 'block';
  
  // 모달을 트리거 요소 아래에 위치시킵니다.
  const rect = triggerElement.getBoundingClientRect();
  modal.style.top = rect.bottom + 'px';
  modal.style.left = rect.left + 'px';
}

// 모달 닫기
function closeModal(modalId) {
  document.getElementById(modalId).style.display = 'none';
}

// 모달 외부 클릭 시 닫기
window.onclick = function(event) {
  const modals = document.getElementsByClassName('modal');
  for (let i = 0; i < modals.length; i++) {
      if (event.target === modals[i]) {
          modals[i].style.display = 'none';
      }
  }
}

function openCostModal(event) {
  openModal('costModal', event.target);
}

function openAreaModal(event) {
  openModal('areaModal', event.target);
}

function openTypeModal(event) {
  openModal('typeModal', event.target);
}

function openDetailModal(event) {
  openModal('detailModal', event.target);
}
