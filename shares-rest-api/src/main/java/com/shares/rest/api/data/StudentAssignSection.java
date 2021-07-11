package com.shares.rest.api.data;

import java.util.UUID;

public class StudentAssignSection {
	private UUID id;
	private String lrnNo;
	private String lastname;
	private String firstname;
	private String middlename;
	private String addrHouseNo;
	private String addrStreet;
	private String addrMakatiResident;
	private byte addrMakatiResidentBarangay_id;
	private String addrBarangay;
	private String addrCityMunicipality;
	private String gender;
	private String dob;
	private int section_id;
	private boolean forUpdate;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getLrnNo() {
		return lrnNo;
	}
	public void setLrnNo(String lrnNo) {
		this.lrnNo = lrnNo;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getAddrHouseNo() {
		return addrHouseNo;
	}
	public void setAddrHouseNo(String addrHouseNo) {
		this.addrHouseNo = addrHouseNo;
	}
	public String getAddrStreet() {
		return addrStreet;
	}
	public void setAddrStreet(String addrStreet) {
		this.addrStreet = addrStreet;
	}
	public String getAddrMakatiResident() {
		return addrMakatiResident;
	}
	public void setAddrMakatiResident(String addrMakatiResident) {
		this.addrMakatiResident = addrMakatiResident;
	}
	public byte getAddrMakatiResidentBarangay_id() {
		return addrMakatiResidentBarangay_id;
	}
	public void setAddrMakatiResidentBarangay_id(byte addrMakatiResidentBarangay_id) {
		this.addrMakatiResidentBarangay_id = addrMakatiResidentBarangay_id;
	}
	public String getAddrBarangay() {
		return addrBarangay;
	}
	public void setAddrBarangay(String addrBarangay) {
		this.addrBarangay = addrBarangay;
	}
	public String getAddrCityMunicipality() {
		return addrCityMunicipality;
	}
	public void setAddrCityMunicipality(String addrCityMunicipality) {
		this.addrCityMunicipality = addrCityMunicipality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getSection_id() {
		return section_id;
	}
	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}
	public boolean isForUpdate() {
		return forUpdate;
	}
	public void setForUpdate(boolean forUpdate) {
		this.forUpdate = forUpdate;
	}	
}
