package edu.cksharma.designpatterns.observer;

public class Test {
	public static void main(String[] args) {
		FaultMessageGenerator observable = new FaultMessageGenerator();
		FaultLogger flt = new FaultLogger();
		observable.addFaultListener(flt);
		observable.addFaultListener(new FaultEmailer());
		observable.addFaultListener(new FaultMessageSender());
		observable.errorOccured("network problem");
		System.out.println("");
		observable.removeFaultListener(flt);
		observable.errorOccured(" connection time out");
	}
}
