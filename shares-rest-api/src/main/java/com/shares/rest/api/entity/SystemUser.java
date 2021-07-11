package com.shares.rest.api.entity;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "system_users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "su_id"),
		@UniqueConstraint(columnNames = "su_username")})
public class SystemUser {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "su_id", unique = true, nullable = false)
	private UUID id;
	
	@Column(name = "su_username")
	private String userName;
	
	@Column(name = "su_password")
	private String password;
	
	@Column(name = "su_access_level")
	private String accessLevel;
	
	@ManyToOne
	@JoinColumn(name = "su_designation_id")
	private CfgDesignation designation;
	
	@Column(name = "su_api_key")
	private String apiKey;
	
	@Column(name = "su_fullname")
	private String fullName;
	
	@Column(name = "su_ent_date")
	private Instant entDate;
	
	@Column(name = "su_mod_date")
	private Instant modDate;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public CfgDesignation getDesignation() {
		return designation;
	}

	public void setDesignation(CfgDesignation designation) {
		this.designation = designation;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
