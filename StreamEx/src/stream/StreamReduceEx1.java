package stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class StreamReduceEx1 {
	
	public static void main(String[] args) {
		
		String[] strArr = {
				"Inheritance", "Java", "Lambda", "stream",
				"OptionalDouble", "IntStream", "count", "sum"
		};
		
		Stream.of(strArr).forEach(System.out::println);
		
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length()==20);
		//잠만...length < 0 true
		//		length > 0 false
		//		length == 0 true
		//noneMatch는 하나라도 일치하면 false다
		System.out.println(noEmptyStr);
		Optional<String> sWord = Stream.of(strArr)
									.filter(s->s.charAt(0)=='s')
									.findFirst();
		System.out.println(sWord.get());
		
		//Stream<String[]>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		
		int count = intStream1.reduce(0,(a,b)-> a+1);
		//초기값 , 그리고 그 다음값에 넘어갈때마다 초기값에 +1만 하는것
		int sum = intStream2.reduce(0, (a,b)-> a+b );
		//초기값에 넘어갈때마다 누적으로 그다음값을 더하는것
		
		OptionalInt max = intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);
		//여기서 Optional을 쓴 이유는 intStream이 값이 없을수가 있기 때문에
		//예외와 널 체크를 안하려고 Optional로 받은거고
		//reduce는 하나하나 a b (b= a+1 index) 로 
		//최대값과 최소값을 구한다.
		
		System.out.println("Count= "+count);
		System.out.println("sum= "+sum);
		System.out.println("max="+max.getAsInt());
		System.out.println("min="+min.getAsInt());
		
		//Optional에서는 값을 꺼낼때 get을 사용한다.
		
		//이건 테스트 한번더
		
	}
}
