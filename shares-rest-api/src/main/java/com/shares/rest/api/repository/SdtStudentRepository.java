package com.shares.rest.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shares.rest.api.entity.SdtStudent;

public interface SdtStudentRepository extends JpaRepository<SdtStudent, UUID>, SdtStudentRepositoryCustom {
	SdtStudent findStudentByLrnNo(String lrnNo);
}
