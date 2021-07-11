package com.shares.rest.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "configs")
public class Config implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7397697297203308699L;

	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cf_primary_key")
	private int primarykey;
		
	@Column(name = "cf_major")
	private String cfMajor;
	
	@NaturalId
	@Column(name = "cf_minor")
	private String cfMinor;
	
	@Column(name = "cf_name") 
	private String cfName;
	
	@Column(name = "cf_desc")
	private String cfDesc;
	
	@Column(name = "cf_general_1") 
	private String cfGeneral1;
	
	@Column(name = "cf_general_2")
	private String cfGeneral2;
	

	public int getPrimarykey() {
		return primarykey;
	}

	public void setPrimarykey(int primarykey) {
		this.primarykey = primarykey;
	}

	public String getCfMajor() {
		return cfMajor;
	}

	public void setCfMajor(String cfMajor) {
		this.cfMajor = cfMajor;
	}

	public String getCfMinor() {
		return cfMinor;
	}

	public void setCfMinor(String cfMinor) {
		this.cfMinor = cfMinor;
	}

	public String getCfName() {
		return cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	public String getCfDesc() {
		return cfDesc;
	}

	public void setCfDesc(String cfDesc) {
		this.cfDesc = cfDesc;
	}

	public String getCfGeneral1() {
		return cfGeneral1;
	}

	public void setCfGeneral1(String cfGeneral1) {
		this.cfGeneral1 = cfGeneral1;
	}

	public String getCfGeneral2() {
		return cfGeneral2;
	}

	public void setCfGeneral2(String cfGeneral2) {
		this.cfGeneral2 = cfGeneral2;
	}
	
}
