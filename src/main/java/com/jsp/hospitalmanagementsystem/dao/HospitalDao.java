package com.jsp.hospitalmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.repo.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	private HospitalRepo hospitalRepo;

	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}

	public Hospital updateHospital(int hid, Hospital hospital) {
		if (hospitalRepo.findById(hid).isPresent()) {
			hospital.setId(hid);
			return hospitalRepo.save(hospital);
		} else {
			return null;
		}
	}

	public Hospital deleteHospital(int hid) {
		if (hospitalRepo.findById(hid).isPresent()) {
			Hospital hospital = hospitalRepo.findById(hid).get();
			hospitalRepo.deleteById(hid);
			return hospital;
		} else {
			return null;
		}
	}

	public Hospital getHospitalbyid(int hid) {
		Optional<Hospital> hospital = hospitalRepo.findById(hid);
		if (hospital.isPresent()) {
			return hospital.get();
		} else {
			return null;
		}
	}

	public Hospital gethospitalbyemail(String email) {
		return hospitalRepo.findbyemail(email);

	}
}
