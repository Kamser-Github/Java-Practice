package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StreamCollectEx3 {
	
	public static void main(String[] args) {
		String[] strArr = {"aaa","bbb","ccc"};
		Stream<String> strStream = Stream.of(strArr);
		
		String result = strStream.collect(new ConcatCollector());
		
		System.out.println(Arrays.toString(strArr));
		System.out.println("result="+result);
	}
}

class ConcatCollector implements Collector<String,StringBuilder,String>{
	
	@Override
	public Supplier<StringBuilder> supplier(){
		return ()-> new StringBuilder();
		
		//Supplier<T> -> return T;
	}
	
	@Override
	public BiConsumer<StringBuilder, String> accumulator(){
		return (sb,s)->sb.append(s);
		
		//2개 입력값을 받아서 출력은 없고
		//누적하는 계산부분
	}
	@Override
	public Function<StringBuilder,String> finisher(){
		return sb->sb.toString();
		//StringBuilder -> String으로 변환
	}
	@Override
	public BinaryOperator<StringBuilder> combiner(){
		return (sb, sb2)-> {
			sb.append(sb2);
			return sb;		
		};
		//T,T- > T
	}
	@Override
	public Set<Characteristics> characteristics(){
		return Collections.emptySet();
	}
}