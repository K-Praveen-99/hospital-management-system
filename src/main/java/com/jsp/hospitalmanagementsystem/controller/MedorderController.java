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

import com.jsp.hospitalmanagementsystem.dto.Medorder;
import com.jsp.hospitalmanagementsystem.service.MedorderService;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/medorder")
public class MedorderController {

	@Autowired
	private MedorderService medorderService;

	@ApiOperation(value = "save medorder",notes="api is used to save medorder")
	@ApiResponses(value = {@ApiResponse(code=201,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Medorder>> saveMedorder(@Valid @RequestBody Medorder medorder,
			@RequestParam int eid) {
		return medorderService.saveMedorder(medorder, eid);
	}

	@ApiOperation(value = "update medorder",notes="api is used to update medorder")
	@ApiResponses(value = {@ApiResponse(code=201,message = "succesfully updated")})
	@PutMapping
	public ResponseEntity<Responsestructure<Medorder>> updateMedorder( @Valid @RequestBody Medorder medorder,
			@RequestParam int mid) {
		return medorderService.updateMedorder(mid, medorder);
	}

	@ApiOperation(value = "delete medorder",notes="api is used to delete medorder")
	@ApiResponses(value = {@ApiResponse(code=200,message = "succesfully deleted"),
			@ApiResponse(code=404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Medorder>> deleteMedorder(@RequestParam int mid) {
		return medorderService.deleteMedorder(mid);
	}

	@ApiOperation(value = "get medorder by id",notes="api is used to find medorder based on id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "succesfully found"),
			@ApiResponse(code=404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure<Medorder>> getMedorderbuid(@RequestParam int mid) {
		return medorderService.getMedorderbyid(mid);
	}
}
