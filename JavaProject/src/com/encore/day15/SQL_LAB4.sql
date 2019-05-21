--========================================
--		SubQuery
--========================================
--1. 'IT'부서에서 근무하는 직원들의 이름, 급여, 입사일을 조회하시오.
select *
from employees
where department_id = (
		select department_id
		from departments
		where department_name = 'IT')


--2. 'Alexander' 와 같은 부서에서 근무하는 직원의 이름과 부서id를 조회하시오.
select first_name, department_id
from employees
where department_id in (
				select department_id
				from employees
				where first_name = 'Alexander' )
and first_name <> 'Alexander'

select e1.first_name, e1. department_id
from employees e1 , employees e2
where e1.department_id in e2.department_id
and e2.first_name = 'Alexander'
and e1.first_name <> 'Alexander'

--3. 80번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 부서id, 급여를 조회하시오.
select first_name, department_id, salary
from employees
where salary > (
			select avg(salary)
			from employees
			where department_id = 80)

--4. 'South San Francisco'에 근무하는 직원의 최소급여보다 급여를 많이 받으면서 
--50 번부서의 평균급여보다 많은 급여를 받는 직원의 이름, 급여, 부서명, -
--부서id를 조회하시오.
select first_name, salary, department_name, d.department_id
from employees e join departments d on e.department_id = d.department_id
where salary > all (
(select min(salary)
from employees e join departments d on e.department_id = d.department_id 
				join locations l on l.location_id = d.location_id
where l.city = 'South San Francisco'), 
 (select avg(salary) 
		from employees
		where department_id = 50) 
)
----------------------------------------------------
--부서별 최소 급여를 받는 직원을 조회
select first_name, department_id, salary
from employees
where (department_id, salary) = any (
select  department_id, min(salary)
from employees
group by department_id
)

--------------------------------
----inline view
-- 다중컬럼을 반환하는 서브쿼리

select e.first_name, e.department_id, e.salary
from (
select  department_id, min(salary) minsal
from employees
group by department_id) aa, employees e
where aa.department_id = e.department_id
and minsal = e.salary

---------부서별 입사일이 가장 늦은 직원 정보를 구하여라
select first_name, e.department_id, hire_date
from (
	select department_id, max(hire_date) maxd
	from employees
	group by department_id) ee, employees e
where ee.department_id = e.department_id
and maxd = e.hire_date

-----------------------------
-- 본인이 받는 급여가 본인이 속한 부서의 평균 급여보다 적은 급여를 받는 직원의 이름, 부서번호, 급여를 조회하시오. 
select e.first_name, e.department_id, salary, avgsal
from employees e, 
	(select department_id, avg(salary) avgsal
	from employees
	group by department_id
	) ee
where salary <ee.avgsal 
and e.department_id = ee.department_id

select  department_id,  min(salary)
from employees
group by department_id

-------------------scott/tiger (emp, dept)

--1. BLAKE와 동일한 부서에 속한 모든 사원의 이름및 입사일을 표시하는 질의를 작성하시오.
-- 결과에서 BLAKE는 제외시킵니다.
select * from tab; 
select * from EMP;
select * from salgrade; 
select * from bonus;
select * from dept;

select ename, hiredate, deptno
from emp
where emp.deptno in (select deptno 
from emp
where ename = 'BLAKE'
)
and ename <> 'BLAKE'

--2. 부서의 위치가 DALLAS인 모든 사원의 이름, 부서번호 , 직무를 표시하시오 
select ename, emp.deptno, job, loc
from emp join dept on dept.deptno = emp.deptno
where dept.loc= 'DALLAS'

--3. KING에게 보고하는 모든 사원의 이름과 급여를 표시하는 질의를 작성하시오 
select * from EMP;
select emp1.ename, emp1.sal, emp2.ename
from emp emp1 join emp emp2 on
emp1.mgr = emp2.empno
where emp2.ename='KING'
 
-- SELF JOIN
--1. 직원의 이름과 관리자 이름을 조회하시오.
select  emp1.ename, mgr.ename
from emp emp1 join emp mgr on emp1.mgr = mgr.empno

--2. 직원의 이름과 관리자 이름을 조회하시오.
- 관리자가 없는 직원정보도 모두 출력하시오.
select  emp1.ename, mgr.ename
from emp emp1 left outer join emp mgr on emp1.mgr = mgr.empno

select * from emp

--3. 관리자 이름과 관리자가 관리하는 직원의 수를 조회하시오.
--단, 관리직원수가 3명 이상인 관리자만 출력되도록 하시오.
select e1.ename, ce
from (
	select mgr, count(empno) ce
	from emp 
	group by mgr) aa join emp e1
on e1.empno = aa.mgr
where ce >=3

select e1.ename, ce
from (
	select mgr, count(empno) ce
	from emp 
	group by mgr) aa, emp e1
where e1.empno = aa.mgr
and ce >=3

========================================
		SubQuery
========================================


1. 직원들의 이름, 입사일, 부서명을 조회하시오.
단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
그리고 부서가 없는 직원에 대해서는 '<부서없음>' 이 출력되도록 한다.
(outer-join , nvl() )

select first_name, hire_date, nvl(department_name, '<부서없음>')
from employees  e left outer join departments d on e.department_id= d.department_id


2. 직원의 직책에 따라 월급을 다르게 지급하려고 한다.
직책에 'Manager'가 포함된 직원은 급여에 0.5를 곱하고
나머지 직원들에 대해서는 원래의 급여를 지급하도록 한다. 
적절하게 조회하시오. (decode)

select first_name, job_title,  salary,  decode(instr(job_title, 'Manager', 1,1), 0, salary,  salary*1.5) 
from employees e join jobs j on j.job_id = e.job_id

select first_name, job_title,  salary,  decode(substr(job_title, -7,7), 'Manager', salary*1.5,  salary) 급여
from employees e join jobs j on j.job_id = e.job_id
---------------------------------------------------
union을 사용할 수도 있음. 
select employee_id, first_name, '직원'
from employees
union
select department_id, department_name, '부서'
from departments
order by 3

3. 각 부서별로 최저급여를 받는 직원의 이름과 부서id, 급여를 조회하시오.
select first_name, e.department_id, salary
from employees e, (select department_id, min(salary) minsal
from employees
group by department_id) ee
where e.department_id = ee.department_id
and salary = minsal

4. 각 직급별(job_title) 인원수를 조회하되 사용되지 않은 직급이 있다면 해당 직급도
출력결과에 포함시키시오. 그리고 직급별 인원수가 3명 이상인 직급만 출력결과에 포함시키시오.

select job_title, count(employee_id)
from employees e right outer join jobs j on e.job_id = j.job_id
group by job_title
having count(*) >=3

5. 각 부서별 최대급여를 받는 직원의 이름, 부서명, 급여를 조회하시오.
select first_name, department_name, salary
from employees e join departments d on e.department_id = d.department_id
where (e.department_id, salary) in (
select department_id, min(salary)
from employees
group by department_id)


6. 직원의 이름, 부서id, 급여를 조회하시오. 그리고 직원이 속한 해당 부서의 
최소급여를 마지막에 포함시켜 출력 하시오.
select first_name, e.department_id, salary, ee.minsal
from employees e, 
(select department_id, min(salary) minsal
from employees
group by department_id) ee
where e.department_id = ee.department_id 
			
