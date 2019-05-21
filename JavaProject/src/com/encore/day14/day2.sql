select * 
from EMPLOYEES
order by 9 --table의 컬럼 

select * 
from EMPLOYEES
order by commission_pct desc nulls last ; -- null을 뒤로 미루는 option

select * 
from EMPLOYEES
order by commission_pct desc nulls first ; -- null을 앞으로 당기는 option

select sysdate
from EMPLOYEES
where employee_id= 100

select 10+20
from dual;

select sysdate
from dual;

-- 숫자함수
select 10+20, -10, abs(-10) 절대치
from dual;

select floor(2.9) 버림, ceil(2.1) 올림, round(2.62645, 2) 반올림
from dual; 

select round(2.62645, 2) 반올림, round(2.62645, 0) 반올림, round(32.62645, -1) 반올림
from dual; 

select mod(27,10) 
from dual; 

-- 문자 함수

select  first_name, lower(first_name) "소 문자", upper(first_name)  대문자,  initcap(email) 첫문자대문자, 
Initcap('ORACLE mysqul'), substr(first_name,1,3) 첫3자리, substr(first_name, -3,3) 끝3자리 
from employees

select * 
from jobs
where substr(job_title, -7,7) = 'Manager';

select * 
from jobs
where job_title like '%Manager';

select  length('오라클') 길이, lengthb('오라클') 길이, length('oracle') , lengthb('oracle')
from dual; 

select instr('Welcome to Oracle',  'Wel',1,1 )
from dual; 

select first_name, instr(first_name, 'r', 1, 2) -- first name에서 r의 위치, 시작위치, 몇번째
from EMPLOYEES;

select first_name, lpad(first_name, 10, '*') 왼쪽채우기, rpad(first_name, 10, '*') 오른쪽채우기
from Employees; 

select *
from employees;

select '*' || trim('   ORACLE     ') || '*' 자르기,
'*' || ltrim('   ORACLE     ') || '*' 자르기,
'*' || rtrim('   ORACLE     ') || '*' 자르기
from dual;

select  trim(both 'a' from trim('aaaaORACLEaaa   ')),
  trim(leading 'a' from trim('aaaaORACLEaaa   ')) 왼쪽자르기,
  trim(trailing 'a' from trim('aaaaORACLEaaa   ')) 오른쪽자르기
  from dual;

---날짜 함수

select sysdate+30, sysdate+7 "7일후",  hire_date, 
to_char(hire_date, 'yyyy/mm/dd day'),
next_day(hire_date, '일요일') 첫휴일, 
last_day(hire_date) 달의말일, 
sysdate-hire_date 근무일수, 
months_between(sysdate, hire_date) 입사월수
from employees; 

select floor(months_between(sysdate, hire_date) /12) 입사월수,
		add_months(sysdate-20, 7) "7개월후"
from employees; 

select sysdate, to_char(sysdate, 'scc  yyyy/mm/dd am hh24:mi:ss dy')
from dual 

select first_name, salary, to_char(salary, 'L999,999,999'), to_char(salary, 'L000,000,000')
from employees;

select hire_date
from employees
where hire_date = '2001/01/13'

select hire_date
from employees
where hire_date = '2001-01-13'

select hire_date
from employees
where to_char(hire_date, 'yyyy.mm.dd') = '2001.01.13'

select '100' + 200, '100' + '200', '100' ||'200'
from dual;

select concat(first_name, last_name), first_name || ' ' || last_name,  salary || department_id
from employees;

select first_name, salary, commission_pct, nvl(commission_pct, 0), 
nvl2(commission_pct, commission_pct*100,1)
from employees;

-- 커미션이 있으면 보여주고 없으면 없어...
select first_name, salary, commission_pct,  
nvl(to_char(commission_pct), '없음'),
nvl2(commission_pct, to_char(commission_pct),'없음')
from employees;

select department_id, decode(department_id, 10, '개발부',
							 20, '영업부',
							 '기타')		
