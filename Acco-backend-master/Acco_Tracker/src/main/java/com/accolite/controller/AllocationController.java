package com.accolite.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.dto.AllocationDto;
import com.accolite.dto.Response;
import com.accolite.model.Allocation;
import com.accolite.services.AllocationServices;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/allocation")
public class AllocationController {

	@Autowired
	public AllocationServices allocationservices;


	
	@GetMapping("/getAllAllocation")
	public List<Map<String, Object>> getAllAllocation()
	{
		return allocationservices.getAllAllocation();
	}
//	
	@GetMapping("/getAllocationByEmpName")
	public List<Map<String, Object>> getAllocationByEmpName(@RequestParam String name)
	{
		return allocationservices.getAllocationByEmpName(name);
	}
//	
	@GetMapping("/getAllocationByEmpEmail")
	public List<Map<String, Object>> getAllocationByEmpEmail(@RequestParam String email)
	{
		return allocationservices.getAllocationByEmpEmail(email);
	}
//
//	
	@GetMapping("/getAllocationByEmpId")
	public List<Map<String, Object>> getAllocationByEmpId(@RequestParam String empid)
	{
		return allocationservices.getAllocationByEmpId(empid);
	}
//

	@GetMapping("/getAllocationHistory")
	public List<Map<String, Object>> getAllocationHistory(@RequestParam String empId)
	{
		return allocationservices.getAllocationHistory(empId);
	}
	

	@GetMapping("/checkExistingWork")
	public ResponseEntity<Response> checkExistingWork(@RequestParam("empid") long empId)
	{
		return allocationservices.checkExistingWork(empId);
	}
	
	@GetMapping("/checkAllocation")
	public ResponseEntity<String> checkAllocation(@RequestParam("empid") Long empId)
	{
		return allocationservices.checkAllocation(empId);
	}

	@PostMapping("/addAllocation")
	public ResponseEntity<Response> addAllocation(@RequestBody Allocation allocation)
	{
		return allocationservices.addAllocation(allocation);
	}

}
