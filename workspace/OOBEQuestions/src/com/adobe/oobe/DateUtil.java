/*******************************************************************************
 * ADOBE CONFIDENTIAL
 *   ___________________
 * 
 *    Copyright 2013 Adobe Systems Incorporated. All Rights Reserved.
 * 
 *   NOTICE:  All information contained herein is, and remains
 *   the property of Adobe Systems Incorporated and its suppliers,
 *   if any.  The intellectual and technical concepts contained
 *   herein are proprietary to Adobe Systems Incorporated and its
 *   suppliers and are protected by trade secret or copyright law.
 *   Dissemination of this information or reproduction of this material
 *   is strictly forbidden unless prior written permission is obtained
 *   from Adobe Systems Incorporated.
 ******************************************************************************/
package com.adobe.oobe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;



public class DateUtil {

	public static String getDateStringInISO8601Format(long dateVal) {
		Date date = new Date(dateVal);
		String dateFormatStr = "yyyy-MM-dd'T'HH:mm:ssZ";
		DateFormat m_ISO8601Local = new SimpleDateFormat(dateFormatStr);
		TimeZone tz = TimeZone.getDefault();
		m_ISO8601Local.setTimeZone(tz);
		return m_ISO8601Local.format(date);
	}
	
	public static String getPSTDateStringInISO8601Format(long dateVal) {
		Date date = new Date(dateVal);
		String dateFormatStr = "yyyy-MM-dd'T'HH:mm:ssZ";
		DateFormat m_ISO8601Local = new SimpleDateFormat(dateFormatStr);
		TimeZone tz = TimeZone.getTimeZone("PST"); 
		m_ISO8601Local.setTimeZone(tz);
		return m_ISO8601Local.format(date);
	}
}
