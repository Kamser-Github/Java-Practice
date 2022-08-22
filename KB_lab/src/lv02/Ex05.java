package lv02;

import java.util.Arrays;

public class Ex05 {

	public static void main(String[] args) {
		String[][] arr = new String[4][3];
		int num = 1;
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<3 ; j++) {
				if(i%2==0) arr[i][j]=((j<2)?"  "+num++:"   "+num++);
				else arr[i][j]=((j<2)?"  ■":"  ■■■");
			}
			System.out.println();
		}
		int price = 0;
		String[] lotto = new String[7];
		int[] lottoCheck = new int[7];
		int[] ch = {2000,3000,4000,5000,6000};
		String[] mo = {"★","●","■","◆","♥"};
		int[] number = new int[7];
		
		for(int i=1 ; i<7 ; i++) {
			number[i]=(int)(Math.random()*5);
		}
		
		System.out.println(Arrays.toString(number));
		
//		for(int i=1 ; i<7 ; i++) {
//			if(i%3==0) {
//				lotto[i]=ch[(int)(Math.random()*5)];
//			}
//			else {
//				lotto[i]=mo[(int)(Math.random()*5)];
//			}
//			System.out.print(lotto[i]+" ");
//		}
//		굳이 보여줄 이유가없지
//		arr[1][2]=ch[number[3]];
//		lottoCheck[3]=1;
//		for(int i=0 ; i<4 ; i++) {
//			for(int j=0 ; j<3 ; j++) {
//				if(i%2==0) break;
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		
//		for(int i=1 ; i<7 ; i+=3 ){
//			if(number[i]==number[i+1]) {
//				price=ch[number[i+2]];
//			}
//		}
//		System.out.println(price);
	}
}
