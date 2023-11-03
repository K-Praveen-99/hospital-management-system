package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.HospitalDao;
import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.util.IdnotFound;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<Responsestructure<Hospital>> saveHospital(Hospital hospital) {
		Responsestructure<Hospital> responsestructure = new Responsestructure<>();
		responsestructure.setMessage("Sucessfully Saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<Responsestructure<Hospital>>(responsestructure, HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<Hospital>> updateHospital(int hid, Hospital hospital) {
		Hospital hospital2 = hospitalDao.updateHospital(hid, hospital);
		if (hospital2 != null) {
			Responsestructure<Hospital> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Succesfully Updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hospital2);
			return new ResponseEntity<Responsestructure<Hospital>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Founf for the Hospital");
		}
	}

	public ResponseEntity<Responsestructure<Hospital>> deleteHospital(int hid) {
		Hospital hospital = hospitalDao.deleteHospital(hid);
		if (hospital != null) {
			Responsestructure<Hospital> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Sucessfully Deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hospital);
			return new ResponseEntity<Responsestructure<Hospital>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Founf for the Hospital");
		}
	}

	public ResponseEntity<Responsestructure<Hospital>> getHospitalbyid(int hid) {
		Hospital hospital = hospitalDao.getHospitalbyid(hid);
		if (hospital != null) {
			Responsestructure<Hospital> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Sucessfully Found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(hospital);
			return new ResponseEntity<Responsestructure<Hospital>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("No Id Found");
		}
	}

	public ResponseEntity<Responsestructure<Hospital>> gethospitalbyemail(String email) {
		Hospital hospital = hospitalDao.gethospitalbyemail(email);
		if (hospital != null) {
			Responsestructure<Hospital> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("sucessfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(hospital);
			return new ResponseEntity<Responsestructure<Hospital>>(responsestructure, HttpStatus.FOUND);

		} else {
			throw new NoSuchElementException("No Id Found");
		}

	}
}
