package com.onmobile.training;
import java.io.Serializable;
import java.util.Set;

public class ProjectMembers implements Serializable {
	private int project_id;
	private int emp_id;
	private double status;
	
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int projectId) {
		project_id = projectId;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int empId) {
		emp_id = empId;
	}
	
	public double getStatus() {
		return status;
	}
	public void setStatus(double status) {
		this.status = status;
	}
	public ProjectMembers() {
		super();
		// TODO Auto-generated constructor stub
	}
}