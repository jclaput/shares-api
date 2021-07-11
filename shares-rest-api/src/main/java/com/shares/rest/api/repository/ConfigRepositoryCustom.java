package com.shares.rest.api.repository;

import java.util.List;

import com.shares.rest.api.entity.Config;

public interface ConfigRepositoryCustom {
	Config findConfigByMajorMinor(String cfMajor, String cfMinor);
	Config findConfigByMajorMinorSingleResult(String cfMajor, String cfMinor);	
	List<Config> findConfigByMajorWithSort(String cfMajor);
}
