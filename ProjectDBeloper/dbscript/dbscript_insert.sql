-- INSERT EB
INSERT INTO EB VALUES(1, '종이책');
INSERT INTO EB VALUES(2, '전자책');

-- INSERT BOOK_CATEGORY
INSERT INTO BOOK_CATEGORY VALUES(1, '소설');
INSERT INTO BOOK_CATEGORY VALUES(2, '장르소설');    
INSERT INTO BOOK_CATEGORY VALUES(3, '만화책');   
INSERT INTO BOOK_CATEGORY VALUES(4, '에세이'); 
INSERT INTO BOOK_CATEGORY VALUES(5, '철학/종교');   
INSERT INTO BOOK_CATEGORY VALUES(6, '인문학/사회/역사');    
INSERT INTO BOOK_CATEGORY VALUES(7, '자기계발/교재'); 
INSERT INTO BOOK_CATEGORY VALUES(8, '과학/IT');
INSERT INTO BOOK_CATEGORY VALUES(9, '잡지');
INSERT INTO BOOK_CATEGORY VALUES(10, '수험서');   
INSERT INTO BOOK_CATEGORY VALUES(11, '기타');   

-- INSERT BOOK
DROP SEQUENCE SEQ_BOOK;
CREATE SEQUENCE SEQ_BOOK NOCACHE;
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '코딩 이렇게만 하자', '김용승', 45000
, TO_DATE(2012, 'RRRR'), 10, DEFAULT
, '코딩트리', 1, 7
);

INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '시,커피한잔', '이다영', 11000
, TO_DATE(2021, 'RRRR'), 10, DEFAULT
, '도토리나무', 1, 11
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '오늘부터 드래곤 집사', '김민서', 8900
, TO_DATE(2019, 'RRRR'), 10, DEFAULT
, '아이브노벨', 1, 2
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '밤의 끝자락', 'William Green', 17000
, TO_DATE(2009, 'RRRR'), 10, DEFAULT
, '체리나무', 1, 1
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '쏙독새의 비상', 'Taneda Kaori', 12000
, TO_DATE(1999, 'RRRR'), 10, DEFAULT
, '문학노트', 1, 2
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, 'Saturn', 'Danny Bruno', 35000
, TO_DATE(2002, 'RRRR'), 10, DEFAULT
, '과학상자', 1, 8
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '할수있다 자바', '김자바', 5000
, TO_DATE(2022, 'RRRR'), 10, DEFAULT
, '개발자연구소', 2, 7
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '인생에 대하여', '칸토', 35000
, TO_DATE(2015, 'RRRR'), 10, DEFAULT
, '철학소년', 1, 5
);

INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '즐거운 물리학', '조지 가모프', 16000
, TO_DATE(2007, 'RRRR'), 5, DEFAULT
, '과학상자', 1, 8
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '혼자 공부하는 자바', '신용권', 24000
, TO_DATE(2007, 'RRRR'), 3, DEFAULT
, '한빛미디어', 1, 7
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '남한산성', '김훈', 16000
, TO_DATE(2007, 'RRRR'), 3, DEFAULT
, '학고재', 1, 1
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '종의 기원', '김유정', 13000
, TO_DATE(2013, 'RRRR'), 7, DEFAULT
, '전자노트', 2, 1
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '마음 산책', '정지우', 8000
, TO_DATE(2021, 'RRRR'), 10, DEFAULT
, '열린출판사', 1, 3
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '뜯어 먹는 인문학', '고정우', 24000
, TO_DATE(2019, 'RRRR'), 10, DEFAULT
, '닫힌출판사', 1, 6
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '시사인', '편집단', 8000
, TO_DATE(2022, 'RRRR'), 10, DEFAULT
, '시사출판사', 1, 9
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '쎈수학', '정승재', 12000
, TO_DATE(2021, 'RRRR'), 4, DEFAULT
, '닫힌출판사', 1, 10
);

-- INSERT MEMBER_GRADE
INSERT INTO MEMBER_GRADE VALUES('G', 'GOLD',  0.01);
INSERT INTO MEMBER_GRADE VALUES('S', 'SILVER',  0.005);
INSERT INTO MEMBER_GRADE VALUES('B', 'BRONZE',  0.003);

-- INSERT MEMBER
DROP SEQUENCE MEM_NO;
CREATE SEQUENCE MEM_NO;

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '백이진', '016-547-1864'
, '서울특별시 마포구 아현동 236-57', DEFAULT, 'BACK2JIN'
, '2JIN1015', NULL, 'N'
, 0
);

