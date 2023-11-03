package com.jsp.hospitalmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalmanagementsystem.dto.Meditems;
import com.jsp.hospitalmanagementsystem.dto.Medorder;
import com.jsp.hospitalmanagementsystem.repo.MeditemsRepo;

@Repository
public class MeditemDao {
	@Autowired
	private MeditemsRepo meditemsRepo;

	@Autowired
	private MedorderDao medorderDao;

	public Meditems saveMeditems(Meditems meditems, int mid) {
		Medorder medorder = medorderDao.getMedordderbyid(mid);
		meditems.setMedorder(medorder);
		return meditemsRepo.save(meditems);
	}

	public Meditems updateMeditems(Meditems meditems, int id) {
		if (meditemsRepo.findById(id).isPresent()) {
			meditems.setId(id);
			return meditemsRepo.save(meditems);
		} else {
			return null;
		}
	}

	public Meditems deleteMeditems(int id) {
		if (meditemsRepo.findById(id).isPresent()) {
			Meditems meditems = meditemsRepo.findById(id).get();
			meditemsRepo.deleteById(id);
			return meditems;
		} else {
			return null;
		}
	}

	public Meditems getMeditemsbyid(int id) {
		if (meditemsRepo.findById(id).isPresent()) {
			Meditems meditems = meditemsRepo.findById(id).get();
			return meditems;
		} else {
			return null;
		}
	}
}
