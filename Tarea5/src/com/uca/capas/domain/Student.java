package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="student")
public class Student {
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "id_student")
	private Integer id_student;
	
	@Column(name = "s_name")
	private String s_name;
	
	@Column(name = "s_lname")
	private String s_lname;
	
	@Column(name = "s_age")
	private Integer s_age;
	
	@Column(name = "b_active")
	private Boolean b_active;

	
	public Student(int id_student, String s_name,
			String s_lname, boolean b_active, int s_age) {
		this.id_student = id_student;
		this.s_name = s_name;
		this.s_lname = s_lname;
		this.b_active = b_active;
		this.s_age = s_age;
	}
	
	public int getId_student() {
		return id_student;
	}
	public void setId_student(int id_student) {
		this.id_student = id_student;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_lname() {
		return s_lname;
	}

	public void setS_lname(String s_lname) {
		this.s_lname = s_lname;
	}

	public boolean isB_active() {
		return b_active;
	}

	public void setB_active(boolean b_active) {
		this.b_active = b_active;
	}

	public int getS_age() {
		return s_age;
	}

	public void setS_age(int s_age) {
		this.s_age = s_age;
	}
	
	public String getActivoDelegate() {
		if(this.b_active == null) return "";
		else return b_active ? "Activo" : "Inactivo";
	}

}
