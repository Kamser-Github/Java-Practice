package format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex04 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Calendar today = Calendar.getInstance();
		today.clear();
		today.set(2022, 9, 16);
		Date day = today.getTime();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String dayString = df.format(day);
		System.out.println(dayString);
		
		try {
			Date newDay = df.parse(dayString);
			System.out.print((1900+newDay.getYear())+"년 ");
			System.out.print(newDay.getMonth()+1+"월 ");
			System.out.println(newDay.getDate()+"일");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
