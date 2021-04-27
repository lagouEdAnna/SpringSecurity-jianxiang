package com.lagou.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lagou.springsecurity.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByUsername(String username);
}
