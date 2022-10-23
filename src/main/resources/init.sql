-- IF NOT EXISTS 만약 없다면 테이블을 만들어줘 

 CREATE TABLE IF NOT EXISTS DEPT (
      DEPTNO DECIMAL(2),
      DNAME VARCHAR(14),
      LOC VARCHAR(13),
      CONSTRAINT PK_DEPT PRIMARY KEY (DEPTNO) 
  );

  CREATE TABLE IF NOT EXISTS EMP (
      EMPNO DECIMAL(4),
      ENAME VARCHAR(10),
      JOB VARCHAR(9),
      MGR DECIMAL(4),
      HIREDATE DATE,
      SAL DECIMAL(7,2),
      COMM DECIMAL(7,2),
      DEPTNO DECIMAL(2),
      CONSTRAINT PK_EMP PRIMARY KEY (EMPNO),
      CONSTRAINT FK_DEPTNO FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
  );
  
-- 로그 테이블 생성하기
-- AUTO_INCREMENT 자동으로 값이 1씩 증가
CREATE TABLE emp_logs(
	log_id bigint(20) AUTO_INCREMENT PRIMARY KEY COMMENT '로그 번호',
	ip varchar(50) COMMENT '사용자 아이피',
	url varchar(100) COMMENT '접속 경로',
	http_method varchar(10) COMMENT 'http method',
	create_at datetime comment '접속 시간'
)