// 법정동 코드와 법정동 이름
const areaData = [
  { code: 1100000000, name: '서울특별시' },
  { code: 1111000000, name: '서울특별시 종로구' },
  { code: 1111010100, name: '서울특별시 종로구 청운동' },
  { code: 1111010200, name: '서울특별시 종로구 신교동' },
  { code: 1111010300, name: '서울특별시 종로구 궁정동' },
  { code: 1111010400, name: '서울특별시 종로구 효자동' },
  { code: 1111010500, name: '서울특별시 종로구 창성동' },
  { code: 1111010600, name: '서울특별시 종로구 통의동' },
  { code: 1111010700, name: '서울특별시 종로구 적선동' },
  { code: 1111010800, name: '서울특별시 종로구 통인동' },
  { code: 1111010900, name: '서울특별시 종로구 누상동' },
  { code: 1111011000, name: '서울특별시 종로구 누하동' },
  { code: 1111011100, name: '서울특별시 종로구 옥인동' },
  { code: 1111011200, name: '서울특별시 종로구 체부동' },
  { code: 1111011300, name: '서울특별시 종로구 필운동' },
  { code: 1111011400, name: '서울특별시 종로구 내자동' },
  { code: 1111011500, name: '서울특별시 종로구 사직동' },
  { code: 1111011600, name: '서울특별시 종로구 도렴동' },
  { code: 1111011700, name: '서울특별시 종로구 당주동' },
  { code: 1111011800, name: '서울특별시 종로구 내수동' },
  { code: 1111011900, name: '서울특별시 종로구 세종로' },
  { code: 1111012000, name: '서울특별시 종로구 신문로1가' },
  { code: 1111012100, name: '서울특별시 종로구 신문로2가' },
  { code: 1111012200, name: '서울특별시 종로구 청진동' },
  { code: 1111012300, name: '서울특별시 종로구 서린동' },
  { code: 1111012400, name: '서울특별시 종로구 수송동' },
  { code: 1111012500, name: '서울특별시 종로구 중학동' },
  { code: 1111012600, name: '서울특별시 종로구 종로1가' },
  { code: 1111012700, name: '서울특별시 종로구 공평동' },
  { code: 1111012800, name: '서울특별시 종로구 관훈동' },
  { code: 1111012900, name: '서울특별시 종로구 견지동' },
  { code: 1111013000, name: '서울특별시 종로구 와룡동' },
  { code: 1111013100, name: '서울특별시 종로구 권농동' },
  { code: 1111013200, name: '서울특별시 종로구 운니동' },
  { code: 1111013300, name: '서울특별시 종로구 익선동' },
  { code: 1111013400, name: '서울특별시 종로구 경운동' },
  { code: 1111013500, name: '서울특별시 종로구 관철동' },
  { code: 1111013600, name: '서울특별시 종로구 인사동' },
  { code: 1111013700, name: '서울특별시 종로구 낙원동' },
  { code: 1111013800, name: '서울특별시 종로구 종로2가' },
  { code: 1111013900, name: '서울특별시 종로구 팔판동' },
  { code: 1111014000, name: '서울특별시 종로구 삼청동' },
  { code: 1111014100, name: '서울특별시 종로구 안국동' },
  { code: 1111014200, name: '서울특별시 종로구 소격동' },
  { code: 1111014300, name: '서울특별시 종로구 화동' },
  { code: 1111014400, name: '서울특별시 종로구 사간동' },
  { code: 1111014500, name: '서울특별시 종로구 송현동' },
  { code: 1111014600, name: '서울특별시 종로구 가회동' },
  { code: 1111014700, name: '서울특별시 종로구 재동' },
  { code: 1111014800, name: '서울특별시 종로구 계동' },
  { code: 1111014900, name: '서울특별시 종로구 원서동' },
  { code: 1111015000, name: '서울특별시 종로구 훈정동' },
  { code: 1111015100, name: '서울특별시 종로구 묘동' },
  { code: 1111015200, name: '서울특별시 종로구 봉익동' },
  { code: 1111015300, name: '서울특별시 종로구 돈의동' },
  { code: 1111015400, name: '서울특별시 종로구 장사동' },
  { code: 1111015500, name: '서울특별시 종로구 관수동' },
  { code: 1111015600, name: '서울특별시 종로구 종로3가' },
  { code: 1111015700, name: '서울특별시 종로구 인의동' },
  { code: 1111015800, name: '서울특별시 종로구 예지동' },
  { code: 1111015900, name: '서울특별시 종로구 원남동' },
  { code: 1111016000, name: '서울특별시 종로구 연지동' },
  { code: 1111016100, name: '서울특별시 종로구 종로4가' },
  { code: 1111016200, name: '서울특별시 종로구 효제동' },
  { code: 1111016300, name: '서울특별시 종로구 종로5가' },
  { code: 1111016400, name: '서울특별시 종로구 종로6가' },
  { code: 1111016500, name: '서울특별시 종로구 이화동' },
  { code: 1111016600, name: '서울특별시 종로구 연건동' },
  { code: 1111016700, name: '서울특별시 종로구 충신동' },
  { code: 1111016800, name: '서울특별시 종로구 동숭동' },
  { code: 1111016900, name: '서울특별시 종로구 혜화동' },
  { code: 1111017000, name: '서울특별시 종로구 명륜1가' },
  { code: 1111017100, name: '서울특별시 종로구 명륜2가' },
  { code: 1111017200, name: '서울특별시 종로구 명륜4가' },
  { code: 1111017300, name: '서울특별시 종로구 명륜3가' },
  { code: 1111017400, name: '서울특별시 종로구 창신동' },
  { code: 1111017500, name: '서울특별시 종로구 숭인동' },
  { code: 1111017600, name: '서울특별시 종로구 교남동' },
  { code: 1111017700, name: '서울특별시 종로구 평동' },
  { code: 1111017800, name: '서울특별시 종로구 송월동' },
  { code: 1111017900, name: '서울특별시 종로구 홍파동' },
  { code: 1111018000, name: '서울특별시 종로구 교북동' },
  { code: 1111018100, name: '서울특별시 종로구 행촌동' },
  { code: 1111018200, name: '서울특별시 종로구 구기동' },
  { code: 1111018300, name: '서울특별시 종로구 평창동' },
  { code: 1111018400, name: '서울특별시 종로구 부암동' },
  { code: 1111018500, name: '서울특별시 종로구 홍지동' },
  { code: 1111018600, name: '서울특별시 종로구 신영동' },
  { code: 1111018700, name: '서울특별시 종로구 무악동' },
  { code: 1114000000, name: '서울특별시 중구' },
  { code: 1114010100, name: '서울특별시 중구 무교동' },
  { code: 1114010200, name: '서울특별시 중구 다동' },
  { code: 1114010300, name: '서울특별시 중구 태평로1가' },
  { code: 1114010400, name: '서울특별시 중구 을지로1가' },
  { code: 1114010500, name: '서울특별시 중구 을지로2가' },
  { code: 1114010600, name: '서울특별시 중구 남대문로1가' },
  { code: 1114010700, name: '서울특별시 중구 삼각동' },
  { code: 1114010800, name: '서울특별시 중구 수하동' },
  { code: 1114010900, name: '서울특별시 중구 장교동' },
  { code: 1114011000, name: '서울특별시 중구 수표동' },
  { code: 1114011100, name: '서울특별시 중구 소공동' },
  { code: 1114011200, name: '서울특별시 중구 남창동' },
  { code: 1114011300, name: '서울특별시 중구 북창동' },
  { code: 1114011400, name: '서울특별시 중구 태평로2가' },
  { code: 1114011500, name: '서울특별시 중구 남대문로2가' },
  { code: 1114011600, name: '서울특별시 중구 남대문로3가' },
  { code: 1114011700, name: '서울특별시 중구 남대문로4가' },
  { code: 1114011800, name: '서울특별시 중구 남대문로5가' },
  { code: 1114011900, name: '서울특별시 중구 봉래동1가' },
  { code: 1114012000, name: '서울특별시 중구 봉래동2가' },
  { code: 1114012100, name: '서울특별시 중구 회현동1가' },
  { code: 1114012200, name: '서울특별시 중구 회현동2가' },
  { code: 1114012300, name: '서울특별시 중구 회현동3가' },
  { code: 1114012400, name: '서울특별시 중구 충무로1가' },
  { code: 1114012500, name: '서울특별시 중구 충무로2가' },
  { code: 1114012600, name: '서울특별시 중구 명동1가' },
  { code: 1114012700, name: '서울특별시 중구 명동2가' },
  { code: 1114012800, name: '서울특별시 중구 남산동1가' },
  { code: 1114012900, name: '서울특별시 중구 남산동2가' },
  { code: 1114013000, name: '서울특별시 중구 남산동3가' },
  { code: 1114013100, name: '서울특별시 중구 저동1가' },
  { code: 1114013200, name: '서울특별시 중구 충무로4가' },
  { code: 1114013300, name: '서울특별시 중구 충무로5가' },
  { code: 1114013400, name: '서울특별시 중구 인현동2가' },
  { code: 1114013500, name: '서울특별시 중구 예관동' },
  { code: 1114013600, name: '서울특별시 중구 묵정동' },
  { code: 1114013700, name: '서울특별시 중구 필동1가' },
  { code: 1114013800, name: '서울특별시 중구 필동2가' },
  { code: 1114013900, name: '서울특별시 중구 필동3가' },
  { code: 1114014000, name: '서울특별시 중구 남학동' },
  { code: 1114014100, name: '서울특별시 중구 주자동' },
  { code: 1114014200, name: '서울특별시 중구 예장동' },
  { code: 1114014300, name: '서울특별시 중구 장충동1가' },
  { code: 1114014400, name: '서울특별시 중구 장충동2가' },
  { code: 1114014500, name: '서울특별시 중구 광희동1가' },
  { code: 1114014600, name: '서울특별시 중구 광희동2가' },
  { code: 1114014700, name: '서울특별시 중구 쌍림동' },
  { code: 1114014800, name: '서울특별시 중구 을지로6가' },
  { code: 1114014900, name: '서울특별시 중구 을지로7가' },
  { code: 1114015000, name: '서울특별시 중구 을지로4가' },
  { code: 1114015100, name: '서울특별시 중구 을지로5가' },
  { code: 1114015200, name: '서울특별시 중구 주교동' },
  { code: 1114015300, name: '서울특별시 중구 방산동' },
  { code: 1114015400, name: '서울특별시 중구 오장동' },
  { code: 1114015500, name: '서울특별시 중구 을지로3가' },
  { code: 1114015600, name: '서울특별시 중구 입정동' },
  { code: 1114015700, name: '서울특별시 중구 산림동' },
  { code: 1114015800, name: '서울특별시 중구 충무로3가' },
  { code: 1114015900, name: '서울특별시 중구 초동' },
  { code: 1114016000, name: '서울특별시 중구 인현동1가' },
  { code: 1114016100, name: '서울특별시 중구 저동2가' },
  { code: 1114016200, name: '서울특별시 중구 신당동' },
  { code: 1114016300, name: '서울특별시 중구 흥인동' },
  { code: 1114016400, name: '서울특별시 중구 무학동' },
  { code: 1114016500, name: '서울특별시 중구 황학동' },
  { code: 1114016600, name: '서울특별시 중구 서소문동' },
  { code: 1114016700, name: '서울특별시 중구 정동' },
  { code: 1114016800, name: '서울특별시 중구 순화동' },
  { code: 1114016900, name: '서울특별시 중구 의주로1가' },
  { code: 1114017000, name: '서울특별시 중구 충정로1가' },
  { code: 1114017100, name: '서울특별시 중구 중림동' },
  { code: 1114017200, name: '서울특별시 중구 의주로2가' },
  { code: 1114017300, name: '서울특별시 중구 만리동1가' },
  { code: 1114017400, name: '서울특별시 중구 만리동2가' },
  { code: 1117000000, name: '서울특별시 용산구' },
  { code: 1117010100, name: '서울특별시 용산구 후암동' },
  { code: 1117010200, name: '서울특별시 용산구 용산동2가' },
  { code: 1117010300, name: '서울특별시 용산구 용산동4가' },
  { code: 1117010400, name: '서울특별시 용산구 갈월동' },
  { code: 1117010500, name: '서울특별시 용산구 남영동' },
  { code: 1117010600, name: '서울특별시 용산구 용산동1가' },
  { code: 1117010700, name: '서울특별시 용산구 동자동' },
  { code: 1117010800, name: '서울특별시 용산구 서계동' },
  { code: 1117010900, name: '서울특별시 용산구 청파동1가' },
  { code: 1117011000, name: '서울특별시 용산구 청파동2가' },
  { code: 1117011100, name: '서울특별시 용산구 청파동3가' },
  { code: 1117011200, name: '서울특별시 용산구 원효로1가' },
  { code: 1117011300, name: '서울특별시 용산구 원효로2가' },
  { code: 1117011400, name: '서울특별시 용산구 신창동' },
  { code: 1117011500, name: '서울특별시 용산구 산천동' },
  { code: 1117011600, name: '서울특별시 용산구 청암동' },
  { code: 1117011700, name: '서울특별시 용산구 원효로3가' },
  { code: 1117011800, name: '서울특별시 용산구 원효로4가' },
  { code: 1117011900, name: '서울특별시 용산구 효창동' },
  { code: 1117012000, name: '서울특별시 용산구 도원동' },
  { code: 1117012100, name: '서울특별시 용산구 용문동' },
  { code: 1117012200, name: '서울특별시 용산구 문배동' },
  { code: 1117012300, name: '서울특별시 용산구 신계동' },
  { code: 1117012400, name: '서울특별시 용산구 한강로1가' },
  { code: 1117012500, name: '서울특별시 용산구 한강로2가' },
  { code: 1117012600, name: '서울특별시 용산구 용산동3가' },
  { code: 1117012700, name: '서울특별시 용산구 용산동5가' },
  { code: 1117012800, name: '서울특별시 용산구 한강로3가' },
  { code: 1117012900, name: '서울특별시 용산구 이촌동' },
  { code: 1117013000, name: '서울특별시 용산구 이태원동' },
  { code: 1117013100, name: '서울특별시 용산구 한남동' },
  { code: 1117013200, name: '서울특별시 용산구 동빙고동' },
  { code: 1117013300, name: '서울특별시 용산구 서빙고동' },
  { code: 1117013400, name: '서울특별시 용산구 주성동' },
  { code: 1117013500, name: '서울특별시 용산구 용산동6가' },
  { code: 1117013600, name: '서울특별시 용산구 보광동' },
  { code: 1120000000, name: '서울특별시 성동구' },
  { code: 1120010100, name: '서울특별시 성동구 상왕십리동' },
  { code: 1120010200, name: '서울특별시 성동구 하왕십리동' },
  { code: 1120010300, name: '서울특별시 성동구 홍익동' },
  { code: 1120010400, name: '서울특별시 성동구 도선동' },
  { code: 1120010500, name: '서울특별시 성동구 마장동' },
  { code: 1120010600, name: '서울특별시 성동구 사근동' },
  { code: 1120010700, name: '서울특별시 성동구 행당동' },
  { code: 1120010800, name: '서울특별시 성동구 응봉동' },
  { code: 1120010900, name: '서울특별시 성동구 금호동1가' },
  { code: 1120011000, name: '서울특별시 성동구 금호동2가' },
  { code: 1120011100, name: '서울특별시 성동구 금호동3가' },
  { code: 1120011200, name: '서울특별시 성동구 금호동4가' },
  { code: 1120011300, name: '서울특별시 성동구 옥수동' },
  { code: 1120011400, name: '서울특별시 성동구 성수동1가' },
  { code: 1120011500, name: '서울특별시 성동구 성수동2가' },
  { code: 1120011800, name: '서울특별시 성동구 송정동' },
  { code: 1120012200, name: '서울특별시 성동구 용답동' },
  { code: 1121500000, name: '서울특별시 광진구' },
  { code: 1121510100, name: '서울특별시 광진구 중곡동' },
  { code: 1121510200, name: '서울특별시 광진구 능동' },
  { code: 1121510300, name: '서울특별시 광진구 구의동' },
  { code: 1121510400, name: '서울특별시 광진구 광장동' },
  { code: 1121510500, name: '서울특별시 광진구 자양동' },
  { code: 1121510700, name: '서울특별시 광진구 화양동' },
  { code: 1121510900, name: '서울특별시 광진구 군자동' },
  { code: 1123000000, name: '서울특별시 동대문구' },
  { code: 1123010100, name: '서울특별시 동대문구 신설동' },
  { code: 1123010200, name: '서울특별시 동대문구 용두동' },
  { code: 1123010300, name: '서울특별시 동대문구 제기동' },
  { code: 1123010400, name: '서울특별시 동대문구 전농동' },
  { code: 1123010500, name: '서울특별시 동대문구 답십리동' },
  { code: 1123010600, name: '서울특별시 동대문구 장안동' },
  { code: 1123010700, name: '서울특별시 동대문구 청량리동' },
  { code: 1123010800, name: '서울특별시 동대문구 회기동' },
  { code: 1123010900, name: '서울특별시 동대문구 휘경동' },
  { code: 1123011000, name: '서울특별시 동대문구 이문동' },
  { code: 1126000000, name: '서울특별시 중랑구' },
  { code: 1126010100, name: '서울특별시 중랑구 면목동' },
  { code: 1126010200, name: '서울특별시 중랑구 상봉동' },
  { code: 1126010300, name: '서울특별시 중랑구 중화동' },
  { code: 1126010400, name: '서울특별시 중랑구 묵동' },
  { code: 1126010500, name: '서울특별시 중랑구 망우동' },
  { code: 1126010600, name: '서울특별시 중랑구 신내동' },
  { code: 1129000000, name: '서울특별시 성북구' },
  { code: 1129010100, name: '서울특별시 성북구 성북동' },
  { code: 1129010200, name: '서울특별시 성북구 성북동1가' },
  { code: 1129010300, name: '서울특별시 성북구 돈암동' },
  { code: 1129010400, name: '서울특별시 성북구 동소문동1가' },
  { code: 1129010500, name: '서울특별시 성북구 동소문동2가' },
  { code: 1129010600, name: '서울특별시 성북구 동소문동3가' },
  { code: 1129010700, name: '서울특별시 성북구 동소문동4가' },
  { code: 1129010800, name: '서울특별시 성북구 동소문동5가' },
  { code: 1129010900, name: '서울특별시 성북구 동소문동6가' },
  { code: 1129011000, name: '서울특별시 성북구 동소문동7가' },
  { code: 1129011100, name: '서울특별시 성북구 삼선동1가' },
  { code: 1129011200, name: '서울특별시 성북구 삼선동2가' },
  { code: 1129011300, name: '서울특별시 성북구 삼선동3가' },
  { code: 1129011400, name: '서울특별시 성북구 삼선동4가' },
  { code: 1129011500, name: '서울특별시 성북구 삼선동5가' },
  { code: 1129011600, name: '서울특별시 성북구 동선동1가' },
  { code: 1129011700, name: '서울특별시 성북구 동선동2가' },
  { code: 1129011800, name: '서울특별시 성북구 동선동3가' },
  { code: 1129011900, name: '서울특별시 성북구 동선동4가' },
  { code: 1129012000, name: '서울특별시 성북구 동선동5가' },
  { code: 1129012100, name: '서울특별시 성북구 안암동1가' },
  { code: 1129012200, name: '서울특별시 성북구 안암동2가' },
  { code: 1129012300, name: '서울특별시 성북구 안암동3가' },
  { code: 1129012400, name: '서울특별시 성북구 안암동4가' },
  { code: 1129012500, name: '서울특별시 성북구 안암동5가' },
  { code: 1129012600, name: '서울특별시 성북구 보문동4가' },
  { code: 1129012700, name: '서울특별시 성북구 보문동5가' },
  { code: 1129012800, name: '서울특별시 성북구 보문동6가' },
  { code: 1129012900, name: '서울특별시 성북구 보문동7가' },
  { code: 1129013000, name: '서울특별시 성북구 보문동1가' },
  { code: 1129013100, name: '서울특별시 성북구 보문동2가' },
  { code: 1129013200, name: '서울특별시 성북구 보문동3가' },
  { code: 1129013300, name: '서울특별시 성북구 정릉동' },
  { code: 1129013400, name: '서울특별시 성북구 길음동' },
  { code: 1129013500, name: '서울특별시 성북구 종암동' },
  { code: 1129013600, name: '서울특별시 성북구 하월곡동' },
  { code: 1129013700, name: '서울특별시 성북구 상월곡동' },
  { code: 1129013800, name: '서울특별시 성북구 장위동' },
  { code: 1129013900, name: '서울특별시 성북구 석관동' },
  { code: 1130500000, name: '서울특별시 강북구' },
  { code: 1130510100, name: '서울특별시 강북구 미아동' },
  { code: 1130510200, name: '서울특별시 강북구 번동' },
  { code: 1130510300, name: '서울특별시 강북구 수유동' },
  { code: 1130510400, name: '서울특별시 강북구 우이동' },
  { code: 1132000000, name: '서울특별시 도봉구' },
  { code: 1132010500, name: '서울특별시 도봉구 쌍문동' },
  { code: 1132010600, name: '서울특별시 도봉구 방학동' },
  { code: 1132010700, name: '서울특별시 도봉구 창동' },
  { code: 1132010800, name: '서울특별시 도봉구 도봉동' },
  { code: 1135000000, name: '서울특별시 노원구' },
  { code: 1135010200, name: '서울특별시 노원구 월계동' },
  { code: 1135010300, name: '서울특별시 노원구 공릉동' },
  { code: 1135010400, name: '서울특별시 노원구 하계동' },
  { code: 1135010500, name: '서울특별시 노원구 상계동' },
  { code: 1135010600, name: '서울특별시 노원구 중계동' },
  { code: 1138000000, name: '서울특별시 은평구' },
  { code: 1138010100, name: '서울특별시 은평구 수색동' },
  { code: 1138010200, name: '서울특별시 은평구 녹번동' },
  { code: 1138010300, name: '서울특별시 은평구 불광동' },
  { code: 1138010400, name: '서울특별시 은평구 갈현동' },
  { code: 1138010500, name: '서울특별시 은평구 구산동' },
  { code: 1138010600, name: '서울특별시 은평구 대조동' },
  { code: 1138010700, name: '서울특별시 은평구 응암동' },
  { code: 1138010800, name: '서울특별시 은평구 역촌동' },
  { code: 1138010900, name: '서울특별시 은평구 신사동' },
  { code: 1138011000, name: '서울특별시 은평구 증산동' },
  { code: 1138011400, name: '서울특별시 은평구 진관동' },
  { code: 1141000000, name: '서울특별시 서대문구' },
  { code: 1141010100, name: '서울특별시 서대문구 충정로2가' },
  { code: 1141010200, name: '서울특별시 서대문구 충정로3가' },
  { code: 1141010300, name: '서울특별시 서대문구 합동' },
  { code: 1141010400, name: '서울특별시 서대문구 미근동' },
  { code: 1141010500, name: '서울특별시 서대문구 냉천동' },
  { code: 1141010600, name: '서울특별시 서대문구 천연동' },
  { code: 1141010700, name: '서울특별시 서대문구 옥천동' },
  { code: 1141010800, name: '서울특별시 서대문구 영천동' },
  { code: 1141010900, name: '서울특별시 서대문구 현저동' },
  { code: 1141011000, name: '서울특별시 서대문구 북아현동' },
  { code: 1141011100, name: '서울특별시 서대문구 홍제동' },
  { code: 1141011200, name: '서울특별시 서대문구 대현동' },
  { code: 1141011300, name: '서울특별시 서대문구 대신동' },
  { code: 1141011400, name: '서울특별시 서대문구 신촌동' },
  { code: 1141011500, name: '서울특별시 서대문구 봉원동' },
  { code: 1141011600, name: '서울특별시 서대문구 창천동' },
  { code: 1141011700, name: '서울특별시 서대문구 연희동' },
  { code: 1141011800, name: '서울특별시 서대문구 홍은동' },
  { code: 1141011900, name: '서울특별시 서대문구 북가좌동' },
  { code: 1141012000, name: '서울특별시 서대문구 남가좌동' },
  { code: 1144000000, name: '서울특별시 마포구' },
  { code: 1144010100, name: '서울특별시 마포구 아현동' },
  { code: 1144010200, name: '서울특별시 마포구 공덕동' },
  { code: 1144010300, name: '서울특별시 마포구 신공덕동' },
  { code: 1144010400, name: '서울특별시 마포구 도화동' },
  { code: 1144010500, name: '서울특별시 마포구 용강동' },
  { code: 1144010600, name: '서울특별시 마포구 토정동' },
  { code: 1144010700, name: '서울특별시 마포구 마포동' },
  { code: 1144010800, name: '서울특별시 마포구 대흥동' },
  { code: 1144010900, name: '서울특별시 마포구 염리동' },
  { code: 1144011000, name: '서울특별시 마포구 노고산동' },
  { code: 1144011100, name: '서울특별시 마포구 신수동' },
  { code: 1144011200, name: '서울특별시 마포구 현석동' },
  { code: 1144011300, name: '서울특별시 마포구 구수동' },
  { code: 1144011400, name: '서울특별시 마포구 창전동' },
  { code: 1144011500, name: '서울특별시 마포구 상수동' },
  { code: 1144011600, name: '서울특별시 마포구 하중동' },
  { code: 1144011700, name: '서울특별시 마포구 신정동' },
  { code: 1144011800, name: '서울특별시 마포구 당인동' },
  { code: 1144012000, name: '서울특별시 마포구 서교동' },
  { code: 1144012100, name: '서울특별시 마포구 동교동' },
  { code: 1144012200, name: '서울특별시 마포구 합정동' },
  { code: 1144012300, name: '서울특별시 마포구 망원동' },
  { code: 1144012400, name: '서울특별시 마포구 연남동' },
  { code: 1144012500, name: '서울특별시 마포구 성산동' },
  { code: 1144012600, name: '서울특별시 마포구 중동' },
  { code: 1144012700, name: '서울특별시 마포구 상암동' },
  { code: 1147000000, name: '서울특별시 양천구' },
  { code: 1147010100, name: '서울특별시 양천구 신정동' },
  { code: 1147010200, name: '서울특별시 양천구 목동' },
  { code: 1147010300, name: '서울특별시 양천구 신월동' },
  { code: 1150000000, name: '서울특별시 강서구' },
  { code: 1150010100, name: '서울특별시 강서구 염창동' },
  { code: 1150010200, name: '서울특별시 강서구 등촌동' },
  { code: 1150010300, name: '서울특별시 강서구 화곡동' },
  { code: 1150010400, name: '서울특별시 강서구 가양동' },
  { code: 1150010500, name: '서울특별시 강서구 마곡동' },
  { code: 1150010600, name: '서울특별시 강서구 내발산동' },
  { code: 1150010700, name: '서울특별시 강서구 외발산동' },
  { code: 1150010800, name: '서울특별시 강서구 공항동' },
  { code: 1150010900, name: '서울특별시 강서구 방화동' },
  { code: 1150011000, name: '서울특별시 강서구 개화동' },
  { code: 1150011100, name: '서울특별시 강서구 과해동' },
  { code: 1150011200, name: '서울특별시 강서구 오곡동' },
  { code: 1150011300, name: '서울특별시 강서구 오쇠동' },
  { code: 1153000000, name: '서울특별시 구로구' },
  { code: 1153010100, name: '서울특별시 구로구 신도림동' },
  { code: 1153010200, name: '서울특별시 구로구 구로동' },
  { code: 1153010300, name: '서울특별시 구로구 가리봉동' },
  { code: 1153010600, name: '서울특별시 구로구 고척동' },
  { code: 1153010700, name: '서울특별시 구로구 개봉동' },
  { code: 1153010800, name: '서울특별시 구로구 오류동' },
  { code: 1153010900, name: '서울특별시 구로구 궁동' },
  { code: 1153011000, name: '서울특별시 구로구 온수동' },
  { code: 1153011100, name: '서울특별시 구로구 천왕동' },
  { code: 1153011200, name: '서울특별시 구로구 항동' },
  { code: 1154500000, name: '서울특별시 금천구' },
  { code: 1154510100, name: '서울특별시 금천구 가산동' },
  { code: 1154510200, name: '서울특별시 금천구 독산동' },
  { code: 1154510300, name: '서울특별시 금천구 시흥동' },
  { code: 1156000000, name: '서울특별시 영등포구' },
  { code: 1156010100, name: '서울특별시 영등포구 영등포동' },
  { code: 1156010200, name: '서울특별시 영등포구 영등포동1가' },
  { code: 1156010300, name: '서울특별시 영등포구 영등포동2가' },
  { code: 1156010400, name: '서울특별시 영등포구 영등포동3가' },
  { code: 1156010500, name: '서울특별시 영등포구 영등포동4가' },
  { code: 1156010600, name: '서울특별시 영등포구 영등포동5가' },
  { code: 1156010700, name: '서울특별시 영등포구 영등포동6가' },
  { code: 1156010800, name: '서울특별시 영등포구 영등포동7가' },
  { code: 1156010900, name: '서울특별시 영등포구 영등포동8가' },
  { code: 1156011000, name: '서울특별시 영등포구 여의도동' },
  { code: 1156011100, name: '서울특별시 영등포구 당산동1가' },
  { code: 1156011200, name: '서울특별시 영등포구 당산동2가' },
  { code: 1156011300, name: '서울특별시 영등포구 당산동3가' },
  { code: 1156011400, name: '서울특별시 영등포구 당산동4가' },
  { code: 1156011500, name: '서울특별시 영등포구 당산동5가' },
  { code: 1156011600, name: '서울특별시 영등포구 당산동6가' },
  { code: 1156011700, name: '서울특별시 영등포구 당산동' },
  { code: 1156011800, name: '서울특별시 영등포구 도림동' },
  { code: 1156011900, name: '서울특별시 영등포구 문래동1가' },
  { code: 1156012000, name: '서울특별시 영등포구 문래동2가' },
  { code: 1156012100, name: '서울특별시 영등포구 문래동3가' },
  { code: 1156012200, name: '서울특별시 영등포구 문래동4가' },
  { code: 1156012300, name: '서울특별시 영등포구 문래동5가' },
  { code: 1156012400, name: '서울특별시 영등포구 문래동6가' },
  { code: 1156012500, name: '서울특별시 영등포구 양평동1가' },
  { code: 1156012600, name: '서울특별시 영등포구 양평동2가' },
  { code: 1156012700, name: '서울특별시 영등포구 양평동3가' },
  { code: 1156012800, name: '서울특별시 영등포구 양평동4가' },
  { code: 1156012900, name: '서울특별시 영등포구 양평동5가' },
  { code: 1156013000, name: '서울특별시 영등포구 양평동6가' },
  { code: 1156013100, name: '서울특별시 영등포구 양화동' },
  { code: 1156013200, name: '서울특별시 영등포구 신길동' },
  { code: 1156013300, name: '서울특별시 영등포구 대림동' },
  { code: 1156013400, name: '서울특별시 영등포구 양평동' },
  { code: 1159000000, name: '서울특별시 동작구' },
  { code: 1159010100, name: '서울특별시 동작구 노량진동' },
  { code: 1159010200, name: '서울특별시 동작구 상도동' },
  { code: 1159010300, name: '서울특별시 동작구 상도1동' },
  { code: 1159010400, name: '서울특별시 동작구 본동' },
  { code: 1159010500, name: '서울특별시 동작구 흑석동' },
  { code: 1159010600, name: '서울특별시 동작구 동작동' },
  { code: 1159010700, name: '서울특별시 동작구 사당동' },
  { code: 1159010800, name: '서울특별시 동작구 대방동' },
  { code: 1159010900, name: '서울특별시 동작구 신대방동' },
  { code: 1162000000, name: '서울특별시 관악구' },
  { code: 1162010100, name: '서울특별시 관악구 봉천동' },
  { code: 1162010200, name: '서울특별시 관악구 신림동' },
  { code: 1162010300, name: '서울특별시 관악구 남현동' },
  { code: 1165000000, name: '서울특별시 서초구' },
  { code: 1165010100, name: '서울특별시 서초구 방배동' },
  { code: 1165010200, name: '서울특별시 서초구 양재동' },
  { code: 1165010300, name: '서울특별시 서초구 우면동' },
  { code: 1165010400, name: '서울특별시 서초구 원지동' },
  { code: 1165010600, name: '서울특별시 서초구 잠원동' },
  { code: 1165010700, name: '서울특별시 서초구 반포동' },
  { code: 1165010800, name: '서울특별시 서초구 서초동' },
  { code: 1165010900, name: '서울특별시 서초구 내곡동' },
  { code: 1165011000, name: '서울특별시 서초구 염곡동' },
  { code: 1165011100, name: '서울특별시 서초구 신원동' },
  { code: 1168000000, name: '서울특별시 강남구' },
  { code: 1168010100, name: '서울특별시 강남구 역삼동' },
  { code: 1168010300, name: '서울특별시 강남구 개포동' },
  { code: 1168010400, name: '서울특별시 강남구 청담동' },
  { code: 1168010500, name: '서울특별시 강남구 삼성동' },
  { code: 1168010600, name: '서울특별시 강남구 대치동' },
  { code: 1168010700, name: '서울특별시 강남구 신사동' },
  { code: 1168010800, name: '서울특별시 강남구 논현동' },
  { code: 1168011000, name: '서울특별시 강남구 압구정동' },
  { code: 1168011100, name: '서울특별시 강남구 세곡동' },
  { code: 1168011200, name: '서울특별시 강남구 자곡동' },
  { code: 1168011300, name: '서울특별시 강남구 율현동' },
  { code: 1168011400, name: '서울특별시 강남구 일원동' },
  { code: 1168011500, name: '서울특별시 강남구 수서동' },
  { code: 1168011800, name: '서울특별시 강남구 도곡동' },
  { code: 1171000000, name: '서울특별시 송파구' },
  { code: 1171010100, name: '서울특별시 송파구 잠실동' },
  { code: 1171010200, name: '서울특별시 송파구 신천동' },
  { code: 1171010300, name: '서울특별시 송파구 풍납동' },
  { code: 1171010400, name: '서울특별시 송파구 송파동' },
  { code: 1171010500, name: '서울특별시 송파구 석촌동' },
  { code: 1171010600, name: '서울특별시 송파구 삼전동' },
  { code: 1171010700, name: '서울특별시 송파구 가락동' },
  { code: 1171010800, name: '서울특별시 송파구 문정동' },
  { code: 1171010900, name: '서울특별시 송파구 장지동' },
  { code: 1171011100, name: '서울특별시 송파구 방이동' },
  { code: 1171011200, name: '서울특별시 송파구 오금동' },
  { code: 1171011300, name: '서울특별시 송파구 거여동' },
  { code: 1171011400, name: '서울특별시 송파구 마천동' },
  { code: 1174000000, name: '서울특별시 강동구' },
  { code: 1174010100, name: '서울특별시 강동구 명일동' },
  { code: 1174010200, name: '서울특별시 강동구 고덕동' },
  { code: 1174010300, name: '서울특별시 강동구 상일동' },
  { code: 1174010500, name: '서울특별시 강동구 길동' },
  { code: 1174010600, name: '서울특별시 강동구 둔촌동' },
  { code: 1174010700, name: '서울특별시 강동구 암사동' },
  { code: 1174010800, name: '서울특별시 강동구 성내동' },
  { code: 1174010900, name: '서울특별시 강동구 천호동' },
  { code: 1174011000, name: '서울특별시 강동구 강일동' }
];


