package date;

import java.util.Calendar;

public class CalTest {
	public static void main(String[] args) {
		Calendar caladd = Calendar.getInstance();
		Calendar calroll = Calendar.getInstance();
		
		caladd.clear();
		calroll.clear();
		
		caladd.set(2020, 10, 1);
		calroll.set(2020, 10, 1);
		
		caladd.add(Calendar.DATE, 35);
		calroll.roll(Calendar.DATE, 35);
		System.out.println("11월의 마지막 날 : "+calroll.getActualMaximum(Calendar.DATE));
		System.out.println("add+35day : "+toString(caladd));
		System.out.println("roll+35day :"+toString(calroll));
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"년"
				+(date.get(Calendar.MONTH)+1)+"월"
				+date.get(Calendar.DATE)+"일";
	}
}
