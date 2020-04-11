package rmiclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.cksharma.designpatterns.facade.TransferServiceFacade;

public class ServiceClient {
	public static void main(String[] args) {
		//String debitScvUrl = "rmi://localhost:1099/debitService"; // by default rmi registry runs at this port
		//String creditSvcUrl = "rmi://localhost:1099/creditService";
		try {
			/*Service1Interface svc1 = (Service1Interface)Naming.lookup(debitScvUrl);
			Service2Interface svc2 = (Service2Interface)Naming.lookup(creditSvcUrl);
			svc1.debit(1001, 5000);
			svc2.credit(1002, 5000); */
			String transferSvcUrl = "rmi://localhost:1099/transferService";
			TransferServiceFacade transFacade = (TransferServiceFacade) Naming.lookup(transferSvcUrl);
			transFacade.transferAmount(1001, 1002, 50000);
			System.out.println("amount transferred");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
