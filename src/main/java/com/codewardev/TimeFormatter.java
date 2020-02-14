package com.codewardev;

//https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java

import java.time.Duration;

public class TimeFormatter {
	
	private static final int MINUTES = 60;
	private static final int HOURS = MINUTES*60;
	private static final int DAYS = HOURS*24;
	private static final int YEARS = DAYS*365;

	public static String formatDuration(int seconds) {
		StringBuilder output = new StringBuilder();
		
		if(seconds == 0) return "now";
		
		Duration duration = Duration.ofSeconds((long) seconds);
		int Year = 0, Day = 0, Hour = 0, Minute = 0, Second = 0;
		while(duration.getSeconds() > 0) {
			if(YEARS <= duration.getSeconds()) {
				Year++;
				duration = duration.minusSeconds(YEARS);
			} else
			if(DAYS <= duration.getSeconds()) {
				Day++;
				duration = duration.minusSeconds(DAYS);
			} else
			if(HOURS <= duration.getSeconds()) {
				Hour++;
				duration = duration.minusSeconds(HOURS);
			} else
			if(MINUTES <= duration.getSeconds()) {
				Minute++;
				duration = duration.minusSeconds(MINUTES);
			} else {
				Second++;
				duration = duration.minusSeconds(1);
			}
		}

		boolean hasFirst = false, hasNext = false;
		if(Year > 0) {
			output.append(Year == 1? "1 year":Year+" years");
			hasFirst = true;
			hasNext = Hour > 0 || Minute > 0 || Second > 0? true:false;
		}
		
		if(Day > 0) {
			if(hasFirst) output.append(hasNext?", ":" and ");
			output.append((Day == 1? "1 day":Day+" days"));
			hasFirst = true;
			hasNext = Minute > 0 || Second > 0? true:false;
		}
		
		if(Hour > 0) {
			if(hasFirst) output.append(hasNext?", ":" and ");
			output.append((Hour == 1? "1 hour":Hour+" hours"));
			hasFirst = true;
			hasNext = Second > 0? true:false;
		}
		
		if(Minute > 0) {
			if(hasFirst) output.append(hasNext?", ":" and ");
			output.append((Minute == 1? "1 minute":Minute+" minutes"));
			hasFirst = true;
		}
		
		if(Second > 0) {
			if(hasFirst) output.append(" and ");
			output.append((Second == 1? "1 second":Second+" seconds"));
		}
		
		return output.toString();
	}

}