-- INSERT MEMBER2
INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '나희도', '017-8465-1546'
, '서울특별시 마포구 아현동 312-23', DEFAULT, 'RIDER37'
, 'HDHD0723', NULL, 'N'
, 0
);

-- INSERT MEMBER3
INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '고유림', '011-365-7546'
, '서울특별시 마포구 망원동 759 ', DEFAULT, 'JULME'
, 'URJULME', NULL, 'N'
, 0
);

-- INSERT MEMBER4
INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '문지웅', '010-4685-7024'
, '서울특별시 마포구 도화동 154-56 ', DEFAULT, 'LOVEUR'
, 'JWLOVEUR', NULL, 'N'
, 0
);

-- INSERT MEMBER5
INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '지승완', '010-8547-2474'
, '서울특별시 마포구 아현동 236-57', DEFAULT, 'WANSEUNG81'
, 'WS810514', NULL, 'N'
, 0
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '나큰솔', '010-5147-1864'
, '서울특별시 마포구 이현동 211-57', 'NORU'
, 'JUMPINGNORU', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '김지원', '010-5117-1864'
, '서울특별시 마포구 서형동 211-11', 'HELLO'
, 'WORLD', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '승윤자', '010-1147-1864'
, '서울특별시 종로구 탑골동 114-57', 'WHITE199'
, 'BLACK12140', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '김응누', '010-5147-8764'
, '서울특별시 마포구 고루동 987-57', 'OLDMAN'
, 'WALKINGTOTHE', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '영역동', '010-5147-1364'
, '서울특별시 마포구 이현동 211-57', 'OLDWOMAN'
, 'ROLLINGINTHEDEEP', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '이현아', '010-7747-1864'
, '서울특별시 구로구 구로1동 211-37', 'GOOD'
, 'BAD12', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, 'DR.DRE', '010-5147-1114'
, '서울특별시 강남구 대치동 111-57', 'IMRICH'
, 'NOTENGMONEY', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '홍길동', '010-1747-1864'
, '경기도 수원시 팔달동 1210-221', 'CREATE'
, 'BATTERPLACE1311', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '김여울', '010-1747-1144'
, '경기도 수원시 팔달동 1210-210', 'TEST1'
, 'PASS1', 'G'
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '김여울', '010-1747-1144'
, '경기도 수원시 팔달동 1210-210', 'TEST2'
, 'PASS2', 'S'
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '김여울', '010-1747-1144'
, '경기도 수원시 팔달동 1210-210', 'TEST3'
, 'PASS3', 'B'
);

-- INSERT NONMEMBERS

DROP SEQUENCE SEQ_NONMEMBERS_NO;
CREATE SEQUENCE SEQ_NONMEMBERS_NO NOCACHE;

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '김은하', '010-9999-9999'
, '안양시 만안구 만안로 421'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '김사랑', '010-9999-9998'
, '안양시 만안구 만안로 422'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '강나은', '010-8899-0000'
, '안양시 만안구 명학로 399'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '김우정', '010-9999-0000'
, '안양시 만안구 만안로 421'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '이정은', '010-9999-9000'
, '부천시 원미구 도당동 421'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '강별', '010-9989-0000'
, '안양시 동안구 평촌로 483'
);


-- INSERT INPUT_ORDER_HISTORY
DROP SEQUENCE SEQ_INPUT_ORDER_NO;
CREATE SEQUENCE SEQ_INPUT_ORDER_NO CACHE 20;
DELETE FROM INPUT_ORDER_HISTORY;

INSERT
  INTO INPUT_ORDER_HISTORY
(
  INPUT_ORDER_NO, INPUT_BOOK_NAME, INPUT_BOOK_AUTHOR
, INPUT_BOOK_PUBLISHER_NAME, INPUT_APPROVAL, INPUT_BOOK_NO, INPUT_NEWBOOK
)
VALUES
(
  CONCAT('I-', SEQ_INPUT_ORDER_NO.NEXTVAL), '시, 커피한잔', '이다영'
, '도토리 나무', DEFAULT, 2, 'N'
);


INSERT
  INTO INPUT_ORDER_HISTORY
(
  INPUT_ORDER_NO, INPUT_BOOK_NAME, INPUT_BOOK_AUTHOR
, INPUT_BOOK_PUBLISHER_NAME, INPUT_APPROVAL, INPUT_BOOK_NO, INPUT_NEWBOOK
)
VALUES
(
  CONCAT('I-', SEQ_INPUT_ORDER_NO.NEXTVAL), 'Saturn', 'Danny Bruno'
, '과학상자', DEFAULT, 6, 'N'
);

