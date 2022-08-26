package lv02;

import java.util.Scanner;

public class ArrayTicTacTokQ1 {

		/* 
		 * # 틱택토
		 * === 틱택토 ===
		 * [X][X][O]
		 * [ ][O][ ]
		 * [ ][ ][ ]
		 * [p1]인덱스 입력 : 6
		 * === 틱택토 ===
		 * [X][X][O]
		 * [ ][O][ ]
		 * [O][ ][ ]
		 * [p1]승리
		 * 
		 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] game = new int[9];
		int turn = 1;
		int win = 0;
		int cnt = 0;
	/*	
	 * 1.해당번호가 비어있을때 O or X;
	 * 2.값이 있으면 입력불가
	 * 3.가로 세로 대각선 좌우 일치하면 빙고
	 * 공통배열 9칸.
	 * 
	 *	1.화면 출력
	 *		배열에 1이 있으면 O;
	 *		배열에 2가 있으면 X;
	 *		배열에 0이 있으면'  ';
	 *	2.차례 입력
	 *	3.1~9사이 입력해주세요
	 *		ㄴ 값 O
	 *			다시 골라주세요.
	 *			continue;
	 *		ㄴ 값 X
	 *			턴값 대입
	 *	4.빙고 확인하기
	 *		가로 012 345 678
	 *		세로 036 147 258
	 *		대각선 048 246
	 *	5.턴 변경
	 * 
	 */
		while(true) {
			//화면 출력
			for(int i=0 ; i<9 ; i++) {
				if(i%3==0) {
					System.out.print("\t   ");
				}
				if(game[i]==0) {
					System.out.printf("[%d]",i+1);
				}
				else {
					System.out.print((game[i]==1?"[O]":"[X]"));
				}
				if(i%3==2) {
					System.out.println();
				}
			}
			if(win!=0) {
				System.out.printf("p%d님의 승리",win);
				break;
			}
			//차례 입력받기
			System.out.printf("\t[p%d님 차례 입니다]\n",turn);
			System.out.println("해당 번호를 입력해주세요.");
			int idx = sc.nextInt()-1;
			
			//예외처리
			if(idx<0 || idx>8) {
				System.out.println("잘못된 입력");
				continue;
			}
			
			if(game[idx]==0) {
				game[idx]=turn;
			}
			else {
				System.out.println("다른곳을 골라주세요");
				continue;
			}
			
			//빙고
			//가로
			cnt=0;
			for(int i=0 ; i<game.length ; i++) {
				if(game[i]==1) {
					cnt++;
				}
				else if(game[i]==2) {
					cnt--;
				}
				if(Math.abs(cnt)==3) {
					System.out.println("가로 빙고");
					win = turn;
				}
				if(i%3==2) cnt=0;
			}
			
			//세로 036 147 258
			int[] cnts = new int[3];
			for(int i=0 ; i<game.length ; i++) {
				if(i%3==0) {
					if(game[i]==1) {
						cnts[0]++;
					}
					else if(game[i]==2) {
						cnts[0]--;
					}
				}
				else if(i%3==1) {
					if(game[i]==1) {
						cnts[1]++;
					}
					else if(game[i]==2) {
						cnts[1]--;
					}
				}
				else {
					if(game[i]==1) {
						cnts[2]++;
					}
					else if(game[i]==2) {
						cnts[2]--;
					}
				}
			}
			for(int i=0 ; i<cnts.length ; i++) {
				if(Math.abs(cnts[i])==3) {
					System.out.println("세로 빙고");
					win = turn;
				}
			}
			cnt=0;
			//대각선 048 
			for(int i=0; i<game.length ; i+=4) {
				if(game[i]==1) {
					cnt++;
				}
				else if(game[i]==2){
					cnt--;
				}
			}
			if(Math.abs(cnt)==3) {
				System.out.println("1-대각선 빙고");
				win = turn;
			}
			cnt=0;
			//대각선 246 
			for(int i=1 ; i<=6 ;i+=2) {
				if(game[i+1]==1) {
					cnt++;
				}
				else if(game[i+1]==2) {
					cnt--;
				}
			}
			if(Math.abs(cnt)==3) {
				System.out.println("3-대각선 빙고");
				win = turn;
			}

			turn = turn==1 ? 2 : 1;
		}
	}
}
