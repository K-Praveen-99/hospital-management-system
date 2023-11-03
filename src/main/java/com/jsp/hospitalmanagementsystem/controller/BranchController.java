package com.jsp.hospitalmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospitalmanagementsystem.dto.Address;
import com.jsp.hospitalmanagementsystem.dto.Branch;
import com.jsp.hospitalmanagementsystem.dto.Hospital;
import com.jsp.hospitalmanagementsystem.service.BranchService;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@ApiOperation(value = "save branch",notes="api is used to save branch")
	@ApiResponses(value = {@ApiResponse(code=201,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Branch>> saveBranch(@Valid @RequestBody Branch branch, @RequestParam int hid, @RequestParam int aid) {
		return branchService.saveBranch(branch, hid, aid);
	}

	@ApiOperation(value = "update branch",notes="api is used to update branch")
	@ApiResponses(value = {@ApiResponse(code=201,message = "succesfully updated")})
	@PutMapping
	public ResponseEntity<Responsestructure<Branch>> updateBranch(@RequestParam int bid,@Valid @RequestBody Branch branch) {
		return branchService.updateBranch(bid, branch);
	}

	@ApiOperation(value = "delete branch",notes="api is used to delete branch")
	@ApiResponses(value = {@ApiResponse(code=200,message = "succesfully deleted"),
			@ApiResponse(code=404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Branch>> deleteBranch(@RequestParam int bid) {
		return branchService.deleteBranch(bid);
	}

	@ApiOperation(value = "get branch by id",notes="api is used to find branch based on id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "succesfully found"),
			@ApiResponse(code=404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure<Branch>> getBranchbyid(@RequestParam int bid) {
		return branchService.getBranchbyid(bid);
	}

}
