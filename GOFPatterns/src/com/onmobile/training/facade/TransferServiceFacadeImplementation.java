package com.onmobile.training.facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TransferServiceFacadeImplementation extends UnicastRemoteObject implements TransferServiceFacade{

	private Service1Interface service1;
	private Service2Interface service2;
	
	protected TransferServiceFacadeImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		service1 = new Service1Implementation();
		service2 = new Service2Implementation();
	}
	
	@Override
	public void transferAmount(int srcAcc, int tagetAcc, double amount)
			throws RemoteException {
		// TODO Auto-generated method stub
		service1.debit(srcAcc, amount);
		service2.credit(tagetAcc, amount);
		System.out.println("amount transferred");
	}	
}
