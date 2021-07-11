package com.shares.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shares.rest.api.entity.CfgRegion;

public interface CfgRegionRepository extends JpaRepository<CfgRegion, byte[]>{}
