package com.adobe.oobe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class DateFormatter {

	/**
	 * Utility function to convert java Date to TimeZone format
	 * 
	 * @param date
	 * @param format
	 * @param timeZone
	 * @return
	 */
	public static String formatDateToString(Date date, String format, String timeZone) {
		// null check
		HashMap <Integer, Integer> m  = new HashMap<Integer, Integer>();
		if (date == null)
			return null;
		// create SimpleDateFormat object with input format
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// default system timezone if passed null or empty
		if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		// set timezone to SimpleDateFormat
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		// return Date in required format with timezone as String
		return sdf.format(date);
		
	}
	
	public static String getPSTDateStringInISO8601Format(long dateVal, String timeZone) {
		
		Date date = new Date(dateVal);
		String dateFormatStr = "yyyy-MM-dd'T'HH:mm:ssZ";
		DateFormat m_ISO8601Local = new SimpleDateFormat(dateFormatStr);
		TimeZone tz = TimeZone.getTimeZone(timeZone); 
		m_ISO8601Local.setTimeZone(tz);
		return m_ISO8601Local.format(date);
	}

	public static void main(String[] args) {
		// Test formatDateToString method
		/*Date date = new Date();
		System.out.println("Default Date:" + date.toString());
		System.out.println("System Date: " + formatDateToString(date, "dd MMM yyyy hh:mm:ss a", null));
		System.out.println("System Date in PST: " + formatDateToString(date, "dd MMM yyyy hh:mm:ss a", "PST"));
		System.out.println("System Date in IST: " + formatDateToString(date, "dd MMM yyyy hh:mm:ss a", "IST"));
		System.out.println("System Date in GMT: " + formatDateToString(date, "dd MMM yyyy hh:mm:ss a", "GMT"));*/
		long tt = new Date().getTime();
		String kk = getPSTDateStringInISO8601Format(tt, "PST");
		String rr = getPSTDateStringInISO8601Format(tt, "IST");
		String xx = getPSTDateStringInISO8601Format(tt, "GMT");
		System.out.println(kk);
		System.out.println(rr);
		System.out.println(xx);
		
	}

}