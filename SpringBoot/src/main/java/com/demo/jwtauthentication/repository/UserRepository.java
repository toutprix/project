package com.demo.jwtauthentication.repository;

import java.util.Optional;

import com.demo.jwtauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByName(String name);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}