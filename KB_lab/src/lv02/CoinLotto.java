package lv02;

public class CoinLotto {
	
	public static void main(String[] args) {
		
		
		
		
		boolean run = false;
		//복권 구매부터 시작
		//복권 당첨금액
		int winPrice = 0;
		//복권 구매금액
		int payPrice = 0;
		
		if(run) {
			//복권 구매
			//복권 가격배열
			int[] priceArr = {0,0,0,3000,5000};
			//복권 이미지 배열
			String[] imgArr = {"★","★","♠","♣","♥"};
			String[] imgMoney = {"꽝","꽝","꽝","3천원","5천원"};
			//몇장 살건지 물어보기
			if(abc){
				//유효범위 밖
			}
			else {
				//유효범위 안
				int num = 1;
				//복권 만들기
				int[] lotto = new int[/*입력한번호*3+1*/];
				//복권 랜덤으로 초기화하기
				for(int i=1 ; i<lotto.length ; i++) {
					lotto[i]=(int)(Math.random()*5);
				}
				//이미지용 복권
				String[][] imgLotto = new String[/*장수*2*/][3];
				//초기화
				for(int i=0 ; i<이미지.랭스 ; i++) {
					for(int j=0; j<3 ; j++) {
						if(i%2==0) imgLotto[i][j] = " "+num++;
						else {
							imgLotto[i][j]=(j<2)?"  ■" :"  ■■■■";
						}
					}
				}
				if(긁겟다) {
					while(멈출때까지) {
						//이미지 보여주기
						for(int i=0 ; i<이미지.랭스 ; i++) {
							System.out.println(이미지[i]);
						}
						//번호고르기
						//번호 예외처리
						//번호 유효범위
						//고른번호 교체
						if(고른번호%3==0) {
							//금액쪽 고를경우
							//고른번호/3
							String[/*고른번호-1/3*/][2]=imgMoney[lotto[/*고른번호*/]];
						}else {
							//이미지쪽 고를경우
							String[/*고른번호-1/3*/][/*고른번호%3*/]=imgArr[lotto[/*고른번호*/]];
						}
						//
						//정산한다고하면 while문 나가기
					}
					/*정산한다*/
				}
				else {
					//안긁겟다
				}
			}
			
			
		}
		else {
			//복권 미구매
		}
			
	}
}
