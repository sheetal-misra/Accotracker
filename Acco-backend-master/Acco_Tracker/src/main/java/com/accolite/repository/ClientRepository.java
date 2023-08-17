package com.accolite.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accolite.dto.ClientDto;
import com.accolite.dto.dtoclient;
import com.accolite.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query(value="select c.client_id as clientId, c.client_name as clientName, c.domain_name as domainName, c.is_active as isActive, sum(if(a.is_active=1,1,0))as headCount\r\n"
			+ "			from client c left join allocation a\r\n"
			+ "			        on c.client_id = a.client_id\r\n"
			+ "                    where c.client_id!=-1 and c.client_name like %?1%\r\n"
			+ "		                group by c.client_id;",nativeQuery=true)
	List<dtoclient> getClientByClientName(String clientName);

	@Query(value="select c.client_id as clientId, c.client_name as clientName, c.domain_name as domainName, c.is_active as isActive, sum(if(a.is_active=1,1,0))as headCount\r\n"
			+ "			from client c left join allocation a\r\n"
			+ "			        on c.client_id = a.client_id\r\n"
			+ "                    where c.client_id!=-1 and c.domain_name like %?1%\r\n"
			+ "		                group by c.client_id;",nativeQuery=true)
	List<dtoclient> getClientByDomainName(String domainName);
	
	@Query(value="select c.client_id as clientId, c.client_name as clientName, c.domain_name as domainName, c.is_active as isActive, sum(if(a.is_active=1,1,0))as headCount\r\n"
			+ "			from client c left join allocation a\r\n"
			+ "			        on c.client_id = a.client_id\r\n"
			+ "                    where c.client_id!=-1\r\n"
			+ "		                group by c.client_id;",nativeQuery=true)
	List<dtoclient> findAllClients();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE client SET is_active = ?2 WHERE client_id = ?1", nativeQuery = true)
	void updatestatus(Long clientId, int status);
	

	@Query(value = "select count(*) as total_clients from client where client_id!=-1 and is_active=1",nativeQuery = true)
	long getClientCount();
	@Query(value = "select * from client where is_active=1 and client_id!=-1", nativeQuery = true)
	List<Client> getActiveClient(); 

}
