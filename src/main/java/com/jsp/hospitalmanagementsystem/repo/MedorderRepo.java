package com.jsp.hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospitalmanagementsystem.dto.Medorder;

public interface MedorderRepo extends JpaRepository<Medorder, Integer>{

}
