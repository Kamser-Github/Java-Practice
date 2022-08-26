package lv02;

import java.util.Scanner;

public class ArrayMiniMable2 {
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
		turn = 랜덤 1 ~ 2
	 */
	public static void main(String[] args) {
/*
	  //위치 프린트
	  //남은 바퀴수 제공
	   
	  //바퀴를 다 돌았을경우.
	  	ㄴ종료
	  //바퀴를 다돌지 않을경우
	    ㄴ누구 차례인지 프린트
	  	
	  //변수 하나로 나누어쓰기
	  if(turn==1) 자기 변수값 불러오기
	  else(turn==2) 자기 변수값 불러오기
	  //점프할 번호를 입력해주세요.
	  jump = 스캔
	  
	  점프를 하려면.
	  현재 내 위치가 0;
	  점프 입력후 위치가 1or 2;
	  
	  1.점프 숫자 입력받기
	    ㄴ유효범위가 아닌경우
	  2.캐릭터 점프
	  	ㄴ인텍스를 넘을경우
	  		ㄴ바퀴수 추가
	  		ㄴ3턴 정보를 남기기.
	  		   :좌표를 찍고 종료하는게 맞는데
	  		   :3턴을 남기고 종료하는걸 따로 만들 이유가 없다.
	  	ㄴ인덱스를 안넘을경우
	  --------------------------
	  현재 이건 다 인덱스만 변경.
	  //현재좌표도 그대로
	  //현재 좌표값도 그대로
	  
	  3.캐릭터가 겹칠경우
	  turn으로 2번
	  	ㄴ 상대방 현재 좌표값 0
	  	ㄴ 상대방 현재 좌표 0
	  	ㄴ 상대방 좌표에 1
	  turn으로 1번
	  	ㄴ 상대방 현재 좌표값 0
	  	ㄴ 상대방 현재 좌표 0
	  	ㄴ 상대방 좌표에 2
	  //같을 경우에만 상대방 좌표 초기화.
	  //방법은
	   * 변수에는 턴 캐릭의 좌표가 들어있지만.
	   * 상대방 좌표는 알수가 없어서 확인해야한다.
	   * 확인하는 방법은 if(turn=?)
	   * 
	   캐릭터 이동방법.
	   내캐릭
		   좌표값 = 0; //변수로 해결 불가
		   좌표인덱스+=점프인덱스 //변수로 해결
		   좌표값 = turn; //변수값 대입
	   
	   상대방 위치가 같으면.
	   상대방
		   좌표값 = 0;
		   좌표인덱스 = 0;
		   좌표값 = 반대로.
	  	
	  	겹치는것 좌표값 0 ; 좌표값 초기화 ;
	  	만약에 변수하나로 통일하면.다시 대입을 해야한다.
	  	대입할때도 turn으로 확인후 대입해야한다.
	  	겹칠때 상대방 좌표 인덱스를 0;
	  	
	  	turn==1
	  		xx = 1의 좌표
	  	turn==2
	  		xx = 2의 좌표
	  	//어차피 xx는 이미 이동했기때문에 자기 자신과 같을수 없다.
	  	if(xx == idx1){
	  		idx1=0;
	  	}
	  	else if( idx2 == xx){
	  		idx2=0;
	  	}
	  	
	  	//마무리 대입
	  	turn==1
	  		1의 좌표 == xx
	  		
	  	
	  5.턴 변경
 */
		Scanner sc = new Scanner(System.in);
		int[] game = {1,2,3,4,5,6,7,8};
		int[] p1 = {1,0,0,0,0,0,0,0};
		int[] p2 = {2,0,0,0,0,0,0,0};
		
		int idx1 = 0;	int idx2 = 0; int turn = 1;
		int[] cnt = new int[2];
		int win = 0;
		while(true) {
			//위치 프린트
			//좌표 프린트
			for(int i=0 ; i<game.length ; i++) {
				if(p1[i]==1) {
					System.out.print("O ");
				}
				else {
					System.out.print("_ ");
				}
			}
			System.out.println();
			
			for(int i=0 ; i<game.length ; i++) {
				if(p2[i]==2) {
					System.out.print("X ");
				}
				else {
					System.out.print("_ ");
				}
			}
			System.out.println();
			//승리
			if(win!=0) {
				System.out.printf("p%d님이 이겼습니다.",win);
				break;
			}
			//남은 바퀴수
			System.out.printf("p1은 %d바퀴 남았습니다.\np2는 %d바퀴 남았습니다.\n",3-cnt[0],3-cnt[1]);
			//차례 입력
			System.out.printf("\tp%d님 차례입니다.\n",turn);
			
			System.out.print("점프하실 숫자를 입력해주세요 1 ~ 3 : ");
			int jump = sc.nextInt();
			
			//예외 처리
			if(jump<1 || jump>3) {
				System.out.println("잘못된 입력");
				continue;
			}
			
			int xx = 0;
			
			//내 좌표값 초기화
			if(turn == 1) 	{ xx = idx1; p1[idx1]=0; }
			else 			{ xx = idx2; p2[idx2]=0; }
			
			
			//점프 더하기
			xx+=jump;
			
			//경우의수
			if(xx>game.length-1) {
				xx-=game.length;
				cnt[turn-1]++;
				if(cnt[turn-1]==3) {
					win=turn;
				}
			}
			
			//캐릭터가 겹칠경우 상대방 좌표 0 좌표값도 0;
			if(xx == idx1) {
				p1[idx1]=0;
				idx1=0;
				p1[idx1]=1;
			}
			else if(xx == idx2) {
				p2[idx2]=0;
				idx2=0;
				p2[idx2]=2;
			}
			
			//이동한 좌표값 대입하기.
			if(turn==1) {
				idx1=xx;
				p1[idx1]=1;
			}
			else {
				idx2=xx;
				p2[idx2]=2;
			}
			
			//turn 변경
			turn = turn==1 ? 2:1;
		}
	}
}
