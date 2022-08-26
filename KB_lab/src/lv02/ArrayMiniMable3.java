package lv02;

import java.util.Scanner;

public class ArrayMiniMable3 {
	/*
	 * # 미니마블
	 * 1. 플레이어는 p1과 p2 2명이다.
	 * 2. 번갈아가며 1~3 사이의 숫자를 입력해 이동한다.
	 * 3. 이동하다가 다음 플레이어와 같은 위치에 놓이게 되면,
	 *    상대 플레이어는 잡히게 되어 원점으로 되돌아간다.
	 * 4. 먼저 3바퀴를 돌면 이긴다.
	 *    
	 *  [p2]1~3 입력 : 1
	 *  1 2 3 4 5 6 7 8 
	 *  0 1 0 0 0 0 0 0 
	 *  0 0 0 2 0 0 0 0 
	 *  
	 *  [p1]1~3 입력 : 2
	 *  [p1]이 p2를 잡았다!
	 *  1 2 3 4 5 6 7 8 
	 *  0 0 0 1 0 0 0 0 
	 *  2 0 0 0 0 0 0 0 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] game = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] p1   = {0, 0, 0, 0, 0, 0, 0, 0};
		int[] p2   = {0, 0, 0, 0, 0, 0, 0, 0};
		int turn = 0;
		int idx1 = 0;	int idx2 = 0;
		p1[idx1] = 1;	p2[idx2] = 2;
		int win = 0;
		int[] cnt = new int[2];
		
		/*
		 *포인트.
		 *자리를 이동한걸 표현하려면.
		 *현재위치 좌표값 = 0;
		 *인덱스값 변경;
		 *변경한 인덱스좌표값 = 대입;
		 */
		
		/*
		 *1.자리 출력
		 *3번다돌경우 우승자 출력후 종료
		 *초기화 현재위치 좌표값 전부 0;
		 *2.숫자 입력받기
		 *-자리와 숫자 합치기
		 *	ㄴ인덱스를 넘어갈때
		 *		0부터 시작.
		 *		1바퀴 감소
		 *		3바퀴 다돌경우 값 변경
		 *인덱스값 변경
		 *
		 *
		 *변경한 인덱스 좌표값 1,2대입
		 */
		
		while(true) {
			//좌표 출력
			for(int i=0; i<game.length ; i++) {
				if(p1[i]==1&&p2[i]==2) {
					System.out.print("ox_ ");
				}
				else if(p1[i]==1) {
					System.out.print("O_ ");
				}
				else if(p2[i]==2) {
					System.out.print("X_ ");
				}
				else {
					System.out.print("_ ");
				}
			}
			System.out.println();
			//게임 종료
			if(win!=0) {
				System.out.printf("p%d님이 승리하셨습니다\n",win);
				break;
			}
			
			//숫자 입력받기
			System.out.println("점프할 숫자를 입력해주세요 1~ 3");
			int jump = sc.nextInt();
			
			if(jump<1 || jump>3) {
				System.out.println("1~3만 가능");
				continue;
			}
			
			//초기화 및 변수선언
			p1[idx1]=0;
			p2[idx2]=0;
			
			//p1,p2인덱스를 번갈아 받을 변수
			int xx = 0;
			xx = turn==1 ? idx1 : idx2 ;
			
			//인덱스에 점프할 인덱스 대입
			xx+=jump;
			
			//한바퀴를 돌면
			if(xx>game.length-1) {
				xx-=game.length;
				cnt[turn-1]++;
				if(cnt[turn-1]==3) {
					win = turn;
				}
			}
			
			//점프를 했는데 거기에 상대방이 있으면
			if(xx==idx1) {
				idx1=0;
			}
			else if(xx==idx2) {
				idx2=0;
			}
			
			//변경한 인덱스 값 대입
			if(turn==1) {
				idx1=xx;
			}
			else {
				idx2=xx;
			}
			
			//변경된 인덱스로 다시 초기화
			p1[idx1]=1;
			p2[idx2]=2;
			
			//턴 변경
			turn = turn==1 ? 2:1;
		}
	}
}
