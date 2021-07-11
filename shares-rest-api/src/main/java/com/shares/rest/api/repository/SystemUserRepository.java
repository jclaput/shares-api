package com.shares.rest.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shares.rest.api.entity.SystemUser;

public interface SystemUserRepository extends JpaRepository<SystemUser, UUID>, SystemUserRepositoryCustom {
	SystemUser findByUserName(String userName);
}
