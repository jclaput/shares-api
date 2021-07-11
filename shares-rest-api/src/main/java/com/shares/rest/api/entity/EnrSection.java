package com.shares.rest.api.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enr_sections")
public class EnrSection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "et_id")	
	private int id;
	
	@Column(name = "et_name")
	private String name;
	
	@Column(name = "et_desc")
	private String desc;
	
	@ManyToOne
	@JoinColumn(name = "et_grade_level_id")
	private CfgGradeLevel gradeLevel;
	
	@ManyToOne
	@JoinColumn(name = "et_adviser_id")
	private SystemUser adviser;
	
	@Column(name = "et_section_limit")
	private byte sectionLimit;
	
	@Column(name = "et_shs_sy")
	private String shsSy;
	
	@Column(name = "et_shs_sem")
	private String shsSem;
	
	@Column(name = "et_ent_date")
	private Instant entDate;
	
	@Column(name = "et_mod_date")
	private Instant modDate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CfgGradeLevel getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(CfgGradeLevel gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public SystemUser getAdviser() {
		return adviser;
	}

	public void setAdviser(SystemUser adviser) {
		this.adviser = adviser;
	}

	public byte getSectionLimit() {
		return sectionLimit;
	}

	public void setSectionLimit(byte sectionLimit) {
		this.sectionLimit = sectionLimit;
	}

	public String getShsSy() {
		return shsSy;
	}

	public void setShsSy(String shsSy) {
		this.shsSy = shsSy;
	}

	public String getShsSem() {
		return shsSem;
	}

	public void setShsSem(String shsSem) {
		this.shsSem = shsSem;
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