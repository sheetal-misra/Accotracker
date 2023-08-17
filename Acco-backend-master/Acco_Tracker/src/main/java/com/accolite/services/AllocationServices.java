package com.accolite.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.accolite.dto.AllocationDto;
import com.accolite.dto.Response;
import com.accolite.model.Allocation;
import com.accolite.model.Employee;
import com.accolite.repository.AllocationRepository;
import com.accolite.repository.EmployeeRepository;

@Service
public class AllocationServices {

	@Autowired
	public AllocationRepository allocationRepo;
	
	@Autowired
	public EmployeeRepository empRepo;

////	public void addAllocation(Allocation allocation) {
////		String id=allocation.getEmployeeId();
////		Allocation alloc=allocationRepo.getAllocationByEmpId(id);
////		if(alloc!=null) {
////			alloc.setIsActive(0);
////			alloc.setEndDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
////			allocationRepo.save(alloc);
////		}
////        allocationRepo.save(allocation);		
////	}
//	
////	public void addAllocation(AllocationDto allocationdto)
////        allocationRepo.save(allocationdto);
////	}
//
//	public List<Map<String, Object>> getAllAllocation() {
//        return allocationRepo.getAllAllocation();		
//	}
//
//	public List<Map<String, Object>> getAllocationByEmpName(String name) {
//		return allocationRepo.getAllocationByEmpName(name);
//	}
//
//	public List<Map<String, Object>> getAllocationByEmpEmail(String email) {
//		return allocationRepo.getAllocationByEmpEmail(email);
//	}
//
//	public List<Map<String, Object>> getAllocationByEmpId(String id) {
//		return allocationRepo.getAllocationEmpId(id);
//	}
//
//
//	public List<Map<String, Object>> getAllocationHistory(String empId) {
//		return allocationRepo.getAllocationHistory(empId);
//	}
//
//	public Response checkExistingWork(String empId) {
//		List<Allocation> a=allocationRepo.checkExisitngWork(empId);
//		if(a.size()==0)
//		{
//			System.out.println("No");
//			return new Response("No");
//		}
//		System.out.println("Yes");
//		return new Response("Yes");
//	}
//
//	public ResponseEntity<String> checkAllocation(String empId) {
//	    List<String> notalloted = allocationRepo.checkAllocation(empId);
//	    if(notalloted.contains(empId))
//	    {
//	    	return new ResponseEntity<>(HttpStatus.OK);
//	    }
//	    else
//	    {
//	    	return new ResponseEntity<>("Enter valid employee id",HttpStatus.BAD_REQUEST);
//	    }
//	}
//
//	public ResponseEntity<Response> addAllocation(Allocation allocation) {
//		String id=allocation.getEmployeeId();
//		Allocation alloc=allocationRepo.getAllocationByEmpId(id);
//		if(alloc!=null) {
//			alloc.setIsActive(0);
//			alloc.setEndDate(LocalDateTime.now());
//			allocationRepo.save(alloc);
//		}
//        allocationRepo.save(allocation);
//		return new ResponseEntity<>(new Response("Allocation done seccessfully"), HttpStatus.OK);
//	}

	
//	public void addAllocation(AllocationDto allocationdto)
//        allocationRepo.save(allocationdto);
//	}

	public List<Map<String, Object>> getAllAllocation() {
        return allocationRepo.getAllAllocation();		
	}
//
	public List<Map<String, Object>> getAllocationByEmpName(String name) {
		return allocationRepo.getAllocationByEmpName(name);
	}
//
	public List<Map<String, Object>> getAllocationByEmpEmail(String email) {
		return allocationRepo.getAllocationByEmpEmail(email);
	}

	public List<Map<String, Object>> getAllocationByEmpId(String id) {
		return allocationRepo.getAllocationEmpId(id);
	}


	public List<Map<String, Object>> getAllocationHistory(String empId) {
		return allocationRepo.getAllocationHistory(empId);
	}

	public ResponseEntity<Response> checkExistingWork(long empId) {
		List<Allocation> a=allocationRepo.checkExisitngWork(empId);
		if(a.size()==0)
		{
//			System.out.println("No");
			return new ResponseEntity<>(new Response("No"),HttpStatus.OK);
		}
//		System.out.println("Yes");
		return new ResponseEntity<>(new Response("Yes"),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> checkAllocation(Long empId) {
	    List<Long> notalloted = allocationRepo.checkAllocation(empId);
	    if(notalloted.contains(empId))
	    {
	    	System.out.println("if");
	    	return new ResponseEntity<>(HttpStatus.OK);
	    }
	    else
	    {
	    	System.out.println("else");
	    	return new ResponseEntity<>("Employee doesn't exist or resigned",HttpStatus.BAD_REQUEST);
	    }
	}

	public ResponseEntity<Response> addAllocation(Allocation allocation) {
		long id=allocation.getEmployeeId();
		Employee e=empRepo.getEmployeeByEmployeeId(id);
		String status=e.getStatus();
		System.out.println(status);
		if(status.equals("resign")) {
			return new ResponseEntity<>(new Response("Employee resigned"), HttpStatus.BAD_REQUEST);
		}
		else {
		Allocation alloc=allocationRepo.getAllocationById(id);
		if(alloc!=null) {
			alloc.setIsActive(0);
			alloc.setEndDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
			allocationRepo.save(alloc);
		}
        allocationRepo.save(allocation);
		return new ResponseEntity<>(new Response("Allocation done successfully"), HttpStatus.OK);
		}
	}
}
