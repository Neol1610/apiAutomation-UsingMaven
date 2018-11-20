package com.ttn.allyoApi.Utilities;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

public class Keywords {

	private static int paramOldCount = 0;
	private static int paramNewCount = 0;
	private static List<String> oldUrls = new ArrayList<String>();
	private static List<String> newUrls = new ArrayList<String>();

	public static String url1;
	public static String url2;

	public static void setURL(String env) {
		/*
		 * switch case for env load the properties file for the env append
		 * version to it. return url
		 */
		Properties properties = new Properties();
		String fileName = "application-" + env + ".properties";
		try {
			FileReader reader = new FileReader(fileName);
			properties.load(reader);

			GlobalVars.BASE_URL = properties.getProperty("BASE_URL");

			GlobalVars.TOKEN_USER = properties.getProperty("TOKEN_USER");
			

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	// Return Current Date
	public static String DateReturn() {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("da", "DK"));
		String date = simpleDateFormat.format(new Date());
		return date;
	}

	public static String FutureHoursReturn() {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("da", "DK"));
		Date newDate = DateUtils.addHours(new Date(), 3);
		return simpleDateFormat.format(newDate);
	}

	public static String FutureMonthReturn() {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("da", "DK"));
		Date newDate = DateUtils.addMonths(new Date(), 3);
		return simpleDateFormat.format(newDate);
	}

	// Return Future Hours in GMT
	public static String futureHoursTimeGMT() {

		Random rand = new Random();
		Date newDate = DateUtils.addHours(new Date(), rand.nextInt((60 - 0) + 1) + 0);
		SimpleDateFormat converter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		converter.setTimeZone(TimeZone.getTimeZone("GMT"));
		String currentDate = converter.format(newDate);
		return currentDate;
	}

	// Return Future Month in GMT
	public static String futureMonthTimeGMT() {

		Date newDate = DateUtils.addMonths(new Date(), 3);
		SimpleDateFormat converter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		converter.setTimeZone(TimeZone.getTimeZone("GMT"));
		String currentDate = converter.format(newDate);
		return currentDate;
	}

	// Return Current Date in GMT
	public static String currentDateTimeGMT() {
		Date localTime = new Date();
		SimpleDateFormat converter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		converter.setTimeZone(TimeZone.getTimeZone("GMT"));
		String currentDate = converter.format(localTime);
		return currentDate;
	}

	public boolean hasMoreNewUrl() {
		return paramNewCount <= newUrls.size();
	}

	public boolean hasMoreOldUrl() {
		return paramOldCount <= oldUrls.size();
	}

	public String getNewUrl() {
		return newUrls.get(paramNewCount++);
	}

	public String getOldUrl() {
		return newUrls.get(paramOldCount++);
	}

}