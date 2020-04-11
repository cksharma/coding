package com.onmobile.training;

import com.opensymphony.xwork2.ActionSupport;

public class TestAliasInterceptorAction extends ActionSupport {

	private String userName;
	private String password;

	
	public String getuserName() {
		return userName;
	}


	public void setuserName(String userName) {
		this.userName = userName;
	}


	public String getpassword() {
		return password;
	}


	public void setpassword(String password) {
		this.password = password;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("aagaya");
		// TODO Auto-generated method stub
		if (userName.equals("testuser") && password.equals("testpass")) {
			userName = userName + "\t from " + getText("companyName");
			return SUCCESS;
		}
		else
		{
			addActionError("Invalid username and password");
			return ERROR;
		}	  
	}
}