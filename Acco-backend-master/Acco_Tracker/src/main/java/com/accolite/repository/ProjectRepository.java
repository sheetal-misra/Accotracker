package com.accolite.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.dto.dtoproject;
import com.accolite.dto.projectDto;
import com.accolite.model.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


	


	
	
	
	@Transactional
	@Query(value="select c.domain_name as domainName, c.client_name as clientName, p.swift_code as swiftCode, p.division, \r\n"
			+ "p.super_department as superDepartment, p.department, p.project_name as projectName, p.project_location as projectLocation, \r\n"
			+ "p.client_side_manager as clientSideManager, p.is_active as isActive, p.type_of_project as typeOfProject,sum(if(a.is_active=1,1,0)) as headCount\r\n"
			+ "	from project p\r\n"
			+ "      left join client c\r\n"
			+ "		 on p.client_id = c.client_id\r\n"
			+ "			left join allocation a\r\n"
			+ "			   on p.swift_code = a.swift_code\r\n"
			+ "			      where p.swift_code is not null group by p.swift_code;",nativeQuery=true)
	List<dtoproject> getAllProject();
	


	@Query(value = "select * from project p where p.swift_code = ?1",nativeQuery = true)
	Project findBySwiftCode(String scode);
	
	@Query(value="select c.domain_name as domainName, c.client_name as clientName, p.swift_code as swiftCode, p.division, \r\n"
			+ "p.super_department as superDepartment, p.department, p.project_name as projectName, p.project_location as projectLocation, \r\n"
			+ "p.client_side_manager as clientSideManager, p.is_active as isActive, p.type_of_project as typeOfProject,sum(if(a.is_active=1,1,0)) as headCount\r\n"
			+ "	from project p\r\n"
			+ "      left join client c\r\n"
			+ "		 on p.client_id = c.client_id\r\n"
			+ "			left join allocation a\r\n"
			+ "			   on p.swift_code = a.swift_code\r\n"
			+ "			      where p.swift_code is not null and p.swift_code like %?1% group by p.swift_code;",nativeQuery=true)
	List<dtoproject> getProjectBySwiftCode(String swiftCode);

	






	@Query(value="select c.domain_name as domainName, c.client_name as clientName, p.swift_code as swiftCode, p.division, \r\n"
			+ "p.super_department as superDepartment, p.department, p.project_name as projectName, p.project_location as projectLocation, \r\n"
			+ "p.client_side_manager as clientSideManager, p.is_active as isActive, p.type_of_project as typeOfProject,sum(if(a.is_active=1,1,0)) as headCount\r\n"
			+ "	from project p\r\n"
			+ "      left join client c\r\n"
			+ "		 on p.client_id = c.client_id\r\n"
			+ "			left join allocation a\r\n"
			+ "			   on p.swift_code = a.swift_code\r\n"
			+ "			      where p.swift_code is not null and c.client_name like %?1% group by p.swift_code;",nativeQuery=true)
	List<dtoproject> getProjectByClientName(String clientName);


	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE project SET is_active = ?2 WHERE project_id = ?1", nativeQuery = true)
	void updateStatus(Long clientId, int status);

	@Query("select new com.accolite.dto.projectDto(c.domainName, c.clientName, p.swiftCode, p.division, "
			+ "	p.superDepartment, p.department, p.projectName, p.projectLocation, "
			+ "		p.clientSideManager, p.isActive, p.typeOfProject, count(a.swiftCode) as headCount) "
			+ "			from Project p "
			+ "			  left join Client c "
			+ "			     on p.clientId = c.clientId "
			+ "			       left join Allocation a "
			+ "			          on p.swiftCode = a.swiftCode "
			+ "                       where p.projectName like %?1% "
			+ "			                  group by p.swiftCode")
	List<projectDto> getProjectByProjectName(String projectName);



	
	@Query(value = "select * from project p where p.client_id = ?1", nativeQuery = true)
	List<Project> getProjectByClientId(long clientId);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE project SET is_active = ?2 WHERE swift_code = ?1", nativeQuery = true)
	void updateStatus(String swiftcode, int status);

	@Query(value="select * from project where client_id=?1 and is_active = 1 and project_id!=-1", nativeQuery = true)
	List<Project> getActiveProject(Long client_id);
	
	@Query(value = "select count(*) as total_projects from project where project_id!=-1 and is_active=1",nativeQuery = true)
	long getProjectCount();
}
