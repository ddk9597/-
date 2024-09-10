
const fileInput = document.getElementById('fileInput');
const uploadArea = document.getElementById('pictureUploadArea');
const uploadedPictureContainer = document.getElementById('uploadedPictureContainer');


// 파일 선택 핸들러
fileInput.addEventListener('change', (event) => {
  handleFiles(event.target.files);
});

// 파일 드래그 앤 드롭 핸들러
uploadArea.addEventListener('dragover', (event) => {
  event.preventDefault();
  uploadArea.classList.add('drag-over');
});

uploadArea.addEventListener('dragleave', () => {
  uploadArea.classList.remove('drag-over');
});

uploadArea.addEventListener('drop', (event) => {
  event.preventDefault();
  uploadArea.classList.remove('drag-over');
  handleFiles(event.dataTransfer.files);
});

// 파일 처리 함수
function handleFiles(files) {
  Array.from(files).forEach(file => {
    if (file.type.startsWith('image/')) {
      const reader = new FileReader();
      reader.onload = (e) => {
        const img = document.createElement('img');
        img.src = e.target.result;
        img.classList.add('uploadedPic');
        uploadedPictureContainer.appendChild(img);
      };
      reader.readAsDataURL(file);
    } else {
      alert('이미지 파일만 업로드할 수 있습니다.');
    }
  });
}