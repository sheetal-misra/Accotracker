package com.accolite.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accolite.dto.ClientDto;
import com.accolite.dto.Response;
import com.accolite.dto.dtoclient;
import com.accolite.model.Client;
import com.accolite.model.Employee;
import com.accolite.repository.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	public ClientRepository clientRepo;
	
	public ResponseEntity<Response> addClient(Client client) {
		String clientname = client.getClientName();
		List<dtoclient> c = clientRepo.getClientByClientName(clientname);
		 //System.out.println(e);
		if(c.size()!=0)
		{
	     return new ResponseEntity<>(new Response("Client already exists"),HttpStatus.BAD_REQUEST);
		}
		else
		{
			clientRepo.save(client);
			return new ResponseEntity<>(new Response("Client created successfully"),HttpStatus.ACCEPTED);
		}
	}

	
	public List<dtoclient> getAllClient() {
		return clientRepo.findAllClients();
	}

	
	public List<dtoclient> getClientByClientName(String clientName) {
		return clientRepo.getClientByClientName(clientName.toLowerCase());
	}


	public List<dtoclient> getClientByDomainName(String domainName) {
		return clientRepo.getClientByDomainName(domainName.toLowerCase());
	}


	public long findNoOfClients() {
		return clientRepo.getClientCount();
	}
	
	public List<dtoclient> updatestatus(long clientId,int status) {
		try {
		clientRepo.updatestatus(clientId,status);
		return clientRepo.findAllClients();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Client> getActiveClient(){
		return clientRepo.getActiveClient(); 
	}
	
}
