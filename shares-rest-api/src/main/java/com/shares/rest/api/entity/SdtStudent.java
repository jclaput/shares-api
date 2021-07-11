package com.shares.rest.api.entity;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sdt_students", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ss_id"),
		@UniqueConstraint(columnNames = "ss_lrn_no")})
public class SdtStudent {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ss_id", unique = true, nullable = false)
	private UUID id;
	
	@Column(name = "ss_lrn_no", unique = true, nullable = true, length = 15)
	private String lrnNo;
	
	@Column(name = "ss_lastname") 
	private String lastname;
	
	@Column(name = "ss_firstname")
	private String firstname;
	
	@Column(name = "ss_middlename")
	private String middlename;
	
	@Column(name = "ss_addr_houseno")
	private String addrHouseNo;
	
	@Column(name = "ss_addr_street")
	private String addrStreet;
	
	@Column(name = "ss_addr_makati_resident")
	private String addrMakatiResident;
	
	@ManyToOne
	@JoinColumn(name = "ss_addr_makati_resident_barangay_id")
	private CfgBarangay addrMakatiResidentBarangay;
	
	@Column(name = "ss_addr_barangay")
	private String addrBarangay;
	
	@Column(name = "ss_addr_citymunicipality")
	private String addrCityMunicipality;
	
	@Column(name = "ss_gender")
	private String gender;
	
	@Column(name = "ss_dob")
	private String dob;
	
	@Column(name = "ss_nationality")
	private String nationality;
	
	@Column(name = "ss_birthplace")
	private String birthplace;
	
	@ManyToOne
	@JoinColumn(name = "ss_status_id")
	private CfgStatus status;
	
	@Column(name = "ss_registration_date")
	private String registrationDate;
	
	@Column(name = "ss_elem_name")
	private String elemName;
	
	@Column(name = "ss_elem_school_addr")
	private String elemSchoolAddr;
	
	@Column(name = "ss_elem_comp_month")
	private String elemCompMonth;
	
	@Column(name = "ss_elem_comp_year")
	private String elemCompYear;
	
	@ManyToOne
	@JoinColumn(name = "ss_elem_region_id")
	private CfgRegion elemRegion;

	@Column(name = "ss_elem_pept_passer")
	private String elemPeptPasser;
	
	@Column(name = "ss_elem_pept_month")
	private String elemPeptMonth;
	
	@Column(name = "ss_elem_pept_year")
	private String elemPeptYear;
	
	@Column(name = "ss_elem_ae_passer")
	private String elemAePasser;
	
	@Column(name = "ss_elem_ae_month")
	private String elemAeMonth;
	
	@Column(name = "ss_elem_ae_year")
	private String elemAeYear;
	
	@Column(name = "ss_jhs_name")
	private String jhsName;
	
	@Column(name = "ss_jhs_addr")
	private String jhsAddr;
	
	@ManyToOne
	@JoinColumn(name = "ss_jhs_region_id")
	private CfgRegion jhsRegion;
	
	@Column(name = "ss_jhs_comp_month")
	private String jhsCompMonth;
	
	@Column(name = "ss_jhs_comp_year")
	private String jhsCompYear;
	
	@Column(name = "ss_jhs_pept_passer")
	private String jhsPeptPasser;
	
	@Column(name = "ss_jhs_pept_month")
	private String jhsPeptMonth;
	
	@Column(name = "ss_jhs_pept_year")
	private String jhsPeptYear;
	
	@Column(name = "ss_jhs_ae_passer")
	private String jhsAePasser;
	
	@Column(name = "ss_jhs_ae_month")
	private String jhsAeMonth;
	
	@Column(name = "ss_jhs_ae_year")
	private String jhsAeYear;
	
	@ManyToOne
	@JoinColumn(name = "ss_shs_school_firstchoice_id")
	private CfgSchool shsSchoolFirstChoice;
	
	@Column(name = "ss_shs_school_firstchoice_others_nm")
	private String shsSchoolFirstChoiceOthersNm;
	
	@Column(name = "ss_shs_school_firstchoice_others_addr")
	private String shsSchoolFirstChoiceOthersAddr;
	
