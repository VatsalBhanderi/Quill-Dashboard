package com.example.quill.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	public static String getCurrentDate() {
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static String getStartDate(String dateRange) {
		System.out.println("getEndDate() dateRange: "+ dateRange);
		// TODO Auto-generated method stub
		String endDate = "";
		LocalDateTime now = LocalDateTime.now();
		
		if(dateRange.equalsIgnoreCase("LAST_90_DAYS")) {
			LocalDateTime dateBefore90Days = now.minusDays(90);
			endDate = dateBefore90Days.format(dtf);
		}
		else if(dateRange.equalsIgnoreCase("LAST_30_DAYS")) {
			LocalDateTime dateBefore30Days = now.minusDays(30);
			endDate = dateBefore30Days.format(dtf);
		}
		else {
			LocalDateTime thisMonth = now.withDayOfMonth(1);
			endDate = thisMonth.format(dtf);
		}
		
		System.out.println("getEndDate() endDate: "+ endDate);
		return endDate;
	}
	
}
