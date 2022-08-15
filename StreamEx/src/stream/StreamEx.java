package stream;
import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
	
	public static void  main(String[] args) {
		
		//생성
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> stream = list.stream();
		
		//Collection을 구현한 클래스는 전부 .stream으로 가능하다.
		stream.forEach(System.out::print);
		stream = list.stream();
		stream.forEach(e->System.out.print(e));
		
		Stream<String> strStream = Stream.of("d","dd","ddd");
		strStream.forEach(System.out::print);
		String[] strs = {"1","2","3","4","5"};
		Stream<String> strStream2 = Stream.of(strs);
		Stream<String> strStream3 = Arrays.stream(strs);
		Stream<String> strStream4 = Arrays.stream(strs,0,3);
		//index: 0포함부터 3미포함까지 0 1 2 3까지
		//지네릭 스트림은 끝에 인덱스는 다 미포함이지만
		
		//기본형 스트림일경우에는 해당지점까지 포함하는 매서드가 있다.
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		IntStream intstream = IntStream.of(nums);
		//내용 알맹이는 Arrays.stream(nums)와 같다;
		IntStream intstream2 = Arrays.stream(nums);
		intstream2 = IntStream.rangeClosed(1, 3);
		//range는 내가 지정한 배열에서 차례를 골라주는게 아니라.
		//IntStream내부에 숫자배열에 있는걸 때서 주는거엿다.
		
		//임의의 수 (난수)
		IntStream intstream3 = new Random().ints();
		//ints() 가 붙으면 무한으로 계속 흐르는 배열이 된다.
		intstream3.limit(5).forEach(System.out::println);
		System.out.println("---------------");
		//20~1000사이의 난수를 5개만 추출해보싶다.
		IntStream intstream4 = new Random().ints(5);
		//IntStream의 매소드가 아니라 Random클래스가 가지고 있는
		//매서드를 활용한것이다. 반환타입이 IntStream이다.
		intstream4.forEach(System.out::println);
		System.out.println("---------");
		//출력까지 한번해 해보겟다.
		new Random().ints(5,20,30).forEach(System.out::println);
	}
}