// 제출 시 값들이 제대로 입력 되었는지 체크
const listInfoForm = document.getElementById('listInfoForm');
listInfoForm.addEventListener('submit', (event) => {

  const checkAdd = {
    "locationTitle": false,
    "addressNo": false,
    "category": false,
    "isTenant": false,
    "shopName": false,
    "contactInfo": false,
    "floor": false,
    "py": false,
    "premium": false,
    "deposit": false,
    "rent": false,
    "adminCost": false,
    "note": false
  }

  // 법정동 유효성 검사 함수
  const isLocationValid = (location) => areaData.some(area => area.name === location);

  const searchInput = document.getElementById('searchInput');
  searchInput.addEventListener('input', () => {
    const locationTitle = searchInput.value.trim();
    checkAdd.locationTitle = isLocationValid(locationTitle);
    searchInput.style.borderColor = checkAdd.locationTitle ? '' : 'red';
  });

  // 상세주소 유효성 검사
  const addressInput = document.getElementById('addressInput').value.trim();
  checkAdd.addressNo = addressInput.length !== 0;

  // 매물 종류 입력되었는지 확인
  const selectedCategory = document.querySelector('input[name="category"]:checked');
  checkAdd.category = !!selectedCategory;

  // 공실여부 입력 확인
  const isTenantCheck = document.querySelector('input[name="isTenant"]:checked');
  checkAdd.isTenant = !!isTenantCheck;

  // 상호명 입력 검사 (조건부)
  const shopNameInput = document.getElementById('productName');
  if (isTenantCheck && selectedCategory) {
    if (isTenantCheck.value === '1' && selectedCategory.value !== '사무실') {
      checkAdd.shopName = shopNameInput.value.trim() !== '';
    } else {
      checkAdd.shopName = true;
    }
  } else {
    checkAdd.shopName = false;
  }

  // 연락처 입력 검사
  const contactInfoCheck = document.getElementById('contactInfo').value.trim();
  checkAdd.contactInfo = contactInfoCheck.length !== 0;

  // 층수 입력 검사
  const floorInput = document.getElementById('floorInput').value.trim();
  checkAdd.floor = floorInput.length !== 0;

  // 면적 입력 검사
  const pyInput = document.getElementById('pyInput').value.trim();
  checkAdd.py = pyInput.length !== 0;

  // 권리금 입력 검사
  const premiumInput = document.getElementById('premiumInput').value.trim();
  checkAdd.premium = premiumInput.length !== 0;

  // 보증금 입력 검사
  const depositInput = document.getElementById('depositInput').value.trim();
  checkAdd.deposit = depositInput.length !== 0;

  // 월세 입력 검사
  const rentInput = document.getElementById('rentInput').value.trim();
  checkAdd.rent = rentInput.length !== 0;

  // 관리비 입력 검사
  const adminCostInput = document.getElementById('adminCostInput').value.trim();
  checkAdd.adminCost = adminCostInput.length !== 0;

  // 기타 매물 특이사항 입력 검사
  const noteInput = document.getElementById('noteInput').value.trim();
  if (noteInput.length !== 0) {
    checkAdd.note = true;
  } else {
    const result = confirm("매물 특이사항을 적지 않으시겠습니까?");
    if (result) {
      checkAdd.note = true;
    } else {
      checkAdd.note = false;
      document.getElementById('noteInput').focus();
    }
  }

  // 모든 필드가 올바르게 입력되었는지 확인
  const allValid = Object.values(checkAdd).every(value => value === true);
  if (!allValid) {
    event.preventDefault();  // 폼 제출 중단
    alert('모든 필드를 올바르게 입력하세요.');
  }
});




