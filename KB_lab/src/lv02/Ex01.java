package lv02;
import java.util.Scanner;
public class Ex01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 목적지(destination)
		// -10~10까지 랜덤숫자
		int desX = (int)(Math.random()*10+1)*(int)(Math.round(Math.random())==1?-1:1);
		int desY = (int)(Math.random()*10+1)*(int)(Math.round(Math.random())==1?-1:1);

		// 현재 위치
		int x = 0;
		int y = 0;

		// 방향(direction)
		int dir = 0;
		
		//방향표
		String dirs = "0동서남북";

		// 속도
		int speed = 0;

		// 요금
		int fee = 0;

		boolean run = true;
		while (run) {

			System.out.println("= 카카오 택시 =");
			System.out.println("목적지 : " + desX + "," + desY);
			System.out.println("현위치 : " + x + "," + y);
			System.out.println("방   향 : " + dirs.charAt(dir));
			System.out.println("속   도 : " + speed);
			System.out.println("============");

			System.out.println("1.방향설정");
			System.out.println("2.속도설정");
			System.out.println("3.이동하기");
			System.out.print("메뉴 선택 : ");
			
			int sel = sc.nextInt();
			//방향과 속도를 안정하고 누를 경우
			if(sel==3&&dir==0&&speed==0) {
				System.out.println("제자리입니다.방향과 속도를 정해주세요");
				threadSleep(1);
				continue;
			}
			//범위를 벗어날 경우
			if (sel<0 || sel>3) {
				System.out.println("잘못된 입력입니다 1~3사이의 숫자를 입력해주세요");
				threadSleep(1);
				continue;
			}
			
			if (sel == 1) {
				
				//방향설정
				System.out.println("1)동 2)서 3)남 4)북");
				dir = sc.nextInt();
				
				//예외
				if(dir>4||dir<1) {
					dir = 0;
					System.out.println("해당하는 방향이 없습니다. 다시 입력해주세요");
					threadSleep(1);
					continue;
				}
				
				System.out.println(dirs.charAt(dir)+"쪽으로 출발합니다.");
				threadSleep(1);
				
			} else if (sel == 2) {
				//속도설정
				System.out.println("1~3 속도를 골라주세요");
				speed = sc.nextInt();
				
				//예외
				if(speed>3||speed<1) {
					speed = 0;
					System.out.println("속도위반입니다 다시 입력해주세요");
					threadSleep(1);
					continue;
				}
				
				System.out.println("속도 : "+speed+" 으로 달려갑니다");
				threadSleep(1);
				
				
				//방향이동
			} else if (sel == 3) {
				
				//예외
				if(dir==0) {
					System.out.println("방향을 정해주세요. 이동할수 없습니다.");
					threadSleep(1);
					continue;
				}
				
				//이동하기
				if(dir == 1) x+=speed;//동
				else if(dir == 2) x-=speed;//서
				else if(dir == 3) y-=speed; //남
				else if(dir == 4) y+=speed; //북
				fee+=speed;
			}
			//목적지 도착
			if(x==desX && y==desY) run = false;
		}//while end
		System.out.println("요금은 : "+fee*50);
		sc.close();
	}
	
	static void threadSleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {}
	}
}
