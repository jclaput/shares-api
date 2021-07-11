package com.shares.rest.api.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shares.rest.api.data.StudentAssignSection;
import com.shares.rest.api.entity.EnrSection;
import com.shares.rest.api.repository.ConfigRepository;
import com.shares.rest.api.repository.EnrSectionRepository;

@Service
public class EnrollmentService {

	@Autowired
	private EnrSectionRepository enrSectionRepository;
	
	@Autowired
	private ConfigRepository configRepository;
	
	@Autowired
	private SdtStudentService sdtStudentService;
	
	public EnrSection addNewSection(EnrSection enrSection) {
		enrSection.setEntDate(Instant.now());
		enrSection.setShsSy(configRepository.findConfigByMajorMinorSingleResult("CFG", "CSY").getCfGeneral1());
		enrSection.setShsSem(configRepository.findConfigByMajorMinorSingleResult("CFG", "SME").getCfGeneral1());
		return enrSectionRepository.save(enrSection);
	}
	
	public EnrSection updateSection(EnrSection enrSection) {		
		enrSection.setModDate(Instant.now());
		return enrSectionRepository.save(enrSection);
	}
	
	public List<EnrSection> getAllSections() {
		return enrSectionRepository.findAll();
	}
	
	public EnrSection getSectionByID(int id) {
		return enrSectionRepository.findById(id).orElse(null);
	}
	
	public List<StudentAssignSection> getCurrenlyEnrolledStudentsForSectionAssignment() {
			
		List<StudentAssignSection> lstStudentAssignSection = new ArrayList<>();
		
		sdtStudentService.getAllCurrentlyEnrolledStudents().forEach(sdtStudent -> {
			StudentAssignSection studentAssignSection = new StudentAssignSection();
			studentAssignSection.setId(sdtStudent.getId());
			studentAssignSection.setLrnNo(sdtStudent.getLrnNo());
			studentAssignSection.setLastname(sdtStudent.getLastname());
			studentAssignSection.setFirstname(sdtStudent.getFirstname());
			studentAssignSection.setMiddlename(sdtStudent.getMiddlename());
			studentAssignSection.setAddrHouseNo(sdtStudent.getAddrHouseNo());
			studentAssignSection.setAddrStreet(sdtStudent.getAddrStreet());
			studentAssignSection.setAddrMakatiResident(sdtStudent.getAddrMakatiResident());
			if(sdtStudent.getAddrMakatiResident().equalsIgnoreCase("Y")) {
				studentAssignSection.setAddrMakatiResidentBarangay_id(sdtStudent.getAddrMakatiResidentBarangay().getId());
				studentAssignSection.setAddrBarangay(sdtStudent.getAddrMakatiResidentBarangay().getName());
			}
			else {
				studentAssignSection.setAddrMakatiResidentBarangay_id((byte) 0);
				studentAssignSection.setAddrBarangay(sdtStudent.getAddrBarangay());
			}
			
			studentAssignSection.setAddrCityMunicipality(sdtStudent.getAddrCityMunicipality());
			studentAssignSection.setGender(sdtStudent.getGender());
			studentAssignSection.setDob(sdtStudent.getDob());
			studentAssignSection.setSection_id(0);
			studentAssignSection.setForUpdate(false);
			
			lstStudentAssignSection.add(studentAssignSection);
		});
		
		return lstStudentAssignSection;
	}
}
