package com.accolite.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;

public class AllocationDto {

	
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String skills;
	private long years;
	private long months;
	private String domainName;
	private String clientName;
	private String division;
	
	private String superDepartment;
	private String department;
	private String projectName;
	private String typeOfProject;
    private String projectLocation;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int isActive;
    
    public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
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
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public String getSuperDepartment() {
		return superDepartment;
	}
	public void setSuperDepartment(String superDepartment) {
		this.superDepartment = superDepartment;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTypeOfProject() {
		return typeOfProject;
	}
	public void setTypeOfProject(String typeOfProject) {
		this.typeOfProject = typeOfProject;
	}
	public String getProjectLocation() {
		return projectLocation;
	}
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public AllocationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllocationDto(String employeeId, String employeeName, String employeeEmail, String skills, long years,
			long months, String domainName, String clientName, String division, String superDepartment,
			String department, String projectName, String typeOfProject, String projectLocation,
			LocalDateTime startDate, LocalDateTime endDate, int isActive) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.skills = skills;
		this.years = years;
		this.months = months;
		this.domainName = domainName;
		this.clientName = clientName;
		this.division = division;
		this.superDepartment = superDepartment;
		this.department = department;
		this.projectName = projectName;
		this.typeOfProject = typeOfProject;
		this.projectLocation = projectLocation;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActive = isActive;
	}
	
	
	
}
