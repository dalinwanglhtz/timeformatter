package com.codewardev;

// https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java

public class TimeFormatter {

	public static String formatDuration(int seconds) {
		int numSeconds = seconds;
		StringBuilder output = new StringBuilder();
		int minutes = 60;
		int hours = minutes*60;
		int days = hours*24;
		int years = 365*days;
		
		if(seconds == 0) {
			return "now";
		}
		
		int remainder = numSeconds;
		String year="";
		if(numSeconds / years > 0) {
			year = (numSeconds / years == 1? "1 year":(numSeconds / years)+" years");
			remainder = numSeconds % years;
			output.append(year);
		} else {
			remainder = numSeconds % years;
		}
		
		
		numSeconds = remainder;
		String day="";
		if(numSeconds / days > 0) {
			day = (numSeconds / days == 1? "1 day":(numSeconds / days)+" days");
			remainder = numSeconds % days;
			if(!year.isEmpty()) {
				if(remainder > 0) {
					output.append(", "+day);
				} else {
					output.append(" and "+day);
				}
			} else {
				output.append(day);
			}
		} else {
			remainder = numSeconds % days;
		}
		
		
		numSeconds = remainder;
		String hour="";
		if(numSeconds / hours > 0) {
			hour = (numSeconds / hours == 1? "1 hour":(numSeconds / hours)+" hours");
			remainder = numSeconds % hours;
			if(!year.isEmpty() || !day.isEmpty()) {
				if(remainder > 0) {
					output.append(", "+hour);
				} else {
					output.append(" and "+hour);
				}
			} else {
				output.append(hour);
			}
		} else {
			remainder = numSeconds % hours;
		}
		
		numSeconds = remainder;
		String minute="";
		if(numSeconds / minutes > 0) {
			minute = (numSeconds / minutes == 1? "1 minute":(numSeconds / minutes)+" minutes");
			remainder = numSeconds % minutes;
			if(!year.isEmpty() || !day.isEmpty() || !hour.isEmpty()) {
				if(remainder > 0) {
					output.append(", "+minute);
				} else {
					output.append(" and "+minute);
				}
			} else {
				output.append(minute);
			}
		} else {
			remainder = numSeconds % minutes;
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
