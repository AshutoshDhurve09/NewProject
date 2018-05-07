package com.v2Technologies.project_management_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_GENERAL_ADMIN")
public class GeneralAdmin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long admin_id;
	
	@Column(name="ADMIN_NAME",unique=true,nullable=false)
	private String adminName;
	
	@Column(name="PASSWORD" , nullable=false)
	private String password;

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
