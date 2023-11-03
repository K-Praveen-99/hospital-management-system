package com.jsp.hospitalmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.BranchDao;
import com.jsp.hospitalmanagementsystem.dao.EncounterDao;
import com.jsp.hospitalmanagementsystem.dao.PersonDao;
import com.jsp.hospitalmanagementsystem.dto.Branch;
import com.jsp.hospitalmanagementsystem.dto.Encounter;
import com.jsp.hospitalmanagementsystem.dto.Person;
import com.jsp.hospitalmanagementsystem.util.IdnotFound;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<Responsestructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = personDao.getpersonbyid(pid);
		Branch branch = branchDao.getbrBranchbyid(bid);

		encounter.setPerson(person);
		List<Branch> list = new ArrayList<>();
		list.add(branch);
		encounter.setList(list);

		Responsestructure<Encounter> responsestructure = new Responsestructure<>();
		responsestructure.setMessage("Successfully Saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(encounterDao.saveEncounter(encounterDao.saveEncounter(encounter)));

		return new ResponseEntity<Responsestructure<Encounter>>(responsestructure, HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<Encounter>> updateEncounter(int eid, int bid, Encounter encounter) {
		Encounter encounter2 = encounterDao.getEncounterbyid(eid);
		Branch branch = branchDao.getbrBranchbyid(bid);

		List<Branch> list = encounter2.getList();
		encounter.setList(encounter2.getList());
		encounter.setPerson(encounter2.getPerson());

		Responsestructure<Encounter> responsestructure = new Responsestructure<>();
		responsestructure.setMessage("Successfully Updated");
		responsestructure.setStatus(HttpStatus.OK.value());
		responsestructure.setData(encounterDao.updateEncounter(eid, encounter));

		return new ResponseEntity<Responsestructure<Encounter>>(responsestructure, HttpStatus.OK);
	}

	public ResponseEntity<Responsestructure<Encounter>> deleteEncounter(int eid) {
		Encounter encounter = encounterDao.deleteEncounter(eid);
		if (encounter != null) {
			Responsestructure<Encounter> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Successfully Deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(encounter);
			return new ResponseEntity<Responsestructure<Encounter>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for Encounter");
		}
	}

	public ResponseEntity<Responsestructure<Encounter>> getEncounterbyid(int eid) {
		Encounter encounter = encounterDao.getEncounterbyid(eid);
		if (encounter != null) {
			Responsestructure<Encounter> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Successfully Found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(encounter);
			return new ResponseEntity<Responsestructure<Encounter>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("No Id Found");
		}
	}
}
