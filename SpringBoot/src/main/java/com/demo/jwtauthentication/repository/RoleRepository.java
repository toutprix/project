package com.demo.jwtauthentication.repository;

import java.util.Optional;

import com.demo.jwtauthentication.model.Role;
import com.demo.jwtauthentication.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName roleName);
}