package com.shares.rest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shares.rest.api.entity.Config;

public interface ConfigRepository extends JpaRepository<Config, Integer>, ConfigRepositoryCustom {
	List<Config> findConfigByCfMajor(String cfMajor);	
}