function filterResults() {
  const input = document.getElementById('searchInput').value.toLowerCase();
  const resultsDiv = document.getElementById('results');
  resultsDiv.innerHTML = '';

  if (input.trim() === '') {
    return;
  }

  const filteredAreaData = areaData.filter(item => item.name.toLowerCase().includes(input));

  filteredAreaData.forEach(item => {
    const div = document.createElement('div');
    div.textContent = `${item.name} (${item.code})`;
    div.addEventListener('click', function () {
      document.getElementById('searchInput').value = item.name;
      resultsDiv.innerHTML = '';
    });
    resultsDiv.appendChild(div);
  });
}

// 공실 아닌 상가인 경우에만 상호명 입력하게 하기
const radios = document.getElementsByName('isTenant');
const productNameInput = document.getElementById('productName');

radios.forEach(radio => {
  radio.addEventListener('change', function () {
    const isNotVacant = document.getElementById('ownerIs').checked;
    const isStoreOrBoth = document.getElementById('typeStore').checked || document.getElementById('typeBoth').checked;

    if (isNotVacant && isStoreOrBoth) {
      productNameInput.disabled = false;
    } else {
      productNameInput.disabled = true;
      productNameInput.value = '';
    }
  });
});

const propertyTypeRadios = document.getElementsByName('propertyType');
propertyTypeRadios.forEach(radio => {
  radio.addEventListener('change', function () {
    const isNotVacant = document.getElementById('ownerIs').checked;
    const isStoreOrBoth = document.getElementById('typeStore').checked || document.getElementById('typeBoth').checked;

    if (isNotVacant && isStoreOrBoth) {
      productNameInput.disabled = false;
    } else {
      productNameInput.disabled = true;
      productNameInput.value = '';
    }
  });
});

