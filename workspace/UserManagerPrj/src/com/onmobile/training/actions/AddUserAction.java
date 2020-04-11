package com.onmobile.training.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;

import com.onmobile.training.domains.User;
import com.opensymphony.xwork2.ActionSupport;

public class AddUserAction extends ActionSupport implements ApplicationAware {
	private String username;
	private String password;
	private String email;
	private Map map;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ArrayList users = (ArrayList)map.get("users");
		if(users == null) {
			users = new ArrayList ();
		}
		if(getUser(username) == null)
		{
			users.add(buildUser());
			map.put("users", users);
		}
		else
		{
			addActionError("user name already exists");
			return ERROR;
		}
		return SUCCESS;
	}

	private User buildUser() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		return user;
	}

	private User getUser(String username) {
		// TODO Auto-generated method stub
		User user = new User();
		boolean found = false;
		Object userList = map.get("users");
		
		if(userList != null)
		{
			ArrayList users = (ArrayList)userList;
			Iterator it = users.iterator();
			while(it.hasNext()){
				user = (User)it.next();
				if(user.getUsername().equals(username)) {
					found = true;
					break;
				}
			}
		}
		if(found) return user;
		else return null;
	}

	@Override
	public void setApplication(Map map) { //this method is invoked by the frameowkr automatically.
		//a sort oif DI (dependency injection).
		// TODO Auto-generated method stub
		this.map = map;
	}
}
