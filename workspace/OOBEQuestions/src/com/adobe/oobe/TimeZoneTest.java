package com.adobe.oobe;

import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {
	public static void main(String[] args) {
		TimeZone pacificTimeZone = TimeZone.getTimeZone("America/Los_Angeles");
		System.out.println(System.currentTimeMillis());
		long currentTime = new Date().getTime();
		System.out.println("Current Server Time " + currentTime);
		long convertedTime = currentTime +
		    pacificTimeZone.getOffset(currentTime);
	    System.out.println("Pacific Server Time " + convertedTime);  
	    long diff = currentTime - convertedTime;
	    System.out.println("Diff = " + diff);
	    double hrs = diff * 1. / 1000; hrs = hrs / 3600;
	    System.out.println("Diff in hours " + hrs);
	}
}
