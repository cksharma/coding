//http://stackoverflow.com/questions/647017/java-abstract-class-confusion-overridden-method-not-being-called
package com.java2s.java.abstractclass;

import java.rmi.RMISecurityManager;

public class BasicClient extends AbstractClient {
	// private IBasicServer basicServer;

	public static void main(String[] args) {
		new BasicClient();
	}
	
	public BasicClient() {
		try {
			System.setSecurityManager(new RMISecurityManager());
			//Registry registry = LocateRegistry.getRegistry();
			// basicServer = (IBasicServer)
			// registry.lookup(IBasicServer.LOOKUPNAME);
			run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	void displayOptions() {
		// BasicClientOptions.displayOptions();
		System.out.println("We're in subclasses displayOptions().");
	}

	@Override
	void processInputCommand(String input) {
		System.out.println("We're in subclasses processInputCommand().");
	}
}
