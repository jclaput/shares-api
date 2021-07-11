package com.shares.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shares.rest.api.entity.CfgDesignation;

public interface CfgDesignationRepository extends JpaRepository<CfgDesignation, byte[]>{
	CfgDesignation findCfgDesignationByCode(String code);
}
