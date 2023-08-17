package com.accolite.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class Client {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long clientId;
	private String clientName;
	private String domainName;
	private int isActive;
	private String modifiedBy;
	private LocalDateTime modifiedOn;
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Client(long clientId, String clientName, String domainName, int isActive, String modifiedBy,
			LocalDateTime modifiedOn) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.domainName = domainName;
		this.isActive = isActive;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}
	public Client() {
		super();
	}
	
	
	
}
