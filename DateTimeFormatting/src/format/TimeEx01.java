package format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeEx01 {
	public static void main(String[] args) {
		//now() 현재 시간을 담는다.
		LocalDate date = LocalDate.now();
		System.out.println(date); //2022-10-16
		LocalTime time = LocalTime.now();
		System.out.println(time); //17:55:59.686142600
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime); //2022-10-16T17:55:59.686142600
		
		//of() 해당 필드의 값을 순서대로 지정해준다.
		LocalDate dateOf = LocalDate.of(2022, 10, 16);
		System.out.println(dateOf); //2022-10-16
		LocalTime timeOf = LocalTime.of(17, 58, 16);
		System.out.println(timeOf); //17:58:16
		
		LocalDateTime dateTime2 = LocalDateTime.of(dateOf, timeOf);
		ZonedDateTime zDateTime = ZonedDateTime.of(dateTime2, ZoneId.of("Asia/Seoul"));
	}
}
