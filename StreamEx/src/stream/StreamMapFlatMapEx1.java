package stream;
import java.util.stream.Stream;
import java.util.Arrays;
public class StreamMapFlatMapEx1 {
	
	public static void main(String[] args) {
		
		Stream<String[]> strArrStrm = Stream.of(
				new String[]{"abc", "def", "jkl"},
				new String[]{"ABC", "GHI", "JKL"}
				);
		//Stream<String[]>
		
		//map() -> Stream<Stream<String>>;
		//Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
		
		Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
		
		strStrm.map(String::toLowerCase)
		//map(e->String.toLowerCase(e))
			   .distinct()
			   .sorted()
			   .forEach(System.out::println);
		
		System.out.println("----------------");
		
		String[] lineArr = {
				"Believe or not It is true",
				"Do or do not There is no try",
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.peek(s->System.out.printf("%s ",s))
				  .flatMap(line->Stream.of(line.split(" +")))//정규식이다.
				  .peek(s->System.out.printf("%s ",s))
				  .map(String::toLowerCase)
				  .distinct()
				  .sorted()
				  .forEach(System.out::println);
		
		System.out.println("------------------");
		
		Stream<String> strStrm1 = Stream.of("AAA","ABC","bBb");
		Stream<String> strStrm2 = Stream.of("bbb","aaa","ccc");
		
		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1,strStrm2);
		
		Stream<String> strStream = strStrmStrm
									.map(s->s.toArray(String[]::new))
									.flatMap(Arrays::stream);
		
		//
		strStream.map(String::toLowerCase)
				 .distinct()
				 .forEach(System.out::println);
		
	}
}
