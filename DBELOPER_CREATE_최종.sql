DROP TABLE INPUT_ORDER_HISTORY CASCADE CONSTRAINTS;
DROP TABLE OUTPUT_ORDER_HISTORY CASCADE CONSTRAINTS;
DROP TABLE BOOK CASCADE CONSTRAINTS; 
DROP TABLE BOOK_CATEGORY CASCADE CONSTRAINTS;
DROP TABLE EB CASCADE CONSTRAINTS;
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE NONMEMBERS CASCADE CONSTRAINTS;
DROP TABLE MEMBER_GRADE CASCADE CONSTRAINTS;
DROP TABLE MANAGER CASCADE CONSTRAINTS;
DROP TABLE STORE_SALES_HISTORY CASCADE CONSTRAINTS;
DROP TABLE STORE_SUM_MONEY CASCADE CONSTRAINTS;
DROP TABLE REVIEW CASCADE CONSTRAINTS;
DROP TABLE MILEAGE CASCADE CONSTRAINTS;

-- 도서 분류 테이블 생성 
CREATE TABLE EB
(
  EB_BOOK_NUMBER NUMBER CONSTRAINT PK_EB_BOOK_NUMBER PRIMARY KEY
, EB_CATEGORY VARCHAR2(30) CONSTRAINT NN_EB_CATEGORY NOT NULL
);
COMMENT ON COLUMN EB.EB_BOOK_NUMBER IS '구분번호';
COMMENT ON COLUMN EB.EB_CATEGORY IS '구분종류';

-- 도서 장르 테이블 생성
CREATE TABLE BOOK_CATEGORY
(
  BOOK_CATEGORY_NUMBER NUMBER CONSTRAINT PK_BOOK_CATEGORY_NUMBER PRIMARY KEY
, BOOK_CATEGORY_NAME VARCHAR2(30) CONSTRAINT NN_BOOK_CATEGORY_NAME NOT NULL
);
COMMENT ON COLUMN BOOK_CATEGORY.BOOK_CATEGORY_NUMBER IS '장르번호';
COMMENT ON COLUMN BOOK_CATEGORY.BOOK_CATEGORY_NAME IS '장르이름';

-- 도서 테이블 생성
CREATE TABLE BOOK
(
  BOOK_NO NUMBER CONSTRAINT FK_BOOK_NO PRIMARY KEY
, BOOK_NAME VARCHAR2(300) CONSTRAINT NN_BOOK_NAME NOT NULL
, BOOK_AUTHOR VARCHAR2(60) CONSTRAINT NN_BOOK_AUTHOR NOT NULL
, BOOK_PRICE NUMBER CONSTRAINT NN_BOOK_PRICE NOT NULL
, BOOK_PUBLISHING_DATE DATE CONSTRAINT NN_BOOK_PUBLISHING_DATE NOT NULL
, BOOK_STOCK NUMBER DEFAULT 10 CONSTRAINT NN_BOOK_STOCK NOT NULL 
, BOOK_SALES_RATE NUMBER DEFAULT 0 CONSTRAINT NN_BOOK_SALES_RATE NOT NULL
, BOOK_PUBLISHER_NAME VARCHAR2(60) CONSTRAINT NN_BOOK_PUBLISHER_NAME NOT NULL
, BOOK_EB_NUMBER NUMBER CONSTRAINT NN_BOOK_EB_NUMBER NOT NULL
, BOOK_CATEGORY_NUMBER NUMBER CONSTRAINT NN_BOOK_CATEGORY_NUMBER NOT NULL
, CONSTRAINT CK_BOOK_PRICE CHECK (BOOK_PRICE > 0)
, CONSTRAINT CK_BOOK_EB_NUMBER CHECK (BOOK_EB_NUMBER IN ('1', '2'))
, CONSTRAINT FK_BOOK_EB_NUMBER FOREIGN KEY (BOOK_EB_NUMBER) 
                               REFERENCES EB(EB_BOOK_NUMBER) 
, CONSTRAINT CK_BOOK_CATEGORY_NUMBER CHECK (BOOK_CATEGORY_NUMBER IN ('1', '2','3','4','5','6','7','8','9','10','11'))
, CONSTRAINT FK_BOOK_CATEGORY_NUMBER FOREIGN KEY (BOOK_CATEGORY_NUMBER) 
                               REFERENCES BOOK_CATEGORY(BOOK_CATEGORY_NUMBER) 
);
COMMENT ON COLUMN BOOK.BOOK_NO IS '도서번호';
COMMENT ON COLUMN BOOK.BOOK_NAME IS '도서제목';
COMMENT ON COLUMN BOOK.BOOK_AUTHOR IS '도서작가';
COMMENT ON COLUMN BOOK.BOOK_PRICE IS '도서가격';
COMMENT ON COLUMN BOOK.BOOK_PUBLISHING_DATE IS '도서출판년도';
COMMENT ON COLUMN BOOK.BOOK_STOCK IS '도서재고';
COMMENT ON COLUMN BOOK.BOOK_SALES_RATE IS '도서판매량';
COMMENT ON COLUMN BOOK.BOOK_PUBLISHER_NAME IS '도서출판사이름';
COMMENT ON COLUMN BOOK.BOOK_EB_NUMBER IS '도서구분번호';
COMMENT ON COLUMN BOOK.BOOK_CATEGORY_NUMBER IS '도서장르번호';