INSERT
  INTO INPUT_ORDER_HISTORY
(
  INPUT_ORDER_NO, INPUT_BOOK_NAME, INPUT_BOOK_AUTHOR
, INPUT_BOOK_PUBLISHER_NAME, INPUT_APPROVAL, INPUT_BOOK_NO, INPUT_NEWBOOK
)
VALUES
(
  CONCAT('I-', SEQ_INPUT_ORDER_NO.NEXTVAL), '오늘부터 드래곤 집사', '김민서'
, '아이브노벨', DEFAULT, 3, 'N'
);

INSERT
  INTO INPUT_ORDER_HISTORY
(
  INPUT_ORDER_NO, INPUT_BOOK_NAME, INPUT_BOOK_AUTHOR
, INPUT_BOOK_PUBLISHER_NAME, INPUT_APPROVAL, INPUT_BOOK_NO, INPUT_NEWBOOK
)
VALUES
(
  CONCAT('I-', SEQ_INPUT_ORDER_NO.NEXTVAL), '인생에 대하여', '칸토'
, '철학소년', DEFAULT, 8, 'N'
);

-- INSERT OUTPUT_ORDER_HISTORY
DROP SEQUENCE SEQ_OUTPUT_ORDER_NO;
CREATE SEQUENCE SEQ_OUTPUT_ORDER_NO NOCACHE;

SELECT * FROM OUTPUT_ORDER_HISTORY;


-- 첫 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 3, DEFAULT
, DEFAULT, 1, 2, NULL
);

-- 두 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 1, DEFAULT
, DEFAULT, 5, 1, NULL
);

-- 세 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 1, DEFAULT
, DEFAULT, 1, 3, NULL
);

-- 네 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 1, DEFAULT
, DEFAULT, 5, 3, NULL
);

-- 다섯번 째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 3, DEFAULT
, DEFAULT, 8, 4, NULL
);

-- 여섯 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 10, DEFAULT
, DEFAULT, 7, 5, NULL
);

-- 일곱 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 1, DEFAULT
, DEFAULT, 6, 4, NULL
);


-- INSERT MANAGER
DROP SEQUENCE SEQ_MANAGER;
CREATE SEQUENCE SEQ_MANAGER START WITH 1;

-- MASTER 관리자 정보 INSERT 1
-- MASTER 1명, SUBMASTER - 2명, PT- 3명
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '김가영', 'MASTER', '010-1234-5678'
, '성남시 분당구 판교동', 'M01', 'M0101'
, 3000000, 'N'
);

-- MASTER 관리자 정보 INSERT 2
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '이혜준', 'MASTER', '010-5678-5678'
, '경기도 용인시 기흥구 중동', 'M02', 'M0202'
, 5000000, 'Y'
);

-- MASTER 관리자 정보 INSERT 3
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '차효진', 'MASTER', '010-1243-5678'
, '서울시 강남구 압구정동', 'S03 ', 'S0303'
, 5000000, 'Y'
);

-- SUBMASTER 관리자 정보 INSERT 4
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '김덕진', 'SUBMASTER', '010-1342-4321'
, '서울시 성북구 동선동', 'S04 ', 'S0404'
, 2500000, 'Y'
);

-- SUBMASTER 관리자 정보 INSERT 5
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '김춘식', 'SUBMASTER', '010-2345-5432'
, '경기 가평군 가평읍', 'S05', 'S0505'
, 2500000, 'N'
);

-- SUBMASTER 관리자 정보 INSERT 6
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '장덕팔', 'SUBMASTER', '010-5678-7893'
, '대구광역시 달서구 호림동', 'S06', 'S0606'
, 2750000, 'N'
);

-- PART_TIMER 관리자 정보 INSERT 7
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '강태풍', 'PART_TIMER', '010-7895-7410'
, '서울 마포구 동교동', 'P07', 'P0707'
, 2000000, 'Y'
);

-- PART_TIMER 관리자 정보 INSERT 8
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '곽두팔', 'PART_TIMER', '010-7895-1234'
, '서울 마포구 서교동', 'P08', 'P0808'
, 2000000, 'N'
);

-- PART_TIMER 관리자 정보 INSERT 9
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '이나래', 'PART_TIMER', '010-7895-1001'
, '서울 성동구 응봉동', 'P09', 'P0909'
, 2000000, 'Y'
);

