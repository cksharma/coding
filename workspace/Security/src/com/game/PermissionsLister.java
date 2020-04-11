package com.game;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.Policy;

public class PermissionsLister {

	/**
	 * @param args
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException {
		CodeSource codeSource = new CodeSource(new URL("file:/-"),
				(CodeSigner[]) null);
		System.out.println(Policy.getPolicy().getPermissions(codeSource));

	}

}
