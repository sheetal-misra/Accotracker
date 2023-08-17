package com.accolite.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accolite.dto.Response;
import com.accolite.model.Manager;
import com.accolite.repository.ManagerRepository;

@Service
public class ManagerServices {

	@Autowired
	public ManagerRepository managerRepo;
	
	public ResponseEntity<Response> checkuser(String email) {
        try
        {
        	Manager ismanager = managerRepo.findById(email).get();
        }
        catch(Exception e)
        {
        	return new ResponseEntity<>(new Response("Not a valid user"),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Response("Success"),HttpStatus.OK);
	}

}
