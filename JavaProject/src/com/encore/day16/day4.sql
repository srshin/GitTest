
-----------------------------------------------------------------------------------------
--        [    JOIN    ]  
-----------------------------------------------------------------------------------------

-- outer join 
select student.name, nvl(professor.name||'교수님', '지도교수없음'), nvl2(professor.name, professor.name||'교수님', '지도교수없음')
from student left outer join PROFESSOR using(profno);

select * from p_grade;

select name, pay, position, s_pay, e_pay from emp2 left outer join p_grade using(position);

select s.name, s.deptno1, p.name
from student s join professor p
on s.profno = p.profno and s.deptno1 = 101;

-- join 문에 조건을 줄 수도 있음. 
select gift.gname, count(gift.gname)
from gogak join gift on point between g_start and g_end
group by gift.gname;

-- ansi
select s.name, e.total, h.grade
from student s join exam_01 e on s.studno = e.studno
			join hakjum h on total between min_point and max_point ;

--oracle
select s.name, e.total, h.grade
from student s, exam_01 e, hakjum h 
where  s.studno = e.studno
and e.total between h.min_point and h.max_point ;

select trunc((sysdate-birthday)/365), sysdate, e.birthday, p.position, e.position
from emp2 e join p_grade p on trunc((sysdate-birthday)/365) between s_age and e_age;

-- 조인시 공통 컬럼 이름이 동일한 경우 using사용
select student.name 학생이름, professor.name 교수이름 
from student right outer join PROFESSOR using(profno);

------- nvl : null을 대체 
select nvl(student.name, '****'), nvl(professor.name, '####')
from student full outer join professor
on student.profno = professor.profno;

select low.dcode, low.dname 부서,  high.dname 상위부서
from dept2 low left outer join dept2 high
on  low.pdept = high.dcode
order by low.dcode;

----------------------------------------------------
-- SUB QUERY 
----------------------------------------------------
-- 이윤나의 전공과 같은 학생  
select name, dname
from STUDENT s join department d on s.deptno1 = d.deptno
where deptno1 = 
	(select deptno1
	from student s
	where name='이윤나')
	and
	name <> '이윤나';
	

select p.name, hiredate, dname
from professor p join department d on  p.deptno = d.deptno
where hiredate > (select hiredate
from professor
where name = '송도권');

select name, weight from student
where weight > (
	select avg(weight)
	from student
	where deptno1 = 101
	);

select name, pay, hiredate
from professor
where hiredate = (
				select hiredate
				from professor
				where name = '심슨') 
and pay < (
				select pay
				from professor
				where name = '조인형');

-----다중비교 : IN ANY ALL
select * 
from EMP2
where deptno in 
			(
			select dcode
			from dept2
			where area ='서울지사');

select name, position, to_char(pay, '999,999,999') || ' 원' 연봉
from emp2
where pay > any ( 
				select pay
				from EMP2
				where position='과장');
-------------------------------------
--(3) student 테이블을 조회하여 전체 학생중에서 체중이 4학년 학생들의 체중에서 가장 적게 나가는 학생보다 몸무게가 적은
-- 학생의 이름과 학년과 몸무게를 출력하세요. 
select name, grade, weight
from student
where weight < all (
select weight
from STUDENT
where grade = 4
);

------------------------
-- (1) 다중컬럼 sub query예1 :
-- student 테이블을 조회하여 각 학년별로 최대키를 가진 학생들의 학년과 이름과 키를 출력하세요.

select grade, name, height 
from student
where (grade, height) in (
							select grade, max(height)
							from student
							group by grade)
order by grade;
---------------
 
select s.grade, s.name, s.height 
from student s join (
						select grade , max(height) h
						from student
						group by grade) aa
on s.grade = aa.grade and s.height = aa.h
order by s.grade;
--------------------------------------------
-- (2) professor 테이블을 조회하여 각 학과별로 입사일이 가장 오래된 교수의 교수번호와
-- 이름, 학과명을 출력하세요(학과이름순으로 오름차순 정렬하세요)
select p.profno, p.name, p.hiredate, d.dname
from professor p join department d on d.deptno = p.deptno
			join (select deptno, min(hiredate) h
					from professor
					group by deptno ) aa
on p.deptno = aa.deptno and p.hiredate = aa.h
order by 4;
----------------------
--(3) emp2 테이블을 조회하여 직급별로 해당직급에서 최대연봉을 받는 직원의 이름과
-- 직급, 연봉을 출력하세요. 연봉순으로 오름차순으로 정렬하세요 
select emp2.name, emp2.position, emp2.pay
from emp2, (
				select position, max(pay) maxpay
				from emp2
				group by position) ee
