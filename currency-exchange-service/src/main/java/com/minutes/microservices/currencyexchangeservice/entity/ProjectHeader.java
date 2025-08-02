package com.minutes.microservices.currencyexchangeservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional
@Table(name ="header")
public class ProjectHeader {
	//# project_header_id, customer, manager, status DB column

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_header_id")
	 private	Long headerId;
	
	@Column(name = "customer")
	private String cusomerName;
	
	@Column(name = "manager")
	private String managerName;
	
	@Column(name = "status")
	private String status;

	@Column(name = "projectName")
	private String projectName;
	
	@Column(name = "projectNumber")
	private String projectNumber;


	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	public String getCusomerName() {
		return cusomerName;
	}

	public void setCusomerName(String cusomerName) {
		this.cusomerName = cusomerName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

}