from employees;

--case 
select first_name, salary,
case when salary>15000 then 'A'
	 when salary>10000 then 'B'
	 when salary>50000 then 'C'
	 else 'D' end "급여 level1"
from employees

select first_name, 
case when first_name like 'S%' then 'S로 시작' else '아니다' end
from employees

---그룹함수
select sum(salary), round(avg(salary), 3), max(salary), min(salary), 
round(stddev(salary), 4), variance(salary), count(first_name),
count(commission_pct), count(department_id), count(distinct department_id)
from employees

select department_id,  avg(salary)
from employees
group by department_id
order by 1

select department_id, job_id,  avg(salary)
from employees
group by department_id, job_id
order by 1

select department_id, job_id,  avg(salary)
from employees
group by rollup(department_id, job_id)
order by 1


select department_id, job_id,  avg(salary), sum(salary)
from employees
group by cube(department_id, job_id)
order by 1


select department_id, avg(salary), sum(salary) --5
from employees --1
where 1 = 1 --2
group by department_id --3
having sum(salary) >=10000 --4
order by 1 --6

select count(*)
from departments


-- JOIN :크로스 조인
--  equi join 

-- Vendor 문법 (oracle, mySQL)
select first_name, department_name
from EMPLOYEES, DEPARTMENTS
where EMPLOYEES.department_id = departments.department_id;

--ANSI 표준
select first_name, department_name
from EMPLOYEES join DEPARTMENTS
using (department_id) -- id이름이 다르거나 같은 id가 있을때는 사용불가. 

select first_name, department_name
from EMPLOYEES join DEPARTMENTS
on EMPLOYEES.department_id = departments.department_id
where salary > 15000

select e.first_name, e.salary, e.hire_date, j.job_title, j.job_id
from employees e, jobs j
where e.job_id = j.job_id

select count (*)
from jobs

select e.first_name, e.salary, e.hire_date, j.job_title, job_id
from employees e join jobs j
using (job_id)

select *
from emp;


select * from tab; 

select * from salgrade;

select *
from emp, SALGRADE
where sal between losal and hisal;


select sal, losal, hisal
from emp, SALGRADE
where sal between losal and hisal;

CREATE TABLE SALGRADE
( GRADE NUMBER,
LOSAL NUMBER,
HISAL NUMBER );
INSERT INTO SALGRADE VALUES (1,700,4000);
INSERT INTO SALGRADE VALUES (2,4001,7000);
INSERT INTO SALGRADE VALUES (3,7001,10000);
INSERT INTO SALGRADE VALUES (4,10001,15000);
INSERT INTO SALGRADE VALUES (5,15001,30000);

select * from tab;
select * from salgrade;

select first_name, salary, grade
from employees, salgrade
where salary between losal and hisal
order by first_name

select * from EMPLOYEES

select emp.employee_id, emp.first_name "직원 이름", manager.first_name "매니저 이름"
from employees emp, employees manager
where emp.manager_id = manager.employee_id(+)
order by 1

select emp.employee_id, emp.first_name "직원 이름", manager.first_name "매니저 이름"
from employees emp inner join employees manager
on emp.manager_id = manager.employee_id
order by 1

-- ANSI 표준 / SELF 조인 /Equi 조인  - left outer/right outer
select emp.employee_id, emp.first_name "직원 이름", manager.first_name "매니저 이름"
from employees emp left outer join employees manager
on emp.manager_id = manager.employee_id
order by 1

select emp.employee_id, emp.first_name "직원 이름", manager.first_name "매니저 이름"
from  employees manager right outer join employees emp
on emp.manager_id = manager.employee_id
order by 1

select first_name, department_name 
from employees e, departments d
where e.department_id = d.department_id(+)

select first_name, department_name 
from employees e full outer join departments d
on e.department_id = d.department_id

select job_id,lpad(substr  (job_id,  instr(job_id,'_'), length(job_id) ), length(job_id),'*')
from employees



