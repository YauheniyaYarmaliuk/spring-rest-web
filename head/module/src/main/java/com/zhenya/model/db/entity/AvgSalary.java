package com.zhenya.model.db.entity;

public class AvgSalary {
	private String name;
	private int salary;
	private Department department;
	private Employee employee;
	
	public AvgSalary() {
		
	}
	
	public AvgSalary(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee (Employee employee) {
		this.employee = employee;
	}
	
	
}
