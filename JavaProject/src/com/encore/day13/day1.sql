select * from DEPARTMENTS;
--desc departments;

select 
DEPARTMENT_ID, 
DEPARTMENT_NAME from DEPARTMENTS;

select EMPLOYEE_ID
, FIRST_NAME
, LAST_NAME, department_id  from EMPLOYEES;

select distinct department_id from employees; 

select first_name as 이름, salary "나의 급여"  , salary *12 연봉 from employees;

select first_name as 이름, salary "나의 급여"  , salary *12 연봉,  '엔코아' "회사명", department_id 부서코드,
COMMISSION_PCT 
from employees;

select first_name as 이름, salary, salary*nvl(COMMISSION_PCT, 0) "나의 급여"  , salary *12 연봉,  '엔코아' "회사명", department_id 부서코드,
COMMISSION_PCT 
from employees
order by "나의 급여" desc ;  

-- null을 0으로 : nvl
select first_name as 이름, salary, salary*nvl(COMMISSION_PCT, 0) "나의 급여"  , salary *12 연봉,  '엔코아' "회사명", department_id 부서코드,
commission_pct 
from employees
order by 1  ;  

-- 부서배치 안된 직원 조회
select first_name, salary, hire_date, department_id
from employees
where department_id is  NULL;

select first_name || ' ' || last_name from employees; 

-- 조건절
select *
from employees
where department_id <=90;

select *
from employees
where first_name = 'Steven';

select *
from EMPLOYEES
where hire_date >='1982/01/01'

-- 2005년 이후 입사자
select *
from EMPLOYEES
where hire_date >='2005/01/01'
and job_id = 'ST_CLERK'
or Salary >=3000 
order by hire_date

select *
from EMPLOYEES
where not job_id = 'ST_CLERK'

select *
from EMPLOYEES
where salary >=10000 and salary <=20000

-- between 작은 수  and 큰수 
select *
from EMPLOYEES
where salary  between 10000 and 20000;

select *
from EMPLOYEES
where salary  between 10000 and 10000;

select *
from employees
where (department_id = 10 or department_id = 20 or department_id = 60 ) and job_id = 'MK_MAN'

select *
from employees
where department_id in (10,20,60) and job_id = 'MK_MAN'

select *
from employees
where first_name like 'S____'

select *
from employees
where first_name like '%n'

select *
from employees
where first_name like '%N'

select *
from employees
where first_name like '__n'

select *
from employees
where first_name like '%oh%'

select * 
from employees
where length(first_name)  = 6;

select *
from employees 
where substr(first_name, -1,1) = 'r'

select *
from employees 
where substr(first_name, length(first_name),1) = 'r'

select *
from employees 
where first_name like '_______r'






