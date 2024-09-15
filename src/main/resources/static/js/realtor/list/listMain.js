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
window.onclick = function (event) {
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

function openPremiumlModal(event) {
  openModal('premeiumModal', event.target);
}


// 전체 페이지네이션 관련 기능
document.addEventListener("DOMContentLoaded", function () {
  const itemsPerPage = 20; // 한 페이지에 표시할 상품 개수
  const maxPageNumbersToShow = 10; // 한 번에 표시할 페이지 번호 개수
  let currentPage = 1;    // 현재 페이지
  let currentPageGroup = 1; // 현재 페이지 번호 그룹
  const productList = document.querySelectorAll('.productInfo'); // 모든 상품
  const totalPages = Math.ceil(productList.length / itemsPerPage); // 총 페이지 수
  const totalPageGroups = Math.ceil(totalPages / maxPageNumbersToShow); // 총 페이지 번호 그룹 수

  // 페이지 번호를 표시하는 함수
  function renderPageNumbers() {
    const pageNumbersContainer = document.querySelector('.pageNumbers');
    pageNumbersContainer.innerHTML = ""; // 기존 번호를 초기화

    // 현재 페이지 그룹의 시작 번호와 끝 번호 계산
    const startPage = (currentPageGroup - 1) * maxPageNumbersToShow + 1;
    const endPage = Math.min(startPage + maxPageNumbersToShow - 1, totalPages);

    for (let i = startPage; i <= endPage; i++) {
      const pageNumber = document.createElement('span');
      pageNumber.textContent = i;
      pageNumber.classList.add('pageNumber');
      if (i === currentPage) {
        pageNumber.classList.add('active'); // 현재 페이지에 active 클래스 추가
      }
      pageNumber.addEventListener('click', () => goToPage(i)); // 페이지 번호 클릭 시 해당 페이지로 이동
      pageNumbersContainer.appendChild(pageNumber);
    }
  }

  function showPage(page) {
    // 모든 상품을 숨김
    productList.forEach((item, index) => {
      item.style.display = "none";
      // 현재 페이지에 해당하는 상품만 표시
      if (index >= (page - 1) * itemsPerPage && index < page * itemsPerPage) {
        item.style.display = "block";
      }
    });
  }

  // 페이지 이동 함수
  function goToPage(page) {
    if (page < 1) page = 1;
    if (page > totalPages) page = totalPages;
    currentPage = page;
    showPage(page);

    // 페이지 번호 그룹 변경 필요 시
    const groupStartPage = (currentPageGroup - 1) * maxPageNumbersToShow + 1;
    if (page < groupStartPage || page > groupStartPage + maxPageNumbersToShow - 1) {
      currentPageGroup = Math.ceil(page / maxPageNumbersToShow);
    }

    renderPageNumbers(); // 페이지를 이동할 때마다 페이지 번호를 다시 렌더링
  }

  // 페이지 그룹 이동 함수
  function goToPageGroup(group) {
    if (group < 1) group = 1;
    if (group > totalPageGroups) group = totalPageGroups;
    currentPageGroup = group;
    renderPageNumbers();
  }

  // 처음 페이지 로드 시 첫 페이지 및 첫 그룹 표시
  showPage(currentPage);
  renderPageNumbers(); // 페이지 번호 초기 렌더링

  // 다음 페이지 버튼 클릭 이벤트
  document.querySelector('.nextPage').addEventListener('click', () => {
    goToPage(currentPage + 1);
  });

  // 이전 페이지 버튼 클릭 이벤트
  document.querySelector('.prevPage').addEventListener('click', () => {
    goToPage(currentPage - 1);
  });

  // 다음 페이지 그룹 버튼 클릭 이벤트
  document.querySelector('.nextPageGroup').addEventListener('click', () => {
    goToPageGroup(currentPageGroup + 1);
  });

  // 이전 페이지 그룹 버튼 클릭 이벤트
  document.querySelector('.prevPageGroup').addEventListener('click', () => {
    goToPageGroup(currentPageGroup - 1);
  });
});


// --------- 상단 nav bar 관련 함수 --------- //




// --------- 매물 상세 조회 관련 함수 --------- //
const productInfo = document.querySelectorAll('.productInfo');

productInfo.forEach(item => {
  item.addEventListener('click', () => {
    let productNo = item.querySelector('.productNo span').innerText;

    // 클릭된 매물 번호를 clickedProductNo에 반영
    document.getElementById('clickedProductNo').innerText = productNo;

    console.log("클릭된 매물번호:", productNo);

    // 클릭된 매물 번호를 기준으로 fetch 진행하여 비동기로 정보 받아옴
    fetch('/realtor/list/getDetailInfo?productNo=' + productNo)
      .then(response => response.json())
      .then(data => {

        // console.log("data : ", data.note);

        document.getElementById('detailInfoUploader').innerText = data.memberNo;
        document.getElementById('detailInfoCategory').innerText = data.category;
        document.getElementById('detailInfoLocation').innerText = data.locationTitle;
        document.getElementById('detailInfoDeposit').innerText = data.deposit;
        document.getElementById('detailInfoRent').innerText = data.rent;
        document.getElementById('detailInfoAdminCost').innerText = data.adminCost;
        document.getElementById('detailInfoPremium').innerText = data.premium;
        document.getElementById('detailInfoNote').innerText = data.noteForCustomer;

      })
      .catch(error => console.error('Error:', error));

  });
});

/* ---------- 카카오 지도 관련 js ---------- */
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
  mapOption = {
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
  };

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption);

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();



// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울시 강동구 성내동 386-14', function (result, status) {

  


  // 정상적으로 검색이 완료됐으면 
  if (status === kakao.maps.services.Status.OK) {

    var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    // 결과값으로 받은 위치를 마커로 표시합니다
    var marker = new kakao.maps.Marker({
      map: map,
      position: coords
    });

    // 인포윈도우로 장소에 대한 설명을 표시합니다
    var infowindow = new kakao.maps.InfoWindow({
      content: '<div style="width:150px;text-align:center;padding:6px 0;">검색 장소</div>'
    });
    infowindow.open(map, marker);

    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    map.setCenter(coords);
  }
});