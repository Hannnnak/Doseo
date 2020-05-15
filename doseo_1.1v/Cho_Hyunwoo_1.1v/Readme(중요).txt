조현우_후기 게시판

회원가입-로그인 DB 연결은 프로젝트의 web.xml에 로컬 연결로 진행했습니다.

로컬 DB 연결시 만든 member 테이블의 쿼리문은 아래와 같습니다.

CREATE TABLE `member` (
  `memberid` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL,
  `regdate` datetime NOT NULL,
  PRIMARY KEY (`memberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

회원가입-로그인 처리는 교재 chapter 21을 참고해서 진행하였습니다.

후기 게시판은 교재 chapter 22를 참고해서 진행하였습니다. 
후기-후기 상세 테이블을 분리하였고, 학원 DB에는 수정해두었습니다.

후기 테이블 작성 쿼리문은 아래와 같습니다.

CREATE TABLE `review` (
  `rNo` int AUTO_INCREMENT,					-- 후기 번호
  `pNo` int,							-- 제품 번호
  `memberId` varchar(100),						-- 회원 아이디
  `name` varchar(50),						-- 회원 이름
  `rTitle` varchar(100),						-- 후기 제목
  `rDate` datetime,							-- 후기 작성날짜
  `mDate` datetime,						-- 후기 수정 날짜
  `rating` int,							-- 별점
  `rCnt` int,							-- 조회수review
  PRIMARY KEY (`rNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `review_content` (
  `rNo` int,							-- 후기 번호
  `rContents` varchar(1000),						-- 후기 내용
  PRIMARY KEY (`rNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


현재까지 작동하는 기능은

후기 조회-입력-수정 까지만 가능합니다.

앞으로 할일 

1. DB 수정							-- 완료
2. VO/DAO/Handler/service 수정					-- 완료
3. 동작 확인							-- 완료

4. 삭제 기능 구현
5. 평점 기능 구현	 (자바 스크립트 별점)
6. 검색 기능 구현
7. 추천수 삭제하고 조회수 기능으로 추천수 대체
8. 작성일 표시, 수정일 표시
9. 후기 작성자 아이디로 표시할지, 이름으로 표시할지 정하기
10. 후기 상세보기 페이지에서 이전글, 다음글 기능 구현하기
11. 제품 상세페이지에서 해당 제품의 후기만 모아서 보여주기


감사합니다.