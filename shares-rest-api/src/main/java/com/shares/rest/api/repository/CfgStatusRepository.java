package com.shares.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shares.rest.api.entity.CfgStatus;

public interface CfgStatusRepository extends JpaRepository<CfgStatus, byte[]> {
	CfgStatus findByCode(String code);
}
