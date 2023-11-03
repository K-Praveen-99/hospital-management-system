package com.jsp.hospitalmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalmanagementsystem.dto.Encounter;
import com.jsp.hospitalmanagementsystem.repo.EncounterRepo;

@Repository
public class EncounterDao {

	@Autowired
	private EncounterRepo encounterRepo;

	public Encounter saveEncounter(Encounter encounter) {
		return encounterRepo.save(encounter);
	}

	public Encounter updateEncounter(int eid, Encounter encounter) {
		if (encounterRepo.findById(eid).isPresent()) {
			encounter.setEid(eid);
			return encounterRepo.save(encounter);
		} else {
			return null;
		}
	}

	public Encounter deleteEncounter(int eid) {
		if (encounterRepo.findById(eid).isPresent()) {
			Encounter encounter = encounterRepo.findById(eid).get();
			encounterRepo.deleteById(eid);
			return encounter;
		} else {
			return null;
		}
	}

	public Encounter getEncounterbyid(int eid) {
		if (encounterRepo.findById(eid).isPresent()) {
			Encounter encounter = encounterRepo.findById(eid).get();
			return encounter;
		} else {
			return null;
		}
	}
}
