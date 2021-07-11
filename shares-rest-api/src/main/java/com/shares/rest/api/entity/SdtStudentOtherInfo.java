package com.shares.rest.api.entity;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "sdt_students_other_info")
public class SdtStudentOtherInfo {
	
	@Id
	@Column(name = "so_id")
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="sdtStudent"))
	private UUID id;
	
	@OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
	private SdtStudent sdtStudent;
	
	@Column(name = "so_religion")
	private String religion;
	
	@Column(name = "so_dialect_spoken")
	private String dialectSpoken;
	
	@Column(name = "so_fathers_name")
	private String fathersName;
	
	@Column(name = "so_fathers_occupation")
	private String fathersOccupation;
	
	@Column(name = "so_fathers_contact_no")
	private String fathersContactNo;
	
	@Column(name = "so_mothers_name")
	private String mothersName;
	
	@Column(name = "so_mothers_occupation")
	private String mothersOccupation;
	
	@Column(name = "so_mothers_contact_no")
	private String mothersContactNo;
	
	@Column(name = "so_guardian_name")
	private String guardianName;
	
	@Column(name = "so_guardian_relation")
	private String guardianRelation;
	
	@Column(name = "so_guardian_occupation")
	private String guardianOccupation;
	
	@Column(name = "so_guardian_contact_no")
	private String guardianContactNo;
	
	@Column(name = "so_guardian_address")
	private String guardianAddress;
	
	@Column(name = "so_ent_date")
	private Instant entDate;
	
	@Column(name = "so_mod_date")
	private Instant modDate;
	
	public UUID getId() {
		return id;
	}
	
	public SdtStudent getSdtStudent() {
		return sdtStudent;
	}

	public void setSdtStudent(SdtStudent sdtStudent) {
		this.id = sdtStudent.getId();
		this.sdtStudent = sdtStudent;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getDialectSpoken() {
		return dialectSpoken;
	}

	public void setDialectSpoken(String dialectSpoken) {
		this.dialectSpoken = dialectSpoken;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getFathersOccupation() {
		return fathersOccupation;
	}

	public void setFathersOccupation(String fathersOccupation) {
		this.fathersOccupation = fathersOccupation;
	}

	public String getFathersContactNo() {
		return fathersContactNo;
	}

	public void setFathersContactNo(String fathersContactNo) {
		this.fathersContactNo = fathersContactNo;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getMothersOccupation() {
		return mothersOccupation;
	}

	public void setMothersOccupation(String mothersOccupation) {
		this.mothersOccupation = mothersOccupation;
	}

	public String getMothersContactNo() {
		return mothersContactNo;
	}

	public void setMothersContactNo(String mothersContactNo) {
		this.mothersContactNo = mothersContactNo;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getGuardianRelation() {
		return guardianRelation;
	}

	public void setGuardianRelation(String guardianRelation) {
		this.guardianRelation = guardianRelation;
	}

	public String getGuardianOccupation() {
		return guardianOccupation;
	}

	public void setGuardianOccupation(String guardianOccupation) {
		this.guardianOccupation = guardianOccupation;
	}

	public String getGuardianContactNo() {
		return guardianContactNo;
	}

	public void setGuardianContactNo(String guardianContactNo) {
		this.guardianContactNo = guardianContactNo;
	}

	public String getGuardianAddress() {
		return guardianAddress;
	}

	public void setGuardianAddress(String guardianAddress) {
		this.guardianAddress = guardianAddress;
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
