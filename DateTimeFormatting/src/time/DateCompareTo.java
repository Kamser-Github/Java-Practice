package time;

import java.time.Instant;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.Date;

public class DateCompareTo {
	public static void main(String[] args) {
		Instant epoch = Instant.now();
//		System.out.println(epoch);//2022-10-19T13:14:50.314431100Z
		long epochSec = epoch.getEpochSecond();
		int nano = epoch.getNano();
//		System.out.println(epochSec); //1666185362
//		System.out.println(nano); 	  //860661300
		OffsetTime off = OffsetTime.now(); // UTC
		System.out.println(off); //22:20:07.584048700+09:00
		LocalTime local = LocalTime.now(); // GMT
		System.out.println(local);
		
		Date epochDate = Date.from(epoch);//Instant => Date
		Instant instantDate = epochDate.toInstant();//Date=> Instant
	}
}
