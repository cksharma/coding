package com.onmobile.training.flyweight;

import java.util.HashMap;
import java.util.Map;

public class MathOperationFlyWeightFactory {
	private static Map <Character, MathOperation> cache = new HashMap<Character, MathOperation>();
	
	public static MathOperation createObject(char key)
	{
		MathOperation obj = null;
		if(cache.containsKey(key)) {
			obj = cache.get(key);
		}
		else {
			obj = new MathOperation(key);
			cache.put(key, obj);
		}
		return obj;
	}
}
