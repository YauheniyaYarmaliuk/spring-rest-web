package com.zhenya.model.db.entity;

import java.util.Date;

public class Employee  {
	
	private int id;
	private int deptId;
	private String name;
	private String patronymic;
	private String surname;
	private String birth;
	private int salary;

  	public Employee() {
  		
  	}
  	
  	public Employee(int id, int deptId, String name, String patronymic, 
  					String surname, String birth, int salary) {
  		this.id = id;
  		this.deptId = deptId;
  		this.name = name;
  		this.patronymic = patronymic;
  		this.surname = surname;
  		this.birth = birth;
  		this.salary = salary;
  		
  		
  	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "Employee - Id: " + id + ", id department: " + deptId + ", Name: " + name + ", Surname: " + surname
				+ ", Patronymic: " + patronymic + ", Birth: " + birth + ", Salary " + salary;
	}

}