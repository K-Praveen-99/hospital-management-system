package com.jsp.hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospitalmanagementsystem.dao.BranchDao;
import com.jsp.hospitalmanagementsystem.dto.Branch;
import com.jsp.hospitalmanagementsystem.util.IdnotFound;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

@Service
public class BranchService {
	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<Responsestructure<Branch>> saveBranch(Branch branch, int hid, int aid) {
		Responsestructure<Branch> responsestructure = new Responsestructure<>();
		responsestructure.setMessage("Succesfully Saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(branchDao.saveBranch(branch, hid, aid));
		return new ResponseEntity<Responsestructure<Branch>>(responsestructure, HttpStatus.CREATED);
	}

	public ResponseEntity<Responsestructure<Branch>> updateBranch(int bid, Branch branch) {
		Branch branch2 = branchDao.updateBranch(bid, branch);
		if (branch2 != null) {
			Responsestructure<Branch> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Updated Succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(branch2);
			return new ResponseEntity<Responsestructure<Branch>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for Branch");
		}
	}

	public ResponseEntity<Responsestructure<Branch>> deleteBranch(int bid) {
		Branch branch = branchDao.deleteBranch(bid);
		if (branch != null) {
			Responsestructure<Branch> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Delelted Succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(branch);
			return new ResponseEntity<Responsestructure<Branch>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdnotFound("Id not Found for Branch");
		}
	}

	public ResponseEntity<Responsestructure<Branch>> getBranchbyid(int bid) {
		Branch branch = branchDao.getbrBranchbyid(bid);
		if (branch != null) {
			Responsestructure<Branch> responsestructure = new Responsestructure<>();
			responsestructure.setMessage("Found Succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(branch);
			return new ResponseEntity<Responsestructure<Branch>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Id Not Found");
		}
	}
}
