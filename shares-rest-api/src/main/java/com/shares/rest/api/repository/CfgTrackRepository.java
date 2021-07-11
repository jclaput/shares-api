package com.shares.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shares.rest.api.entity.CfgTrack;

public interface CfgTrackRepository extends JpaRepository<CfgTrack, byte[]> {}
