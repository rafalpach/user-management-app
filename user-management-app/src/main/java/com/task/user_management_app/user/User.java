package com.task.user_management_app.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USERS")
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private Integer grade;
	@Column
	private Integer salary;
	
	public User(int id, String name, String surname, Integer grade, Integer salary) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.grade = grade;
		this.salary = salary;
	}
	
	public User() {
			
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public Integer getGrade() {
		return grade;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	public Integer getSalary() {
		return salary;
	}
	
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
}
