package lv02;
import java.util.Scanner;
import java.util.Arrays;
public class ArrayMiniMable {
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
		int[] game = {0, 0, 0, 1, 0, 2, 0, 0};
		int[] p1   = {1, 0, 0, 0, 0, 0, 0, 0};
		int[] p2   = {1, 0, 0, 0, 0, 0, 0, 0};
		int[] cnt  = new int[2];
		int count = 0;
		int turn = 1;
		int idx1 = 0;	int idx2 = 0;
		p1[idx1] = 1;	p2[idx2] = 2;
		/*
		 * p1,p2 차례대로 번갈아가면서 번호를 입력한다
		 * 1~3만가능
		 * 그외 예외처리
		 * p1이 먼저 시작한다.
		 * 자리를 이동한다
		 * 이동할때 배열 밖으로 벗어나면 처음으로 돌아온다.
		 * 자리를 보여준다.
		 * p2가 시작한다
		 * 자리가 겹치면
		 * 상대방의 위치는 0으로 이동한다.
		 * 처음 자리는 0으로 대기실에서 있는다
		 * 서로의 위치를 모른다.
		 */
		//내 위치 공개
		
		/*
		 *내 차례일때만 내가보인다.
		 */
		while(true) {
			int tmpIdx = 0;
			int[] tmpArr = new int[0];
			//초기화
			System.out.println(Arrays.toString(cnt));
			System.out.println(Arrays.toString(p1));
			System.out.println(Arrays.toString(p2));
			//화면에 내꺼만 출력
			System.out.printf("\t[P%d님 차례입니다.]\n",turn);
			if(turn==1) {
				//p1차례
				tmpArr = p1;
				tmpIdx = idx1;
			}
			else if(turn==2){
				//p2차례
				tmpArr = p2;
				tmpIdx = idx2;
			}
			
			for(int i=0 ; i<tmpArr.length ; i++) {
				if(tmpArr[i]==turn) {
					System.out.print("옷 ");
				}
				else {
					System.out.print("_ ");
				}
			}
			System.out.printf("\n\t[p%d님 자리 화면]\n",turn);
			
			System.out.println("몇칸 이동하시겠습니까?(1~3 칸이동)");
			int jump = sc.nextInt();
			
			//예외처리
			if(jump>3||jump<1) {
				System.out.println("잘못입력");
				continue;
			}
			//자기자리 초기화
			tmpArr[tmpIdx]=0;
			
			//자리 점프하기
			tmpIdx+=jump;
			
			//예외발생
			if(tmpIdx>tmpArr.length-1) {
				tmpIdx-=tmpArr.length;
				cnt[turn-1]++;
			}
			tmpArr[tmpIdx]=turn;
			
			if(cnt[turn-1]==3) {
				System.out.printf("P%d님이 승리하셨습니다.",turn);
				break;
			}
			
			//자리가같을때 상대편 말잡기
			if(turn==1) {
				if(tmpIdx==idx2) {
					p2[idx2]=0;
					idx2=0;
					p2[idx2]=2;
					System.out.println("p2을 잡았습니다.");
				}
				idx1=tmpIdx;
			}
			else {
				if(tmpIdx==idx1) {
					p1[idx1]=0;
					idx1=0;
					p1[idx1]=1;
					System.out.println("p1을 잡았습니다.");
				}
				idx2=tmpIdx;
			}
			//상대말 다시 초기화 및
			//자리값 변경
			turn = turn==1 ? 2 : 1 ;
		}//while end
	}
}
