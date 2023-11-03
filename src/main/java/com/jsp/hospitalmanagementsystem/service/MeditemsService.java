package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.MeditemDao;
import com.jsp.hospitalmanagementsystem.dto.Meditems;
import com.jsp.hospitalmanagementsystem.util.IdnotFound;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

@Service
public class MeditemsService {

	@Autowired
	private MeditemDao meditemDao;

	public ResponseEntity<Responsestructure<Meditems>> saveMeditems(Meditems meditems, int mid) {
		Responsestructure<Meditems> responsestructure = new Responsestructure<>();
		responsestructure.setMessage("Successfully Saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(meditemDao.saveMeditems(meditems, mid));
		return new ResponseEntity<Responsestructure<Meditems>>(responsestructure, HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<Meditems>> updateMeditems(int id, Meditems meditems) {
		Meditems meditems2 = meditemDao.getMeditemsbyid(id);
		meditems.setMedorder(meditems2.getMedorder());
		Meditems dbMeditems = meditemDao.updateMeditems(meditems, id);
		if (dbMeditems != null) {
			Responsestructure<Meditems> responsestructure=new Responsestructure<>();
			responsestructure.setMessage("Updated Succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(dbMeditems);
			return new ResponseEntity<Responsestructure<Meditems>>(responsestructure,HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for MedItems");
		}
	}

	public ResponseEntity<Responsestructure<Meditems>> deleteMeditems(int id) {
		Meditems meditems = meditemDao.deleteMeditems(id);
		if (meditems != null) {
			Responsestructure<Meditems> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Deleted Succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(meditems);
			return new ResponseEntity<Responsestructure<Meditems>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for MedItems");
		}
	}

	public ResponseEntity<Responsestructure<Meditems>> getMeditemsbyid(int id) {
		Meditems meditems = meditemDao.getMeditemsbyid(id);
		if (meditems != null) {
			Responsestructure<Meditems> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Found Succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(meditems);
			return new ResponseEntity<Responsestructure<Meditems>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Id Not Found");
		}
	}
}
