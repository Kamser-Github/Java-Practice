package lv02;

import java.util.Scanner;

public class ExTicTak {

	/*
	 * # 틱택토 
	 * === 틱택토 === 
	 * [X][X][O] 
	 * [ ][O][ ] 
	 * [ ][ ][ ] 
	 * [p1]
	 * 인덱스 입력 : 6 
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
		int p1Cnt = 0;
		int p2Cnt = 0;
		int setGame = 0;
		// 배열
		while (true) {
			// 배열 표시
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (game[i * 3 + j] == 0) {
						System.out.printf("[%2d]", i * 3 + j + 1);
					} else {
						System.out.print((game[i * 3 + j] == 1) ? "[ O]" : "[ X]");
					}
				}
				System.out.println();
			}

			// 9칸 다쓰고 게임이 안끝났을경우
			for (int i = 0; i < 9; i++) {
				if (game[i] != 0) {
					setGame++;
				}
			}
			// 결산하기.
			if (p1Cnt > 0) {
				System.out.println("\tp1이 이겼습니다.");
				break;
			} else if (p2Cnt > 0) {
				System.out.println("\tp2가 이겼습니다.");
				break;
			} else if (setGame == 9) {
				System.out.println("새 게임을 시작해주세요 승자가 없습니다.");
				break;
			}
			
			setGame=0;
			
			System.out.println("빙고 번호를 입력해주세요.1~9");
			String turnAlert = (turn % 2 == 1) ? "\tP1" : "\tP2";
			System.out.println(turnAlert + "차례입니다.");
			int num = sc.nextInt() - 1;
			// 예외처리
			if (num < 0 || num > 8) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} else if (game[num] != 0) {
				System.out.println("이미 마크가 찍혀있습니다.");
				continue;
			} else {
				game[num] = (turn % 2 == 1) ? 1 : 2;
			}

			for (int i = 0; i < 3; i++) {
				int cntgaro = 0;
				for (int j = 0; j < 3; j++) {
					// 가로
					if (game[i * 3 + j] == 1) {
						cntgaro++;
					} else if (game[i * 3 + j] == 2) {
						cntgaro--;
					}
				}
				if (cntgaro == 3)
					p1Cnt++;
				else if (cntgaro == -3)
					p2Cnt++;
			}
			for (int i = 0; i < 3; i++) {
				int cntsero = 0;
				for (int j = 0; j < 3; j++) {
					// 세로
					if (game[j * 3 + i] == 1) {
						cntsero++;
					} else if (game[j * 3 + i] == 1) {
						cntsero--;
					}
				}
				if (cntsero == 3)
					p1Cnt++;
				else if (cntsero == -3)
					p2Cnt++;

			}
			// 대각선
			int cntdea = 0;

			for (int i = 0; i < 3; i++) {
				if (game[i * 4] == 1) {
					cntdea++;
				} else if (game[i * 4] == 2) {
					cntdea--;
				}
			}
			if (cntdea == 3)
				p1Cnt++;
			else if (cntdea == -3)
				p2Cnt++;

			cntdea = 0;
			for (int i = 0; i < 3; i++) {
				// 대각선 반대편
				if (game[i * 2 + 2] == 1) {
					cntdea++;
				} else if (game[i * 2 + 2] == 2) {
					cntdea--;
				}
			}
			if (cntdea == 3)
				p1Cnt++;
			else if (cntdea == -3)
				p2Cnt++;

			turn++;
		}

		// 가로빙고 012 - , 345- ,678 빙고 +1
		// 대각선 빙고는 048 - , 246- +4 +2
		// 세로빙고는 036 -,147 - ,258- +3

		// 시작이 036 048 012
		// 시작이 147
		// 시작이 258 246
		// 시작이 345
		// 시작이 678
	}
}