package com.lagou.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lagou.springsecurity.domain.AuthCode;

import java.util.Optional;

public interface AutoCodeRepository extends JpaRepository<AuthCode, String> {

    Optional<AuthCode> findAuthCodeByUsername(String username);
}