-- PART_TIMER 관리자 정보 INSERT 10
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '박천둥', 'PART_TIMER', '010-8547-9658'
, '강원도 철원군 철원읍', 'P10', 'P1010'
, 2000000, 'N'
);

-- INSERT STORE_SUM_MONEY
INSERT INTO STORE_SUM_MONEY VALUES (100000000);

-- INSERT STORE_SALES_HISTORY
DROP SEQUENCE SEQ_STORE_SALES_CODE;
CREATE SEQUENCE SEQ_STORE_SALES_CODE NOCACHE;

DROP TRIGGER TRG_STORE_SUM_MONEY;
CREATE OR REPLACE TRIGGER TRG_STORE_SUM_MONEY AFTER
  INSERT ON STORE_SALES_HISTORY
  FOR EACH ROW
BEGIN
  IF :NEW.SSH_INCOME_STATEMENT = '입금'
    THEN 
      UPDATE STORE_SUM_MONEY A
         SET A.STORE_SUM_MONEY = A.STORE_SUM_MONEY + :NEW.SSH_MONEY;
  END IF;
  IF :NEW.SSH_INCOME_STATEMENT = '출금'
    THEN
      UPDATE STORE_SUM_MONEY A
         SET A.STORE_SUM_MONEY = A.STORE_SUM_MONEY - :NEW.SSH_MONEY;
  END IF;
  IF :NEW.SSH_INCOME_STATEMENT = '월급지급'
    THEN
      UPDATE STORE_SUM_MONEY A
         SET A.STORE_SUM_MONEY = A.STORE_SUM_MONEY - :NEW.SSH_MONEY;
  END IF;       
END;
/

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 50000
, DEFAULT, '입금'
);

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 20000
, DEFAULT, '출금'
);

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 100000
, DEFAULT, '출금'
);

COMMIT;

-- 마일리지 INSERT
-- INSERT 1
INSERT 
  INTO MILEAGE
(
  MILEAGE_PRODUCTNO,
  MILEAGE_PRODUCTNAME,
  MILEAGE_PRODUCTPRICE
)
VALUES
(
  '1', '북스탠드', '1000'-- INSERT EB
INSERT INTO EB VALUES(1, '종이책');
INSERT INTO EB VALUES(2, '전자책');

-- INSERT BOOK_CATEGORY
INSERT INTO BOOK_CATEGORY VALUES(1, '소설');
INSERT INTO BOOK_CATEGORY VALUES(2, '장르소설');    
INSERT INTO BOOK_CATEGORY VALUES(3, '만화책');   
INSERT INTO BOOK_CATEGORY VALUES(4, '에세이'); 
INSERT INTO BOOK_CATEGORY VALUES(5, '철학/종교');   
INSERT INTO BOOK_CATEGORY VALUES(6, '인문학/사회/역사');    
INSERT INTO BOOK_CATEGORY VALUES(7, '자기계발/교재'); 
INSERT INTO BOOK_CATEGORY VALUES(8, '과학/IT');
INSERT INTO BOOK_CATEGORY VALUES(9, '잡지');
INSERT INTO BOOK_CATEGORY VALUES(10, '수험서');   
INSERT INTO BOOK_CATEGORY VALUES(11, '기타');   

-- INSERT BOOK
DROP SEQUENCE SEQ_BOOK;
CREATE SEQUENCE SEQ_BOOK NOCACHE;
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '코딩 이렇게만 하자', '김용승', 45000
, TO_DATE(2012, 'RRRR'), 10, DEFAULT
, '코딩트리', 1, 7
);

INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '시,커피한잔', '이다영', 11000
, TO_DATE(2021, 'RRRR'), 10, DEFAULT
, '도토리나무', 1, 11
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '오늘부터 드래곤 집사', '김민서', 8900
, TO_DATE(2019, 'RRRR'), 10, DEFAULT
, '아이브노벨', 1, 2
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '밤의 끝자락', 'William Green', 17000
, TO_DATE(2009, 'RRRR'), 10, DEFAULT
, '체리나무', 1, 1
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '쏙독새의 비상', 'Taneda Kaori', 12000
, TO_DATE(1999, 'RRRR'), 10, DEFAULT
, '문학노트', 1, 2
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, 'Saturn', 'Danny Bruno', 35000
, TO_DATE(2002, 'RRRR'), 10, DEFAULT
, '과학상자', 1, 8
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '할수있다 자바', '김자바', 5000
, TO_DATE(2022, 'RRRR'), 10, DEFAULT
, '개발자연구소', 2, 7
);
INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '인생에 대하여', '칸토', 35000
, TO_DATE(2015, 'RRRR'), 10, DEFAULT
, '철학소년', 1, 5
);

