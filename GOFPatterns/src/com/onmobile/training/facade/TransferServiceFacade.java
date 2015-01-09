package com.onmobile.training.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TransferServiceFacade extends Remote{
	public void transferAmount(int srcAcc, int tagetAcc, double amount) throws RemoteException;
}
