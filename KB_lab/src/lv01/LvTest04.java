package lv01;

import java.util.Scanner;

public class LvTest04 {
	
	public static void main(String[] args) {
		/*
		 * # 연산자 기호 맞추기 게임 
		 * 1. 1~10 사이의 랜덤 숫자 2개를 저장한다. 
		 * 2. 1~4 사이의 랜덤 숫자 1개를 저장한다. 
		 * 3. 위 숫자는 연산자 기호에 해당된다. 
		 * 1) 덧셈 2) 뺼셈 3) 곱셈 4) 나머지 
		 * 4. 사용자는 연산자 기호를 맞추는 게임이다. 
		 * 예) 3 ? 4 = 7 
		 * 1) + 2) - 3) * 4) % 정답 : 2번
		 */
		
		/*문제 설명이 부족해서 제대로 이해가 안된거일수도 있다.
		 * 1.숫자 1~10사이 2개를 각각 a,b라고한다
		 * 2.1~4사이는 연산기호 +-*%를 말한다.
		 * 3.a ? b 를 한결과 c를 만들고
		 * 출력창에 a ? b = c를 보여주고
		 * 사용자가 ?를 입력했을때
		 * 연산기호랑 동일하면 합격이다.
		 */
		Scanner sc = new Scanner(System.in);
		//랜덤숫자 1~10사이
		int num1 = (int)(Math.random()*10)+1;
		int num2 = (int)(Math.random()*10)+1;
		//랜덤숫자 1~4
		int operator = (int)(Math.random()*4)+1;
		
		//숫자 1일경우 +
		//숫자 2일경우 -
		//숫자 3일경우 *
		//숫자 4일경우 %
		//작업을 하고 결과 c를 만든다
		int result = 0;
		String answer ="";
		switch(operator) {
		case 1:
			//더하기
			result = num1+num2;
			answer ="+";
			break;
		case 2:
			//빼기
			result = num1-num2;
			answer ="-";
			break;
		case 3:
			//곱하기
			result = num1*num2;
			answer ="*";
			break;
		default:
			//나머지
			result = num1%num2;
			answer ="%";
		}
		String q = String.format("[%2d ? %2d = %2d]",num1,num2,result);
		System.out.println(q);
		System.out.println("연산기호를 입력하세요");
		while(!sc.next().equals(answer)) {
			System.out.println("틀렸습니다.");
		}
		System.out.println("정답입니다.");
		
		
		sc.close();
	}
}
