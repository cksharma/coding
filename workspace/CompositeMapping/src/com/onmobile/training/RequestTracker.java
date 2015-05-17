package com.onmobile.training;

public class RequestTracker {
	private int requestId;
	private int empid;
	private int empidToBeAdded;
	private int empidApprover;
	private int status;
	
	public RequestTracker() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public RequestTracker(int requestId, int empid, int empidToBeAdded,
			int empidApprover, int status) {
		super();
		this.requestId = requestId;
		this.empid = empid;
		this.empidToBeAdded = empidToBeAdded;
		this.empidApprover = empidApprover;
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getEmpidToBeAdded() {
		return empidToBeAdded;
	}
	public void setEmpidToBeAdded(int empidToBeAdded) {
		this.empidToBeAdded = empidToBeAdded;
	}
	public int getEmpidApprover() {
		return empidApprover;
	}
	public void setEmpidApprover(int empidApprover) {
		this.empidApprover = empidApprover;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
}