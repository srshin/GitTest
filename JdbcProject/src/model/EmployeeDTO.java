package model;

public class EmployeeDTO {
	private String first_name;
	private String dept_name;
	
	public EmployeeDTO(String first_name, String department_name) {
		super();
		this.first_name = first_name;
		this.dept_name = department_name;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getDept_name() {
		return dept_name;
	}


	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}


	@Override
	public String toString() {
		return "EmployeeDTO [first_name=" + first_name + ", dept_name=" + dept_name + "]";
	}

	
	

}
