package com.demo.jwtauthentication.repository;

import com.demo.jwtauthentication.model.Case;
import com.demo.jwtauthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case, Integer> {
    List<Case> findAllByUserId(User userId);
}