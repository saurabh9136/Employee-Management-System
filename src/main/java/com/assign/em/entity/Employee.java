package com.assign.em.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_table")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(nullable = false)
	public String first_name;

	@Column(nullable = false)
	public String last_name;

	@Column(nullable = false)
	public Double salary;

	@Column(nullable = false)
	public String department;

	@Column(nullable = false)
	public String position;

	@Column(nullable = false)
	public String email;

	@Column(nullable = false, length = 10)
	public String contactNumber;

	@Lob // use to mark this field as Large Object
	public String picture; // not mandatory in the Backend because testing it to multiple times
							// but in UI marking this field mandatory

	// Constructor & getters and setters
	public Employee() {
		super();

	}

	public Employee(Long id, String first_name, String last_name, Double salary, String department, String position,
			String email, String contactNumber, String picture) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.salary = salary;
		this.department = department;
		this.position = position;
		this.email = email;
		this.contactNumber = contactNumber;
		this.picture = picture;
	}

	public Long id() {
		return id;
	}

	public void setDept_ID(Long id) {
		this.id = id;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_Number() {
		return contactNumber;
	}

	public void setContact_Number(String contact_number) {
		this.contactNumber = contact_number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
