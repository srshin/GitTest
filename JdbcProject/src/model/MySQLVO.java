package model;

import java.sql.Date;

public class MySQLVO {
	int empno;
	String first_name;
	String last_name;
	Gender gender; 
	Date hire_date;
	Date birth_date;
	
	public MySQLVO(int empno, String first_name, String last_name, Gender gender, Date hire_date, Date birth_date) {
		super();
		this.empno = empno;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.hire_date = hire_date;
		this.birth_date = birth_date;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	@Override
	public String toString() {
		return "MySQLVO [empno=" + empno + ", first_name=" + first_name + ", last_name=" + last_name + ", gender="
				+ gender + ", hire_date=" + hire_date + ", birth_date=" + birth_date + "]";
	}
	
	
	
}
