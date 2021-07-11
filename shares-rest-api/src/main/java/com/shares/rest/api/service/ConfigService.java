package com.shares.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shares.rest.api.entity.CfgBarangay;
import com.shares.rest.api.entity.CfgDesignation;
import com.shares.rest.api.entity.CfgGradeLevel;
import com.shares.rest.api.entity.CfgRegion;
import com.shares.rest.api.entity.CfgSchool;
import com.shares.rest.api.entity.CfgStatus;
import com.shares.rest.api.entity.CfgStrandSpec;
import com.shares.rest.api.entity.CfgTrack;
import com.shares.rest.api.entity.Config;
import com.shares.rest.api.repository.CfgBarangayRepository;
import com.shares.rest.api.repository.CfgDesignationRepository;
import com.shares.rest.api.repository.CfgGradeLevelRepository;
import com.shares.rest.api.repository.CfgRegionRepository;
import com.shares.rest.api.repository.CfgSchoolRepository;
import com.shares.rest.api.repository.CfgStatusRepository;
import com.shares.rest.api.repository.CfgStrandSpecRepository;
import com.shares.rest.api.repository.CfgTrackRepository;
import com.shares.rest.api.repository.ConfigRepository;

@Service
public class ConfigService {
	
	@Autowired
	private ConfigRepository configRepository;
	
	@Autowired
	private CfgStatusRepository cfgStatusRepository;
	
	@Autowired
	private CfgRegionRepository cfgRegionRepository;
	
	@Autowired
	private CfgSchoolRepository cfgSchoolRepository;
	
	@Autowired
	private CfgTrackRepository cfgTrackRepository;
	
	@Autowired
	private CfgStrandSpecRepository cfgStrandSpecRepository;
	
	@Autowired
	private CfgBarangayRepository cfgBarangayRepository;
	
	@Autowired
	private CfgDesignationRepository cfgDesignationRepository;
	
	@Autowired
	private CfgGradeLevelRepository cfgGradeLevelRepository; 

	public List<Config> getAllSharesConfiguration(){
		return configRepository.findConfigByCfMajor("CFG");
	}
	
	public List<Config> getConfigByMajor(String major) {
		return configRepository.findConfigByMajorWithSort(major);
	}
	
	public Config getConfigByMajorMinor(String major, String minor) {
		return configRepository.findConfigByMajorMinorSingleResult(major, minor);
	}

	public List<CfgStatus> getAllStatuses() {
		return cfgStatusRepository.findAll();
	}
	
	public CfgStatus getStatusByCode(String code) {
		return cfgStatusRepository.findByCode(code);
	}	
	
	public List<CfgRegion> getAllRegions() {
		return cfgRegionRepository.findAll();
	}
	
	public List<CfgSchool> getAllSchools() {
		return cfgSchoolRepository.findAll();
	}
	
	public List<CfgTrack> getAllTracks() {
		return cfgTrackRepository.findAll();
	}
	
	public List<CfgStrandSpec> getAllStrandSpecs() {
		return cfgStrandSpecRepository.findAll();
	}
	
	public List<CfgBarangay> getAllBarangays() {
		return cfgBarangayRepository.findAll();
	}
	
	public List<CfgDesignation> getAllDesignations() {
		return cfgDesignationRepository.findAll();
	}
	
	public List<CfgGradeLevel> getAllGradeLevels() {
		return cfgGradeLevelRepository.findAll();
	}
	
	public Config updateConfig(Config config) {
		Config configFromDB = getConfigByMajorMinor(config.getCfMajor(), config.getCfMinor());
		if (configFromDB != null) {
			configFromDB.setCfGeneral1(config.getCfGeneral1());
			configFromDB.setCfGeneral2(config.getCfGeneral2());
		}
		
		return configRepository.save(configFromDB);
	}
}
