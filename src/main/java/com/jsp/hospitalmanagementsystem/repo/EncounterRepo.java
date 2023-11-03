package com.jsp.hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospitalmanagementsystem.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer>{

	

}
