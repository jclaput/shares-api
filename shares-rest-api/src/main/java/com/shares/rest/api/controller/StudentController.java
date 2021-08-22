package com.shares.rest.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shares.rest.api.AuthHeader;
import com.shares.rest.api.entity.Student;
import com.shares.rest.api.entity.StudentTable;
import com.shares.rest.api.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private StudentService studentService;
		
	@PostMapping("/studentRegistrationNew")
	public Student AddNewStudent(@RequestBody Student student) {
		return studentService.saveNewStudent(student);
	}
	
	@GetMapping("/studentTableGetAll")
	public List<StudentTable> getAllStudentTable() {
		
		AuthHeader authHeader = new AuthHeader(request);
		if (authHeader.isAnonymous()) return null;
		
		return studentService.getStudentTable();
	}
}