// 면적계산기 기능 및 모달
function openCalcModal() {
  const modalBackground = document.getElementById('modalBackground');
  modalBackground.style.display = 'block';
}

document.getElementById('meterSquare').addEventListener('input', function () {
  const meterSquare = parseFloat(this.value);
  const pyCalcResult = document.getElementById('pyCalcResult');

  if (!isNaN(meterSquare)) {
    const calcPy = meterSquare * 0.3025;
    pyCalcResult.textContent = calcPy.toFixed(2);
  } else {
    pyCalcResult.textContent = '';
  }
});

function applyCalculation() {
  const pyCalcResult = document.getElementById('pyCalcResult').textContent;
  document.getElementById('pyInput').value = pyCalcResult;
  closeModal();
}

function closeModal() {
  document.getElementById('modalBackground').style.display = 'none';
}

// 모달 외부 클릭 시 닫기
window.addEventListener('click', function (event) {
  const modalBackground = document.getElementById('modalBackground');
  const pyCalcModal = document.getElementById('pyCalcModal');
  if (event.target === modalBackground && !pyCalcModal.contains(event.target)) {
    closeModal();
  }
});

// 금액 입력 시 콤마 추가하기
function formatNumberWithCommas(event) {
  let input = event.target;
  let value = input.value.replace(/,/g, '');

  if (!isNaN(value) && value !== '') {
    value = parseInt(value, 10).toLocaleString();
    input.value = value;
  }

  // 서버에 보낼 때 콤마 제거하기
  let hiddenInput = input.nextElementSibling;
  hiddenInput.value = value.replace(/,/g, '');
}

