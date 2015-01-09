package com.onmobile.training.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service2Interface extends Remote{
	public void credit(int accNo, double amount) throws RemoteException;
}
