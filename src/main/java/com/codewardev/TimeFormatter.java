package com.codewardev;

import java.time.Duration;

// https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java

public class TimeFormatter {
	
	private static final int MINUTES = 60;
	private static final int HOURS = MINUTES*60;
	private static final int DAYS = HOURS*24;
	private static final int YEARS = DAYS*365;

	public static String formatDuration(int seconds) {
		int numSeconds = seconds;
		StringBuilder output = new StringBuilder();
		
		if(numSeconds == 0) {
			return "now";
		}
		
		Duration duration = Duration.ofSeconds((long)numSeconds);
		System.out.println("Minutes: "+duration.toMinutes());
		System.out.println("Hours: "+duration.toHours());
		
		int remainder = numSeconds % YEARS;
		String year="";
		if(numSeconds / YEARS > 0) {
			year = (numSeconds / YEARS == 1? "1 year":(numSeconds / YEARS)+" years");
			output.append(year);
		}
		
		
		numSeconds = remainder;
		remainder = numSeconds % DAYS;
		String day="";
		if(numSeconds / DAYS > 0) {
			day = (numSeconds / DAYS == 1? "1 day":(numSeconds / DAYS)+" days");
			if(!year.isEmpty()) {
				if(remainder > 0) {
					output.append(", "+day);
				} else {
					output.append(" and "+day);
				}
			} else {
				output.append(day);
			}
		}
		
		
		numSeconds = remainder;
		remainder = numSeconds % HOURS;
		String hour="";
		if(numSeconds / HOURS > 0) {
			hour = (numSeconds / HOURS == 1? "1 hour":(numSeconds / HOURS)+" hours");
			if(!year.isEmpty() || !day.isEmpty()) {
				if(remainder > 0) {
					output.append(", "+hour);
				} else {
					output.append(" and "+hour);
				}
			} else {
				output.append(hour);
			}
		}
		
		numSeconds = remainder;
		remainder = numSeconds % MINUTES;
		String minute="";
		if(numSeconds / MINUTES > 0) {
			minute = (numSeconds / MINUTES == 1? "1 minute":(numSeconds / MINUTES)+" minutes");
			if(!year.isEmpty() || !day.isEmpty() || !hour.isEmpty()) {
				if(remainder > 0) {
					output.append(", "+minute);
				} else {
					output.append(" and "+minute);
				}
			} else {
				output.append(minute);
			}
		}
		
		String second="";
		if(remainder > 0) {
			second = (remainder == 1? "1 second":remainder+" seconds");
			if(!year.isEmpty() || !day.isEmpty() || !hour.isEmpty() || !minute.isEmpty()) {
				output.append(" and "+second);
			} else {
				output.append(second);
			}
		}
		
		System.out.println("Time is: "+output.toString());
		
		return output.toString();
	}

}