INSERT
  INTO BOOK
(
  BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PRICE
, BOOK_PUBLISHING_DATE, BOOK_STOCK, BOOK_SALES_RATE
, BOOK_PUBLISHER_NAME, BOOK_EB_NUMBER, BOOK_CATEGORY_NUMBER
)
VALUES
(
  SEQ_BOOK.NEXTVAL, '즐거운 물리학', '조지 가모프', 16000
, TO_DATE(2007, 'RRRR'), 5, DEFAULT
, '과학상자', 1, 8
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '혼자 공부하는 자바', '신용권', 24000
, TO_DATE(2007, 'RRRR'), 3, DEFAULT
, '한빛미디어', 1, 7
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '남한산성', '김훈', 16000
, TO_DATE(2007, 'RRRR'), 3, DEFAULT
, '학고재', 1, 1
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '종의 기원', '김유정', 13000
, TO_DATE(2013, 'RRRR'), 7, DEFAULT
, '전자노트', 2, 1
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '마음 산책', '정지우', 8000
, TO_DATE(2021, 'RRRR'), 10, DEFAULT
, '열린출판사', 1, 3
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '뜯어 먹는 인문학', '고정우', 24000
, TO_DATE(2019, 'RRRR'), 10, DEFAULT
, '닫힌출판사', 1, 6
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '시사인', '편집단', 8000
, TO_DATE(2022, 'RRRR'), 10, DEFAULT
, '시사출판사', 1, 9
);

INSERT
  INTO BOOK
VALUES
(
  SEQ_BOOK.NEXTVAL, '쎈수학', '정승재', 12000
, TO_DATE(2021, 'RRRR'), 4, DEFAULT
, '닫힌출판사', 1, 10
);

-- INSERT MEMBER_GRADE
INSERT INTO MEMBER_GRADE VALUES('G', 'GOLD',  0.01);
INSERT INTO MEMBER_GRADE VALUES('S', 'SILVER',  0.005);
INSERT INTO MEMBER_GRADE VALUES('B', 'BRONZE',  0.003);

-- INSERT MEMBER
DROP SEQUENCE MEM_NO;
CREATE SEQUENCE MEM_NO;

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '백이진', '016-547-1864'
, '서울특별시 마포구 아현동 236-57', DEFAULT, 'BACK2JIN'
, '2JIN1015', NULL, 'N'
, 0
);

-- INSERT MEMBER2
INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '나희도', '017-8465-1546'
, '서울특별시 마포구 아현동 312-23', DEFAULT, 'RIDER37'
, 'HDHD0723', NULL, 'N'
, 0
);

-- INSERT MEMBER3
INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '고유림', '011-365-7546'
, '서울특별시 마포구 망원동 759 ', DEFAULT, 'JULME'
, 'URJULME', NULL, 'N'
, 0
);

-- INSERT MEMBER4
INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '문지웅', '010-4685-7024'
, '서울특별시 마포구 도화동 154-56 ', DEFAULT, 'LOVEUR'
, 'JWLOVEUR', NULL, 'N'
, 0
);

-- INSERT MEMBER5
INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_MILEAGE, MEM_ID
, MEM_PWD, MEM_GRADE_NO, MEM_DROP_YN
, MEM_SUM_MONEY
)
VALUES
(
  MEM_NO.NEXTVAL, '지승완', '010-8547-2474'
, '서울특별시 마포구 아현동 236-57', DEFAULT, 'WANSEUNG81'
, 'WS810514', NULL, 'N'
, 0
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '나큰솔', '010-5147-1864'
, '서울특별시 마포구 이현동 211-57', 'NORU'
, 'JUMPINGNORU', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '김지원', '010-5117-1864'
, '서울특별시 마포구 서형동 211-11', 'HELLO'
, 'WORLD', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '승윤자', '010-1147-1864'
, '서울특별시 종로구 탑골동 114-57', 'WHITE199'
, 'BLACK12140', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '김응누', '010-5147-8764'
, '서울특별시 마포구 고루동 987-57', 'OLDMAN'
, 'WALKINGTOTHE', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '영역동', '010-5147-1364'
, '서울특별시 마포구 이현동 211-57', 'OLDWOMAN'
, 'ROLLINGINTHEDEEP', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '이현아', '010-7747-1864'
, '서울특별시 구로구 구로1동 211-37', 'GOOD'
, 'BAD12', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, 'DR.DRE', '010-5147-1114'
, '서울특별시 강남구 대치동 111-57', 'IMRICH'
, 'NOTENGMONEY', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '홍길동', '010-1747-1864'
, '경기도 수원시 팔달동 1210-221', 'CREATE'
, 'BATTERPLACE1311', NULL
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '김여울', '010-1747-5555'
, '경기도 수원시 팔달동 1210-210', 'TEST1'
, 'PASS1', 'G'
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '곽두팔', '010-1747-2222'
, '경기도 수원시 팔달동 1210-270', 'TEST2'
, 'PASS2', 'S'
);

