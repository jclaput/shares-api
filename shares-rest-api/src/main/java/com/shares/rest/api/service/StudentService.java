package com.shares.rest.api.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shares.rest.api.entity.Student;
import com.shares.rest.api.entity.StudentTable;
import com.shares.rest.api.repository.ConfigRepository;
import com.shares.rest.api.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ConfigRepository configRepository;
	
	public Student getStudentByID(int id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public Student getSudentByLrnNo(String lrnNo) {
		return studentRepository.findStudentByLrnNo(lrnNo);
	}
	
	public boolean studentDoesExist(String lrnNo) {		
		return studentRepository.findStudentByLrnNo(lrnNo) != null;
	}
	
	public Student saveNewStudent(Student student ) {		
		student.setEntDate(Instant.now());		
		return studentRepository.save(student);
	}
	
	public Student registerStudent(Student student) {
		student.setShsSy(configRepository.findConfigByMajorMinorSingleResult("CFG", "CSY").getCfGeneral1());
		student.setRegistrationDate(configRepository.findConfigByMajorMinorSingleResult("CFG", "DOR").getCfGeneral1());
		student.setStatusCd("REG");
		student.setModDate(Instant.now());				
		
		
		return studentRepository.save(student);
	}
	
	public List<StudentTable> getStudentTable() {
		return studentRepository.getAllStudentsForTableDisplay();
	}
}
