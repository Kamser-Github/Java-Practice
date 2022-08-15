package stream;

import java.util.stream.Stream;

public class StreamEx01 {
	
	public static void main(String[] args) {
		
		//빈 스트림
		
		Stream<String> emptyStream = Stream.empty();
		//empty()는 static 매소드라 null값이라 생각하면 편할듯하다
		
		int[] a = new int[0];
		String ab = "";
		
		//null값을 넣어서 예외가 발생하는거보다.
		//빈 값을 넣어서 포장하는것이 예외발생과 널체크를 안해도 된다.
		
		long count = emptyStream.count();
		// count() 매소드는 해당 스트림의 elements개수를 반환한다.
		System.out.println(count); //0
		
		
	}
}