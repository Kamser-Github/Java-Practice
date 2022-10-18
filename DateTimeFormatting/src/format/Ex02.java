package format;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Ex02 {
	public static void main(String[] args) {
		//DecimalFormat은 숫자 데이터를 정수,실수,지수,금액등을
		//특정 형식에 맞게 변환하는 클래스
		
		int coffee = 3500;
		int bread = 5500;
		DecimalFormat df = new DecimalFormat("#,###원");
		String price = df.format(coffee);
		String price2 = df.format(bread);
		System.out.println(price); //3,500원
		System.out.println(price2); //5,500원
		//다시 숫자로 변환하기
		try {
			Number rowCoffee = df.parse(price);
			int rowCoffeeData = rowCoffee.intValue(); 
			System.out.println(rowCoffeeData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
