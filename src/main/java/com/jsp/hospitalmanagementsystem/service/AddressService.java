package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.AddressDao;
import com.jsp.hospitalmanagementsystem.dto.Address;
import com.jsp.hospitalmanagementsystem.util.IdnotFound;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<Responsestructure<Address>> saveAddress(Address address) {
		Responsestructure<Address> responseStructure = new Responsestructure();
		responseStructure.setMessage("Succesfully Saved");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<Responsestructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<Address>> updateAddress(int aid, Address address) {
		Address address2 = addressDao.updateAddress(aid, address);
		if (address2 != null) {
			Responsestructure<Address> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Updated Succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(address2);
			return new ResponseEntity<Responsestructure<Address>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for Address");
		}
	}

	public ResponseEntity<Responsestructure<Address>> deleteAddress(int aid) {
		Address address = addressDao.deleteAddress(aid);
		if (address != null) {
			Responsestructure<Address> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Delelted Succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(address);
			return new ResponseEntity<Responsestructure<Address>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for Address");
		}
	}

	public ResponseEntity<Responsestructure<Address>> getAddressbyid(int aid) {
		Address address = addressDao.getAddressbyid(aid);
		if (address != null) {
			Responsestructure<Address> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Found Succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(address);
			return new ResponseEntity<Responsestructure<Address>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("No Id Found");
		}
	}
}
