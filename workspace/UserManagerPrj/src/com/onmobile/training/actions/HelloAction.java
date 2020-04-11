package com.onmobile.training.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		setMessage("Hello from User Management System");
		return SUCCESS;
	}	
}
