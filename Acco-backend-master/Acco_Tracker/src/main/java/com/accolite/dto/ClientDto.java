package com.accolite.dto;

public class ClientDto {

	private long clientId;
	private String clientName;
	private String domainName;
	private int isActive;
	private long headCount;
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
	public long getHeadCount() {
		return headCount;
	}
	public void setHeadCount(long headCount) {
		this.headCount = headCount;
	}
	public ClientDto(long clientId, String clientName, String domainName, int isActive, long headCount) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.domainName = domainName;
		this.isActive = isActive;
		this.headCount = headCount;
	}
	public ClientDto() {
		super();
	}
	
	
}
