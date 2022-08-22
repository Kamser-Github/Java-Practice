package lv02;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Ex05Test {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int winPrice = 0;
		int payPrice = 0;
		int[] priceArr = {0,0,0,3000,5000};
		String[] imgMoney = {"  꽝  ","  꽝  ","  꽝  ","  3천원","  5천원"};
		String[] imgIcon = {"  ▩","  ★","  ♠","  ♣","  ♥"};
		
		while(run) {
			System.out.println("어서오세요 ez편의점입니다.");
			System.out.println("1) 복권구매");
			System.out.println("그외) 종료");
			int choice = sc.nextInt();
			if(choice==1) {
				//복권구매 선택
				System.out.println("몇장을 구매하시겠습니까?");
				choice = sc.nextInt();
				if(0<choice && choice<6) {
					//유효범위내 구매
					//번호매기는 변수
					int num = 1;
					//복권 크기 만들기
					int[] lottoCoin = new int[choice*3+1];
					//복권 랜덤으로 만들기
					for(int i=1 ; i<lottoCoin.length ; i++) {
						lottoCoin[i]=(int)(Math.random()*5);
					}
					//이미지용 복권만들고 초기화하기
					String[][] imgCoin = new String[choice*2][3];
					//초기화
					for(int i=0 ; i<imgCoin.length ; i++) {
						for(int j=0 ; j<3 ; j++) {
							if(i%2==0)
								imgCoin[i][j]=(j<2)? "  "+(num++):"    "+(num++)+" ";
							else
								imgCoin[i][j]=(j<2)?"  ■" :"  ■■■■";
						}
					}//복권 이미지 초기화
					boolean scratch = true;
					while(scratch) {
						//긁음
						//복권 이미지 보여주기
						for(int i=0 ; i<imgCoin.length ; i++) {
							System.out.println(Arrays.toString(imgCoin[i]));
						}
						System.out.println("몇번을 긁으시겠습니까?");
						int scratchNum = sc.nextInt();
						if(0<scratchNum && scratchNum<lottoCoin.length) {
							//유효범위.
							if(scratchNum%3==0) {
								//금액쪽 긁을때
								imgCoin[(scratchNum-1)/3][2]=imgMoney[lottoCoin[scratchNum]];
							}
							else {
								//이미지쪽 긁을때
								imgCoin[(scratchNum-1)/3][scratchNum%3-1]=imgIcon[lottoCoin[scratchNum]];
							}
							//다 긁었을때는 바로 정산으로 넘어가야하는데
						}
						else {
							System.out.println("해당번호는 긁으실수없습니다.");
						}
					}
				}
				else {
					//유효범위 밖
					System.out.println("최대 5장까지만 구입 가능하십니다.");
				}
				
				
			}
			else {
				run=false;
				System.out.println("방문해주셔서 감사합니다.");
			}
		}
		
		
		sc.close();
	}
}
