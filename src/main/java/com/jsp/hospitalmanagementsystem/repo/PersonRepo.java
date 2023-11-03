package com.jsp.hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospitalmanagementsystem.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
