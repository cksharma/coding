package com.jnaapti.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class AdderThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		ArrayManager arrayToBeAdded = ArrayManager.getInstance();
		List<Integer> arrayList = new ArrayList<Integer>();
		while (true) {
			Integer nextValue = arrayToBeAdded.getNextValue();
			if (nextValue != null)
				arrayList.add(nextValue);
			else
				break;
		}

		Integer sum = 0;

		for (Integer value : arrayList) {
			sum += value;
		}

		return sum;
	}
}
