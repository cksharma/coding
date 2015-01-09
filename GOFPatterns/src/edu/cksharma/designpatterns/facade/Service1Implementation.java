package edu.cksharma.designpatterns.facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Service1Implementation extends UnicastRemoteObject implements Service1Interface{

	protected Service1Implementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void debit(int accNo, double amount) throws RemoteException{
		// TODO Auto-generated method stub
		System.out.println("debiting " + amount + " from " + accNo);
	}	
}
