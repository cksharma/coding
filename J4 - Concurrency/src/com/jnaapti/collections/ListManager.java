package com.jnaapti.collections;

import java.util.List;

public class ListManager {
	private static List<Integer> _internalSynchList = null;
	private static List<Integer> _internalNonSynchList = null;

	public synchronized static List<Integer> getInstance(
			boolean synchronizedList) {
		if (synchronizedList) {
			if (_internalSynchList == null) {
				_internalSynchList = new SynchronizedCOWList<Integer>();
			}
			return _internalSynchList;
		} else {
			if (_internalNonSynchList == null) {
				_internalNonSynchList = new NonSynchronizedList<Integer>();
			}
			return _internalNonSynchList;
		}

	}
}