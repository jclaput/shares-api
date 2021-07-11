package com.shares.rest.api.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cfg_schools")
public class CfgSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ch_id")
	private byte id;
	
	@Column(name = "ch_code") 
	private String code;
	
	@Column(name = "ch_name")
	private String name;
	
	@Column(name = "ch_desc")
	private String desc;
	
	@Column(name = "ch_general1")
	private String general1;
	
	@Column(name = "ch_general2")
	private String general2;
	
	@Column(name = "ch_ent_date")
	private Instant entDate;
	
	@Column(name = "ch_mod_date")
	private Instant modDate;

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getGeneral1() {
		return general1;
	}

	public void setGeneral1(String general1) {
		this.general1 = general1;
	}

	public String getGeneral2() {
		return general2;
	}

	public void setGeneral2(String general2) {
		this.general2 = general2;
	}

	public Instant getEntDate() {
		return entDate;
	}

	public void setEntDate(Instant entDate) {
		this.entDate = entDate;
	}

	public Instant getModDate() {
		return modDate;
	}

	public void setModDate(Instant modDate) {
		this.modDate = modDate;
	}
}
