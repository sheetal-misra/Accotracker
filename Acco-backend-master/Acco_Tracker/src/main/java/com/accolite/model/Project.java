package com.accolite.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long projectId;
	private String swiftCode;
	private String division;
	private String superDepartment;
	private String department;
	private String projectName;
	private String projectLocation;
	private String typeOfProject;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "clientId", referencedColumnName = "clientId")
	private long clientId;
	
	private String clientSideManager;
	private int isActive;
	private String modifiedBy;
	private LocalDateTime modifiedOn;
	
	public long getprojectId() {
		return projectId;
	}
	public void setprojectId(long projectId) {
		this.projectId = projectId;
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
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
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
	
	public String getTypeOfProject() {
		return typeOfProject;
	}
	public void setTypeOfProject(String typeOfProject) {
		this.typeOfProject = typeOfProject;
	}
	
	
	public Project(long projectId, String swiftCode, String division, String superDepartment, String department,
			String projectName, String projectLocation, long clientId, String clientSideManager, int isActive,
			String modifiedBy, LocalDateTime modifiedOn, String typeOfProject) {
		super();
		this.projectId = projectId;
		this.swiftCode = swiftCode;
		this.division = division;
		this.superDepartment = superDepartment;
		this.department = department;
		this.projectName = projectName;
		this.projectLocation = projectLocation;
		this.clientId = clientId;
		this.clientSideManager = clientSideManager;
		this.isActive = isActive;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
		this.typeOfProject = typeOfProject;
	}
	public Project() {
		super();
	}
	
	
	
	
	
	
	
	
	
}
