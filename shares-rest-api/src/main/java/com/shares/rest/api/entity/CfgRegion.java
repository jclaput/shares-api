package com.shares.rest.api.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cfg_regions")
public class CfgRegion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cr_id")
	private byte id;
	
	@Column(name = "cr_code")
	private String code;
	
	@Column(name = "cr_name")
	private String name;
	
	@Column(name = "cr_desc")
	private String desc;
	
	@Column(name = "cr_ent_date")
	private Instant entDate;
	
	@Column(name = "cr_mod_date")
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

	public void setEntDate(Instant ent_date) {
		this.entDate = ent_date;
	}

	public Instant getModDate() {
		return modDate;
	}

	public void setModDate(Instant mod_date) {
		this.modDate = mod_date;
	}
}
