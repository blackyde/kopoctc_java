package com.book.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String month = cal.get(Calendar.YEAR) + String.format("%02d", cal.get(Calendar.MONTH) + 1);
		String day = String.format("%d", cal.get(Calendar.DATE));
		System.out.println(month);
		System.out.println(day);
		
		String days = "2019-08-01";
		Date date = null;
		try {
			date = sdf.parse(days);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sdf.format(date));
	}

}
