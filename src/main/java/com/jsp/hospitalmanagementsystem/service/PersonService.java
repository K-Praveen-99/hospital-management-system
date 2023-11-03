package com.jsp.hospitalmanagementsystem.service;

import java.security.interfaces.RSAKey;
import java.util.NoSuchElementException;

import org.aspectj.weaver.patterns.PerCflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.PersonDao;
import com.jsp.hospitalmanagementsystem.dto.Person;
import com.jsp.hospitalmanagementsystem.util.IdnotFound;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public ResponseEntity<Responsestructure<Person>> savePerson(Person person) {
		Responsestructure<Person> responsestructure = new Responsestructure<>();
		responsestructure.setMessage("Succesfully Saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(personDao.savePerson(person));
		return new ResponseEntity<Responsestructure<Person>>(responsestructure, HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<Person>> updatePerson(Person person, int pid) {
		Person person2 = personDao.updatePerson(pid, person);
		if (person2 != null) {
			Responsestructure<Person> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Successfully Updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(person2);
			return new ResponseEntity<Responsestructure<Person>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for Person");
		}
	}

	public ResponseEntity<Responsestructure<Person>> deletePerson(int pid) {
		Person person = personDao.deletePerson(pid);
		if (person != null) {
			Responsestructure<Person> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Deleted Succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(person);
			return new ResponseEntity<Responsestructure<Person>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for Person");
		}
	}

	public ResponseEntity<Responsestructure<Person>> getPersonbyid(int pid) {
		Person person = personDao.getpersonbyid(pid);
		if (person != null) {
			Responsestructure<Person> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Found Succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(person);
			return new ResponseEntity<Responsestructure<Person>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Id Not Found");
		}
	}
}
