# 강연 예약시스템
사내 강연 예약시스템의 Restful API서버를 구현하였습니다.
- 개발언어: Java 11
- 프레임워크: Spring Boot 2.7.9
- RDBMS : Mysql 8
- 데이타 설계
  - ![erd.png](erd.png)
- 완료된일
  - BackOffice
    - 강연 목록(전체 강연 목록)
    - 강연 등록(강연자, 강연장, 신청인원, 강연시간, 강연내용 입력)
- 해야될일
  - validation check
  - @CreatedDate, @LastModifiedDate null입력됨
  - @ColumnPosition
  - api 버전관리, api 분리
  - 기타 API 개발