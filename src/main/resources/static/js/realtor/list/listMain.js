// 모든 모달 닫기
function closeAllModals() {
  const modals = document.getElementsByClassName('modal');
  for (let i = 0; i < modals.length; i++) {
      modals[i].style.display = 'none';
  }
}

// 모달 열기
function openModal(modalId, triggerElement) {
  closeAllModals();  // 다른 모든 모달을 닫음
  const modal = document.getElementById(modalId);
  modal.style.display = 'block';
  
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
