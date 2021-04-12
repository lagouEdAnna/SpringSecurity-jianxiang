package com.lagou.springsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lagou.springsecurity.domain.HealthRecord;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Integer> {

	List<HealthRecord> getHealthRecordsByUsername(String username);
}
