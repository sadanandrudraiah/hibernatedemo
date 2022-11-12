package com.cruds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name="address_id")
	private long id;
	
	@Column
	private String city;

	public Address() {
		super();
	}

	public Address(String city) {
		super();
		this.city = city;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + "]";
	}

}
