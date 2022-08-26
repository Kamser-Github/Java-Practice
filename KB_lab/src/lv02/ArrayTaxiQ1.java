package lv02;

import java.util.Scanner;
public class ArrayTaxiQ1 {
	/*
	 * # 카카오 택시
	 * 1. 손님을 태워 목적지까지 이동하는 게임이다.
	 * 2. -10~10 사이의 랜덤 숫자 2개를 저장해 목적지로 설정한다.
	 * 3. 메뉴는 아래와 같다.
	 * 		1) 속도설정 : 1~3까지만 가능
	 * 		2) 방향설정 : 동(1)서(2)남(3)북(4)
	 * 		3) 이동하기 : 설정된 방향으로 설정된 속도만큼 이동
	 * 4. 거리 1칸 당 50원씩 추가되어 도착시 요금도 출력한다.
	 *
	 */
	
	public static void main(String[] args) {
		/*
		 * 1.랜덤숫자 2개를 저장 (-10~10)
		 * 1)속도 설정 1 ~ 3만 가능
		 * 2)방향 1 동 2 서 3 남 4 북
		 * 3)이동 ) 설정된 속도만큼이동
		 * 4)기준점은 0.0
		 * 5)거리당 50원.
		 */
/*
		int a = -10~10
		int a2 = -10~10
		
		//내 좌표
		int my1 = 0;
		int my2 = 0;
		
		//속도설정
		 속도변수
		 int speed = 0;
		
		//방향변수 1 ~ 4
		 int dir = 0;
		
		//비용
		 int price = 0;
		 int extraCharge = 50;
		 
		 도착할때까지 무한 반복해야하기때문에
		 for x while o
		 굳이 한번이라도 돌려야하는게 아니기때문에 do while x
		 
		 while true;
		 
		 1.인포 보여주기
		 =============
		 목표 : 0 . 0
		 현재 : 0 . 0
		 방향 : 0
		 속도 : 0
		 비용 : 0
		 =============
		 	ㄴ 1입력하면 나가기
		 	ㄴ 아니면 그대로 유지
		 
		 2.뱡향 속도 설정하기
		 	1.방향설정
		 	ㄴ 1~4입력
		 		ㄴ방향설정 알람
		 		ㄴ방향 설정
		 	ㄴ 예외처리
		 	2.속도설정
		 	ㄴ 1~3입력
		 		
		 		ㄴ 속도 설정
		 	ㄴ 예외처리
		 	3.취소하기
		 3.이동하기
		 4.내리기
 */
		Scanner sc =new Scanner(System.in);
		//목적지
		int desX = (int)(Math.random()*21)-10;
		int desY = (int)(Math.random()*21)-10;
		
		//내 좌표
		int x = 0;
		int y = 0;
		
		//속도
		int speed = 0;
		
		//방향
		int dir = 0;
		
		//비용
		int price = 0;
		int extra = 50;
		
		boolean run = true;
		while(run) {
			System.out.println("1)정보 보기");
			System.out.println("2)방향 속도 설정");
			System.out.println("3)이동하기");
			System.out.println("4)내리기");
			System.out.println("===========");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				System.out.println("===============");
				System.out.printf("[목표 : %3d,%3d]\n",desX,desY);
				System.out.printf("[현재 : %3d,%3d]\n",x,y);
				System.out.printf("[방향 : %3d    ]\n",dir);
				System.out.printf("[속도 : %3d    ]\n",speed);
				System.out.printf("[비용 : %4d ]\n",price);
				System.out.println("===============");
			}
			else if(sel == 2) {
				System.out.println("1)속도 설정");
				System.out.println("2)방향 설정");
				int choice = sc.nextInt();
				if(choice==1) {
					System.out.println("속도 1 ~ 3 :");
					int sp = sc.nextInt();
					if(sp<1 || 3< sp) {
						System.out.println("번호를 확인해주세요");
					}
					else {
						speed = sp;
					}
				}
				else if(choice==2) {
					System.out.println("방향 설정 1 ~ 4");
					System.out.println("1) 동 2) 서 3) 남 4) 북");
					int di = sc.nextInt();
					if(di<1 || di>4) {
						System.out.println("번호를 확인해주세요.");
					}
					else {
						dir = di;
					}
				}
				else {
					System.out.println("잘못된 입력입니다.");
				}
			}
			else if(sel == 3) {
				if(dir==0&&speed==0) {
					System.out.println("속도와 뱡향중 정해주세요.");
				}
				else {
					if(dir == 1) {
						x+=speed;
					}else if(dir == 2){
						x-=speed;
					}else if(dir == 3) {
						y-=speed;
					}else {//dir = 4
						y+=speed;
					}
					price += speed*extra;
				}
				
			}
			else if(sel == 4) {
				System.out.println("종료합니다.");
				run = false;
			}
			else {
				System.out.println("잘못된 입력입니다");
			}
			
			if(x==desX && y==desY){
				System.out.println("도착입니다.");
				run = false;
			}
		}
	}
}
