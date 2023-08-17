package com.accolite.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "allocation")
public class Allocation {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long allocationId;
	private int isActive = 1;
	private String swiftCode;
	private long percentage; 
	private Date startDate;
	private  Date endDate = null;
	private LocalDateTime modifiedOn;
	private String modifiedBy;
	
//	@OneToOne
//	@JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
	private long employeeId;
	
//	@OneToOne
//	@JoinColumn(name = "clientId", referencedColumnName = "clientId")
	private long clientId;

	public long getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(long allocationId) {
		this.allocationId = allocationId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	
	

	public long getPercentage() {
		return percentage;
	}

	public void setPercentage(long percentage) {
		this.percentage = percentage;
	}

	

	public Allocation(long allocationId, int isActive, String swiftCode, long percentage, Date startDate,
			Date endDate, LocalDateTime modifiedOn, String modifiedBy, long employeeId, long clientId) {
		super();
		this.allocationId = allocationId;
		this.isActive = isActive;
		this.swiftCode = swiftCode;
		this.percentage = percentage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.employeeId = employeeId;
		this.clientId = clientId;
	}

	public Allocation() {
		super();
	}
	
	
	
	
}
