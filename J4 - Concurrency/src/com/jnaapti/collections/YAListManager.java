package com.jnaapti.collections;

public class YAListManager {

	private static YAList<Integer> _internalList = null;

	public synchronized static YAList<Integer> getInstance() {
		if (_internalList == null) {
			_internalList = new YAList<Integer>();
		}
		return _internalList;

	}

}
