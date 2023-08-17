package com.accolite.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "manager")
@Data
public class Manager {
    @Id
    private String ManagerEmail;

	public String getManagerEmail() {
		return ManagerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		ManagerEmail = managerEmail;
	}

	public Manager(String managerEmail) {
		super();
		ManagerEmail = managerEmail;
	}

	public Manager() {
		super();
	}

	
}
