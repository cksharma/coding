package com.onmobile.training;

public class FindResultUtility 
{
	public static String getResult(Marks m)
	{
		String result = "fail";
		if(m.getMark1() >= 40 && m.getMark2() >= 40 && m.getMark3() >= 40)
		{
			result = "pass";
		}
		return result;
	}
}
