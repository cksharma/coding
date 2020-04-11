package com.adobe.oobe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class Enum {
	
	// This Date-to-String converter method is used for JEM; where no Timezone info comes, instead they send 'Z' 
	public static String convertDateToString(Date date, String outputFormatString, TimeZone timeZone) {
		String outputDateString;
		/* Create Formatters */
		DateTimeFormatter isoFormatter = ISODateTimeFormat.dateTimeNoMillis();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

		if (timeZone != null) {
			isoFormatter = isoFormatter.withZone(DateTimeZone.forTimeZone(timeZone));
			simpleDateFormat.setTimeZone(timeZone);
		}

		if (outputFormatString.equalsIgnoreCase("ISO8601_DATE_FORMAT")) {
			outputDateString = isoFormatter.print(date.getTime());
		} else {
			simpleDateFormat.applyPattern(outputFormatString);
			outputDateString = simpleDateFormat.format(date);
		}

		return outputDateString;
	}
	
	public static void main(String[] args) {
		String format = "yyyy-MM-dd'T'HH:mm:ss'-0800'";
		long ck = new Date().getTime();
		DateFormat ff = new SimpleDateFormat();
		String kk = convertDateToString(new Date(), format, null);
		System.out.println("Time dekho = " + kk);		
	}
}