package com.accolite.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.dto.ClientDto;
import com.accolite.dto.Response;
import com.accolite.dto.dtoclient;
import com.accolite.model.Client;
import com.accolite.services.ClientServices;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {

	@Autowired
	public ClientServices clientservices;
	
	@PostMapping("/addClient")
	public ResponseEntity<Response> addClient(@RequestBody Client client)
	{
		return clientservices.addClient(client);
	}
	
	@GetMapping("/getAllClient")
	public List<dtoclient> getAllClient()
	{
		return clientservices.getAllClient();
	}
	
	@GetMapping("/getClientByClientName")
	public List<dtoclient> getClientByClientName(@RequestParam String clientName)
	{
		return clientservices.getClientByClientName(clientName);
	}
	
	@GetMapping("/getClientByDomainName")
	public List<dtoclient> getClientByDomainName(@RequestParam String domainName)
	{
		return clientservices.getClientByDomainName(domainName);
	}

	
//	@GetMapping("/getClientCount")
//	public long getClientCount()
//	{
//		return clientservices.getClientCount();
//	}

	@GetMapping("/noOfClients")
	public long findNoOfClients() {
		return clientservices.findNoOfClients();
	}
	
	@PutMapping("/updatestatus/{clientId}")
	public List<dtoclient> updatestatus(@PathVariable("clientId") Long clientId,@RequestParam String status){
		int stat;
		System.out.println(status);
		if(status.contentEquals("inActive")) {
			stat=0;
		}else {
			stat=1;
		}
		
		System.out.println(stat);
		return clientservices.updatestatus(clientId,stat);
	}
	@GetMapping("/getActiveClient")
	public List<Client> getActiveClient(){
		return clientservices.getActiveClient(); 
	}
	
}
