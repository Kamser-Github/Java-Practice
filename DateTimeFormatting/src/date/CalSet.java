package date;

import java.util.Calendar;

public class CalSet {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		cal.clear();
		cal.set(2020, 9, 1);//2020 11 -1
//		cal.set(Calendar.DATE, -1);
//		cal.add(Calendar.DATE, -1);
		cal.roll(Calendar.DATE, -1);
		cal.getActualMaximum(Calendar.DATE);
		System.out.println(toString(cal));
		
	}
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"년"
				+(date.get(Calendar.MONTH)+1)+"월"
				+date.get(Calendar.DATE)+"일";
	}
}
