package format;

import java.text.ChoiceFormat;

public class ChoiceFormatEx01 {
	public static void main(String[] args) {
		double[] limits = {60,70,80,90};
		//범위의 경계값은 항상 오름차순으로 정렬이 되어야한다.
		String[] grades = {"D","C","B","A"};
		//치환값은 범위배열의 순서와 길이가 같아야한다.
		int[] scores = {100,95,88,70,52,60,70};
		ChoiceFormat form = new ChoiceFormat(limits,grades);
		
		for(int i=0; i<scores.length ; i++) {
			System.out.println(scores[i]+":"+form.format(scores[i]));
		}
	}
}