INSERT
  INTO MEMBER
(
  MEM_NO, MEM_NAME, MEM_PHONE
, MEM_ADDRESS, MEM_ID
, MEM_PWD, MEM_GRADE_NO

)
VALUES
(
  MEM_NO.NEXTVAL, '공호준', '010-5447-1974'
, '강원도 도봉구 삼척동 10-210', 'TEST3'
, 'PASS3', 'B'
);

-- INSERT NONMEMBERS

DROP SEQUENCE SEQ_NONMEMBERS_NO;
CREATE SEQUENCE SEQ_NONMEMBERS_NO NOCACHE;

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '김은하', '010-9999-9999'
, '안양시 만안구 만안로 421'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '김사랑', '010-9999-9998'
, '안양시 만안구 만안로 422'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '강나은', '010-8899-0000'
, '안양시 만안구 명학로 399'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '김우정', '010-9999-0000'
, '안양시 만안구 만안로 421'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '이정은', '010-9999-9000'
, '부천시 원미구 도당동 421'
);

INSERT
    INTO NONMEMBERS
(
  NONMEMBERS_NO, NONMEMBERS_NAME, NONMEMBERS_PHONE
, NONMEMBERS_ADDRESS  
)
VALUES
(
  ('NM-' || SEQ_NONMEMBERS_NO.NEXTVAL), '강별', '010-9989-0000'
, '안양시 동안구 평촌로 483'
);


-- INSERT INPUT_ORDER_HISTORY
DROP SEQUENCE SEQ_INPUT_ORDER_NO;
CREATE SEQUENCE SEQ_INPUT_ORDER_NO CACHE 20;
DELETE FROM INPUT_ORDER_HISTORY;

INSERT
  INTO INPUT_ORDER_HISTORY
(
  INPUT_ORDER_NO, INPUT_BOOK_NAME, INPUT_BOOK_AUTHOR
, INPUT_BOOK_PUBLISHER_NAME, INPUT_APPROVAL, INPUT_BOOK_NO, INPUT_NEWBOOK
)
VALUES
(
  CONCAT('I-', SEQ_INPUT_ORDER_NO.NEXTVAL), '시, 커피한잔', '이다영'
, '도토리 나무', DEFAULT, 2, 'N'
);


INSERT
  INTO INPUT_ORDER_HISTORY
(
  INPUT_ORDER_NO, INPUT_BOOK_NAME, INPUT_BOOK_AUTHOR
, INPUT_BOOK_PUBLISHER_NAME, INPUT_APPROVAL, INPUT_BOOK_NO, INPUT_NEWBOOK
)
VALUES
(
  CONCAT('I-', SEQ_INPUT_ORDER_NO.NEXTVAL), 'Saturn', 'Danny Bruno'
, '과학상자', DEFAULT, 6, 'N'
);

INSERT
  INTO INPUT_ORDER_HISTORY
(
  INPUT_ORDER_NO, INPUT_BOOK_NAME, INPUT_BOOK_AUTHOR
, INPUT_BOOK_PUBLISHER_NAME, INPUT_APPROVAL, INPUT_BOOK_NO, INPUT_NEWBOOK
)
VALUES
(
  CONCAT('I-', SEQ_INPUT_ORDER_NO.NEXTVAL), '오늘부터 드래곤 집사', '김민서'
, '아이브노벨', DEFAULT, 3, 'N'
);

INSERT
  INTO INPUT_ORDER_HISTORY