-- 고객 등급 테이블 생성
CREATE TABLE MEMBER_GRADE(
  MG_GRADE_NO VARCHAR2(3) CONSTRAINT PK_MG_GRADE_NO PRIMARY KEY,
  MG_GRADE_NAME VARCHAR2(30) CONSTRAINT NN_MG_GRADE_NAME NOT NULL,
  MG_MILEAGE_PER NUMBER CONSTRAINT NN_MG_MILEAGE_PER NOT NULL,
  CONSTRAINT CK_MG_GRADE_NO CHECK(MG_GRADE_NO IN('G', 'S', 'B')),
  CONSTRAINT CK_MG_GRADE_NAME CHECK(MG_GRADE_NAME IN('GOLD', 'SILVER', 'BRONZE'))
);
COMMENT ON COLUMN MEMBER_GRADE.MG_GRADE_NO IS '멤버등급번호';
COMMENT ON COLUMN MEMBER_GRADE.MG_GRADE_NAME IS '멤버등급이름';
COMMENT ON COLUMN MEMBER_GRADE.MG_MILEAGE_PER IS '등급별적립률';

-- 고객 테이블 생성
CREATE TABLE MEMBER (
    MEM_NO VARCHAR2(30) CONSTRAINT PK_MEM_NO PRIMARY KEY,
    MEM_NAME VARCHAR2(30)CONSTRAINT NN_MEM_NAME NOT NULL,
    MEM_PHONE VARCHAR2(30)CONSTRAINT NN_MEM_PHONE NOT NULL,
    MEM_ADDRESS VARCHAR2(90) CONSTRAINT NN_MEM_ADD NOT NULL,
    MEM_MILEAGE NUMBER DEFAULT 1000 CONSTRAINT NN_MEM_MILE NOT NULL,
    MEM_ID VARCHAR2(30) CONSTRAINT NN_MEM_ID NOT NULL ,
    MEM_PWD VARCHAR2(300) CONSTRAINT NN_MEM_PWD NOT NULL ,
    MEM_GRADE_NO VARCHAR2(3),   
    MEM_DROP_YN VARCHAR2(3) DEFAULT 'N' CONSTRAINT NN_MEM_DROP_YN NOT NULL,
    MEM_SUM_MONEY NUMBER DEFAULT 0 CONSTRAINT NN_MEN_SUM_MONEY NOT NULL,
    CONSTRAINT FK_MEM_GRADE_NO FOREIGN KEY (MEM_GRADE_NO) REFERENCES MEMBER_GRADE(MG_GRADE_NO),
    CONSTRAINT UK_MEM_PHONE UNIQUE(MEM_PHONE), 
    CONSTRAINT UK_MEM_ID UNIQUE(MEM_ID),
    CONSTRAINT CK_MEM_DROP_YN CHECK(MEM_DROP_YN IN('Y','N')),
    CONSTRAINT CK_MEM_GRADE_NO CHECK(MEM_GRADE_NO IN('G','S','B')),
    CONSTRAINT CK_MEM_SUM_MONEY CHECK(MEM_SUM_MONEY >= 0)
);
COMMENT ON COLUMN MEMBER.MEM_NO IS '회원번호';
COMMENT ON COLUMN MEMBER.MEM_NAME IS '회원이름';
COMMENT ON COLUMN MEMBER.MEM_PHONE IS '회원번호';
COMMENT ON COLUMN MEMBER.MEM_ADDRESS IS '회원주소';
COMMENT ON COLUMN MEMBER.MEM_MILEAGE IS '회원마일리지';
COMMENT ON COLUMN MEMBER.MEM_ID IS '회원아이디';
COMMENT ON COLUMN MEMBER.MEM_PWD IS '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEM_GRADE_NO IS '회원등급';
COMMENT ON COLUMN MEMBER.MEM_DROP_YN IS '회원탈퇴여부';
COMMENT ON COLUMN MEMBER.MEM_SUM_MONEY IS '회원누적금액';

