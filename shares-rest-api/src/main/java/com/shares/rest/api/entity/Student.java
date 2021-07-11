package com.shares.rest.api.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

	@Id
	@Column(name = "sd_primary_key")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int primaryKey;
	
	@Column(name = "sd_lrn_no")
	private String lrnNo;
	
	@Column(name = "sd_lastname")
	private String lastName;
	
	@Column(name = "sd_firstname")
	private String firstName;
	
	@Column(name = "sd_middlename")
	private String middleName;
	
	@Column(name = "sd_addr_houseno")
	private String addrHouseno;
	
	@Column(name = "sd_addr_street")
	private String addrStreet;
	
	@Column(name = "sd_addr_barangay")
	private String addrBarangay;
	
	@Column(name = "sd_addr_citymunicipality")
	private String addrCityMunicipality;
	
	@Column(name = "sd_gender")
	private String gender;
	
	@Column(name = "sd_dob")
	private String dob;
	
	@Column(name = "sd_nationality")
	private String nationality;
	
	@Column(name = "sd_birthplace")
	private String birthplace;
	
	@Column(name = "sd_status_cd")
	private String statusCd;
	
	@Column(name = "sd_registration_date")
	private String registrationDate;
	
	@Column(name = "sd_elem_name")
	private String elemName;
	
	@Column(name = "sd_elem_school_addr")
	private String elemSchoolAddr;
	
	@Column(name = "sd_elem_comp_month")
	private String elemCompMonth;
	
	@Column(name = "sd_elem_comp_year")
	private String elemCompYear;
	
	@Column(name = "sd_elem_region_cd")
	private String elemRegionCd;
	
	@Column(name = "sd_elem_pept_passer")
	private String elemPeptPasser;
	
	@Column(name = "sd_elem_pept_month")
	private String elemPeptMonth;
	
	@Column(name = "sd_elem_pept_year")
	private String elemPeptYear;
	
	@Column(name = "sd_elem_ae_passer")
	private String elemAePasser;
	
	@Column(name = "sd_elem_ae_month")
	private String elemAeMonth;
	
	@Column(name = "sd_elem_ae_year")
	private String elemAeYear;
	
	@Column(name = "sd_jhs_name")
	private String jhsName;
	
	@Column(name = "sd_jhs_addr")
	private String jhsAddr;
	
	@Column(name = "sd_jhs_region_cd")
	private String jhsRegionCd;
	
	@Column(name = "sd_jhs_comp_month")
	private String jhsCompMonth;
	
	@Column(name = "sd_jhs_comp_year")
	private String jhsCompYear;
	
	@Column(name = "sd_jhs_pept_passer")
	private String jhsPeptPasser;
	
	@Column(name = "sd_jhs_pept_month")
	private String jhsPeptMonth;
	
	@Column(name = "sd_jhs_pept_year")
	private String jhsPeptYear;
	
	@Column(name = "sd_jhs_ae_passer")
	private String jhsAePasser;
	
	@Column(name = "sd_jhs_ae_month")
	private String jhsAeMonth;
	
	@Column(name = "sd_jhs_ae_year")
	private String jhsAeYear;
	
	@Column(name = "sd_shs_school_firstchoice_cd")
	private String shsSchoolFirstchoiceCd;
	
	@Column(name = "sd_shs_school_firstchoice_others_nm")
	private String shsSchoolFirstchoiceOthersNm;
	
	@Column(name = "sd_shs_school_firstchoice_others_addr")
	private String shsSchoolFirstchoiceOthersAddr;
	
	@Column(name = "sd_shs_track_firstchoice_cd")
	private String shsTrackFirstchoiceCd;
	
	@Column(name = "sd_shs_strspec_firstchoice_cd")
	private String shsStrspecFirstchoiceCd;
	
	@Column(name = "sd_shs_school_secondchoice_cd")
	private String shsSchoolSecondchoiceCd;
	
	@Column(name = "sd_shs_school_secondchoice_others_nm")
	private String shsSchoolSecondchoiceOthersNm;
	
	@Column(name = "sd_shs_school_secondchoice_others_addr")
	private String shsSchoolSecondchoiceOthersAddr;
	
	@Column(name = "sd_shs_track_secondchoice_cd")
	private String shsTrackSecondchoiceCd;
	
	@Column(name = "sd_shs_strspec_secondchoice_cd")
	private String shsStrspecSecondchoiceCd;
	
	@Column(name = "sd_shs_track_enrolled_cd")
	private String shsTrackEnrolledCd;
	
	@Column(name = "sd_shs_strspec_enrolled_cd")
	private String shsStrspecEnrolledCd;
	
	@Column(name = "sd_shs_gradesection")
	private String shsGradesection;
	
	@Column(name = "sd_shs_class_adviser")
	private String shsClassAdviser;
	
	@Column(name = "sd_shs_exam_result")
	private String shsExamResult;
	
	@Column(name = "sd_shs_date_enrolled")
	private String shsDateEnrolled;
	
	@Column(name = "sd_shs_sy")
	private String shsSy;
	
	@Column(name = "sd_shs_sem")
	private String shsSem;
	
	@Column(name = "sd_lastschool_attended")
	private String lastSchoolAttended;
	
	@Column(name = "sd_lastschool_address")
	private String lastSchoolAddress;
	
	@Column(name = "sd_lastschool_average")
	private String lastSchoolAverage;
	
	@Column(name = "sd_lastschool_yearsection")
	private String lastSchoolYearSection;
	
	@Column(name = "sd_lastschool_adviser")
	private String lastSchoolAdviser;
	
	@Column(name = "sd_lastschool_sy")
	private String lastSchoolSy;
	
	@Column(name = "sd_ent_date")
	private Instant entDate;
	
	@Column(name = "sd_mod_date")
	private Instant modDate;
	
	
	public int getPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public String getLrnNo() {
		return lrnNo;
	}
	
	public void setLrnNo(String lrnNo) {
		this.lrnNo = lrnNo;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getAddrHouseno() {
		return addrHouseno;
	}
	
	public void setAddrHouseno(String addrHouseno) {
		this.addrHouseno = addrHouseno;
	}
	
	public String getAddrStreet() {
		return addrStreet;
	}
	
	public void setAddrStreet(String addrStreet) {
		this.addrStreet = addrStreet;
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
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getBirthplace() {
		return birthplace;
	}
	
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	
	public String getStatusCd() {
		return statusCd;
	}
	
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	
	public String getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public String getElemName() {
		return elemName;
	}
	
	public void setElemName(String elemName) {
		this.elemName = elemName;
	}
	
	public String getElemSchoolAddr() {
		return elemSchoolAddr;
	}
	
	public void setElemSchoolAddr(String elemSchoolAddr) {
		this.elemSchoolAddr = elemSchoolAddr;
	}
	
	public String getElemCompMonth() {
		return elemCompMonth;
	}
	
	public void setElemCompMonth(String elemCompMonth) {
		this.elemCompMonth = elemCompMonth;
	}
	
	public String getElemCompYear() {
		return elemCompYear;
	}
	
	public void setElemCompYear(String elemCompYear) {
		this.elemCompYear = elemCompYear;
	}
	
	public String getElemRegionCd() {
		return elemRegionCd;
	}
	
	public void setElemRegionCd(String elemRegionCd) {
		this.elemRegionCd = elemRegionCd;
	}
	
	public String getElemPeptPasser() {
		return elemPeptPasser;
	}
	
	public void setElemPeptPasser(String elemPeptPasser) {
		this.elemPeptPasser = elemPeptPasser;
	}
	
	public String getElemPeptMonth() {
		return elemPeptMonth;
	}
	
	public void setElemPeptMonth(String elemPeptMonth) {
		this.elemPeptMonth = elemPeptMonth;
	}
	
	public String getElemPeptYear() {
		return elemPeptYear;
	}
	
	public void setElemPeptYear(String elemPeptYear) {
		this.elemPeptYear = elemPeptYear;
	}
	
	public String getElemAePasser() {
		return elemAePasser;
	}
	
	public void setElemAePasser(String elemAePasser) {
		this.elemAePasser = elemAePasser;
	}
	
	public String getElemAeMonth() {
		return elemAeMonth;
	}
	
	public void setElemAeMonth(String elemAeMonth) {
		this.elemAeMonth = elemAeMonth;
	}
	
	public String getElemAeYear() {
		return elemAeYear;
	}
	
	public void setElemAeYear(String elemAeYear) {
		this.elemAeYear = elemAeYear;
	}
	
	public String getJhsName() {
		return jhsName;
	}
	
	public void setJhsName(String jhsName) {
		this.jhsName = jhsName;
	}
	
	public String getJhsAddr() {
		return jhsAddr;
	}
	
	public void setJhsAddr(String jhsAddr) {
		this.jhsAddr = jhsAddr;
	}
	
	public String getJhsRegionCd() {
		return jhsRegionCd;
	}
	
	public void setJhsRegionCd(String jhsRegionCd) {
		this.jhsRegionCd = jhsRegionCd;
	}
	
	public String getJhsCompMonth() {
		return jhsCompMonth;
	}
	
	public void setJhsCompMonth(String jhsCompMonth) {
		this.jhsCompMonth = jhsCompMonth;
	}
	
	public String getJhsCompYear() {
		return jhsCompYear;
	}
	
	public void setJhsCompYear(String jhsCompYear) {
		this.jhsCompYear = jhsCompYear;
	}
	
	public String getJhsPeptPasser() {
		return jhsPeptPasser;
	}
	
	public void setJhsPeptPasser(String jhsPeptPasser) {
		this.jhsPeptPasser = jhsPeptPasser;
	}
	
	public String getJhsPeptMonth() {
		return jhsPeptMonth;
	}
	
	public void setJhsPeptMonth(String jhsPeptMonth) {
		this.jhsPeptMonth = jhsPeptMonth;
	}
	
	public String getJhsPeptYear() {
		return jhsPeptYear;
	}
	
	public void setJhsPeptYear(String jhsPeptYear) {
		this.jhsPeptYear = jhsPeptYear;
	}
	
	public String getJhsAePasser() {
		return jhsAePasser;
	}
	
	public void setJhsAePasser(String jhsAePasser) {
		this.jhsAePasser = jhsAePasser;
	}
	
	public String getJhsAeMonth() {
		return jhsAeMonth;
	}
	
	public void setJhsAeMonth(String jhsAeMonth) {
		this.jhsAeMonth = jhsAeMonth;
	}
	
	public String getJhsAeYear() {
		return jhsAeYear;
	}
	
	public void setJhsAeYear(String jhsAeYear) {
		this.jhsAeYear = jhsAeYear;
	}
	
	public String getShsSchoolFirstchoiceCd() {
		return shsSchoolFirstchoiceCd;
	}
	
	public void setShsSchoolFirstchoiceCd(String shsSchoolFirstchoiceCd) {
		this.shsSchoolFirstchoiceCd = shsSchoolFirstchoiceCd;
	}
	
	public String getShsSchoolFirstchoiceOthersNm() {
		return shsSchoolFirstchoiceOthersNm;
	}
	
	public void setShsSchoolFirstchoiceOthersNm(String shsSchoolFirstchoiceOthersNm) {
		this.shsSchoolFirstchoiceOthersNm = shsSchoolFirstchoiceOthersNm;
	}
	
	public String getShsSchoolFirstchoiceOthersAddr() {
		return shsSchoolFirstchoiceOthersAddr;
	}
	
	public void setShsSchoolFirstchoiceOthersAddr(String shsSchoolFirstchoiceOthersAddr) {
		this.shsSchoolFirstchoiceOthersAddr = shsSchoolFirstchoiceOthersAddr;
	}
	
	public String getShsTrackFirstchoiceCd() {
		return shsTrackFirstchoiceCd;
	}
	
	public void setShsTrackFirstchoiceCd(String shsTrackFirstchoiceCd) {
		this.shsTrackFirstchoiceCd = shsTrackFirstchoiceCd;
	}
	
	public String getShsStrspecFirstchoiceCd() {
		return shsStrspecFirstchoiceCd;
	}
	
	public void setShsStrspecFirstchoiceCd(String shsStrspecFirstchoiceCd) {
		this.shsStrspecFirstchoiceCd = shsStrspecFirstchoiceCd;
	}
	
	public String getShsSchoolSecondchoiceCd() {
		return shsSchoolSecondchoiceCd;
	}
	
	public void setShsSchoolSecondchoiceCd(String shsSchoolSecondchoiceCd) {
		this.shsSchoolSecondchoiceCd = shsSchoolSecondchoiceCd;
	}
	
	public String getShsSchoolSecondchoiceOthersNm() {
		return shsSchoolSecondchoiceOthersNm;
	}
	
	public void setShsSchoolSecondchoiceOthersNm(String shsSchoolSecondchoiceOthersNm) {
		this.shsSchoolSecondchoiceOthersNm = shsSchoolSecondchoiceOthersNm;
	}
	
	public String getShsSchoolSecondchoiceOthersAddr() {
		return shsSchoolSecondchoiceOthersAddr;
	}
	
	public void setShsSchoolSecondchoiceOthersAddr(String shsSchoolSecondchoiceOthersAddr) {
		this.shsSchoolSecondchoiceOthersAddr = shsSchoolSecondchoiceOthersAddr;
	}
	
	public String getShsTrackSecondchoiceCd() {
		return shsTrackSecondchoiceCd;
	}
	
	public void setShsTrackSecondchoiceCd(String shsTrackSecondchoiceCd) {
		this.shsTrackSecondchoiceCd = shsTrackSecondchoiceCd;
	}
	
	public String getShsStrspecSecondchoiceCd() {
		return shsStrspecSecondchoiceCd;
	}
	
	public void setShsStrspecSecondchoiceCd(String shsStrspecSecondchoiceCd) {
		this.shsStrspecSecondchoiceCd = shsStrspecSecondchoiceCd;
	}
	
	public String getShsTrackEnrolledCd() {
		return shsTrackEnrolledCd;
	}
	
	public void setShsTrackEnrolledCd(String shsTrackEnrolledCd) {
		this.shsTrackEnrolledCd = shsTrackEnrolledCd;
	}
	
	public String getShsStrspecEnrolledCd() {
		return shsStrspecEnrolledCd;
	}
	
	public void setShsStrspecEnrolledCd(String shsStrspecEnrolledCd) {
		this.shsStrspecEnrolledCd = shsStrspecEnrolledCd;
	}
	
	public String getShsGradesection() {
		return shsGradesection;
	}
	
	public void setShsGradesection(String shsGradesection) {
		this.shsGradesection = shsGradesection;
	}
	
	public String getShsClassAdviser() {
		return shsClassAdviser;
	}
	
	public void setShsClassAdviser(String shsClassAdviser) {
		this.shsClassAdviser = shsClassAdviser;
	}
	
	public String getShsExamResult() {
		return shsExamResult;
	}
	
	public void setShsExamResult(String shsExamResult) {
		this.shsExamResult = shsExamResult;
	}
	
	public String getShsDateEnrolled() {
		return shsDateEnrolled;
	}
	
	public void setShsDateEnrolled(String shsDateEnrolled) {
		this.shsDateEnrolled = shsDateEnrolled;
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
	
	public String getLastSchoolAttended() {
		return lastSchoolAttended;
	}
	
	public void setLastSchoolAttended(String lastSchoolAttended) {
		this.lastSchoolAttended = lastSchoolAttended;
	}
	
	public String getLastSchoolAddress() {
		return lastSchoolAddress;
	}
	
	public void setLastSchoolAddress(String lastSchoolAddress) {
		this.lastSchoolAddress = lastSchoolAddress;
	}
	
	public String getLastSchoolAverage() {
		return lastSchoolAverage;
	}
	
	public void setLastSchoolAverage(String lastSchoolAverage) {
		this.lastSchoolAverage = lastSchoolAverage;
	}
	
	public String getLastSchoolYearSection() {
		return lastSchoolYearSection;
	}
	
	public void setLastSchoolYearSection(String lastSchoolYearSection) {
		this.lastSchoolYearSection = lastSchoolYearSection;
	}
	
	public String getLastSchoolAdviser() {
		return lastSchoolAdviser;
	}
	
	public void setLastSchoolAdviser(String lastSchoolAdviser) {
		this.lastSchoolAdviser = lastSchoolAdviser;
	}
	
	public String getLastSchoolSy() {
		return lastSchoolSy;
	}
	
	public void setLastSchoolSy(String lastSchoolSy) {
		this.lastSchoolSy = lastSchoolSy;
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
