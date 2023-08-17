package com.accolite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String>{

}