where emp2.position = ee.position 
and emp2.pay = ee.maxpay
order by 3;
--------------------------------------------
-- (4) emp2 테이블을 조회하여 각부서별 평균 연봉을 구하고 그 중에서 평균 연봉이가장 적은 부서의 
-- 평균 연봉보다 적게 받는 직원들의 부서명, 직원명, 연봉을 출력하세요. 
select dname,  name, pay 
from emp2 e join dept2 d
on e.deptno=d.dcode
where pay < all (
					select avg(pay)
					from emp2
					group by position
					) 
order by pay

---------------------------------------------------
-- 상호연관 subquery
-- (1) emp2 테이블을 조회하여 직원들 중 자신의 직급의 평균 연봉과 같거나 많이 받는 사람들의 이름과 직급, 
-- 현재연봉을 출력하세요. 
-------------------------
select emp2.name, emp2.position, emp2.pay
from emp2, (
				select position, avg(pay) avgpay
				from EMP2
				group by position) aa
where emp2.position = aa.position and pay >=avgpay
order by emp2.pay desc;

------------------------------
-- Scalar sub query 예
--  emp2 테이블과 dept2테이브를 조회하여 사원들의 이름과 부서이름을 출력하세요
select name, dname
from EMP2 join dept2 on emp2.deptno = dept2.dcode;

select name, (select dname from dept2 where emp2.deptno = dept2.dcode)
from emp2;

select rowid, deptno
from emp2;


-----------------------------------------------------------
--DDL 문장 /CREATE /INSERT/DROP/ALTER
---------------------------------------------------------
--- CREATE	
create table emp01(
	empno number(4),
	ENAME VARCHAR2(20),
	sal NUMBER(7,2),
	year01 interval year(3) to month,
	day01 interval day(3) to second
	
);

-- INSERT 
insert into emp01(empno) values(1)
insert into emp01(empno, ename) values(2, '현진우')
insert into emp01(empno, ename, sal) values(3, '허정표', 500)
insert into emp01(empno, ename, sal, year01) values(3, '정인창', 500, interval '36' month(3));
insert into emp01(empno, ename, sal, year01) values(15, '정인창', 500, interval '361' month(3));
insert into emp01(empno, ename, sal, year01, day01) values(3, '정인창', 500, interval '90' month(3), interval '100' day(3));
insert into emp01(empno, ename, sal, year01, day01) values(5, '정인창', 500, interval '36' month(3), interval '1000' day(3));


select empno, ename, sal, year01, sysdate+year01 from emp01
select empno, ename, sal, year01, sysdate+year01, sysdate+day01, sysdate+100 from emp01
-- DROP : TABLE삭제. 복구안됨!
drop table dept01;
create table dept01 (
deptno number(2),
dname varchar2(14),
loc varchar2(20)
);
insert into dept01(deptno) values(1);
insert into dept01 values(1,'엔코어', '서울');

-- INSERT (다른 TABLE을 이용한)  : 대량으로 데이타 입력: select한 결과(SUBQUREY)를 table에 넣어줌. 
insert into dept01 select * from dept; 

insert into dept01 select rownum, ename, job from emp;
-- CREATE TABLE (다른 TABLE을 이용한)  & INSERT : 데이타 입력도 한번에 함.  
create table emp02
as
select * from EMP;

-- CREATE TABLE :다른 TABLE을 이용함. 조건을 줄 수 있음!
create table emp03
as
select * from emp2
where emp_type='정규직';

-- CREATE TABLE: 다른 TABLE을 이용함 - 단, 데이타는 입력하지 않고 구조만 가져옴. 
create table emp05
as
select * from EMP2
where 1=2;

-----------------------------------
--  구조만 복사 (서브쿼리 활용)
create table dept02
as
select * from dept01
where 1=2

----------------------------------
-- ALTER: 테이블 구조 변경
-- 새로운 컬럼 추가  
alter table emp01
add job varchar2(20);
-- 기존 컬럼 변경 
alter table emp01
modify job varchar2(30);
-- 컬럼 삭제 
alter table emp01
drop column job;


drop table emp01;

-- 테이블 이름 변경 
rename emp02 to emp07;
select * from user_tables
order by 1;

select *
from all_tables;

select * from tab;

select *
from all_users

