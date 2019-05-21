-- subquery
--neena가 근무하는 부서의 이름? 

select department_id, first_name
from EMPLOYEES
where first_name = 'Neena';

select department_name
from departments d
where department_id = (
		select department_id
		from EMPLOYEES
		where first_name = 'Neena'
		);

select first_name, department_name
from departments d join employees e
on e.first_name = 'Neena' and e.department_id = d.department_id;


select department_name
from departments d
where d.department_id in (
	select department_id
	from employees
	where first_name = 'Steven' 
);

select department_name
from departments d join employees e
on d.department_id = e.department_id 
and e.first_name = 'Steven'


-- 평균 급여 이상을 받고 있는 직원의 이름

select *
from employees
where salary >= (
		select avg(salary)
		from employees
)

--최대급여를 받고 있는 직원
select first_name, salary
from employees 
where salary = (
		select max(salary) 
		from employees )


--데이비드가 근무하는 부서의 이름 찾기

select department_name
from departments
where department_id  in  (
	select department_id
	from employees
	where first_name = 'David')

select department_name
from departments
where department_id  = any  (
	select department_id
	from employees
	where first_name = 'David')
	
-- 20000보다 커야 함. 	=  and 
select first_name, salary 
from employees
where salary >= all (15000, 20000)

-- 15000보다 크면 됨.  =  or
select first_name, salary 
from employees
where salary >= any (15000, 20000)

-- 30번 부서의 직원들의 급여보다 많은 급여를 받는 직원들을 조회하라
select *
from employees
where salary > all (
		select salary
		from employees
		where department_id = 30)

select *
from employees
where salary >  (
		select max(salary)
		from employees
		where department_id = 30)

select *
from employees
where salary >  (
		select min (salary)
		from employees
		where department_id = 30)

		
		
