package lv02;
public class Ex06 {
	public static void main(String[] args) {

		int arr[] = { 3, 3, 3
					, 0, 0, 3
					, 3, 3, 0 };
		
		// 문제1) 배열을 위와 같이3줄씩 출력
		/*
		 * 1. (idx+1)/3%==0일때 마다 새 라인만들기. 
		 * 2. 3번째 6번째 9번째 다 idx 관련..3개씩 출력하기.
		 */
		int idx = 0;
		int cnt = 0;
		int bingoCnt = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[idx] + " ");
				if (arr[idx] == 3) {
					cnt++;
				}
				idx++;
			}
			if (cnt == 3) {
				bingoCnt++;
			}
			cnt = 0;
			System.out.println();
		}
		if(bingoCnt>0) {
			System.out.println("빙고");
		}

		System.out.println("=====================");

		cnt = 0;
		boolean check = false;
		for (int i = 0; i < 9; i++) {
			System.out.print(arr[i] + " ");
			if (arr[i] == 3)
				cnt++;
			if (cnt == 3)
				check = true;
			if ((i + 1) % 3 == 0) {
				System.out.println();
				cnt = 0;
			}
		}
		if (check)
			System.out.println("빙고");
		
		//배열을 위와 같이 3줄씩 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			if(i%3==2) {
				System.out.println();
			}
			
		}
		
		//빙고
		for(int i=0; i<arr.length; i+=3) {
			if(arr[i]==3&&arr[i+1]==3&&arr[i+2]==3) {
				System.out.println("빙고!");
			}
		}
		
//		//count 활용
//		for(int i=0 ; i<arr.length ; i+=3) {
//			int count = 0;
//			for(int j=0; i<3 ; j++) {
//				if(arr[i+j]==3) {
//					count++;
//				}
//			}
//			if(count==3) {
//				System.out.println("빙고 !");
//			}
//		}
			
	}
}