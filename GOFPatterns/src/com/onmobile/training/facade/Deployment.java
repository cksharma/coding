package com.onmobile.training.facade;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Deployment { // invoking server method from object in server from client side is RMI.
	//we require stub which is the proxy of the server object.
	//server object in the client side is called as stub(in Layman terms).
	//rmic tool for creating stub in rmi.  ejbc in EJB to create this tool.
	public static void main(String[] args) {
		try {
			/*Service1Implementation service1 = new Service1Implementation();
			Service2Implementation service2 = new Service2Implementation();
			Naming.rebind("debitService", service1);
			Naming.rebind("creaditService", service2); */
			Naming.rebind("transferService", new TransferServiceFacadeImplementation());
			System.out.println("Deployed");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