-- 비회원 테이블 생성
CREATE TABLE NONMEMBERS
(
  NONMEMBERS_NO VARCHAR2(30) CONSTRAINT PK_NONMEMBERS_NO PRIMARY KEY
, NONMEMBERS_NAME VARCHAR2(30) CONSTRAINT NN_NONMEMBERS_NAME NOT NULL
, NONMEMBERS_PHONE VARCHAR2(30) CONSTRAINT NN_NONMEMBERS_PHONE NOT NULL
, NONMEMBERS_ADDRESS VARCHAR2(90) CONSTRAINT NN_NONMEMBERS_ADDRESS NOT NULL
);
COMMENT ON COLUMN NONMEMBERS.NONMEMBERS_NO IS '비회원번호';
COMMENT ON COLUMN NONMEMBERS.NONMEMBERS_NAME IS '비회원이름';
COMMENT ON COLUMN NONMEMBERS.NONMEMBERS_PHONE IS '비회원전화번호';
COMMENT ON COLUMN NONMEMBERS.NONMEMBERS_ADDRESS IS '비회원주소';


-- 입고 테이블 생성
CREATE TABLE INPUT_ORDER_HISTORY
(
  INPUT_ORDER_NO VARCHAR2(30) CONSTRAINT PK_INPUT_ORDER_NO PRIMARY KEY
, INPUT_BOOK_NAME VARCHAR2(300) CONSTRAINT NN_INPUT_BOOK_NAME NOT NULL
, INPUT_BOOK_AUTHOR VARCHAR2(60) CONSTRAINT NN_INPUT_BOOK_AUTHOR NOT NULL
, INPUT_BOOK_PUBLISHER_NAME VARCHAR2(60) CONSTRAINT NN_INPUT_BOOK_PUBLISHER_NAME NOT NULL
, INPUT_APPROVAL VARCHAR2(3) DEFAULT 'N' CONSTRAINT NN_INPUT_APPROVAL NOT NULL
, INPUT_BOOK_NO NUMBER
, INPUT_NEWBOOK VARCHAR2(30)
, CONSTRAINT CK_INPUT_APPROVAL CHECK(INPUT_APPROVAL IN ('Y', 'N'))
, CONSTRAINT FK_INPUT_BOOK_NO FOREIGN KEY (INPUT_BOOK_NO) REFERENCES BOOK(BOOK_NO)
, CONSTRAINT CK_INPUT_NEWBOOK CHECK(INPUT_NEWBOOK IN ('Y', 'N'))
);
COMMENT ON COLUMN INPUT_ORDER_HISTORY.INPUT_ORDER_NO IS '입고주문번호';
COMMENT ON COLUMN INPUT_ORDER_HISTORY.INPUT_BOOK_NAME IS '책 이름';
COMMENT ON COLUMN INPUT_ORDER_HISTORY.INPUT_BOOK_AUTHOR IS '작가 이름';
COMMENT ON COLUMN INPUT_ORDER_HISTORY.INPUT_BOOK_PUBLISHER_NAME IS '출판사';
COMMENT ON COLUMN INPUT_ORDER_HISTORY.INPUT_APPROVAL IS '승인 여부';
COMMENT ON COLUMN INPUT_ORDER_HISTORY.INPUT_BOOK_NO IS '도서 번호';
COMMENT ON COLUMN INPUT_ORDER_HISTORY.INPUT_NEWBOOK IS '새 도서 여부';

