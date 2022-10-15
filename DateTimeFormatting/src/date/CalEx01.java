package date;

import java.util.Calendar;

public class CalEx01 {
	//기본적으로 현재 날짜와 시간으로 설정된다.
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println("이 해의 년도 : "+today.get(Calendar.YEAR));
		System.out.println("월(0~11, 0:1월 : "+today.get(Calendar.MONTH));
		System.out.println("이 해의 몇 째 주 : "+today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇 째 주 : "+today.get(Calendar.WEEK_OF_MONTH));
		//DATE와 DAY_OF MONTH는 같다.
		System.out.println("이 달의 몇 일 : "+today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 달의 몇 일 : "+today.get(Calendar.DATE));
		
		System.out.println("요일(1~7), 1=일요일 : "+today.get(Calendar.DAY_OF_WEEK));
							//1:일요일 ~7:토요일
		System.out.println("이 달의 몇 째 요일 : "+today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		//이번주의 요일을 선택하고 달에서 몇번째 요일인지 알려줌
		System.out.println("오전_오후(0:오전,1:오후):"+today.get(Calendar.AM_PM));
		System.out.println("시간 0~11"+today.get(Calendar.HOUR));
		System.out.println("시간 0~23"+today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : "+today.get(Calendar.MINUTE));
		System.out.println("초(0~59) : "+today.get(Calendar.SECOND));
		
		System.out.println("1000분의 1초(0~999)"+ today.get(Calendar.MILLISECOND));
		//천분으 ㅣ1초를 시간으로 표현하기위해 3600000으로 나눈다(1시간 60*60)
		//GMT offset changes.로 변경이 되서 계산된다.
		
		System.out.println("TimeZone(-12~12) : "+(today.get(Calendar.ZONE_OFFSET))/(60*60*1000));
		//이 달의 마지막 날
		System.out.println("이 달의 마지막 날 :"+today.getActualMaximum(Calendar.DATE));
	}
}
