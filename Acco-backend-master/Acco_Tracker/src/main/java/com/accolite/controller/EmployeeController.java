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
import org.springframework.web.bind.annotation.RestController;

import com.accolite.dto.Response;
import com.accolite.model.Employee;
import com.accolite.services.EmployeeServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	public EmployeeServices employeeservices;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Response> addemployee(@RequestBody Employee employee)
	{
		return employeeservices.addemployee(employee);
		
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee()
	{
		return employeeservices.getAllEmployee();
	}
	
	@GetMapping("/getEmployeeByEmail")
	public List<Employee> getEmployeeByEmail(@RequestParam String email)
	{
		return employeeservices.getEmployeeByEmail(email);
	}
//	
	@GetMapping("/getEmployeeByName")
	public List<Employee> getEmployeeByName(@RequestParam String name)
	{
		return employeeservices.getEmployeeByName(name);
	}
	
	@GetMapping("/getEmployeeByEmpId")
	public Employee getEmployeeByEmpId(@RequestParam long empId)
	{
		return employeeservices.getEmployeeByEmpId(empId);
	}
	@GetMapping("/noOfEmployees")
	public long findNoOfEmployees() {
		return employeeservices.findNoOfEmployees();
	}

//	@PutMapping("/updateEmployee")
//	public List<Employee> updateEmployee(@RequestParam long empId, @RequestParam String status)
//	{
//		return employeeservices.updateEmployee(empId,status);
//	}

	@PutMapping("/updateEmployee/{employeeid}")
	public List<Employee> updateEmployee(@PathVariable("employeeid") long empId, @RequestParam String status)
	{
		return employeeservices.updateEmployee(empId,status);
	}

	@GetMapping("checkemp")
	public ResponseEntity<Response> checkEmp(@RequestParam("empid") long empid){
		return employeeservices.checkEmp(empid);
	}
	@GetMapping("/findUnallocEmp")
	public List<Long> findUnallocEmpe() {
		return employeeservices.findUnallocEmp(); 
	}
	
}
