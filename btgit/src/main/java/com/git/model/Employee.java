package com.git.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sinhvien")
public class Employee {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name ="id")
	int Id;
	
	@Column(name="name")
	String name;
	@Column(name="diachi")
	String diachi;
	@Column(name="email")
	String email;
	
//	public Employee(int id, String name, String diachi, String email) {
//		super();
//		Id = id;
//		this.name = name;
//		this.diachi = diachi;
//		this.email = email;
//	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", diachi=" + diachi + ", email=" + email + "]";
	}
	
	
}
