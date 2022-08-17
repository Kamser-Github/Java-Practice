package lv01;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class LvTest01 {

	public static void main(String[] args) throws IOException{
		
		//금일 국비 복습
		//레벨테스트 다시 풀어보기 
		
		// 문제) 시험점수3개를 입력받고 학점출력 
		// 조건 1) 3과목의 평균을 가지고 점수를 매긴다.
		// 조건 2) 3과목의 평균이 100~90 ==> A
		// 조건 3) 3과목의 평균이 89~80 ==> B
		// 조건 4) 3과목의 평균이 79~70 ==> C
		// 조건 5) 69이하                      ==> 재시험 
		// 추가조건) 각점수대별로 끝자리가 7점 이상은 + 가붙는다. 
		// 예) 98 ==> A+
		// 예) 89 ==> B+
		// 예) 79 ==> C+
		
		//강사님이 모든 문장에 break를 쓰면
		//switch문장을 쓸 이유가 없다고 하셔서
		//break없이 사용해보겟다.
		
		//점수 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		int count = 0;
		String grade = "";
		while(st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
			count++;
		}
		int avg = sum/count;
		
		if(avg>=90) grade = "A";
		else if(avg>=80) grade = "B";
		else if(avg>=70) grade = "C";
		else grade = "재시험";
		
		if(avg>=70 && avg%10>=7) grade+="+";
		if(avg>=70 && avg%10<=4) grade+="-";
		System.out.println(grade);
		
		//switch문으로 작성했을때
		//추가로 점수끝자리가 4 이하일때는 -라고 한다면
		//어느게 더 좋을까
		
		switch(avg/10) {
		case 10 : case 9 :
			grade = "A";
			break;
		case 8 :
			grade = "B";
			break;
		case 7 :
			grade = "C";
			break;
		default :
		}
		
		if(avg>=70) {
			
			if(avg%10>=7)
				grade+="+";
			else if(avg%10<=4)
				grade+="-";
		}
		
		System.out.println(grade);
	}
}
