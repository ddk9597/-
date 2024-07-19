    // 모달 열기 및 닫기 스크립트
    window.onload = function() {
        var modal = document.getElementById("myModal");
        var span = document.getElementsByClassName("close")[0];

        // 페이지 로드 시 모달 열기
        modal.style.display = "block";

        // 닫기 버튼 클릭 시 모달 닫기
        span.onclick = function() {
            modal.style.display = "none";
        }

        // 모달 외부 클릭 시 모달 닫기
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    }
