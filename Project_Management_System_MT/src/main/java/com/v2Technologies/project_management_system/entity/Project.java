package com.v2Technologies.project_management_system.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_PROJECT")
public class Project 
{

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		Long projectId;
		
		@Column(name="PROJECT_NAME",unique=true,nullable=false)
		String projectName;
		
		@Column(name="PROJ_START_DATE",nullable=false)
		Date projectStartDate;
		
		@Column(name="PROJ_END_DATE",nullable=false)
		Date projectEndDate;
		
		@Column(name="PRIORITY",nullable=false)
		String priority;
	

		public Project() {
			// TODO Auto-generated constructor stub
		}

		public Project(String projectName, Date projectStartDate, Date projectEndDate, String priority) {
			super();
			this.projectName = projectName;
			this.projectStartDate = projectStartDate;
			this.projectEndDate = projectEndDate;
			this.priority = priority;
		}

		public Long getProjectId() {
			return projectId;
		}

		public void setProjectId(Long projectId) {
			this.projectId = projectId;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public Date getProjectStartDate() {
			return projectStartDate;
		}

		public void setProjectStartDate(Date projectStartDate) {
			this.projectStartDate = projectStartDate;
		}

		public Date getProjectEndDate() {
			return projectEndDate;
		}

		public void setProjectEndDate(Date projectEndDate) {
			this.projectEndDate = projectEndDate;
		}

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}
		

		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="EMPLOYEE_ID_FK")
		private Employee employee;
		
		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		
	
		public void allocateEmployee(Employee employee2)
		{
			employee=employee2;
		}
		
		
}
