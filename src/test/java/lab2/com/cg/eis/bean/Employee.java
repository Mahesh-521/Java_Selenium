package lab2.com.cg.eis.bean;

import lab3.com.cg.eis.exception.Lab3_3EmployeeException;

public class Employee  {

	private int id;
	private String name;
	private double salary;
	private String designation;
	private String insuranceScheme;

	public Employee(int id, String name, double salary, String designation) {
		if(salary<3000) {
			throw new Lab3_3EmployeeException("Salary should be above 3000");
		}
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.insuranceScheme = "";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getDesignation() {
		return designation;
	}

	public String getInsuranceScheme() {
		return insuranceScheme;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setInsuranceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + salary + "," + designation;
	}

	
	
}
