package com.cruds.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	
	@Id
	@GeneratedValue
	@Column
	private int pid;
	
	@Column
	private String fname;
	
	@Column
	private String lname;
	
	public Person() {}

	public Person(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	
}
