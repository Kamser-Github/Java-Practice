package stream;

import java.util.Optional;

public class StreamOptionalEx1 {
	
	public static void main(String[] args) {
		Optional<String> optStr = Optional.of("abcde");
		//of는 객체에 value를 넣는 방법
		//null이 있을경우에는 ofNullable을 사용한다
		Optional<Integer> optInt = optStr.map(String::length);
		
		System.out.println("optStr="+optStr.get());
		//이때 get도 좋지만 null일수도 있을때는
		//orElse("null일경우 출력할 내용");
		System.out.println("optInt="+optInt.get());
		
		int result1 = Optional.of("123")
							  .filter(x->x.length()>0)
							  .map(Integer::parseInt)
							  .get();
		int result2 = Optional.of("")
							  .filter(x->x.length()>0)
							  .map(Integer::parseInt)
							  .orElse(-1);
		
		System.out.println("result1="+result1);
		System.out.println("result1="+result2);
		
		Optional.of("456").map(Integer::parseInt)
						  .ifPresent(x->System.out.printf("result3=%d%n",x));
		//ifPresent는 값이 null이 아닐경우에만 안에있는 람다식이 작동한다.
		
		//Optional<String> optStr1 = Optional.of(null); 오류
		Optional<String> optStr1 = Optional.ofNullable(null);
		Optional<String> optStr2 = Optional.<String>empty();
		System.out.println(optStr2.orElse(""));
		
		System.out.println(optStr1.isPresent());//false
		System.out.println(optStr2.isPresent());//false
		System.out.println(optStr1.equals(optStr2)); //true
		
		//아래에 optStrToInt와 같은 매서드가 있다
		//대신 둘다 반환값이 없는 void이기 때문에 홀로 작동한다.
		optStr2.ifPresentOrElse(Integer::parseInt,()->System.out.print("없다."));
		//ifPresent 와 orElseGet() 을 합친 메소드라고 생각하면되겟다
		//단 orElseGet()은 안에있는 문장이 Supplier라서 값을 반환한다.
		
	}
	
	public static int optStrToInt(Optional<String> optStr,int defaultValue) {
		try {
			return optStr.map(Integer::parseInt).get();
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	
}
