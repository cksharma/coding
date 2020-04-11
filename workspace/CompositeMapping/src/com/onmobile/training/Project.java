package com.onmobile.training;

import java.util.List;
import java.util.Set;

public class Project {
	private int project_id;
	private String project_name;
	private int approver;
	private double status_percentage;
	private List<Employee> members;
	

	public List<Employee> getMembers() {
		return members;
	}
	public void setMembers(List<Employee> members) {
		this.members = members;
	}
	public Project(int projectId, String projectName, int approver,
			double statusPercentage) {
		super();
		project_id = projectId;
		project_name = projectName;
		this.approver = approver;
		status_percentage = statusPercentage;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int projectId) {
		project_id = projectId;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String projectName) {
		project_name = projectName;
	}
	public int getApprover() {
		return approver;
	}
	public void setApprover(int approver) {
		this.approver = approver;
	}
	public double getStatus_percentage() {
		return status_percentage;
	}
	public void setStatus_percentage(double statusPercentage) {
		status_percentage = statusPercentage;
	}
}