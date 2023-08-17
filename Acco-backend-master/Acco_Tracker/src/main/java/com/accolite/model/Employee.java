package com.accolite.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;



import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
     
	public Employee(long sno, long employeeId, String employeeName, String employeeEmail, String skills, long years,
			@Max(12) long months, String status, String modifiedBy, LocalDateTime modifiedOn) {
		super();
		this.sno = sno;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.skills = skills;
		this.years = years;
		this.months = months;
		this.status = status;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long sno;
	private long employeeId;
	private String employeeName;
	private String employeeEmail;
	private String skills;
	private long years;
	@Max(value = 12)
	private long months;
	public String status = "active";
	private String modifiedBy;
	private LocalDateTime modifiedOn;
	
	public Employee() {
		super();
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public long getYears() {
		return years;
	}

	public void setYears(long years) {
		this.years = years;
	}

	public long getMonths() {
		return months;
	}

	public void setMonths(long months) {
		this.months = months;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public long getSno() {
		return sno;
	}

	public void setSno(long sno) {
		this.sno = sno;
	}

	
}
