package format;

import java.text.ChoiceFormat;

public class ChoiceFormatEx2 {
	public static void main(String[] args) {
		String pattern = "60#D|70#C|80<B|90#A";
		//치환값은 범위배열의 순서와 길이가 같아야한다.
		int[] scores = {60,61,70,71,80,81,90,91,100};
		ChoiceFormat form = new ChoiceFormat(pattern);
		
		for(int i=0; i<scores.length ; i++) {
			System.out.println(scores[i]+":"+form.format(scores[i]));
		}
	}
}
