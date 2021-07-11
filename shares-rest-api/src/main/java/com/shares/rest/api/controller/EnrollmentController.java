package com.shares.rest.api.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shares.rest.api.data.StudentAssignSection;
import com.shares.rest.api.entity.EnrSection;
import com.shares.rest.api.service.EnrollmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EnrollmentController {

	@Autowired
	EnrollmentService enrollmentService;
	
	@PostMapping("/enrSectionAddNew")
	public EnrSection addNewSection(@RequestBody EnrSection enrSection) {
		return enrollmentService.addNewSection(enrSection);
	}
	
	@PutMapping("/enrSectionUpdate")
	public EnrSection updateSection(@RequestBody EnrSection enrSection) {
		enrSection.setEntDate(Instant.now());
		enrSection.setModDate(Instant.now());
		return enrollmentService.updateSection(enrSection);
	}
	
	@GetMapping("/enrSectionsGetAll")
	public List<EnrSection> getAllSections() {
		return enrollmentService.getAllSections();
	}
	
	@GetMapping("/enrSectionGetByID/{id}")
	public EnrSection getSectionByID(@PathVariable int id) {
		return enrollmentService.getSectionByID(id);
	}
	
	@GetMapping("/enrGetAllStudentsForSectionAssigment")
	public List<StudentAssignSection> getAllStudentsForSectionAssignment() {
		return enrollmentService.getCurrenlyEnrolledStudentsForSectionAssignment();
	}
}