-- 출고 테이블 생성
CREATE TABLE OUTPUT_ORDER_HISTORY
(
  OUTPUT_ORDER_NO VARCHAR2(30) CONSTRAINT PK_OUTPUT_ORDER_NO PRIMARY KEY
, OUTPUT_NUMBER_OF_BOOKS NUMBER CONSTRAINT NN_OUTPUT_NUMBER_OF_BOOKS NOT NULL
, OUTPUT_ORDER_DATE DATE DEFAULT SYSDATE CONSTRAINT NN_OUTPUT_ORDER_DATE NOT NULL
, OUTPUT_APPROVAL VARCHAR2(3) DEFAULT 'N' CONSTRAINT NN_OUTPUT_APPROVAL NOT NULL
, OUTPUT_BOOK_NO NUMBER CONSTRAINT NN_OUTPUT_BOOK_NO NOT NULL
, OUTPUT_MEMBER_NO VARCHAR2(30)
, OUTPUT_NONMEMBERS_NO VARCHAR2(30)
, CONSTRAINT CK_OUTPUT_NUMBER_OF_BOOKS CHECK(OUTPUT_NUMBER_OF_BOOKS > 0)
, CONSTRAINT CK_OUTPUT_APPROVAL CHECK(OUTPUT_APPROVAL IN ('Y', 'N'))
, CONSTRAINT FK_OUTPUT_BOOK_NO FOREIGN KEY (OUTPUT_BOOK_NO) REFERENCES BOOK(BOOK_NO)
, CONSTRAINT FK_OUTPUT_MEMBER_NO FOREIGN KEY (OUTPUT_MEMBER_NO) REFERENCES MEMBER(MEM_NO) 
, CONSTRAINT FK_OUTPUT_NONMEMBERS_NO FOREIGN KEY (OUTPUT_NONMEMBERS_NO) REFERENCES NONMEMBERS(NONMEMBERS_NO)
);
COMMENT ON COLUMN OUTPUT_ORDER_HISTORY.OUTPUT_ORDER_NO IS '출고 주문 번호';
COMMENT ON COLUMN OUTPUT_ORDER_HISTORY.OUTPUT_NUMBER_OF_BOOKS IS '수량';
COMMENT ON COLUMN OUTPUT_ORDER_HISTORY.OUTPUT_ORDER_DATE IS '주문일자';
COMMENT ON COLUMN OUTPUT_ORDER_HISTORY.OUTPUT_APPROVAL IS '승인 여부';
COMMENT ON COLUMN OUTPUT_ORDER_HISTORY.OUTPUT_BOOK_NO IS '도서 번호';
COMMENT ON COLUMN OUTPUT_ORDER_HISTORY.OUTPUT_MEMBER_NO IS '회원 번호';
COMMENT ON COLUMN OUTPUT_ORDER_HISTORY.OUTPUT_NONMEMBERS_NO IS '비회원 번호';

