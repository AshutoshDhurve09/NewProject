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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TBL_TASK")
public class Task 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long taskId;
	
	@Column(name = "TASK_NAME",nullable = false,length=20)
	String taskName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_START_DATE", nullable = false, length = 13)
	Date taskStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TASK_END_DATE", nullable = false, length = 13)
	Date taskEndDate;
	
	@Column(name = "PRIORITY", nullable = false)
	String priority;
	
	@Column(name="STATUS",columnDefinition="boolean default false",updatable=true)
	Boolean status=false;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(String taskName, Date taskStartDate, Date taskEndDate, String priority, Boolean status) {

		this.taskName = taskName;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
		this.priority = priority;
		this.status = status;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID_FK")
	private Employee employee;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROJECT_ID_FK")
	private Project assignProject;
	
	public Project getAssignProject() {
		return assignProject;
	}

	public void setAssignProject(Project assignProject) {
		this.assignProject = assignProject;
	}

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
