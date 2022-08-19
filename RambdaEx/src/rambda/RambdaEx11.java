package rambda;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;

public class RambdaEx11 {
	
	public static void main(String[] args) {
		Supplier<Integer> s = ()->(int)(Math.random()*100)+1;
		Consumer<Integer> c = i-> System.out.println(i+" ");
		Predicate<Integer> p = i -> i%2==0;
		Function<Integer,Integer> f = i->i/10*10;
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s,list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f,list);
		
		
	}
	static <T> void makeRandomList(Supplier<T> s, List<T> list){
		for(int i = 0 ; i<list.size(); i++) 
			list.add(s.get());
	}
	static <T> void printEvenNum(Predicate<T> p,Consumer<T> c,List<T> list) {
		for(int i=0 ; i<list.size(); i++) {
			if(p.test(list.get(i))) {
				c.accept(list.get(i));
			}
		}
	}
	static <T> List<T> doSomething(Function<T,T> f,List<T> list){
		List<T> abc = new ArrayList<T>(list.size());
		
		for(T a : list) {
			abc.add(f.apply(a));
		}
		//apply(a)는 f의 함수형인터페이스를
		//작용해서 나온 결과값을 add하겟다는것.
		//Function이 헷갈리긴함.
		return abc;
	}
	
}
