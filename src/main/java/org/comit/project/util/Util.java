package org.comit.project.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Util {

	public static Date parseDate(String str) {

		Date date = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = new Date(formatter.parse(str.trim()).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public static int parseId(String id) {
		return (id==null)?0:Integer.parseInt(id.trim());
	}
}