-- 매니저 테이블 생성
CREATE TABLE MANAGER
(
  MANAGER_NUM VARCHAR2(30) CONSTRAINT PK_MANAGER_NUM PRIMARY KEY         
, MANAGER_NAME VARCHAR2(30) CONSTRAINT NN_MANAGER_NAME NOT NULL         
, MANAGER_GRADE VARCHAR2(30) CONSTRAINT NN_MANAGER_GRADE NOT NULL       
, MANAGER_PHONE VARCHAR2(30) CONSTRAINT NN_MANAGER_PHONE NOT NULL        
, MANAGER_ADDRESS VARCHAR2(90) CONSTRAINT NN_MANAGER_ADDRESS NOT NULL    
, MANAGER_ID VARCHAR2(30) CONSTRAINT NN_MANAGER_ID NOT NULL              
, MANAGER_PWD VARCHAR2(30) CONSTRAINT NN_MANAGER_PWD NOT NULL            
, MANAGER_SALARY NUMBER CONSTRAINT NN_MANAGER_SALARY NOT NULL            
, MANAGER_DROP_YN VARCHAR2(30) CONSTRAINT NN_MANAGER_DROP_YN NOT NULL    
, CONSTRAINT CK_MANAGER_GRADE CHECK(MANAGER_GRADE IN ('MASTER', 'SUBMASTER', 'PART_TIMER'))
, CONSTRAINT UK_MANAGER_PHONE UNIQUE(MANAGER_PHONE)
, CONSTRAINT UK_MANAGER_ID UNIQUE(MANAGER_ID)
, CONSTRAINT CK_MANAGER_SALARY CHECK(MANAGER_SALARY > 0)  
, CONSTRAINT CK_MANAGER_DROP_YN CHECK(MANAGER_DROP_YN IN ('Y', 'N'))
);
COMMENT ON COLUMN MANAGER.MANAGER_NUM IS '관리자번호';
COMMENT ON COLUMN MANAGER.MANAGER_NAME IS '관리자이름';
COMMENT ON COLUMN MANAGER.MANAGER_GRADE IS '관리자등급';
COMMENT ON COLUMN MANAGER.MANAGER_PHONE IS '관리자연락처';
COMMENT ON COLUMN MANAGER.MANAGER_ADDRESS IS '관리자주소';
COMMENT ON COLUMN MANAGER.MANAGER_ID IS '관리자아이디';
COMMENT ON COLUMN MANAGER.MANAGER_PWD IS '관리자비밀번호';
COMMENT ON COLUMN MANAGER.MANAGER_SALARY IS '관리자월급';
COMMENT ON COLUMN MANAGER.MANAGER_DROP_YN IS '탈퇴여부';

-- 매장 재산 테이블 생성
CREATE TABLE STORE_SUM_MONEY
(
  STORE_SUM_MONEY NUMBER
, CONSTRAINT CK_STORE_SUM_MONEY CHECK(STORE_SUM_MONEY >0)
);

COMMENT ON COLUMN STORE_SUM_MONEY.STORE_SUM_MONEY IS '매장보유금액';

-- 매장 매출 내역 테이블 생성
CREATE TABLE STORE_SALES_HISTORY
(
  SSH_SALES_CODE VARCHAR2(30) CONSTRAINT PK_SSH_SALES_CODE PRIMARY KEY                                                  
, SSH_MONEY NUMBER CONSTRAINT NN_SSH_MONEY NOT NULL                                                                      
, SSH_DBELOPER_DATE DATE DEFAULT SYSDATE CONSTRAINT NN_SSH_DBELOPER_DATE NOT NULL                                                        
, SSH_INCOME_STATEMENT VARCHAR2(30) CONSTRAINT NN_SSH_INCOME_STATMENT NOT NULL                                                             
, CONSTRAINT CK_SSH_MONEY CHECK(SSH_MONEY > 0)
, CONSTRAINT CK_SSH_INCOME_STATEMENT CHECK(SSH_INCOME_STATEMENT IN ('입금', '출금', '월급지급'))
);
COMMENT ON COLUMN STORE_SALES_HISTORY.SSH_SALES_CODE IS '매출코드';
COMMENT ON COLUMN STORE_SALES_HISTORY.SSH_MONEY IS '금액';
COMMENT ON COLUMN STORE_SALES_HISTORY.SSH_DBELOPER_DATE IS '날짜';
COMMENT ON COLUMN STORE_SALES_HISTORY.SSH_INCOME_STATEMENT IS '내역';

