========================================
		JOIN
========================================

1.직원들의 이름과 직급명(job_title)을 조회하시오.
select first_name, job_title
from employees e join jobs j
on e.job_id = j.job_id

2.부서이름과 부서가 속한 도시명(city)을 조회하시오.
select department_name, city 
from departments d join locations l
on d.location_id = l.location_id;

select count(*)
from departments
where location_id is null;

select * 
from departments

3. 직원의 이름과 근무국가명을 조회하시오. (employees, departments, locations,countries)
select first_name, last_name, country_name
from employees e join departments d on e.department_id = d.department_id
				join locations l on d.location_id = l.location_id
				join countries c on c.country_id = l.country_id
				
select first_name, last_name, country_name
from employees, departments, locations, countries
where employees.department_id = departments.department_id
and departments.location_id = locations.location_id
and locations.country_id = countries.country_id;

4. 직책(job_title)이 'manager' 인 사람의 이름, 직책, 부서명을 조회하시오.
select first_name, job_title, department_name
from jobs 	join employees e on jobs.job_id = e.job_id
			join departments d on e.department_id = d.department_id
where job_title like '%Manager%'

select first_name, job_title, department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id
and e.department_id = d.department_id
and substr(j.job_title, -7,7) = initcap('manager')


5. 직원들의 이름, 입사일, 부서명을 조회하시오.
select first_name, hire_date, department_name
from employees e
join departments d
on e.department_id = d.department_id

6. 직원들의 이름, 입사일, 부서명을 조회하시오.
단, 부서가 없는 직원이 있다면 그 직원정보도 출력결과에 포함시킨다.
select first_name, hire_date, department_name
from employees e left outer join departments d 
on e.department_id = d.department_id


select count(*)
from employees e left outer join departments d 
on e.department_id = d.department_id

7. 직원의 이름과 직책(job_title)을 출력하시오.
단, 사용되지 않는 직책이 있다면 그 직책정보도 출력결과에 포함시키시오.
insert into jobs values('play', '놀기', 3500, 8000)

select first_name, job_title
from employees e 
right outer join jobs
on jobs.job_id = e.job_id 

