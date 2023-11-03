package com.jsp.hospitalmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.jsp.hospitalmanagementsystem.dto.Address;
import com.jsp.hospitalmanagementsystem.dto.Branch;
import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.repo.BranchRepo;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepo branchRepo;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;

	public Branch saveBranch(Branch branch, int hid, int aid) {
		Hospital hospital = hospitalDao.getHospitalbyid(hid);
		Address address = addressDao.getAddressbyid(aid);
		branch.setHospital(hospital);
		branch.setAddress(address);
		return branchRepo.save(branch);
	}

	public Branch updateBranch(int bid, Branch branch) {
		Branch branch2 = branchRepo.findById(bid).get();
		if (branch2 != null) {
			branch.setBid(bid);
			branch.setHospital(branch2.getHospital());
			branch.setAddress(branch2.getAddress());
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch deleteBranch(int bid) {
		if (branchRepo.findById(bid).isPresent()) {
			Branch branch = branchRepo.findById(bid).get();
			branchRepo.deleteById(bid);
			return branch;
		} else {
			return null;
		}
	}

	public Branch getbrBranchbyid(int bid) {
		if (branchRepo.findById(bid).isPresent()) {
			Branch branch = branchRepo.findById(bid).get();
			return branch;
		} else {
			return null;
		}
	}

}
