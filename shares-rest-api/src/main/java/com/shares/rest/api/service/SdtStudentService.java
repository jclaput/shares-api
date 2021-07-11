package com.shares.rest.api.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shares.rest.api.data.BatchUpdateResult;
import com.shares.rest.api.data.GuidanceReportResult;
import com.shares.rest.api.data.GuidanceReportStatistics;
import com.shares.rest.api.entity.Config;
import com.shares.rest.api.entity.EnrSection;
import com.shares.rest.api.entity.SdtStudent;
import com.shares.rest.api.generics.types.DataReturnDual;
import com.shares.rest.api.repository.CfgSchoolRepository;
import com.shares.rest.api.repository.CfgStatusRepository;
import com.shares.rest.api.repository.CfgStrandSpecRepository;
import com.shares.rest.api.repository.CfgTrackRepository;
import com.shares.rest.api.repository.ConfigRepository;
import com.shares.rest.api.repository.EnrSectionRepository;
import com.shares.rest.api.repository.SdtStudentRepository;
import com.shares.rest.common.enums.StudentRegistrationStatus;

@Service
public class SdtStudentService {
	
	Logger logger = LoggerFactory.getLogger(SdtStudentService.class);

	@Autowired
	private SdtStudentRepository sdtStudentRepository;
	
	@Autowired
	private ConfigRepository configRepository;
	
	@Autowired
	private CfgStatusRepository cfgStatusRepository;
	
	@Autowired
	private EnrSectionRepository enrSectionRepository;
	
	@Autowired
	private CfgSchoolRepository cfgSchoolRepository;
	
	@Autowired
	private CfgTrackRepository cfgTrackRepository;
	
	@Autowired
	private CfgStrandSpecRepository cfgStrandSpecRepository;
	
	private Config getCurrentShoolYear() {
		return configRepository.findConfigByMajorMinorSingleResult("CFG", "CSY");
	}
	
	private Config getCurrentSemester() {
		return configRepository.findConfigByMajorMinorSingleResult("CFG", "SME");
	}
	
	private boolean isStudentAnNR(String shsSy) {
		
		if(shsSy.equalsIgnoreCase(getCurrentShoolYear().getCfGeneral1())) {
	
			return false;
		}
		else return true;		
	}
	
	public SdtStudent getStudentByID(UUID id) {
		return sdtStudentRepository.findById(id).orElse(null);
	}
	
	public SdtStudent getSudentByLrnNo(String lrnNo) {
		return sdtStudentRepository.findStudentByLrnNo(lrnNo);
	}
	
	public boolean studentDoesExist(String lrnNo) {		
		return sdtStudentRepository.findStudentByLrnNo(lrnNo) != null;
	}
	
	/*Return Codes
	 * UD - Error Undefined
	 * NR - Not Registered for current school year/semester
	 * AR - Already registered for current school year/semester
	 * DE - Student record does not exist
	 * CE - Student is already enrolled for current school year/semester
	 * GR - Student already a graduated
	 * KO - Student was kicked-out
	 * DR - Student is a drop-out
	 */
	public StudentRegistrationStatus studentRegistrationStatus(String lrnNo) {
		SdtStudent stdnt = sdtStudentRepository.findStudentByLrnNo(lrnNo);
		if(stdnt == null) {
			return StudentRegistrationStatus.DE;
		} else if(isStudentAnNR(stdnt.getShsSy())) {
			return StudentRegistrationStatus.NR;
		}
		else {
			switch(stdnt.getStatus().getCode()) {
				case "CEN" : 
					return StudentRegistrationStatus.CE;
				case "REG" :
					return StudentRegistrationStatus.AR;
				case "DRP" :
					return StudentRegistrationStatus.DR;
				case "KIO" :
					return StudentRegistrationStatus.KO;
				case "GRD" :
					return StudentRegistrationStatus.GR;
				default :
					return StudentRegistrationStatus.UD;
			}
		}
	}
	
	public List<SdtStudent> getAllSdtStudents() {
		return sdtStudentRepository.findAll();
	}
	
	public SdtStudent getSdtStudentById(String id) {
		UUID uid;
		try { uid = UUID.fromString(id); } catch (IllegalArgumentException ex) { return null; }
		return sdtStudentRepository.findById(uid).orElse(null);
	}
	
	public SdtStudent saveNewSdtStudent(SdtStudent sdtStudent) {
		sdtStudent.setSdtStudentOtherInfo(sdtStudent.getSdtStudentOtherInfo());
		if(sdtStudent.getSdtStudentOtherInfo() != null) {
			sdtStudent.getSdtStudentOtherInfo().setSdtStudent(sdtStudent);
		}
		
		return sdtStudentRepository.save(sdtStudent);
	}
	
