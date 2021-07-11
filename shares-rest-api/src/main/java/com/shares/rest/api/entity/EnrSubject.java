package com.shares.rest.api.entity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "enr_subjects")
public class EnrSubject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "es_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "es_school_id")
	private CfgSchool school;
	
	@ManyToOne
	@JoinColumn(name = "es_teacher_id")
	private SystemUser teacher;
	
	@Column(name = "es_name")
	private String name;
	
	@Column(name = "es_desc")
	private String desc;
	
	@Column(name = "es_schedule")
	private String schedule;
	
	@Column(name = "es_shs_sy")
	private String shsSy;
	
	@Column(name = "es_shs_sem")
	private String shsSem;
	
	@Column(name = "es_student_limit")
	private byte studentLimit;
	
	@Column(name = "es_ent_date")
	private Instant entDate;
	
	@Column(name = "es_mod_date")
	private Instant modDate;
	
	@ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "enr_subjects_students",
            joinColumns = { @JoinColumn(name = "eb_subject_id") },
            inverseJoinColumns = { @JoinColumn(name = "eb_student_id") })
	@JsonIgnore
	private Set<SdtStudent> sdtStudents = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CfgSchool getSchool() {
		return school;
	}

	public void setSchool(CfgSchool school) {
		this.school = school;
	}

	public SystemUser getTeacher() {
		return teacher;
	}

	public void setTeacher(SystemUser teacher) {
		this.teacher = teacher;
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

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
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

	public byte getStudentLimit() {
		return studentLimit;
	}

	public void setStudentLimit(byte studentLimit) {
		this.studentLimit = studentLimit;
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

	public Set<SdtStudent> getSdtStudents() {
		return sdtStudents;
	}

	public void setSdtStudents(Set<SdtStudent> sdtStudents) {
		this.sdtStudents = sdtStudents;
	}
}
