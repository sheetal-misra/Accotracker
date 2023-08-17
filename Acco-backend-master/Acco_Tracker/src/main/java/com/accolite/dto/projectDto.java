package com.accolite.dto;

public class projectDto {
	
	private String domainName;
	private String clientName;
	private String swiftCode;
	private String division;
	private String superDepartment;
	private String department;
	private String projectName;
	private String projectLocation;
	private String clientSideManager;
	private int isActive;	
	private String typeOfProject;
	private long headCount;
	public projectDto(String domainName, String clientName, String swiftCode, String division, String superDepartment,
			String department, String projectName, String projectLocation, String clientSideManager, int isActive,
			String typeOfProject, long headCount) {
		super();
		this.domainName = domainName;
		this.clientName = clientName;
		this.swiftCode = swiftCode;
		this.division = division;
		this.superDepartment = superDepartment;
		this.department = department;
		this.projectName = projectName;
		this.projectLocation = projectLocation;
		this.clientSideManager = clientSideManager;
		this.isActive = isActive;
		this.typeOfProject = typeOfProject;
		this.headCount = headCount;
	}
	
	public projectDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getSwiftCode() {
		return swiftCode;
	}
	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
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
	public String getProjectLocation() {
		return projectLocation;
	}
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	public String getTypeOfProject() {
		return typeOfProject;
	}
	public void setTypeOfProject(String typeOfProject) {
		this.typeOfProject = typeOfProject;
	}
	public String getClientSideManager() {
		return clientSideManager;
	}
	public void setClientSideManager(String clientSideManager) {
		this.clientSideManager = clientSideManager;
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
	

}
