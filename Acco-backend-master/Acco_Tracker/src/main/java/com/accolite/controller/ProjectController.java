package com.accolite.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.dto.Response;
import com.accolite.dto.dtoproject;
import com.accolite.dto.projectDto;
import com.accolite.model.Allocation;
import com.accolite.model.Client;
import com.accolite.model.Project;


import com.accolite.dto.Response;

import com.accolite.services.ProjectServices;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	public ProjectServices projectservices;
	

	
	@PostMapping("/addProject")
	public ResponseEntity<Response> addProject(@RequestBody Project project)
	{
		return projectservices.addProject(project);
	}
	
	
	@GetMapping("/getAllProject")
	public List<dtoproject> getAllProject()
	{
		return projectservices.getAllProject();
	}
		
	@GetMapping("/getProjectBySwiftCode")
	public List<dtoproject> getProjectBySwiftCode(@RequestParam String swiftCode)
	{
		return projectservices.getProjectBySwiftCode(swiftCode);
	}
	
	@GetMapping("/getProjectByClientName")
	public List<dtoproject> getProjectByClientName(@RequestParam String clientName)
	{
			return projectservices.getProjectByClientName(clientName);
	}
	@GetMapping("/getProjectByProjectName")
	public List<projectDto> getProjectByProjectName(@RequestParam String projectName)
	{
		return projectservices.getProjectByProjectName(projectName);
	}
	
	@GetMapping("/noOfProjects")
	public long findNoOfProjects() {
		return projectservices.findNoOfProjects();
	}

	
	@GetMapping("/getProjectByClientId")
	public List<Project> getProjectByClientId(@RequestParam long clientId)
	{
		return projectservices.getProjectByClientId(clientId);
	}
	
	
	@PostMapping("/updateStatus/{swiftCode}")
	public List<dtoproject> updateStatus(@PathVariable("swiftCode") String swiftcode,@RequestParam String status){
		int stat;
		System.out.println(status);
		if(status.contentEquals("inActive")) {
			stat=0;
		}else {
			stat=1;
		}
		return projectservices.updateStatus(swiftcode,stat);
	}
	@GetMapping("/getActiveProject/{client_id}")
	public List<Project> getActiveProject(@PathVariable Long client_id){
		return projectservices.getActiveProject(client_id); 
	}


}