	public SdtStudent updateSdtStudent(SdtStudent sdtStudent) {
		sdtStudent.setSdtStudentOtherInfo(sdtStudent.getSdtStudentOtherInfo());
		if(sdtStudent.getSdtStudentOtherInfo() != null) {
			sdtStudent.getSdtStudentOtherInfo().setSdtStudent(sdtStudent);
		}
		
		//This assumes that all OneToOne biderectional relationship should have values where null is not tolerable 
		//otherwise use the saveNewSdtStudent instead
		sdtStudentRepository.save(sdtStudent);
		//This is to get fresh copy from DB just in case the REST API call doesn't have StudentOtherInfo or null 
		return getSdtStudentById(sdtStudent.getId().toString());
	}
	
	public SdtStudent registerNewStudent(SdtStudent student) {
		student.setShsSy(configRepository.findConfigByMajorMinorSingleResult("CFG", "CSY").getCfGeneral1());
		student.setRegistrationDate(configRepository.findConfigByMajorMinorSingleResult("CFG", "DOR").getCfGeneral1());
		
		student.setStatus(cfgStatusRepository.findByCode("REG"));
		
		student.setEntDate(Instant.now());
		
		return saveNewSdtStudent(student);		
	}
	
	public SdtStudent registerExistingStudent(SdtStudent student) {
		student.setShsSy(configRepository.findConfigByMajorMinorSingleResult("CFG", "CSY").getCfGeneral1());
		student.setRegistrationDate(configRepository.findConfigByMajorMinorSingleResult("CFG", "DOR").getCfGeneral1());
		
		student.setStatus(cfgStatusRepository.findByCode("REG"));
		
		student.setModDate(Instant.now());
		
		return updateSdtStudent(student);
	}
	
	public SdtStudent enrollRegisteredStudent(SdtStudent sdtStudent) {

		if(sdtStudent.getAddrMakatiResident().equalsIgnoreCase("Y")) {
			sdtStudent.setAddrBarangay(null);
			sdtStudent.setAddrCityMunicipality("Makati City");
		}

		sdtStudent.setModDate(Instant.now());
		if(sdtStudent.getSdtStudentOtherInfo().getEntDate() == null) {
			sdtStudent.getSdtStudentOtherInfo().setEntDate(Instant.now());
		}
		else {
			sdtStudent.getSdtStudentOtherInfo().setModDate(Instant.now());
		}


		return updateSdtStudent(sdtStudent);
	}
	
	public SdtStudent assignStudentToSection(SdtStudent sdtStudent) {
		SdtStudent sdtStudentFromDB = getStudentByID(sdtStudent.getId());		
		sdtStudentFromDB.setSection(sdtStudent.getSection());
		sdtStudentFromDB.setModDate(Instant.now());
		
		return updateSdtStudent(sdtStudentFromDB);
	}
	
	public List<SdtStudent> getAllCurrentlyEnrolledStudents() {
		
		return sdtStudentRepository.getAllCurrentlyEnrolledStudents(false, 
				getCurrentShoolYear().getCfGeneral1(), getCurrentSemester().getCfGeneral1());		
	}
	
	public List<SdtStudent> getAllCurrentlyEnrolledStudentsSection(Integer sectionId) {
		
		EnrSection enrSection = enrSectionRepository.findById(sectionId).orElse(null);
		
		return sdtStudentRepository.getAllCurrentlyEnrolledStudentsSection(enrSection, 
				getCurrentShoolYear().getCfGeneral1(), getCurrentSemester().getCfGeneral1());		
	}
	
	public BatchUpdateResult batchAssignStudentsToSection(List<SdtStudent> sdtStudents) {
		List<SdtStudent> stdudentsFromDB = new ArrayList<>();
		sdtStudents.forEach(sdtStudent -> {
			SdtStudent sdtStudentFromDB =  getStudentByID(sdtStudent.getId());
			sdtStudentFromDB.setSection(sdtStudent.getSection());
			sdtStudentFromDB.setModDate(Instant.now());
			stdudentsFromDB.add(sdtStudentFromDB);
		});		
		
		return sdtStudentRepository.batchUpdateSdtStudents(stdudentsFromDB);
	}
	
