package lv05;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class ArrayMemoryQ1 {
	/*
	 * # 기억력 게임
	 * 1. 같은 숫자의 위치를 2개 입력해 정답을 맞추는 게임이다.
	 * 2. 정답을 맞추면 back에 해당 숫자를 저장해,
	 *    back에 모든 수가 채워지면 게임은 종료된다.
	 * 예)
	 * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
	 * back  = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	 * 입력1 : 0
	 * 입력2 : 1
	 * 
	 * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
	 * back  = [1, 1, 0, 0, 0, 0, 0, 0, 0, 0]
	 */

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}; // 셔플 처리 후 게임 진행 : 카드 섞기
		int[] back = new int[10];
		int randomNumber = 0;
		int tmp = 0;
		/*
		 * 조건
		 * 두 숫자 1~10사이 입력
		 * 두 숫자 중복 x
		 * back에 값이 있으면 안됨.
		 * 
		 * front[두숫자]값이 동일
		 * back 해당 인덱스값 저장
		 * back에 0이 없으면 종료
		 * 
		 * 
		 * 첫번째 숫자를 입력해주세요
		 * num = sc.nextInt()
		 * num 숫자 예외처리
		 * 또 back에 값이 없으면.
		 * num 저장.
		 * 해당 front값 보여주기
		 * 
		 * 두번째 숫자를 입력해주세요
		 * num = sc.nextInt()
		 * num 숫자 예외처리
		 * 또 back에 없으면 .
		 * 또 첫번째 숫자와 중복이 아니면
		 * num에 저장
		 * 해당 front값 보여주기.
		 * 
		 * if(num == num2){
		 * back[num],back[num2]=back[num]
		 * cnt--;
		 */
		
		int firstNum = -1;
		int cnt = front.length/2;
		
		//패 섞기
		for(int i=0 ; i<1000 ; i++) {
			randomNumber = ran.nextInt(10);
			tmp = front[0];
			front[0]=front[randomNumber];
			front[randomNumber]=tmp;
		}
		
		while(true) {
			
			System.out.println(Arrays.toString(front));
			System.out.println(Arrays.toString(back));
			
			//게임종료
			if(cnt==0) {
				System.out.println("게임 종료");
				break;
			}
			int num = 0;
			//숫자 입력
			if(firstNum==-1) {
				System.out.println("첫번째 숫자를 입력해주세요 [1~10]");
				num = sc.nextInt();
			}
			if(firstNum!=-1) {
				System.out.println("두번째 숫자를 입력해주세요 [1~10]");
				num = sc.nextInt();
			}
			//인덱스 처리
			num--;
			//예외처리
			if(num<0 || num>9) {
				System.out.println("숫자를 잘못 입력하셨습니다.");
			} else if(back[num]!=0) {
				System.out.println("이미 뒤집은 카드 입니다.");
			} else if(firstNum==num) {
				System.out.println("첫번째 숫자와 중복입니다.");
			} else {
				//확인해보기
				System.out.println("front : "+front[num]);
				
			}
			//첫번째만 값 대입.
			if(firstNum==-1) {
				firstNum=num;
				num=0;
			}
			
			if(num!=0&&(num<0||num>9)) {
				if(front[firstNum]==front[num]) {
					System.out.println("\t성공");
					//back배열에 숫자채우기
					back[firstNum]=front[firstNum];
					back[num]=front[num];
					//숫자 차감
					cnt--;
					
				}
				firstNum=-1;
			}
			/*
			 * 최대한 이중포문을 안쓰려고 했는데
			 * 하다보니까 다른 사람이 본다면 주석없이는 모르는 코드가 되버렸다.
			 * 
			 */
		}//while end
	}
}
