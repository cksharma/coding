package edu.cksharma.designpatterns.facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service2Implementation extends UnicastRemoteObject implements Service2Interface{

	protected Service2Implementation() throws RemoteException { 
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void credit(int accNo, double amount) throws RemoteException{
		// TODO Auto-generated method stub
		System.out.println("crediting " + amount + "  accNumber " + accNo);
	}	
}
