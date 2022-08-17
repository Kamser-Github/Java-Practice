package lv01;

public class LvTest02 {
	public static void main(String[] args) {
		/*
		 * # 369게임[1단계]
		 * 1. 1~50 사이의 랜덤 숫자를 저장한다.
		 * 2. 위 수에 369의 개수가
		 * 	1) 2개이면, 짝짝을 출력
		 *  2) 1개이면, 짝을 출력
		 *  3) 0개이면, 해당 숫자를 출력
		 * 예)
		 * 		33	 : 짝짝
		 * 		16	 : 짝
		 * 		 7	 : 7
		 */
		//이 문제는
		//내가 그동안 문제를 너무 단순하게 풀어왔다는걸 느꼈다.
		/*
		String clapping = "";
		if(십의 자리 %3이 0일때) clapping+="짝";
		if(일의 자리 %3이 0일때) clapping+="짝";
		
		System.out.print(randomNumber+" : ");
		
		if(clapping.length()!=0) {
			System.out.print(clapping);
		} else {
			System.out.print(randomNumber);
		}
		이렇게 하면 문자열을 사용을 해야되고
		만약 숫자가 커진다면 메모리나 가독성도 떨어진다.
		*/
		
//		int ran = 0;
		//1~50까지 랜덤 번호
		//번호 확인
//		while(true) {
//			ran = (int)(Math.random()*50)+1;
//			if(ran==1||ran==50) {
//				System.out.println(ran);
//				break;
//			}
//		} 이상 무
		int ran = (int)(Math.random()*50)+1;
		//일의 자리, 십의 자리가 3으로 나누었을때 0이면 짝
		//단 0을 3으로 나머지를 구하면 0이기 때문에 제외
		
		int cnt = 0;
		//박수 카운트
		int ten = ran/10;
		int one = ran%10;
		
		if(ten!=0 && ten%3==0) cnt++;
		if(one!=0 && one%3==0) cnt++;
		
		System.out.print(ran+" : ");
		if(cnt!=0) {
			while(cnt>0) {
				System.out.print("짝");
				cnt--;
			}
		} else {
			System.out.print(ran);
		}
	}
}
