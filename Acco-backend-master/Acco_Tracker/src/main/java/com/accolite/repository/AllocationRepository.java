package com.accolite.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.dto.AllocationDto;
import com.accolite.dto.Response;
import com.accolite.model.Allocation;


@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {


//	@Modifying(clearAutomatically=true)
//	@Transactional
//	@Query(value = "select  employee_id, employee_name, employee_email, project_name, "
//			+ "	project_department, project_location, is_active, client_name, start_date, end_date from (select e.employee_id, e.employee_name, e.employee_email, p.project_name, "
//			+ "	p.project_department, p.project_location, a.is_active, c.client_name, a.start_date, a.end_date, row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp "
//			+ "	from allocation a join employee e on a.employee_id = e.employee_id "
//			+ "	join client c on a.client_id = c.client_id "
//			+ "	join project p on a.project_id = p.project_id) as ranks where temp=1 ", nativeQuery = true)
//	List<Map<String, Object>> getAllAllocation();
//
//	@Modifying(clearAutomatically=true)
//	@Transactional
//	@Query(value = "select  employee_id, employee_name, employee_email, project_name, "
//			+ "	project_department, project_location, is_active, client_name, start_date, end_date from (select e.employee_id, e.employee_name, e.employee_email, p.project_name, "
//			+ "	p.project_department, p.project_location, a.is_active, c.client_name, a.start_date, a.end_date, row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp "
//			+ "	from allocation a join employee e on a.employee_id = e.employee_id and e.employee_name like %?1% "
//			+ "	join client c on a.client_id = c.client_id "
//			+ "	join project p on a.project_id = p.project_id) as ranks where temp=1 ",nativeQuery=true)
//	List<Map<String, Object>> getAllocationByEmpName(@Param("name") String name);
////
////	
//	@Modifying(clearAutomatically=true)
//	@Transactional
//	@Query(value = "select  employee_id, employee_name, employee_email, project_name, "
//			+ "	project_department, project_location, is_active, client_name, start_date, end_date from (select e.employee_id, e.employee_name, e.employee_email, p.project_name, "
//			+ "	p.project_department, p.project_location, a.is_active, c.client_name, a.start_date, a.end_date, row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp "
//			+ "	from allocation a join employee e on a.employee_id = e.employee_id and e.employee_email like %?1%"
//			+ "	join client c on a.client_id = c.client_id "
//			+ "	join project p on a.project_id = p.project_id) as ranks where temp=1 ",nativeQuery=true)
//	List<Map<String, Object>> getAllocationByEmpEmail(@Param("email") String email);
//
//	
//	@Modifying(clearAutomatically=true)
//	@Transactional
//	@Query(value = "select  employee_id, employee_name, employee_email, project_name,\r\n"
//			+ "			project_department, project_location, is_active, client_name,start_date,end_date from (select a.allocation_id,e.employee_id, e.employee_name, e.employee_email, p.project_name,\r\n"
//			+ "			p.project_department, p.project_location, a.is_active, c.client_name,a.start_date,a.end_date,row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp \r\n"
//			+ "			from allocation a join employee e on a.employee_id = e.employee_id and e.employee_id like %?1% \r\n"
//			+ "			join client c on a.client_id = c.client_id \r\n"
//			+ "			join project p on a.project_id = p.project_id) as ranks where temp=1 order by allocation_id",nativeQuery=true)
//	List<Map<String, Object>> getAllocationEmpId(@Param("id") String id);
//
//
//	@Modifying(clearAutomatically=true)
//	@Transactional
//	@Query(value = "select e.employee_id, e.employee_name, e.employee_email, p.project_name, "
//			+ "p.project_department, p.project_location, a.is_active, c.client_name, start_date, end_date "
//			+ "from allocation a join employee e on a.employee_id = e.employee_id and e.employee_id = ?1 "
//			+ "join client c on a.client_id = c.client_id "
//			+ "join project p on a.project_id = p.project_id "
//			+ "order by a.allocation_id desc",nativeQuery=true)
//	List<Map<String, Object>> getAllocationHistory(@Param("empId") String empId);
//
//	@Transactional
//	@Query(value="select * from allocation a where a.employee_id=?1 and a.is_active=1",nativeQuery=true)
//	Allocation getAllocationByEmpId(@Param("empId") String empId);
//
//
//	@Transactional
//	@Query(value="select * from allocation a where a.employee_id = ?1",nativeQuery = true)
//	List<Allocation> checkExisitngWork(String empId);
//
//	@Transactional
//	@Query(value = "select employee_id from employee ", nativeQuery = true)
//	List<String> checkAllocation(String empId);
//	
	@Modifying(clearAutomatically=true)
	@Transactional

	@Query(value="select employee_id,employee_name,employee_email,skills,years,months,status,domain_name,client_name, \r\n"
			+ "			division,super_department,department,project_name,type_of_project,project_location,is_active, start_date, end_date, percentage  from (select e.employee_id,e.employee_name,e.employee_email,e.skills,e.years,e.months,e.status,c.domain_name,c.client_name, \r\n"
			+ "			p.division,p.super_department,p.department,p.project_name,p.type_of_project,p.project_location,a.is_active,a.start_date, a.end_date, a.percentage, row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp \r\n"

			+ "			from allocation a join employee e on a.employee_id = e.employee_id \r\n"
			+ "			join client c on a.client_id = c.client_id \r\n"
			+ "			join project p on a.swift_code = p.swift_code) as ranks where temp=1",nativeQuery=true)
	List<Map<String, Object>> getAllAllocation();

	@Modifying(clearAutomatically=true)
	@Transactional

	@Query(value="select employee_id,employee_name,employee_email,skills,years,months,status,domain_name,client_name, \r\n"
			+ "			division,super_department,department,project_name,type_of_project,project_location,is_active, start_date, end_date, percentage  from (select e.employee_id,e.employee_name,e.employee_email,e.skills,e.years,e.months,e.status,c.domain_name,c.client_name, \r\n"
			+ "			p.division,p.super_department,p.department,p.project_name,p.type_of_project,p.project_location,a.is_active, a.start_date, a.end_date, a.percentage  , row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp \r\n"

			+ "			from allocation a join employee e on a.employee_id = e.employee_id  and e.employee_name like %?1% \r\n"
			+ "			join client c on a.client_id = c.client_id \r\n"
			+ "			join project p on a.swift_code = p.swift_code) as ranks where temp=1",nativeQuery=true)
	List<Map<String, Object>> getAllocationByEmpName(@Param("name") String name);

	
	@Modifying(clearAutomatically=true)
	@Transactional

	@Query(value="select employee_id,employee_name,employee_email,skills,years,months,status,domain_name,client_name, \r\n"
			+ "			division,super_department,department,project_name,type_of_project,project_location,is_active, start_date, end_date, percentage    from (select e.employee_id,e.employee_name,e.employee_email,e.skills,e.years,e.months,e.status,c.domain_name,c.client_name, \r\n"
			+ "			p.division,p.super_department,p.department,p.project_name,p.type_of_project,p.project_location,a.is_active, a.start_date, a.end_date, a.percentage,   row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp \r\n"

			+ "			from allocation a join employee e on a.employee_id = e.employee_id and e.employee_email like %?1% \r\n"
			+ "			join client c on a.client_id = c.client_id \r\n"
			+ "			join project p on a.swift_code = p.swift_code) as ranks where temp=1",nativeQuery=true)
	List<Map<String, Object>> getAllocationByEmpEmail(@Param("email") String email);

	@Query("select a from Allocation a where employeeId= ?1 and isActive=1")
	Allocation getAllocationById(@Param("id") long id);
	
	@Modifying(clearAutomatically=true)
	@Transactional

	@Query(value ="select employee_id,employee_name,employee_email,skills,years,months,domain_name,client_name, \r\n"
			+ "			division,super_department,department,project_name,type_of_project,project_location,is_active,  start_date, end_date, percentage   from (select e.employee_id,e.employee_name,e.employee_email,e.skills,e.years,e.months,c.domain_name,c.client_name, \r\n"
			+ "			p.division,p.super_department,p.department,p.project_name,p.type_of_project,p.project_location,a.is_active, a.start_date, a.end_date , a.percentage, row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp \r\n"

			+ "			from allocation a join employee e on a.employee_id = e.employee_id and e.employee_id like %?1% \r\n"
			+ "			join client c on a.client_id = c.client_id \r\n"
			+ "			join project p on a.swift_code = p.swift_code) as ranks where temp=1",nativeQuery=true)
	List<Map<String, Object>> getAllocationEmpId(@Param("id") String id);


	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "select e.employee_id,e.employee_name,e.employee_email,e.skills,e.years,e.months,c.domain_name,c.client_name, "
			+ "p.division,p.super_department,p.department,p.project_name,p.type_of_project,p.project_location,a.is_active, a.start_date,a.end_date, a.percentage  "
			+ "from allocation a join employee e on a.employee_id = e.employee_id and e.employee_id = ?1 "
			+ "join client c on a.client_id = c.client_id "
			+ "join project p on a.swift_code = p.swift_code "
			+ "order by a.allocation_id desc",nativeQuery=true)
	List<Map<String, Object>> getAllocationHistory(@Param("empId") String empId);

	@Transactional
	@Query(value="select * from allocation a where a.employee_id=?1 and a.is_active=1",nativeQuery=true)
	Allocation getAllocationByEmpId(@Param("empId") long empId);


	@Transactional
	@Query(value="select * from allocation a where a.employee_id = ?1",nativeQuery = true)
	List<Allocation> checkExisitngWork(long empId);

	@Transactional
	@Query(value = "select employee_id from employee where status!='resign'", nativeQuery = true)
	List<Long> checkAllocation(Long empId);
	

}