	@ManyToOne
	@JoinColumn(name = "ss_shs_track_firstchoice_id")
	private CfgTrack shsTrackFirstChoice;
	
	@ManyToOne
	@JoinColumn(name = "ss_shs_strspec_firstchoice_id")
	private CfgStrandSpec shsStrSpecFirstChoice;
	
	@ManyToOne
	@JoinColumn(name = "ss_shs_school_secondchoice_id")
	private CfgSchool shsSchoolSecondChoice;
	
	@Column(name = "ss_shs_school_secondchoice_others_nm")
	private String shsSchoolSecondChoiceOthersNm;
	
	@Column(name = "ss_shs_school_secondchoice_others_addr")
	private String shsSchoolSecondChoiceOthersAddr;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "ss_shs_track_secondchoice_id")
	private CfgTrack shsTrackSecondChoice;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "ss_shs_strspec_secondchoice_id")
	private CfgStrandSpec shsStrSpecSecondChoice;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "ss_shs_track_enrolled_id")
	private CfgTrack shsTrackEnrolled;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "ss_shs_strspec_enrolled_id")
	private CfgStrandSpec shsStrSpecEnrolled;
	
	@Column(name = "ss_shs_gradesection")
	private String shsGradeSection;
	
	@Column(name = "ss_shs_class_adviser")
	private String shsClassAdviser;
	
	@Column(name = "ss_shs_exam_result")
	private String shsExamResult;
	
	@Column(name = "ss_shs_date_enrolled")
	private String shsDateEnrolled;
	
	@Column(name = "ss_shs_sy")
	private String shsSy;
	
	@Column(name = "ss_shs_sem")
	private String shsSem;
	
	@Column(name = "ss_lastschool_attended")
	private String lastSchoolAttended;
	
	@Column(name = "ss_lastschool_address")
	private String lastSchoolAddress;
	
	@Column(name = "ss_lastschool_average")
	private String lastSchoolAverage;
	
	@Column(name = "ss_lastschool_yearsection")
	private String lastSchoolYearSection;
	
	@Column(name = "ss_lastschool_adviser")
	private String lastSchoolAdviser;
	
	@Column(name = "ss_lastschool_sy")
	private String lastSchoolSy;
	
	@Column(name = "ss_ent_date")
	private Instant entDate;
	
	@Column(name = "ss_mod_date")
	private Instant modDate;
			
	@OneToOne(mappedBy = "sdtStudent", cascade = CascadeType.ALL)	
	private SdtStudentOtherInfo sdtStudentOtherInfo;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "ss_section_id")
	private EnrSection section;
    
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "sdtStudents")
	private Set<EnrSubject> enrSubjects = new HashSet<>();
	
	public EnrSection getSection() {
		return section;
	}

	public void setSection(EnrSection section) {
		this.section = section;
	}

	public Set<EnrSubject> getEnrSubjects() {
		return enrSubjects;
	}

	public void setEnrSubjects(Set<EnrSubject> enrSubjects) {
		this.enrSubjects = enrSubjects;
	}

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

	public CfgBarangay getAddrMakatiResidentBarangay() {
		return addrMakatiResidentBarangay;
	}

	public void setAddrMakatiResidentBarangay(CfgBarangay addrMakatiResidentBarangay) {
		this.addrMakatiResidentBarangay = addrMakatiResidentBarangay;
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

	public CfgStatus getStatus() {
		return status;
	}

	public void setStatus(CfgStatus status) {
		this.status = status;
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

	public CfgRegion getElemRegion() {
		return elemRegion;
	}

	public void setElemRegion(CfgRegion elemRegion) {
		this.elemRegion = elemRegion;
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

	public CfgRegion getJhsRegion() {
		return jhsRegion;
	}

	public void setJhsRegion(CfgRegion jhsRegion) {
		this.jhsRegion = jhsRegion;
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

	public CfgSchool getShsSchoolFirstChoice() {
		return shsSchoolFirstChoice;
	}

	public void setShsSchoolFirstChoice(CfgSchool shsSchoolFirstChoice) {
		this.shsSchoolFirstChoice = shsSchoolFirstChoice;
	}

	public String getShsSchoolFirstChoiceOthersNm() {
		return shsSchoolFirstChoiceOthersNm;
	}

	public void setShsSchoolFirstChoiceOthersNm(String shsSchoolFirstChoiceOthersNm) {
		this.shsSchoolFirstChoiceOthersNm = shsSchoolFirstChoiceOthersNm;
	}

	public String getShsSchoolFirstChoiceOthersAddr() {
		return shsSchoolFirstChoiceOthersAddr;
	}

	public void setShsSchoolFirstChoiceOthersAddr(String shsSchoolFirstChoiceOthersAddr) {
		this.shsSchoolFirstChoiceOthersAddr = shsSchoolFirstChoiceOthersAddr;
	}

	public CfgTrack getShsTrackFirstChoice() {
		return shsTrackFirstChoice;
	}

	public void setShsTrackFirstChoice(CfgTrack shsTrackFirstChoice) {
		this.shsTrackFirstChoice = shsTrackFirstChoice;
	}

	public CfgStrandSpec getShsStrSpecFirstChoice() {
		return shsStrSpecFirstChoice;
	}

	public void setShsStrSpecFirstChoice(CfgStrandSpec shsStrSpecFirstChoice) {
		this.shsStrSpecFirstChoice = shsStrSpecFirstChoice;
	}

	public CfgSchool getShsSchoolSecondChoice() {
		return shsSchoolSecondChoice;
	}

	public void setShsSchoolSecondChoice(CfgSchool shsSchoolSecondChoice) {
		this.shsSchoolSecondChoice = shsSchoolSecondChoice;
	}

	public String getShsSchoolSecondChoiceOthersNm() {
		return shsSchoolSecondChoiceOthersNm;
	}

	public void setShsSchoolSecondChoiceOthersNm(String shsSchoolSecondChoiceOthersNm) {
		this.shsSchoolSecondChoiceOthersNm = shsSchoolSecondChoiceOthersNm;
	}

	public String getShsSchoolSecondChoiceOthersAddr() {
		return shsSchoolSecondChoiceOthersAddr;
	}

	public void setShsSchoolSecondChoiceOthersAddr(String shsSchoolSecondChoiceOthersAddr) {
		this.shsSchoolSecondChoiceOthersAddr = shsSchoolSecondChoiceOthersAddr;
	}

	public CfgTrack getShsTrackSecondChoice() {
		return shsTrackSecondChoice;
	}

	public void setShsTrackSecondChoice(CfgTrack shsTrackSecondChoice) {
		this.shsTrackSecondChoice = shsTrackSecondChoice;
	}

	public CfgStrandSpec getShsStrSpecSecondChoice() {
		return shsStrSpecSecondChoice;
	}

	public void setShsStrSpecSecondChoice(CfgStrandSpec shsStrSpecSecondChoice) {
		this.shsStrSpecSecondChoice = shsStrSpecSecondChoice;
	}

	public CfgTrack getShsTrackEnrolled() {
		return shsTrackEnrolled;
	}

	public void setShsTrackEnrolled(CfgTrack shsTrackEnrolled) {
		this.shsTrackEnrolled = shsTrackEnrolled;
	}

	public CfgStrandSpec getShsStrSpecEnrolled() {
		return shsStrSpecEnrolled;
	}

	public void setShsStrSpecEnrolled(CfgStrandSpec shsStrSpecEnrolled) {
		this.shsStrSpecEnrolled = shsStrSpecEnrolled;
	}

	public String getShsGradeSection() {
		return shsGradeSection;
	}

	public void setShsGradeSection(String shsGradeSection) {
		this.shsGradeSection = shsGradeSection;
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

	public SdtStudentOtherInfo getSdtStudentOtherInfo() {
		return sdtStudentOtherInfo;
	}

	public void setSdtStudentOtherInfo(SdtStudentOtherInfo sdtStudentOtherInfo) {
		this.sdtStudentOtherInfo = sdtStudentOtherInfo;
	}
	
}
