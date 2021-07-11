package com.shares.rest.api.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shares.rest.api.entity.SystemUser;
import com.shares.rest.api.repository.SystemUserRepository;
import com.shares.rest.api.utils.HashCode;

@Service
public class SystemUserService {

	@Autowired
	private SystemUserRepository systemUserRepository;

	public List<SystemUser> getAllSystemUsers() {
		return systemUserRepository.findAll();
	}

	public SystemUser getSystemUserByID(String id) {
		UUID uid;
		try { uid = UUID.fromString(id); } catch (IllegalArgumentException ex) { return null; }
		return systemUserRepository.findById(uid).orElse(null);
	}
	
	public List<SystemUser> getAllTeachers() {
		return systemUserRepository.getAllTeachers();
	}
	
	public SystemUser authenticateUser(String userName, String password){
		SystemUser systemUser = systemUserRepository.findByUserName(userName);
		if(systemUser == null) {
			return null;
		}
		
		try {
			if(systemUser.getPassword().equals(HashCode.md5(password))) {
				return systemUser;
			}
			else {
				return null;
			}
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public SystemUser saveNewSystemUser(SystemUser systemUser) {
		try {
			systemUser.setPassword(HashCode.md5(systemUser.getPassword()));
			systemUser.setApiKey(systemUser.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return systemUserRepository.save(systemUser);
	}
	
	public SystemUser updateSystemUser(SystemUser systemUser){
		if(!HashCode.isValidMD5(systemUser.getPassword())) {
			try {
				systemUser.setPassword(HashCode.md5(systemUser.getPassword()));			
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		return systemUserRepository.updateSystemUser(systemUser);
	}
}