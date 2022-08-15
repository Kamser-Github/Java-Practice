package rambda;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.function.Supplier;

public class RambdaEx03 {
	
	//똑같이 따라해보기 CH1
	static <T> List<T> doSomething(UnaryOperator<T> f,List<T> list){
		
		List<T> newList = new ArrayList<T>(list.size());
		for(T i : list) {
			newList.add(f.apply(i));
			//이 뜻은
			//매개객채로 들어오는 f의 함수형 인터페이스가 가지고있는
			//T i 를 넣을때 결과값을 list에 add하겠다는것
		}
		return newList;
	}
	
	static <T> void printEvenNum(Predicate<T> p,Consumer<T> c,List<T> list) {
		//이식은
		//void (조건문,출력문,매개변수 List)
		System.out.print("[");
		for(T i : list) {
			if(p.test(i)) {
				c.accept(i);
			}
			//p.test(i);
			//test로 구현부에 있는 조건에 따라 참일 경우
			//c가 가지고 있는걸 하겠다
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList(Supplier<T> s,List<T> list) {
		for(int i=0 ; i<10 ; i++) {
			list.add(s.get());
		}
	}
	
	public static void main(String[] args) {
		Supplier<String> s = ()->{
			String[] strs = {"1월","2월","3월","4월"};
			int num = (int)(Math.random()*4);
			return strs[num]+" ";
		};
		List<String> list = new ArrayList<>(10);
		makeRandomList(s,list);
		System.out.println(list);
		
		Consumer<String> c = e -> {
			System.out.println(e);
		};
		
		Predicate<String> p = e -> e.length()%2==0;
		
		
		printEvenNum(p,c,list);
		System.out.println(list);
		
	}
	
	
}
