package stream;

import java.util.stream.Stream;
import java.util.stream.IntStream;

public class StreamExIterate {
	
	//iterate(), generate()
	//람다식을 매개변수로 받아 그 식을 무한스트림으로 만든다.
	
	//static <T> Stream<T> iterate(T seed,UnaryOperator<T> t)
	
	//static <T> Stream<T> generate(Supplier<T> s)
	
	Stream<Integer> evenStream = Stream.iterate(0,n->n+2);
	//초기값이 있다 
	
	Stream<Double> randomStream = Stream.generate(Math::random);
	//초기값이 없는 무한한 랜덤값이나
	Stream<Integer> oneStream = Stream.generate(()->1);
	//하나의 숫자만 계속 찍어내는 스트림을 만든다.
	
	//해당 스트림에 int값만 있다고 해서 기본형으로 담을수가없다.
	//반환값이 지네릭이고 그 타입이 Integer이기 때문에
	//Stream<T>로 받아야 한다.
	
	//다른 방법으로 받아야 한다면.
	IntStream evenStream2 = Stream.iterate(0, n->n+2).mapToInt(Integer::valueOf);
	//<Integer>를 IntStream으로 변환해주는 mapToInt를 사용하면된다
	//반대로 이걸 Stream<Integer>로 변환하려면 boxed를 사용한다.
	Stream<Integer> boxingEven = evenStream2.boxed();
	
	
	
	
	
	
}
