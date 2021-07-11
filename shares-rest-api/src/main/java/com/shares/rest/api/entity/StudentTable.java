package com.shares.rest.api.entity;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "StudentTable1")
@Table(name = "students")
public class StudentTable {
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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_status_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config status;	
	
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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_elem_region_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config elemRegion;
	
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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_jhs_region_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config jhsRegion;
	
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
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_shs_school_firstchoice_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config shsSchoolFirstchoice;
	
	@Column(name = "sd_shs_school_firstchoice_others_nm")
	private String shsSchoolFirstchoiceOthersNm;
	
	@Column(name = "sd_shs_school_firstchoice_others_addr")
	private String shsSchoolFirstchoiceOthersAddr;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_shs_track_firstchoice_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config shsTrackFirstchoice;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_shs_strspec_firstchoice_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config shsStrspecFirstchoice;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_shs_school_secondchoice_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config shsSchoolSecondchoice;
	
	@Column(name = "sd_shs_school_secondchoice_others_nm")
	private String shsSchoolSecondchoiceOthersNm;
	
	@Column(name = "sd_shs_school_secondchoice_others_addr")
	private String shsSchoolSecondchoiceOthersAddr;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_shs_track_secondchoice_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config shsTrackSecondchoice;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		@JoinColumn(name = "sd_shs_strspec_secondchoice_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config shsStrspecSecondchoice;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_shs_track_enrolled_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config shsTrackEnrolled;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "sd_shs_strspec_enrolled_cd", referencedColumnName = "cf_minor", nullable=false, insertable=false, updatable=false)
	private Config shsStrspecEnrolled;
	
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
}