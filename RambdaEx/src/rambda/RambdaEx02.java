package rambda;
import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
public class RambdaEx02 {
	
	static <T> List<T> doSomething(Function<T, T> f,List<T> list){
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
			//Function T,T 는 T를 넣고 반환값도 T타입이다
			//새 배열을 Function함수로 적용하고
			//return을 새함수로 한다
		}
		return newList;
	}
	static <T> void printEvenNum(Predicate<T> p,Consumer<T> c,List<T> list) {
		//predicate 조건을 반환하겠다는거고
		//Consumer은 숫자를 받아오고 출력은 안하겟다는거고
		//return 값은 void이기때문에 반환값이 없다.
		//list의 배을 받아서 짝수를 판단하는 predicate하고
		//그리고 출력을 Consumer가 하면됨.
		System.out.print("[");
		for(T i : list) {
			if(p.test(i)) {
				c.accept(i);
			}
		}
		System.out.print("]");
	}
	static <T> void makeRandomList(Supplier<T> s,List<T> list) {
		for(int i=0 ; i<10 ; i++) {
			list.add(s.get());
		}
	}
	
	public static void main(String[] args) {
		Supplier<Integer> s = ()-> (int)(Math.random()*10)+1;
		Consumer<Integer> c = e-> System.out.print(e+" ");
		Predicate<Integer> p = i->i%2==0;
		Function<Integer,Integer> f = i-> i/10*10;
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s,list);
		System.out.println(list);
		
		printEvenNum(p,c,list);
		System.out.println();
		
		List<Integer> newList = doSomething(f,list);
		System.out.println(newList);
	}
	
}
