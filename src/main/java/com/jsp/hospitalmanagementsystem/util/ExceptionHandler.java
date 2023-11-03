package com.jsp.hospitalmanagementsystem.util;

import java.io.ObjectInputStream.GetField;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(IdnotFound.class)
	public ResponseEntity<Responsestructure<String>> idnotfound(IdnotFound ex) {
		Responsestructure<String> responsestructure = new Responsestructure<>();
		responsestructure.setMessage(ex.getMessage());
		responsestructure.setStatus(HttpStatus.NOT_FOUND.value());
		responsestructure.setData("Id not Found");
		return new ResponseEntity<Responsestructure<String>>(responsestructure, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Responsestructure<String>> nosuchelement(NoSuchElementException ex) {
		Responsestructure<String> responsestructure = new Responsestructure<>();
		responsestructure.setMessage(ex.getMessage());
		responsestructure.setStatus(HttpStatus.NOT_FOUND.value());
		responsestructure.setData("No Element Found");
		return new ResponseEntity<Responsestructure<String>>(responsestructure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ObjectError> list = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();
		for (ObjectError error : list) {
			String feildname = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();

			map.put(feildname, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Responsestructure<String>> handleConstriantViolationException(
			ConstraintViolationException ex) {
		Responsestructure<String> responsestructure = new Responsestructure<>();
		responsestructure.setMessage(ex.getMessage());
		responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responsestructure.setData("Thhe feild should not be null or blank");
		return new ResponseEntity<Responsestructure<String>>(responsestructure, HttpStatus.BAD_REQUEST);
	}

}
