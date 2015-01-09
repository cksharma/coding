package com.onmobile.training.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service1Interface extends Remote {
	public void debit(int accNo, double amount)  throws RemoteException;
}
