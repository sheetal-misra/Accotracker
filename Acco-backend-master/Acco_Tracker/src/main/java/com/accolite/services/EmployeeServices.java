package com.accolite.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accolite.dto.Response;
import com.accolite.model.Employee;
import com.accolite.repository.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	public EmployeeRepository employeeRepo;
	
	public ResponseEntity<Response> addemployee(Employee employee) {
		 long id=employee.getEmployeeId();
		 Employee e=employeeRepo.getEmployeeByEmployeeId(id);
		 //System.out.println(e);
		 if(e!=null)
		 {
		       return new ResponseEntity<>(new Response("Employee already exists"),HttpStatus.BAD_REQUEST);

		 }
		 else
		 {
	         employeeRepo.save(employee);
	         return new ResponseEntity<>(new Response("Employee added successfully"),HttpStatus.OK);

		 }
		
        
	}

	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	public List<Employee> getEmployeeByEmail(String email) {
		return employeeRepo.getEmployeeByEmail(email);
	}

	public List<Employee> getEmployeeByName(String name) {
		return employeeRepo.getEmployeeByName(name);
	}

	public Employee getEmployeeByEmpId(long empId) {
		return employeeRepo.findById(empId).get();
	}

	public long findNoOfEmployees() {
		return employeeRepo.getEmployeeCount();
	}

	public List<Employee> updateEmployee(long empId, String status) {
		try
		{
			employeeRepo.updateEmployee(empId, status);
			return employeeRepo.findAll();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public ResponseEntity<Response> checkEmp(long id){
		
			Employee emp=employeeRepo.checkEmp(id);
			if(emp!=null) {
			return new ResponseEntity<>(new Response("Employee Id Already Exists"),HttpStatus.BAD_REQUEST);
		}
			else {
			return new ResponseEntity<>(new Response("Ok"),HttpStatus.OK);
			}
		
	}
	public List<Long> findUnallocEmp() {
		return employeeRepo.findUnallocEmp(); 
	}


}
