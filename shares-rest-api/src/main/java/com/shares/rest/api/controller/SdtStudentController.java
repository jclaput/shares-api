package com.shares.rest.api.controller;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shares.rest.api.data.BatchUpdateResult;
import com.shares.rest.api.data.GuidanceReportResult;
import com.shares.rest.api.data.GuidanceReportStatistics;
import com.shares.rest.api.entity.SdtStudent;
import com.shares.rest.api.generics.types.DataReturnDual;
import com.shares.rest.api.service.SdtStudentService;
import com.shares.rest.common.enums.StudentRegistrationStatus;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SdtStudentController {
	
	Logger logger = LoggerFactory.getLogger(SdtStudentController.class);
	
	@Autowired
	private SdtStudentService sdtStudentService;
	
	
	@GetMapping("/studentById/{id}")
	public SdtStudent findById(@PathVariable String id) {
		return sdtStudentService.getSdtStudentById(id);
	}
	
	@GetMapping("/studentByLRN/{lrnNo}")
	public SdtStudent findByLRN(@PathVariable String lrnNo) {
		return sdtStudentService.getSudentByLrnNo(lrnNo);
	}
	
	@GetMapping("/studentDoesExist/{lrnNo}")
	public boolean studentDoesExist(@PathVariable String lrnNo) {
		return sdtStudentService.studentDoesExist(lrnNo);
	}
	
	@GetMapping("/studentRegistrationStatus/{lrnNo}")
	public StudentRegistrationStatus studentRegistrationStatus(@PathVariable String lrnNo) {
		return sdtStudentService.studentRegistrationStatus(lrnNo);
	}
	
	@GetMapping("/sdtStudentsGetAll")
	public List<SdtStudent> getAllSdtStudents() {
		return sdtStudentService.getAllSdtStudents();
	}
	
	@GetMapping("/sdtStudentsGetAllCurrentlyEnrolled")
	public List<SdtStudent> getAllCurrentlyEnrolledStudents() {
		return sdtStudentService.getAllCurrentlyEnrolledStudents();
	}
	
	@GetMapping("/sdtStudentsGetSection/{sectionId}")
	public List<SdtStudent> getAllCurrentlyEnrolledStudentsSection(@PathVariable Integer sectionId) {
		return sdtStudentService.getAllCurrentlyEnrolledStudentsSection(sectionId);
	}
	
	@GetMapping("/sdtStudentGetById/{id}")
	public SdtStudent getSdtStudentById(@PathVariable String id) {		
		return sdtStudentService.getSdtStudentById(id);
	}
	
	@GetMapping("/sdtGuidanceEarlyRegistrationReport")
	public DataReturnDual<List<GuidanceReportResult>, List<GuidanceReportStatistics>> getGuidanceEarlyRegistrationReport() {
		return sdtStudentService.getGuidanceEarlyRegistrationReport();
	}
	
	@PostMapping("/sdtStudentAddNew")
	public SdtStudent addNewSdtStudent(@RequestBody SdtStudent sdtStudent) {
		return sdtStudentService.saveNewSdtStudent(sdtStudent);
	}
	
	@PostMapping("/studentRegisterNew")
	public SdtStudent RegisterNewStudent(@RequestBody SdtStudent student) {		
		student.setElemPeptMonth(
				student.getElemPeptPasser().equalsIgnoreCase("N") 
				? null 
				: student.getElemPeptMonth()
		);
		student.setElemPeptYear(
				student.getElemPeptPasser().equalsIgnoreCase("N") 
				? null 
				: student.getElemPeptYear()
		);
		student.setElemAeMonth(
				student.getElemAePasser().equalsIgnoreCase("N") 
				? null 
				: student.getElemAeMonth()
		);
		student.setElemAeYear(
				student.getElemAePasser().equalsIgnoreCase("N") 
				? null 
				: student.getElemAeYear()
		);
		
		student.setJhsPeptMonth(
				student.getJhsPeptPasser().equalsIgnoreCase("N") 
				? null 
				: student.getJhsPeptMonth()
		);
		student.setJhsPeptYear(
				student.getJhsPeptPasser().equalsIgnoreCase("N") 
				? null 
				: student.getJhsPeptYear()
		);
		student.setJhsAeMonth(
				student.getJhsAePasser().equalsIgnoreCase("N") 
				? null 
				: student.getJhsAeMonth()
		);
		student.setJhsAeYear(
				student.getJhsAePasser().equalsIgnoreCase("N") 
				? null 
				: student.getJhsAeYear()
		);
				
		
		student.setShsSchoolFirstChoiceOthersNm(
				student.getShsSchoolFirstChoice().getCode().equalsIgnoreCase("999") 
				? student.getShsSchoolFirstChoiceOthersNm() 
				: null
		);
		student.setShsSchoolFirstChoiceOthersAddr(
				student.getShsSchoolFirstChoice().getCode().equalsIgnoreCase("999") 
				? student.getShsSchoolFirstChoiceOthersAddr() 
				: null
		);
		student.setShsSchoolSecondChoiceOthersNm(
				student.getShsSchoolSecondChoice().getCode().equalsIgnoreCase("999") 
				? student.getShsSchoolSecondChoiceOthersNm() 
				: null
		);
		student.setShsSchoolSecondChoiceOthersAddr(
				student.getShsSchoolSecondChoice().getCode().equalsIgnoreCase("999") 
				? student.getShsSchoolSecondChoiceOthersAddr() 
				: null
		);
		
		student.setShsTrackSecondChoice(
				student.getShsSchoolSecondChoice() == null || 
				student.getShsSchoolSecondChoice().getCode().isBlank() 
				? null 
				: student.getShsTrackSecondChoice()
		);
		student.setShsStrSpecSecondChoice(
				student.getShsSchoolSecondChoice() == null || 
				student.getShsSchoolSecondChoice().getCode().isBlank()
				? null 
				: student.getShsStrSpecSecondChoice()
		);
		student.setShsSchoolSecondChoice(
				student.getShsSchoolSecondChoice() == null ||
				student.getShsSchoolSecondChoice().getCode().isBlank()
				? null
				: student.getShsSchoolSecondChoice()
		);
		
		student.setSdtStudentOtherInfo(null);
		
		student.setEntDate(Instant.now());
		
		return sdtStudentService.registerNewStudent(student);
	}
	
	@PutMapping("/sdtStudentUpdate")
	public SdtStudent updateSdtStudent(@RequestBody SdtStudent sdtStudent) {
		return sdtStudentService.updateSdtStudent(sdtStudent);
	}
	
	@PutMapping("/studentRegisterExisting/{id}")
	public SdtStudent RegisterExistingStudent(@PathVariable String id, @RequestBody SdtStudent student) {
		SdtStudent studentFromSource = sdtStudentService.getSdtStudentById(id);
		studentFromSource.setElemPeptMonth(
				student.getElemPeptPasser().equalsIgnoreCase("N") 
				? null 
				: student.getElemPeptMonth()
		);
		studentFromSource.setElemPeptYear(
				student.getElemPeptPasser().equalsIgnoreCase("N") 
				? null 
				: student.getElemPeptYear()
		);
		studentFromSource.setElemAeMonth(
				student.getElemAePasser().equalsIgnoreCase("N") 
				? null 
				: student.getElemAeMonth()
		);
		studentFromSource.setElemAeYear(
				student.getElemAePasser().equalsIgnoreCase("N") 
				? null 
				: student.getElemAeYear()
		);
		
		studentFromSource.setJhsPeptMonth(
				student.getJhsPeptPasser().equalsIgnoreCase("N") 
				? null 
				: student.getJhsPeptMonth()
		);
		studentFromSource.setJhsPeptYear(
				student.getJhsPeptPasser().equalsIgnoreCase("N") 
				? null 
				: student.getJhsPeptYear()
		);
		studentFromSource.setJhsAeMonth(
				student.getJhsAePasser().equalsIgnoreCase("N") 
				? null 
				: student.getJhsAeMonth()
		);
		studentFromSource.setJhsAeYear(
				student.getJhsAePasser().equalsIgnoreCase("N") 
				? null 
				: student.getJhsAeYear()
		);
		
		studentFromSource.setShsSchoolSecondChoice(student.getShsSchoolSecondChoice());
		studentFromSource.setShsTrackSecondChoice(
				student.getShsSchoolSecondChoice() == null 
				? null 
				: student.getShsTrackSecondChoice()
		);
		studentFromSource.setShsStrSpecSecondChoice(
				student.getShsSchoolSecondChoice() == null 
				? null 
				: student.getShsStrSpecSecondChoice()
		);
		
		studentFromSource.setShsSchoolFirstChoiceOthersNm(
				student.getShsSchoolFirstChoice().getCode().equalsIgnoreCase("999") 
				? student.getShsSchoolFirstChoiceOthersNm() 
				: null
		);
		studentFromSource.setShsSchoolFirstChoiceOthersAddr(
				student.getShsSchoolFirstChoice().getCode().equalsIgnoreCase("999") 
				? student.getShsSchoolFirstChoiceOthersAddr() 
				: null
		);
		studentFromSource.setShsSchoolSecondChoiceOthersNm(
				student.getShsSchoolSecondChoice() != null && 
				student.getShsSchoolSecondChoice().getCode().equalsIgnoreCase("999") 
				? student.getShsSchoolSecondChoiceOthersNm() 
				: null
		);
		studentFromSource.setShsSchoolSecondChoiceOthersAddr(
				student.getShsSchoolSecondChoice() != null && 
				student.getShsSchoolSecondChoice().getCode().equalsIgnoreCase("999") 
				? student.getShsSchoolSecondChoiceOthersAddr() 
				: null
		);
		
		return sdtStudentService.registerExistingStudent(studentFromSource);
	}
	
	@PutMapping("/studentEnroll")
	public SdtStudent EnrollStudent(@RequestBody SdtStudent sdtStudent) {
		
		return sdtStudentService.enrollRegisteredStudent(sdtStudent);
	}
	
	@PutMapping("/assignStudentToSection")
	public SdtStudent assignStudentToSection(@RequestBody SdtStudent sdtStudent) {				
		return sdtStudentService.assignStudentToSection(sdtStudent);
	}
	
	@PutMapping("/batchAssignStudentsToSection")
	public BatchUpdateResult batchAssignStudentsToSection(@RequestBody List<SdtStudent> sdtStudents) {
		return sdtStudentService.batchAssignStudentsToSection(sdtStudents);
	}
}
