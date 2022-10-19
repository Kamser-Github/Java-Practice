package format;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class ChronoEx {
	public static void main(String[] args) {
		//날짜 변경하기
		LocalDate now = LocalDate.now();
		now=now.with(ChronoField.DAY_OF_WEEK,4); //2022-10-20
		now=now.with(ChronoField.DAY_OF_YEAR,355); //2022-12-21
		//chronoField 상수값들이 들어온다.

		//날짜 더하기
		LocalDate nowPlus = LocalDate.now();
		nowPlus.plus(99,ChronoUnit.DAYS);//2023-01-26;
		//plus 매개변수로 Period,Duration
		//날짜를 더할때 ChronoUnit 상수를 가져온다.
		
		nowPlus.plus(5,ChronoUnit.MONTHS);//2023-06-26
		nowPlus.plus(5,ChronoUnit.CENTURIES);//2523-06-26
		
		//LocalDate에는 없고 LocalTime에만 존재하는것
		//trunatedTo(ChronoUnit.Hours) // 필드값보다 작은 단위를 0으로 초기화
		//Date에는 0으로 초기화 될수가 없기때문에 해당 매서드가 없다.
		LocalTime nowTime = LocalTime.now();
		//21:44:37 <변경전
		//09:44:17 <변경후 nowTime.plus(1,ChronoUnit);
/*
		DAYS - 일
		Unit that represents the concept of a day.
		WEEKS - 주
		Unit that represents the concept of a week.
		MONTHS - 달
		Unit that represents the concept of a month.
		YEARS - 년
		Unit that represents the concept of a year.
		DECADES - 10년
		Unit that represents the concept of a decade.
		CENTURIES - 100년
		Unit that represents the concept of a century.
		----
		MILLIS - 천분의 일초
		Unit that represents the concept of a millisecond.
		SECONDS - 초
		Unit that represents the concept of a second.
		MINUTES - 분
		Unit that represents the concept of a minute.
		HOURS - 시간
		Unit that represents the concept of an hour.
		HALF_DAYS - 반나절
		Unit that represents the concept of half a day, as used in AM/PM.
		----
		ERAS - 10억년
		Unit that represents the concept of an era.
		FOREVER
		Artificial  unit that represents the concept of forever.
		MICROS
		Unit that represents the concept of a microsecond.
		MILLENNIA
		Unit that represents the concept of a millennium.
		NANOS
		Unit that represents the concept of a nanosecond, the smallest supported unit of time.
*/
	}
}
