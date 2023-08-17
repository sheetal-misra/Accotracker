package com.accolite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.dto.Response;
import com.accolite.services.ManagerServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	public ManagerServices managerservices;
	
	@GetMapping("/isManager")
	public ResponseEntity<Response> checkuser(@RequestParam("email") String email)
	{
		return managerservices.checkuser(email);
		
	}
}
