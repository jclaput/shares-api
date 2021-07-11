package com.shares.rest.api.repository;

import java.util.List;

import com.shares.rest.api.entity.StudentTable;

public interface StudentRepositoryCustom {
	List<StudentTable> getAllStudentsForTableDisplay();		
}
