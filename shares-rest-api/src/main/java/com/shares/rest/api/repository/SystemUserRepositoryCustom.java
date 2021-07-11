package com.shares.rest.api.repository;

import java.util.List;

import com.shares.rest.api.entity.SystemUser;

public interface SystemUserRepositoryCustom {
	List<SystemUser> getAllUsersForTableDisplay();
	List<SystemUser> getAllTeachers();
	SystemUser getSystemUserByID(int id);
	SystemUser updateSystemUser(SystemUser systemUser);
}
