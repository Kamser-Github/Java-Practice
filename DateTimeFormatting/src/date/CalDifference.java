package date;

import java.util.Calendar;

public class CalDifference {
	public static void main(String[] args) {
		Calendar day1 = Calendar.getInstance();
		Calendar day2 = Calendar.getInstance();
		
		day1.clear();
		day2.clear();
		
		day1.set(2020, 9, 16);
		day1.set(2020, 11, 3);
		
		long day1Millis = day1.getTimeInMillis();
		long day2Millis = day2.getTimeInMillis();
		
		long dayDiff = Math.abs(day1Millis-day2Millis);
		
		int[] times = {3600,60,1};
		String[] day = {"시","분","초"};
		String diffTime = "";
		
		for(int i=0 ; i<times.length ; i++) {
			diffTime+=(dayDiff/times[i]+day[i]);
			dayDiff%=times[i];
		}
		System.out.println(diffTime);
	}
}

