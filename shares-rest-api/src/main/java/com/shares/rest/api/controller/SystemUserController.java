package com.shares.rest.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shares.rest.api.entity.SystemUser;
import com.shares.rest.api.service.SystemUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SystemUserController {
	
	Logger logger = LoggerFactory.getLogger(SystemUserController.class);
	
	@Autowired
	private SystemUserService systemUserService;

	@GetMapping("/userJsonWebToken")
	public String getJsonWebToken(@RequestParam("user") String userName, @RequestParam("password") String password) {		
			
		if(systemUserService.authenticateUser(userName, password) != null) {
		
		String secretKey = "osraldo";
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		String token = Jwts.builder()
				.setId("sharesJWT")
				.setSubject(userName)
				.claim("authorities",
						grantedAuthorities.stream()
							.map(GrantedAuthority::getAuthority)
							.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+86400000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		
		
		
		return "Bearer " + token;
		}
		else {
			return "(Invalid username or password)";
		}
	}
	
	@GetMapping("/userGetAll")
	public List<SystemUser> getAllSystemUsers() {
		return systemUserService.getAllSystemUsers();
	}
	
	@GetMapping("/userGetAllTeachers")
	public List<SystemUser> getAllTeachers() {
		return systemUserService.getAllTeachers();
	}
	
	@GetMapping("/userById/{id}")
	public SystemUser findById(@PathVariable String id) {
		return systemUserService.getSystemUserByID(id);
	}
	
	@PostMapping("/userAddNew")
	public SystemUser AddNewSystemUser(@RequestBody SystemUser systemUser) {
		systemUser.setEntDate(Instant.now());
		return systemUserService.saveNewSystemUser(systemUser);
	}
	
	@PutMapping("/userUpdate")
	public SystemUser UpdateSystemUser(@RequestBody SystemUser systemUser) {
		systemUser.setModDate(Instant.now());
		return systemUserService.updateSystemUser(systemUser);
	}
}
