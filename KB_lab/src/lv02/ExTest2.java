package lv02;

public class ExTest2 {
	public static void main(String[] args) {
		// 문제 1) 과락
		// 3과목의 평균이 60점 이상이면, true
		// 단, 어느 한 과목이라도 50점 미만이면, false
		int kor = 100;
		int eng = 87;
		int math = 41;
		
		//평균이 60이상 ture 하나라도 미만이면 false
		int avg = (kor+eng+math)/3;
		boolean result = false;
		//하나라도 50미만이면 false
		//(kor<50 || eng<50 || math<50)
		//이건 하나라도 50이하면 true;
		//하나라도 50미만이면 false;
		//!(kor<50 || eng<50 || math<50)
		//이걸 붙이면 하나라도 50미만이면 false
		//kor>=50&&eng>=50&&math>=50 으로 표현가능
		result = avg>=60&&kor>=50&&eng>=50&&math>=50;
		System.out.println(result);
		result = avg>=60&&!(kor<50||eng<50||math<50);
		System.out.println(result);
	}
}
