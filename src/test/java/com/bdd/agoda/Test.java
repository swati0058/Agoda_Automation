package com.bdd.agoda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws Exception {
		String bookDate ="21-Jan-2024";
		String dateformat="dd-MMM-yyyy";
		//selectDate(driver, from_date, "dd/MMM/YYYY");
	
		// TODO Auto-generated method stub
		System.out.println("bookDate-----"+bookDate);
		System.out.println("dateformat-----"+dateformat);
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat targetDateFormat = new SimpleDateFormat(dateformat);
		Date formattedTargetDate;
		try {
			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(bookDate);
			calendar.setTime(formattedTargetDate);
	
		System.out.println("formattedDate------"+formattedTargetDate);
		System.out.println("bookDate----"+bookDate);

		int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("targetDay======" + targetDay);
		int targetMonth = calendar.get(Calendar.MONTH);
		System.out.println("targetMonth======" + targetMonth);
		int targetYear = calendar.get(Calendar.YEAR);
		System.out.println("targetYear======" + targetYear);
		Thread.sleep(1000);
		
	

	} catch (ParseException e) {
		throw new Exception("Invalid date is provided, please check input date");
	
		
		}
		}

}