document.querySelectorAll('.budget').forEach(budgetInput => {
  budgetInput.addEventListener('input', formatNumberWithCommas);
  budgetInput.addEventListener('blur', formatNumberWithCommas);
});

// 입력한 금액들을 전달용 input으로 넣기
const thisPremium = document.getElementById('premium');
const thisPremiumInput = document.getElementById('premiumInput');

thisPremium.addEventListener('input', function () {
  thisPremiumInput.value = thisPremium.value;
});// 입력 필드와 전달용 hidden 필드를 연결하는 함수
function syncInputValue(inputId, hiddenInputId) {
  const inputElement = document.getElementById(inputId);
  const hiddenInputElement = document.getElementById(hiddenInputId);

  inputElement.addEventListener('input', function () {
    hiddenInputElement.value = inputElement.value;
  });
}

// 각 입력 필드에 대해 syncInputValue 함수 호출
syncInputValue('premium', 'premiumInput');
syncInputValue('deposit', 'depositInput');
syncInputValue('rent', 'rentInput');
syncInputValue('adminCost', 'adminCostInput');


const thisDeposit = document.getElementById('deposit');
const thisDepositInput = document.getElementById('depositInput');

thisDeposit.addEventListener('input', function () {
  thisDepositInput.value = thisDeposit.value;
});

