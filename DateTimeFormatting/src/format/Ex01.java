package format;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex01 {
	public static void main(String[] args) {

		double number = 1234567.89;
		DecimalFormat df = new DecimalFormat("#,###.##");
		DecimalFormat dfE = new DecimalFormat("#.###E0");
		String word = df.format(number);
		System.out.println(word);
		
		//word 다시 원래의 데이터로
		try {
			Number data = df.parse(word);
			double numberRow = data.doubleValue();
			System.out.println("String > Number > double : "+numberRow);
			String wordE = dfE.format(numberRow);
			System.out.println("double > String : "+wordE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