(
  INPUT_ORDER_NO, INPUT_BOOK_NAME, INPUT_BOOK_AUTHOR
, INPUT_BOOK_PUBLISHER_NAME, INPUT_APPROVAL, INPUT_BOOK_NO, INPUT_NEWBOOK
)
VALUES
(
  CONCAT('I-', SEQ_INPUT_ORDER_NO.NEXTVAL), '인생에 대하여', '칸토'
, '철학소년', DEFAULT, 8, 'N'
);

-- INSERT OUTPUT_ORDER_HISTORY
DROP SEQUENCE SEQ_OUTPUT_ORDER_NO;
CREATE SEQUENCE SEQ_OUTPUT_ORDER_NO NOCACHE;

SELECT * FROM OUTPUT_ORDER_HISTORY;


-- 첫 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 3, DEFAULT
, DEFAULT, 1, 2, NULL
);

-- 두 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 1, DEFAULT
, DEFAULT, 5, 1, NULL
);

-- 세 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 1, DEFAULT
, DEFAULT, 1, 3, NULL
);

-- 네 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 1, DEFAULT
, DEFAULT, 5, 3, NULL
);

-- 다섯번 째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 3, DEFAULT
, DEFAULT, 8, 4, NULL
);

-- 여섯 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 10, DEFAULT
, DEFAULT, 7, 5, NULL
);

-- 일곱 번째 출고 내역
INSERT
    INTO OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO, OUTPUT_NUMBER_OF_BOOKS, OUTPUT_ORDER_DATE
, OUTPUT_APPROVAL, OUTPUT_BOOK_NO, OUTPUT_MEMBER_NO, OUTPUT_NONMEMBERS_NO
)
VALUES
(
  ('O-' || SEQ_OUTPUT_ORDER_NO.NEXTVAL), 1, DEFAULT
, DEFAULT, 6, 4, NULL
);


-- INSERT MANAGER
DROP SEQUENCE SEQ_MANAGER;
CREATE SEQUENCE SEQ_MANAGER START WITH 1;

-- MASTER 관리자 정보 INSERT 1
-- MASTER 1명, SUBMASTER - 2명, PT- 3명
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '김가영', 'MASTER', '010-1234-5678'
, '성남시 분당구 판교동', 'M01', 'M0101'
, 3000000, 'N'
);

-- MASTER 관리자 정보 INSERT 2
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '이혜준', 'MASTER', '010-5678-5678'
, '경기도 용인시 기흥구 중동', 'M02', 'M0202'
, 5000000, 'Y'
);

-- MASTER 관리자 정보 INSERT 3
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '차효진', 'MASTER', '010-1243-5678'
, '서울시 강남구 압구정동', 'S03 ', 'S0303'
, 5000000, 'Y'
);

-- SUBMASTER 관리자 정보 INSERT 4
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '김덕진', 'SUBMASTER', '010-1342-4321'
, '서울시 성북구 동선동', 'S04 ', 'S0404'
, 2500000, 'Y'
);

-- SUBMASTER 관리자 정보 INSERT 5
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '김춘식', 'SUBMASTER', '010-2345-5432'
, '경기 가평군 가평읍', 'S05', 'S0505'
, 2500000, 'N'
);

-- SUBMASTER 관리자 정보 INSERT 6
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '장덕팔', 'SUBMASTER', '010-5678-7893'
, '대구광역시 달서구 호림동', 'S06', 'S0606'
, 2750000, 'N'
);

-- PART_TIMER 관리자 정보 INSERT 7
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '강태풍', 'PART_TIMER', '010-7895-7410'
, '서울 마포구 동교동', 'P07', 'P0707'
, 2000000, 'Y'
);

-- PART_TIMER 관리자 정보 INSERT 8
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '곽두팔', 'PART_TIMER', '010-7895-1234'
, '서울 마포구 서교동', 'P08', 'P0808'
, 2000000, 'N'
);

-- PART_TIMER 관리자 정보 INSERT 9
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '이나래', 'PART_TIMER', '010-7895-1001'
, '서울 성동구 응봉동', 'P09', 'P0909'
, 2000000, 'Y'
);

-- PART_TIMER 관리자 정보 INSERT 10
INSERT
  INTO MANAGER
(
  MANAGER_NUM, MANAGER_NAME, MANAGER_GRADE, MANAGER_PHONE
, MANAGER_ADDRESS, MANAGER_ID, MANAGER_PWD
, MANAGER_SALARY, MANAGER_DROP_YN
)
VALUES
(
  SEQ_MANAGER.NEXTVAL, '박천둥', 'PART_TIMER', '010-8547-9658'
, '강원도 철원군 철원읍', 'P10', 'P1010'
, 2000000, 'N'
);

