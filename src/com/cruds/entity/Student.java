package com.cruds.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="student_id")
	private long id;
	
	@Column(nullable=false,length=255)
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_phone", joinColumns={@JoinColumn(name="student_id")}, 
			inverseJoinColumns={@JoinColumn(name="phone_id")})
	private Set<Phone> phones;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_course", joinColumns={@JoinColumn(name="student_id")}, 
			inverseJoinColumns={@JoinColumn(name="course_id")})
	private Set<Course> courses;
	
	public Student() {}

	public Student(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", phones=" + phones + ", courses="
				+ courses + "]";
	}
	
}
