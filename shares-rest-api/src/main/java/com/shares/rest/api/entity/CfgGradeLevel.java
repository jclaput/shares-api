package com.shares.rest.api.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cfg_grade_levels")
public class CfgGradeLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cg_id")
	private byte id;
	
	@Column(name = "cg_code")
	private String code;
	
	@Column(name = "cg_name")
	private String name;
	
	@Column(name = "cg_desc")
	private String desc;
	
	@Column(name = "cg_ent_date")
	private Instant entDate;
	
	@Column(name = "cg_mod_date")
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
