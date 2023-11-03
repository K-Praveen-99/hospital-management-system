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

import com.jsp.hospitalmanagementsystem.dto.Meditems;
import com.jsp.hospitalmanagementsystem.service.MeditemsService;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/meditems")
public class MeditemsController {

	@Autowired
	private MeditemsService meditemsService;

	@ApiOperation(value = "save meditems",notes="api is used to save meditems")
	@ApiResponses(value = {@ApiResponse(code=201,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Meditems>> saveMeditems(@Valid @RequestBody Meditems meditems,
			@RequestParam int mid) {
		return meditemsService.saveMeditems(meditems, mid);
	}

	@ApiOperation(value = "update meditems",notes="api is used to update meditems")
	@ApiResponses(value = {@ApiResponse(code=201,message = "succesfully updated")})
	@PutMapping
	public ResponseEntity<Responsestructure<Meditems>> updateMeditems(@Valid @RequestBody Meditems meditems,
			@RequestParam int id) {
		return meditemsService.updateMeditems(id, meditems);
	}

	@ApiOperation(value = "delete meditems",notes="api is used to delete meditems")
	@ApiResponses(value = {@ApiResponse(code=200,message = "succesfully deleted"),
			@ApiResponse(code=404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Meditems>> deleteMeditems(@RequestParam int id) {
		return meditemsService.deleteMeditems(id);
	}

	@ApiOperation(value = "get meditems by id",notes="api is used to find meditems based on id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "succesfully found"),
			@ApiResponse(code=404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure<Meditems>> getMeditemsbyid(@RequestParam int id) {
		return meditemsService.getMeditemsbyid(id);
	}

}
