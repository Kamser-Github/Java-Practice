package rambda;
import java.util.function.Function;
import java.util.function.Predicate;
public class RambdaEx05 {
	
	public static void main(String[] args) {
		Function<String,Integer> f = s -> Integer.parseInt(s,16);
		//Function<String,Integer> f = s->Integer.parseInt(s);
		//Function<Integer,String> g = s-> Integer.toBinaryString(s);
		Function<Integer,String> g = Integer::toBinaryString;
		
		Function<String,String> h = f.andThen(g);
		//위에는 s->i->s
		Function<Integer,Integer> h2 = f.compose(g);
		//아래는 i->s->i g.andThen(f);
		//뒤에걸 먼저하는거 차이일뿐
		
		System.out.println(h.apply("FF")); //111111
		System.out.println(h2.apply(2)); //16
		
		Function<String,String> f2 = x -> x;
		System.out.println(f2.apply("AAA"));
		
		Predicate<Integer> p = i-> i<100;
		Predicate<Integer> q = i-> i<200;
		Predicate<Integer> r = i-> i%2==0;
		Predicate<Integer> notP = p.negate();//!p i>=100
		
		Predicate<Integer> all = notP.and(q).or(r);
		//i>=100 && i<200 || i%2==0;
		System.out.println(all.test(150));
		// true && true || true = true
		
		String str1 = "abc";
		String str2 = "abc";
		
		String str3 = new String("abc");
		String str4 = new String("abc");
		
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result); //true
		boolean result2 = Predicate.isEqual(str3).test(str4);
		//isEqual return 타입이 Predicate이다
		//test의 타입은 boolean이고
		System.out.println(result2);
	}
}
