package com.rohan.accolite.date;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TimeZoneDifference {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		String date1, date2, timeZone;
		LocalDateTime localDate1, localDate2;
		
		ZoneId zoneId;
		ZonedDateTime zonedDate1, zonedDate2;
		
		System.out.println("Enter the first date of birth (dd/mm/yyy)");
		date1 = sc.nextLine();
		
		System.out.println("Enter the second date of birth (dd/mm/yyyy)");
		date2 = sc.nextLine();
		
		System.out.println("Enter a time zone:");
		timeZone = sc.next();
		
		try {
			localDate1 = LocalDate.parse(date1, formatter).atStartOfDay();
			localDate2 = LocalDate.parse(date2, formatter).atStartOfDay();
			
			zoneId = ZoneId.of("Asia/Kolkata");
			zonedDate1 = localDate1.atZone(zoneId);
			
			zoneId = ZoneId.of(timeZone);
			zonedDate2 = localDate2.atZone(zoneId); 
		} catch(Exception e) {
			System.out.println("Invalid Date format");
			// Default
			// My Birthday: 17th September 1998, 17:52
			localDate1 = LocalDateTime.of(1998, Month.SEPTEMBER, 17, 17, 52);
			
			// Sister's Birthday: 1st February 1996, 11:04
			localDate2 = LocalDateTime.of(1996, Month.FEBRUARY, 1, 11, 04);
			
			zoneId = ZoneId.of("Asia/Kolkata");
			zonedDate1 = localDate1.atZone(zoneId);
			
			zoneId = ZoneId.of("America/Los_Angeles");
			zonedDate2 = localDate2.atZone(zoneId); 
		} 
		
		long timeDifference = differenceInDate(zonedDate1, zonedDate2);
		System.out.println("The difference between the birth time in Nanoseconds is: "+timeDifference);
		
		long timeDifference2 = differenceInDate2(zonedDate1, zonedDate2);
		System.out.println("The difference between the birth time in Days is: "+timeDifference2);
		sc.close();
	}
	
	public static long differenceInDate(ZonedDateTime date1, ZonedDateTime date2) {
		return Math.abs(ChronoUnit.NANOS.between(date1, date2));	
	}
	
	public static long differenceInDate2(ZonedDateTime date1, ZonedDateTime date2) {
		return Math.abs(ChronoUnit.DAYS.between(date1, date2));	
	}
}
