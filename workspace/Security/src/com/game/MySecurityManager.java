package com.game;

import java.security.Permission;

public class MySecurityManager extends SecurityManager {

	@Override
	public void checkPermission(Permission perm) {
		//System.out.println(perm.getClass().getName());
		//System.out.println(perm.getActions());
		//if (perm.getClass().getName().equals("com.game.HighScorePermission"))
			//throw new AccessControlException("Acces denied for highscore");
	}
}
