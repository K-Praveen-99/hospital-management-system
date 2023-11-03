package com.jsp.hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospitalmanagementsystem.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
