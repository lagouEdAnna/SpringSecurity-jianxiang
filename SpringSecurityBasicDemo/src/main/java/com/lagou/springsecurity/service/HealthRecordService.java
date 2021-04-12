package com.lagou.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lagou.springsecurity.domain.HealthRecord;
import com.lagou.springsecurity.repository.HealthRecordRepository;

@Service
public class HealthRecordService {

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    public List<HealthRecord> getHealthRecordsByUsername(String userName) {
    	
        return healthRecordRepository.getHealthRecordsByUsername(userName);
    }
}
