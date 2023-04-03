package com.userservice.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.com.enities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