-- 리뷰 작성 테이블 생성
DROP SEQUENCE SEQ_REVIEW;
CREATE SEQUENCE SEQ_REVIEW NOCACHE;

CREATE TABLE REVIEW 
(
  REVIEW_NO NUMBER DEFAULT SEQ_REVIEW.NEXTVAL CONSTRAINT PK_REVIEW_NO PRIMARY KEY
, REVIEW_MEM_NO VARCHAR2(30) CONSTRAINT NN_REVIEW_MEM_NO NOT NULL
, REVIEW_BOOK_NO NUMBER CONSTRAINT NN_REVIEW_BOOK_NO NOT NULL
, REVIEW_CONTENTS VARCHAR2(3000) CONSTRAINT NN_REVIEW_CONTENTS NOT NULL
, REVIEW_AWARD VARCHAR2(30) DEFAULT 'Y' CONSTRAINT NN_REVIEW_AWARD NOT NULL
, CONSTRAINT FK_REVIEW_NO FOREIGN KEY (REVIEW_MEM_NO) REFERENCES MEMBER(MEM_NO)
, CONSTRAINT FK_REVIEW_BOOK_NO FOREIGN KEY (REVIEW_BOOK_NO) REFERENCES BOOK(BOOK_NO)
, CONSTRAINT CK_REVIEW_AWARD CHECK(REVIEW_AWARD IN ('Y','N'))
);

COMMENT ON COLUMN REVIEW.REVIEW_NO IS '리뷰 작성 번호';
COMMENT ON COLUMN REVIEW.REVIEW_MEM_NO IS '리뷰작성자 번호';
COMMENT ON COLUMN REVIEW.REVIEW_BOOK_NO IS '리뷰 책 번호';
COMMENT ON COLUMN REVIEW.REVIEW_AWARD IS '리뷰 내용';
COMMENT ON COLUMN REVIEW.REVIEW_AWARD IS '리뷰 작성 내용';

--마일리지 테이블
CREATE TABLE MILEAGE
(
    MILEAGE_PRODUCTNO VARCHAR2(60) CONSTRAINT PK_MILEAGE_PRODUCTNO PRIMARY KEY
  , MILEAGE_PRODUCTNAME VARCHAR2(60) CONSTRAINT NN_MILEAGE_PRODUCTNAME NOT NULL
  , MILEAGE_PRODUCTPRICE NUMBER CONSTRAINT NN_MILEAGE_PRODUCTPRICE NOT NULL
  , CONSTRAINT CK_MILEAGE_PRODUCTPRICE CHECK(MILEAGE_PRODUCTPRICE >= 0)
);

COMMENT ON COLUMN MILEAGE.MILEAGE_PRODUCTNO IS '마일리지 상품번호';
COMMENT ON COLUMN MILEAGE.MILEAGE_PRODUCTNAME IS '마일리지 상품명';
COMMENT ON COLUMN MILEAGE.MILEAGE_PRODUCTPRICE IS '마일리지 상품가격';

SELECT * FROM INPUT_ORDER_HISTORY;
SELECT * FROM OUTPUT_ORDER_HISTORY;
SELECT * FROM EB;
SELECT * FROM BOOK_CATEGORY;
SELECT * FROM BOOK; 
SELECT * FROM MEMBER;
SELECT * FROM MEMBER_GRADE;
SELECT * FROM MANAGER;
SELECT * FROM STORE_SALES_HISTORY;
SELECT * FROM NONMEMBERS;
SELECT * FROM REVIEW;
SELECT * FROM STORE_SUM_MONEY;
SELECT * FROM MILEAGE;
COMMIT;