	public DataReturnDual<List<GuidanceReportResult>, List<GuidanceReportStatistics>> getGuidanceEarlyRegistrationReport() {
		DataReturnDual<List<GuidanceReportResult>, List<GuidanceReportStatistics>> dataReturn = new DataReturnDual<>();

		List<GuidanceReportResult> reportResults = sdtStudentRepository
				.getGuidanceEarlyRegistrationReport(configRepository
						.findConfigByMajorMinorSingleResult("CFG", "CSY").getCfGeneral1());
		dataReturn.setFirstReturn(reportResults);
		
		List<GuidanceReportStatistics> guidanceReportStatistics = new ArrayList<>();
		
		GuidanceReportStatistics header1 = new GuidanceReportStatistics();
		header1.setField1("Content Type");
		header1.setField2("Code");
		header1.setField3("Preferences (option 1)");
		header1.setField4("Count");
		header1.setField5("Option");
		header1.setField6("Ordinal");
		
		guidanceReportStatistics.add(header1);
		
	    final Integer[] totalMaleOpt1 = {0};
	    final Integer[] totalFemaleOpt1 = {0};
	    final Integer[] totalSchool = {0};
	    final Integer[] totalTrack = {0};
	    final Integer[] totalStrandSpec = {0};
	    final Integer[] ordinal = {1};
	    
		GuidanceReportStatistics maleGenderStats = new GuidanceReportStatistics();
		maleGenderStats.setField1("Gender");
		maleGenderStats.setField2("M");
		maleGenderStats.setField3("Male");
		maleGenderStats.setField4("");
		maleGenderStats.setField5("1");
		maleGenderStats.setField6(ordinal[0].toString());
		ordinal[0]++;
		
		guidanceReportStatistics.add(maleGenderStats);
		
		GuidanceReportStatistics femaleGenderStats = new GuidanceReportStatistics();
		femaleGenderStats.setField1("Gender");
		femaleGenderStats.setField2("F");
		femaleGenderStats.setField3("Female");
		femaleGenderStats.setField4("");
		femaleGenderStats.setField5("1");
		femaleGenderStats.setField6(ordinal[0].toString());
		ordinal[0]++;
		
		guidanceReportStatistics.add(femaleGenderStats);
	    
		cfgSchoolRepository.findAll().forEach(cfgSchool -> {
			GuidanceReportStatistics school = new GuidanceReportStatistics();
			school.setField1("School");
			school.setField2(cfgSchool.getCode());
			school.setField3(cfgSchool.getName());
			school.setField4("");
			school.setField5("1");
			school.setField6(ordinal[0].toString());
			ordinal[0]++;
			
			guidanceReportStatistics.add(school);
			
			cfgTrackRepository.findAll().stream()
			.filter(cfgTrack -> cfgTrack.getChId() == cfgSchool.getId())
			.forEach(cfgTrack -> {			
				GuidanceReportStatistics track = new GuidanceReportStatistics();
				track.setField1("Track");
				track.setField2(cfgTrack.getCode());
				track.setField3(cfgTrack.getName());
				track.setField4("");
				track.setField5("1");
				track.setField6(ordinal[0].toString());
				ordinal[0]++;
				
				guidanceReportStatistics.add(track);
				
				cfgStrandSpecRepository.findAll().stream()
				.filter(cfgStrandSpec -> cfgStrandSpec.getChId() == cfgSchool.getId() && 
					cfgStrandSpec.getCtId() == cfgTrack.getId())
				.forEach(cfgStrandSpec -> {
					reportResults.stream()
					.filter(reportRec -> reportRec.getFcSchoolCode().equalsIgnoreCase(cfgSchool.getCode()) &&
							reportRec.getFcTrackCode().equalsIgnoreCase(cfgTrack.getCode()) &&
							reportRec.getFcStrndSpecCode().equalsIgnoreCase(cfgStrandSpec.getCode()))
					.forEach(reportRec -> {
					    totalSchool[0]++;
					    totalTrack[0]++;
					    totalStrandSpec[0]++;
					    
						if(reportRec.getGender().equalsIgnoreCase("M")) {
							totalMaleOpt1[0]++;
						}
						else {
							totalFemaleOpt1[0]++;
						}
					});
					
					GuidanceReportStatistics strandSpec = new GuidanceReportStatistics();
					strandSpec.setField1("Strand/Specialization");
					strandSpec.setField2(cfgStrandSpec.getCode());
					strandSpec.setField3(cfgStrandSpec.getName());
					strandSpec.setField4(totalStrandSpec[0].toString());
					strandSpec.setField5("1");
					strandSpec.setField6(ordinal[0].toString());
					ordinal[0]++;
					
					guidanceReportStatistics.add(strandSpec);
					totalStrandSpec[0] = 0;
				});
				
				track.setField4(totalTrack[0].toString());
				totalTrack[0] = 0;
			});
			
			school.setField4(totalSchool[0].toString());
			totalSchool[0] = 0;
		});
		
		maleGenderStats.setField4(totalMaleOpt1[0].toString());
		totalMaleOpt1[0] = 0;
		
		femaleGenderStats.setField4(totalFemaleOpt1[0].toString());
		totalFemaleOpt1[0] = 0;
		
		GuidanceReportStatistics emptyRec = new GuidanceReportStatistics();
		emptyRec.setField1("");
		emptyRec.setField2("empty");
		emptyRec.setField3("");
		emptyRec.setField4("");
		emptyRec.setField5("0");
		emptyRec.setField6(ordinal[0].toString());
		ordinal[0]++;
		
		guidanceReportStatistics.add(emptyRec);		
		
		GuidanceReportStatistics header2 = new GuidanceReportStatistics();
		header2.setField1("Content Type");
		header2.setField2("Code");
		header2.setField3("Preferences (option 2)");
		header2.setField4("Count");
		header2.setField5("Option");
		header2.setField6("Ordinal");
		
		guidanceReportStatistics.add(header2);
		ordinal[0]++;
		
		maleGenderStats = new GuidanceReportStatistics();
		maleGenderStats.setField1("Gender");
		maleGenderStats.setField2("M");
		maleGenderStats.setField3("Male");
		maleGenderStats.setField4("");
		maleGenderStats.setField5("2");
		maleGenderStats.setField6(ordinal[0].toString());
		ordinal[0]++;
		
		guidanceReportStatistics.add(maleGenderStats);
		
		femaleGenderStats = new GuidanceReportStatistics();
		femaleGenderStats.setField1("Gender");
		femaleGenderStats.setField2("F");
		femaleGenderStats.setField3("Female");
		femaleGenderStats.setField4("");
		femaleGenderStats.setField5("2");
		femaleGenderStats.setField6(ordinal[0].toString());
		ordinal[0]++;
		
		guidanceReportStatistics.add(femaleGenderStats);
		
		cfgSchoolRepository.findAll().forEach(cfgSchool -> {
			GuidanceReportStatistics school = new GuidanceReportStatistics();
			school.setField1("School");
			school.setField2(cfgSchool.getCode());
			school.setField3(cfgSchool.getName());
			school.setField4("");
			school.setField5("2");
			school.setField6(ordinal[0].toString());
			ordinal[0]++;
			
			guidanceReportStatistics.add(school);
			
			cfgTrackRepository.findAll().stream()
			.filter(cfgTrack -> cfgTrack.getChId() == cfgSchool.getId())
			.forEach(cfgTrack -> {			
				GuidanceReportStatistics track = new GuidanceReportStatistics();
				track.setField1("Track");
				track.setField2(cfgTrack.getCode());
				track.setField3(cfgTrack.getName());
				track.setField4("");
				track.setField5("2");
				track.setField6(ordinal[0].toString());
				ordinal[0]++;
				
				guidanceReportStatistics.add(track);
				
				cfgStrandSpecRepository.findAll().stream()
				.filter(cfgStrandSpec -> cfgStrandSpec.getChId() == cfgSchool.getId() && 
					cfgStrandSpec.getCtId() == cfgTrack.getId())
				.forEach(cfgStrandSpec -> {
					reportResults.stream()
					.filter(reportRec -> reportRec.getScSchoolCode().equalsIgnoreCase(cfgSchool.getCode()) &&
							reportRec.getScTrackCode().equalsIgnoreCase(cfgTrack.getCode()) &&
							reportRec.getScStrndSpecCode().equalsIgnoreCase(cfgStrandSpec.getCode()))
					.forEach(reportRec -> {
					    totalSchool[0]++;
					    totalTrack[0]++;
					    totalStrandSpec[0]++;
					    
						if(reportRec.getGender().equalsIgnoreCase("M")) {
							totalMaleOpt1[0]++;
						}
						else {
							totalFemaleOpt1[0]++;
						}
					});
					
					GuidanceReportStatistics strandSpec = new GuidanceReportStatistics();
					strandSpec.setField1("Strand/Specialization");
					strandSpec.setField2(cfgStrandSpec.getCode());
					strandSpec.setField3(cfgStrandSpec.getName());
					strandSpec.setField4(totalStrandSpec[0].toString());
					strandSpec.setField5("2");
					strandSpec.setField6(ordinal[0].toString());
					ordinal[0]++;
					
					guidanceReportStatistics.add(strandSpec);
					totalStrandSpec[0] = 0;
				});
				
				track.setField4(totalTrack[0].toString());
				totalTrack[0] = 0;
			});
			
			school.setField4(totalSchool[0].toString());
			totalSchool[0] = 0;
		});
		
		maleGenderStats.setField4(totalMaleOpt1[0].toString());
		totalMaleOpt1[0] = 0;
		
		femaleGenderStats.setField4(totalFemaleOpt1[0].toString());
		totalFemaleOpt1[0] = 0;
		
		dataReturn.setSecondReturn(guidanceReportStatistics);
		dataReturn.setSuccessfull(true);
		return dataReturn;
	}
}