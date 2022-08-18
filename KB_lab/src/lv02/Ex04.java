package lv02;

import java.util.Scanner;

public class Ex04 {
	
	public static void main(String[] args) {
//		System.out.println("1.로그인");
//		System.out.println("2.로그아웃");
//		System.out.println("3.입금");
//		System.out.println("4.출금");
//		System.out.println("5.이체");
//		System.out.println("6.조회");
//		System.out.println("0.종료");
		
		//저거만 보고 while문으로 만들어보기
		/*
		 * # ATM[종합]
		 * 1. 로그인
		 * . 로그인 후 재 로그인 불가
		 * . 로그아웃 상태에서만 이용 가능
		 * 2. 로그아웃
		 * . 로그인 후 이용가능
		 * 3. 입금
		 * . 로그인 후 이용가능
		 * 4. 출금
		 * . 로그인 후 이용가능
		 * 5. 이체
		 * . 로그인 후 이용가능
		 * 6. 조회
		 * . 로그인 후 이용가능
		 * 7. 종료
		 */
		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int dbMoney1 = 50000;
		
		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		int dbMoney2 = 70000;	
		
		int log = -1;						// -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)
		
		
		//1.로그인후 재 로그인 불가
		//1.로그아웃 상태에서만 로그인 가능
		
		//2~6번 로그인후 가능
		//7번 종료
		//먼저 예외,경우의수,내용물 채우기 순
		/*
		 * 1.선택지 고를때 0이하 ~8이상 아웃
		 * 2.로그인후 2~6보이게 하기.
		 * 
		 * 3.입금시 돈 <0 불가
		 * 3.출금,이체시 돈<0 불가 가진돈<이체돈 불가
		 * 
		 * 
		 * 3.종료하기
		 */
		
		//1.선택지 1,2번
		//1번 고르면 2,3,4,5,6,7번 보이기
		//1번 고르고 2번고르면 반복문 나가기.
		//
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			//은행 어플
			System.out.println("1.로그인");
			System.out.println("2.종료");
			int choice = sc.nextInt();
			boolean flag2 = false;
			if(choice==1) {
				System.out.println("아이디를 입력해주세요");
				int id = sc.nextInt();
				System.out.println("비밀번호를 입력해주세요");
				int pw = sc.nextInt();
				if(id==dbAcc1&&pw==dbPw1) {
					log=1;
					flag2=true;
					System.out.println(log+"님이 로그인이 성공했습니다.");
				}
				else if(id==dbAcc2&&pw==dbPw2) {
					log=2;
					flag2=true;
					System.out.println(log+"님이 로그인이 성공했습니다.");
				}
				else {
					//로그인 실패시
					System.out.println("로그인에 실패했습니다.");
				}
				sleep();
				//로그인 후 화면 등장
				while(flag2) {
						
					System.out.println("1.로그아웃");
					System.out.println("2.입금");
					System.out.println("3.출금");
					System.out.println("4.이체");
					System.out.println("5.조회");
					System.out.println("0.종료");
					System.out.println("===========");
					choice = sc.nextInt();
					if(0<=choice&&choice<=5) {
							//0~5번사이를 무조건 골랐음.
						if(choice==1) {
							//로그아웃
							flag2=false;
							System.out.println("로그아웃 되셨습니다.");
							sleep();
						}
						//입금
						else if(choice==2) {
							//입금
							System.out.println("입금할 금액을 입력해주세요.");
							int depositMoney = sc.nextInt();
							//예외처리
							//1.0보다 작을때
							if(depositMoney>0) {
								System.out.println(depositMoney+"원이 입금이 완료되었습니다.");
								if(log==1) dbMoney1+=depositMoney;
								else if(log==2) dbMoney2+=depositMoney;
							}//deposit>0
							else {
								System.out.println("입금할 금액은 1원이상이여야합니다.");
							}//deposit<=0
							sleep();
						}
						//출금
						else if(choice==3) {
							//출금
							System.out.println("출금할 금액을 입력해주세요.");
							int withdrawMoney = sc.nextInt();
							//예외처리 1.0보다 작거나.소유하고 있는돈보다 많을때
							if(withdrawMoney<=0) {
								System.out.println("출금은 1원 이상만 가능합니다.");
							}
							else {//1보다는 큼
								if(log==1&&dbMoney1>=withdrawMoney) {
									dbMoney1-=withdrawMoney;
									System.out.println(withdrawMoney+"이 출금되었습니다.");
								}
								else if(log==2&&dbMoney2>=withdrawMoney) {
									dbMoney2-=withdrawMoney;
									System.out.println(withdrawMoney+"이 출금되었습니다.");
								}
								else System.out.println("잔액이 부족합니다.");
							}
							sleep();
						}
						
						else if(choice==4) {
							//이체
							System.out.println("계좌번호을 입력해주세요.");
							int transferNumber = sc.nextInt();
							System.out.println("입금할 금액을 입력해주세요.");
							int transferMoney = sc.nextInt();
							if(transferNumber==1 && dbMoney2>=transferMoney) {
								dbMoney2-=transferMoney;
								dbMoney1+=transferMoney;
								System.out.println("이체가 완료되었습니다.");
								sleep();
							}
							else if(transferNumber==2 && dbMoney1>=transferMoney) {
								dbMoney1-=transferMoney;
								dbMoney2+=transferMoney;
								System.out.println("이체가 완료되었습니다.");
								sleep();
							}
							else {
								System.out.println("계좌번호와 금액을 다시한번 확인해주세요");
								sleep();
							}
							
						}else if(choice==5){
							//조회
							if(log==1) System.out.printf("[현재 %d님의 계좌 잔액은 %7d원 입니다.]",log,dbMoney1);
							else if(log==2) System.out.printf("[현재 %d님의 계좌 잔액은 %7d원 입니다.]",log,dbMoney2);
							sleep();
						}else {
							//종료
							flag=false;
						}
					}
					else {
							//1~5번 예외번호 눌렀을 경우
						System.out.println("다시 확인하시고 눌러주세요.");
						sleep();
					}
				}
			}
			else if(choice==2) {
				flag = false;
				sleep();
				System.out.println("은행 어플이 종료되었습니다.");
			}
			else {
				//1,2번 안골랐을경우
				sleep();
				System.out.println("잘못된 번호 입니다.1번,2번중에 골라주세요");
			}
		}//while 종료
	}
	
	public static void sleep() {
		try { Thread.sleep(1000);}
		catch(InterruptedException e) {}
	}
}
