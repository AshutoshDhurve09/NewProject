package com.v2Technologies.project_management_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_DESIGNATION")
public class Designation 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long designationId;
	
	@Column(name="DESIGNATION",unique=true)
	private String designation;
	
	public Designation() {
		// TODO Auto-generated constructor stub
	}

	public Designation(Long designationId, String designation) {

		this.designation = designation;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
}
