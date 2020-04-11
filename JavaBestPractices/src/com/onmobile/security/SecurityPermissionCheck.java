package com.onmobile.security;

public class SecurityPermissionCheck {
	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name", "not specified"));
		System.out.println(System.getProperty("user.home", "not specified"));		
	}
	
	//-Djava.security.policy=resources/java.policy -Djava.security.manager
}