const thisRent = document.getElementById('rent');
const thisRentInput = document.getElementById('rentInput');

thisRent.addEventListener('input', function () {
  thisRentInput.value = thisRent.value;
});

const thistAdminCost = document.getElementById('adminCost');
const thistAdminCostInput = document.getElementById('adminCostInput');

thistAdminCost.addEventListener('input', function () {
  thistAdminCostInput.value = thistAdminCost.value;
});

// 사진 등록 모달 열기
function openPicModal() {
  const modal = document.getElementById('picUploadModal');
  modal.style.display = 'block';
  setTimeout(() => {
    modal.classList.add('show');
  }, 10); // Slight delay to allow the display property to take effect
}

// 사진 등록 모달 닫기
function closePicModal() {
  const modal = document.getElementById('picUploadModal');
  modal.classList.remove('show');
  setTimeout(() => {
    modal.style.display = 'none';
  }, 300);
}

// 모달 외부 클릭 시 닫기
window.onclick = function (event) {
  const modal = document.getElementById('picUploadModal');
  if (event.target == modal) {
    closePicModal();
  }
}

document.addEventListener('DOMContentLoaded', () => {
  const modal = document.getElementById('picUploadModal');
  const fileInput = document.getElementById('fileInput');
  const uploadArea = document.getElementById('pictureUploadArea');
  const uploadedPictureContainer = document.getElementById('uploadedPictureContainer');

  // 모달 열기 함수
  function openPicModal() {
    modal.style.display = 'block';
  }

  // 모달 닫기 함수
  function closePicModal() {
    modal.style.display = 'none';
  }

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

  // 모달 닫기
  window.closePicModal = closePicModal;
});








