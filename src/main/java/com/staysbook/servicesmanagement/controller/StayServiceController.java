package com.staysbook.servicesmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.staysbook.servicesmanagement.dto.StayServicesDTO;
import com.staysbook.servicesmanagement.response.ErrorResponse;
import com.staysbook.servicesmanagement.service.impl.StayService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping("v1/stayBookManagement")
@RestController
public class StayServiceController {

	@Autowired
	StayService stayService;

	@GetMapping("/servicesJpa/{idStays}")
	public ResponseEntity<?> getServicesByStaysJpa(@PathVariable(value = "idStays") String idStays) {
		try {
			List<StayServicesDTO> response = stayService.getServicesByStaysJpa(idStays);
			
			if (response.isEmpty()) {
				return new ResponseEntity<>(new ErrorResponse(404, "No se encontraron registros"), HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(500, "Error interno del servidor. " + e.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/servicesProc/{idStays}")
	@ResponseBody
	public ResponseEntity<?> getServicesByStaysProc(@PathVariable String idStays) {
		try {
			List<StayServicesDTO> response = stayService.getServicesByStaysProc(idStays);
			
			if (response.isEmpty()) {
				return new ResponseEntity<>(new ErrorResponse(404, "No se encontraron registros"), HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse(500, "Error interno del servidor. " + e.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