-- INSERT STORE_SALES_HISTORY
DROP SEQUENCE SEQ_STORE_SALES_CODE;
CREATE SEQUENCE SEQ_STORE_SALES_CODE NOCACHE;

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 100000
, TO_DATE(20220421, 'RRRRMMDD'), '출금'
);

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 200000
, TO_DATE(20220424, 'RRRRMMDD'), '출금'
);

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 12000
, TO_DATE(20220425, 'RRRRMMDD'), '입금'
);

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 100100
, TO_DATE(20220426, 'RRRRMMDD'), '출금'
);

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 100000
, TO_DATE(20220428, 'RRRRMMDD'), '입금'
);

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 50000
, DEFAULT, '입금'
);

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 20000
, DEFAULT, '출금'
);

INSERT 
  INTO STORE_SALES_HISTORY
(
  SSH_SALES_CODE, SSH_MONEY
, SSH_DBELOPER_DATE, SSH_INCOME_STATEMENT
)
VALUES
(
  'S'||SEQ_STORE_SALES_CODE.NEXTVAL, 100000
, DEFAULT, '출금'
);

-- 마일리지 INSERT
-- INSERT 1
INSERT 
  INTO MILEAGE
(
  MILEAGE_PRODUCTNO,
  MILEAGE_PRODUCTNAME,
  MILEAGE_PRODUCTPRICE
)
VALUES
(
  '1', '북스탠드', '1000'
);

-- INSERT 2
INSERT 
  INTO MILEAGE
(
  MILEAGE_PRODUCTNO,
  MILEAGE_PRODUCTNAME,
  MILEAGE_PRODUCTPRICE
)
VALUES
(
  '2', '책갈피', '800'
);

-- INSERT 3
INSERT 
  INTO MILEAGE
(
  MILEAGE_PRODUCTNO,
  MILEAGE_PRODUCTNAME,
  MILEAGE_PRODUCTPRICE
)
VALUES
(
  '3', '김영하 사인회', '2000'
);
-- INSERT 4
INSERT 
  INTO MILEAGE
(
  MILEAGE_PRODUCTNO,
  MILEAGE_PRODUCTNAME,
  MILEAGE_PRODUCTPRICE
)
VALUES
(
  '4', '하이미디어 초청권', '2000'
);

-- INSERT STORE_SUM_MONEY
INSERT INTO STORE_SUM_MONEY VALUES (100000000);

-- STORE_SUM_MONEY TRIGGER
DROP TRIGGER TRG_STORE_SUM_MONEY;
CREATE OR REPLACE TRIGGER TRG_STORE_SUM_MONEY AFTER
  INSERT ON STORE_SALES_HISTORY
  FOR EACH ROW
BEGIN
  IF :NEW.SSH_INCOME_STATEMENT = '입금'
    THEN 
      UPDATE STORE_SUM_MONEY A
         SET A.STORE_SUM_MONEY = A.STORE_SUM_MONEY + :NEW.SSH_MONEY;
  END IF;
  IF :NEW.SSH_INCOME_STATEMENT = '출금'
    THEN
      UPDATE STORE_SUM_MONEY A
         SET A.STORE_SUM_MONEY = A.STORE_SUM_MONEY - :NEW.SSH_MONEY;
  END IF;
  IF :NEW.SSH_INCOME_STATEMENT = '월급지급'
    THEN
      UPDATE STORE_SUM_MONEY A
         SET A.STORE_SUM_MONEY = A.STORE_SUM_MONEY - :NEW.SSH_MONEY;
  END IF;       
END;
/

COMMIT;
);

-- INSERT 2
INSERT 
  INTO MILEAGE
(
  MILEAGE_PRODUCTNO,
  MILEAGE_PRODUCTNAME,
  MILEAGE_PRODUCTPRICE
)
VALUES
(
  '2', '책갈피', '800'
);

-- INSERT 3
INSERT 
  INTO MILEAGE
(
  MILEAGE_PRODUCTNO,
  MILEAGE_PRODUCTNAME,
  MILEAGE_PRODUCTPRICE
)
VALUES
(
  '3', '김영하 사인회', '2000'
);
-- INSERT 4
INSERT 
  INTO MILEAGE
(
  MILEAGE_PRODUCTNO,
  MILEAGE_PRODUCTNAME,
  MILEAGE_PRODUCTPRICE
)
VALUES
(
  '4', '하이미디어 초청권', '2000'
);