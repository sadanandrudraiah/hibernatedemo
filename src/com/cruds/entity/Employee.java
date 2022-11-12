package com.cruds.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@PrimaryKeyJoinColumn(name="pid")
public class Employee extends Person{

	@Column
	private Date joinDate;
	@Column
	private String deptName;

	public Employee(){}
	
	public Employee(String fname, String lname, Date joinDate, String deptName) {
		super(fname,lname);
		this.joinDate = joinDate;
		this.deptName = deptName;
	}
	
}
