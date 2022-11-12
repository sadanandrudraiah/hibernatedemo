package com.cruds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name="pid")
public class Owner extends Person{

	@Column
	private Long stocks;
	
	@Column
	private Long partnershipStake;

	public Owner(){}
	
	public Owner(String fname, String lname, Long stocks, Long partnershipStake) {
		super(fname,lname);
		this.stocks = stocks;
		this.partnershipStake = partnershipStake;
	}
	
}
