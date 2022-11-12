package com.cruds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Phone {

	@Id
	@GeneratedValue
	@Column(name="phone_id")
	private long id;
	@Column
	private String phoneNumber;
	@Column
	private String phoneType;
	
	public Phone() {
		super();
	}

	public Phone(String phoneNumber, String phoneType) {
		super();
		this.phoneNumber = phoneNumber;
		this.phoneType = phoneType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", phoneNumber=" + phoneNumber + ", phoneType=" + phoneType + "]";
	}
	
	
	
	
}
