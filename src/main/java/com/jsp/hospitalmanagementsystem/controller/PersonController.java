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

import com.jsp.hospitalmanagementsystem.dto.Person;
import com.jsp.hospitalmanagementsystem.service.PersonService;
import com.jsp.hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@ApiOperation(value = "save person",notes="api is used to save person")
	@ApiResponses(value = {@ApiResponse(code=201,message = "succesfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return personService.savePerson(person);
	}

	@ApiOperation(value = "update person",notes="api is used to update person")
	@ApiResponses(value = {@ApiResponse(code=201,message = "succesfully updated")})
	@PutMapping
	public ResponseEntity<Responsestructure<Person>> updatePerson(@Valid @RequestBody Person person, @RequestParam int pid) {
		return personService.updatePerson(person, pid);
	}

	@ApiOperation(value = "delete person",notes="api is used to delete person")
	@ApiResponses(value = {@ApiResponse(code=200,message = "succesfully deleted"),
			@ApiResponse(code=404,message = "id not found")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Person>> deletePerson(@RequestParam int pid) {
		return personService.deletePerson(pid);
	}

	@ApiOperation(value = "get person by id",notes="api is used to find person based on id")
	@ApiResponses(value = {@ApiResponse(code=302,message = "succesfully found"),
			@ApiResponse(code=404,message = "id not found")})
	@GetMapping
	public ResponseEntity<Responsestructure<Person>> getPersonbyid(@RequestParam int pid) {
		return personService.getPersonbyid(pid);
	}
}
