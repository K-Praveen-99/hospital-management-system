package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.MedorderDao;
import com.jsp.hospitalmanagementsystem.dto.Medorder;
import com.jsp.hospitalmanagementsystem.util.IdnotFound;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

@Service
public class MedorderService {
	@Autowired
	private MedorderDao medorderDao;

	public ResponseEntity<Responsestructure<Medorder>> saveMedorder(Medorder medorder, int eid) {
		Responsestructure<Medorder> responsestructure = new Responsestructure<>();
		responsestructure.setMessage("Succesfully Saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(medorderDao.saveMedorder(medorder, eid));
		return new ResponseEntity<Responsestructure<Medorder>>(responsestructure, HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<Medorder>> updateMedorder(int mid, Medorder medorder) {
		Medorder medorder2 = medorderDao.getMedordderbyid(mid);
		medorder.setEncounter(medorder2.getEncounter());
		Medorder dbmedorder = medorderDao.updaMedorder(mid, medorder);
		if (dbmedorder != null) {
			Responsestructure<Medorder> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Succesfully Updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(dbmedorder);
			return new ResponseEntity<Responsestructure<Medorder>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for MedOrder");
		}
	}

	public ResponseEntity<Responsestructure<Medorder>> deleteMedorder(int mid) {
		Medorder medorder = medorderDao.deleteMedorder(mid);
		if (medorder != null) {
			Responsestructure<Medorder> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Deleted Succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(medorder);
			return new ResponseEntity<Responsestructure<Medorder>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for MedOrder");
		}
	}

	public ResponseEntity<Responsestructure<Medorder>> getMedorderbyid(int mid) {
		Medorder medorder = medorderDao.getMedordderbyid(mid);
		if (medorder != null) {
			Responsestructure<Medorder> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Found Succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(medorder);
			return new ResponseEntity<Responsestructure<Medorder>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Id Not Found");
		}
	}

}
