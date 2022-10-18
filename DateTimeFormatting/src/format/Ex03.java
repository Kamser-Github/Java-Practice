package format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex03 {
	public static void main(String[] args) {
		Date today = new Date();

		//오늘 날짜를 yyyy-MM-dd 형태로 변환해서 출력
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String todayString = df.format(today);
		System.out.println(todayString);//2022-10-16
		//오늘 날짜를 yyyyMMdd 형태로 변환해서 출력
		SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		todayString = df2.format(today);
		System.out.println(todayString);//20221016
		//오늘 날짜를 MMddyyyy 형태로 변환해서 출력
		SimpleDateFormat df3 = new SimpleDateFormat("MM/dd/yyyy");
		todayString = df3.format(today);
		System.out.println(todayString);//10/16/2022
		SimpleDateFormat df4 = new SimpleDateFormat("a h : mm");
		todayString = df4.format(today);
		System.out.println(todayString);//오후 2 : 49
	}
}
