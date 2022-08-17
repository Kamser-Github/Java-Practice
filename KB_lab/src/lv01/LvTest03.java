package lv01;

import java.util.Scanner;

public class LvTest03 {
	public static void main(String[] args) {
		/*
		 * # 지하철 요금 계산
		 * 1. 이용할 정거장 수를 입력받는다.
		 * 2. 다음과 같이 정거장 수에 따라 요금이 정산된다.
		 * 3. 요금표
		 * 1) 1~5	: 500원
		 * 2) 6~10	: 600원
		 * 3) 11,12 : 650원 (10정거장이후는 2정거장마다 50원추가)
		 * 4) 13,14 : 700원 (10정거장이후는 2정거장마다 50원추가)
		 * 5) 15,16 : 750원 (10정거장이후는 2정거장마다 50원추가)
		 * ... 
		 */
		
		//기본 가격은 500
		//6~이상은 기본가격 +100
		//11이상은 누적가격에 2정거장마다 50원 추가
		
		//정거장수 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("이용할 정거장수를 입력해주세요 : ");
		int station = sc.nextInt();
		
		int standardPrice = 500;
		if(station>5) standardPrice +=100;
		if(station>10) {
			int addPrice = (station-10+1)/2*50;
			//2로 나누면 하나씩 덜 올라가서 전체+1을 했다.
			standardPrice+=addPrice;
		}
		System.out.println(standardPrice);
		sc.close();
	}
}