// budgetInput 클릭 시 클래스 추가 및 다른 budgetInput의 클래스 제거
const budgetBoxes = document.querySelectorAll('.budgetInput');

budgetBoxes.forEach(budgetBox => {
  budgetBox.addEventListener('click', function () {
    // 모든 budgetInput 요소에서 'budgetSelected' 클래스를 제거
    budgetBoxes.forEach(box => box.classList.remove('budgetSelected'));

    // 현재 클릭된 요소에 'budgetSelected' 클래스 추가
    this.classList.add('budgetSelected');
  });
});

// 연락처 조합 : 관련인 + 번호
document.addEventListener('DOMContentLoaded', function () {
  const contactWho = document.getElementById('contactWho');
  const contactPhone = document.getElementById('contactPhone');
  const realContactInfo = document.getElementById('contactInfo');

  // 함수: 두 입력 값을 결합하여 realContactInfo에 업데이트
  function updateContactInfo() {
    realContactInfo.value = `${contactWho.value} ${contactPhone.value}`;
  }

  // 관련인 정보가 변경될 때
  contactWho.addEventListener('input', updateContactInfo);

  // 연락처 정보가 변경될 때
  contactPhone.addEventListener('input', updateContactInfo);
});

// 2개의 form 제출 버튼 하나로 합치기
// 제출용 버튼 관련 Js
const prdInfoRealSubmit = document.getElementById('prdInfoRealSubmit');
// 1. 진짜 버튼 기능 숨기기

// 2. 내용 제출 버튼
// 3. 사진 제출 버튼

// 4. 둘이 합치기