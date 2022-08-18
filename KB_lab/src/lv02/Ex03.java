package lv02;

import java.util.Scanner;

public class Ex03 {
	/*
	 * # 영화관 좌석예매 
	 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다. 
	 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다. 
	 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다. 
	 * 4. 한 좌석당 예매 가격은 12000원이다. 
	 * 5. 프로그램 종료 후, 해당
	 * 영화관의 총 매출액을 출력한다. 
	 * 예) seat = 0 0 0 0 0 0 0
	 * 
	 * 좌석선택 : 1 seat = 0 1 0 0 0 0 0
	 * 
	 * 좌석선택 : 3 seat = 0 1 0 1 0 0 0
	 * 
	 * 좌석선택 : 3 seat = 0 1 0 1 0 0 0 이미 예매가 완료된 자리입니다. ---------------------- 매출액 :
	 * 24000원
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] seat = new int[7];
		//변수 선언
		int price = 12000;
		int people = 0;
		int position = 0;
		boolean flag = false;
		
		boolean run = true;
		
		while (run) {
			
			System.out.println("=영화관=");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel==1) {
				//사람수 입력받기.
				System.out.println("예약인원을 입력하세요");
				people = scan.nextInt();
				
				if(people<8&&people>0) {
					//정상범주
					do {
						//초기화
						flag = false;
						System.out.println("좌석을 골라주세요.");
						position = scan.nextInt()-1;
						int tmp = position;
						if(position>=0 && people+position<8) {
							//정상 작동
							//좌석이 있는지 검사
							for(int i=people ; i>0 ; i--) {
								if(seat[tmp++]!=0) {
									flag=true;
								}
							}
							if(flag) System.out.println("해당 자리는 예약할수 없습니다.");
						}
						else { 
							System.out.println("자리를 다시 입력해주세요");
							flag=true;
						}
					}while(flag);
					
					//자리 예매하기
					for(int i=people ; i>0 ; i--) {
						seat[position++]=1;
					}
					
					System.out.println(price * people+"원 입니다");
					System.out.println("예약되었습니다..");
					for(int i=0; i<seat.length ;i++) {
						System.out.print((seat[i]==0)?"□":"■");
					}
					
					System.out.println();
				}else {
					System.out.println("다시 입력해주세요"); 
				}
			}
			else if(sel==2) {
				//종료
				run=false; //break문이 아니라서 마지막까지 다 돈다.
			}
			else {
				System.out.println("다시 입력해주세요");
			}//1,2선택을 안햇을 경우
			

		}
		//필요한 변수
		//좌석 입력받기
		//자리좌표 입력받기
		//돈계산
		
		//좌석 예매
		//총 7자리
		//사람수 , 자리를 고르기
		//1-1.사람수가 좌석보다 적을때
		//1-2.사람수를 0이하로 입력하지 않을때
		
		//2-1.좌표가 0이하 인구수+좌표가 8이상이 아닐때
			
			//위 조건이 이상없을때
			//먼저 좌석을 돌려서 관객유무 찾기
			//관객이 있으면 좌표를 다시찍게하기.
			//사용자가 다시 자리를 고를지
				//사용자가 예매를 종료할지
			//관객이 없으면 자리 예매하기
				//돈 계산하기.
		
		//종료
	}
}