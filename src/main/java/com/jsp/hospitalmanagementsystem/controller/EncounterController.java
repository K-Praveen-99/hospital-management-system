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

import com.jsp.hospitalmanagementsystem.dto.Encounter;
import com.jsp.hospitalmanagementsystem.dto.Person;
import com.jsp.hospitalmanagementsystem.service.EncounterService;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounter")
public class EncounterController {

	@Autowired
	private EncounterService encounterService;

	@ApiOperation(value = "save encounter",notes="api is used to save encounter")
	@ApiResponses(value = {@ApiResponse(code=201,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter, @RequestParam int pid, @RequestParam int bid) {
		return encounterService.saveEncounter(encounter, pid, bid);
	}

	@ApiOperation(value = "update encounter",notes="api is used to update encounter")
	@ApiResponses(value = {@ApiResponse(code=200,message = "succesfully updated"),
			@ApiResponse(code=404,message = "id not found")})
	@PutMapping
	public ResponseEntity<Responsestructure<Encounter>> updateEncounter(@Valid @RequestBody Encounter encounter, @RequestParam int eid, @RequestParam int bid) {
		return encounterService.updateEncounter(eid, bid, encounter);
	}

	@ApiOperation(value = "delete encounter",notes="api is used to delete encounter")
	@ApiResponses(value = {@ApiResponse(code=200,message = "succesfully deleted"),
			@ApiResponse(code=404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Encounter>> deleteEncounter(@RequestParam int eid) {
		return encounterService.deleteEncounter(eid);
	}

	@ApiOperation(value = "get encounter by id",notes="api is used to find encounter based on id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "succesfully found"),
			@ApiResponse(code=404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure<Encounter>> getEncounterbyid(@RequestParam int eid) {
		return encounterService.getEncounterbyid(eid);
	}
}
