package com.shares.rest.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shares.rest.api.AuthHeader;
import com.shares.rest.api.entity.CfgBarangay;
import com.shares.rest.api.entity.CfgDesignation;
import com.shares.rest.api.entity.CfgGradeLevel;
import com.shares.rest.api.entity.CfgRegion;
import com.shares.rest.api.entity.CfgSchool;
import com.shares.rest.api.entity.CfgStatus;
import com.shares.rest.api.entity.CfgStrandSpec;
import com.shares.rest.api.entity.CfgTrack;
import com.shares.rest.api.entity.Config;
import com.shares.rest.api.service.ConfigService;

@CrossOrigin(origins = "*")
@RestController
public class ConfigController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ConfigService configService;
	
	@GetMapping("/SharesAllConfig")
	public List<Config> getAllSharesConfiguration(){
		return configService.getAllSharesConfiguration();
	}
	
	@GetMapping("/SharesConfigByType/{cfMajor}")
	public List<Config> getSharesConfigByMajor(@PathVariable String cfMajor) {
		return configService.getConfigByMajor(cfMajor);
	}
	
	@GetMapping("/SharesConfigByType/{cfMajor}/{cfMinor}")
	public Config getSharesConfigByMajorMinor(@PathVariable String cfMajor, @PathVariable String cfMinor) {
		return configService.getConfigByMajorMinor(cfMajor, cfMinor);
	}
	
	@GetMapping("/cfgStatuses")
	public List<CfgStatus> getAllCfgStatuses(){
		return configService.getAllStatuses();
	}
	
	@GetMapping("/cfgStatusFindByCode/{code}")
	public CfgStatus getCfgStatusByCode(@PathVariable String code){
		return configService.getStatusByCode(code);
	}
	
	@GetMapping("/cfgRegions")
	public List<CfgRegion> getAllCfgRegions(){
		
		AuthHeader authHeader = new AuthHeader(request);
		if (authHeader.isAnonymous()) return null;
		
		return configService.getAllRegions();
	}
	
	@GetMapping("/cfgSchools")
	public List<CfgSchool> getAllCfgSchools(){
		
		AuthHeader authHeader = new AuthHeader(request);
		if (authHeader.isAnonymous()) return null;
		
		return configService.getAllSchools();
	}
	
	@GetMapping("/cfgTracks")
	public List<CfgTrack> getAllCfgTracks(){
		
		AuthHeader authHeader = new AuthHeader(request);
		if (authHeader.isAnonymous()) return null;
		
		return configService.getAllTracks();
	}
	
	@GetMapping("/cfgStrandSpecs")
	public List<CfgStrandSpec> getAllCfgStrandSpecs(){
		
		AuthHeader authHeader = new AuthHeader(request);
		if (authHeader.isAnonymous()) return null;
		
		return configService.getAllStrandSpecs();
	}
	
	@GetMapping("/cfgBarangays")
	public List<CfgBarangay> getAllCfgBarangays(){
		
		AuthHeader authHeader = new AuthHeader(request);
		if (authHeader.isAnonymous()) return null;
		
		return configService.getAllBarangays();
	}
	
	@GetMapping("/cfgDesignations")
	public List<CfgDesignation> getAllCfgDesignations(){
		
		AuthHeader authHeader = new AuthHeader(request);
		if (authHeader.isAnonymous()) return null;
		
		return configService.getAllDesignations();
	}
	
	@GetMapping("/cfgGradeLevels")
	public List<CfgGradeLevel> getAllCfgGradeLevels() {
		
		AuthHeader authHeader = new AuthHeader(request);
		if (authHeader.isAnonymous()) return null;
		
		return configService.getAllGradeLevels();
	}
	
	@PutMapping("/configUpdate")
	public Config updateConfiguration(@RequestBody Config config){
		
		AuthHeader authHeader = new AuthHeader(request);
		if (authHeader.isAnonymous()) return null;
		
		return configService.updateConfig(config);
	}
}