package com.onmobile.gc;

import java.util.ArrayList;
import java.util.List;

public class GCTester {
	public static void main(String[] args) {
		new Thread(new MemoryPrinter()).start();
		List<Integer> bigList = new ArrayList<Integer>();
		int i = 0;
		while (true) {
			int j = 10;
			int k = j + 20;
			k = k + 3;
			for (int l = 0; l < 10; l++) 
				bigList.add(i++);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
//-XX:+PrintGC -XX:+PrintGCDetails -Xmx20M -Xmn5M

class MemoryPrinter implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(Runtime.getRuntime().freeMemory());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}