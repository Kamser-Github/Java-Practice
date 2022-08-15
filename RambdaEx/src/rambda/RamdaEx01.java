package rambda;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.Map;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class RamdaEx01 {
	
	public static void main(String[] args) {
		
		/*
		 * Runnable -> 입력 x , 반환 x				run()
		 * Supplier<T> -> 입력 x , 반환 o			get()
		 * Consumer<T> -> 입력 o , 반환 x			accept(T t)
		 * Function<T,R> -> 입력 T, 반환 R			apply(T t)
		 * Predicate<T> -> 입력 T, 반환 boolean	test(T t)
		 */
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0 ; i<10 ; i++) {
			list.add(i);
		}
		
		//list 목록 확인하기
		list.forEach((e)->{
			System.out.print(e+" ");
		});
		//consumer (e)->{} 반환값이 없어야하는 함수형 인터페이스
		System.out.println();
		list.forEach(new Consumer<Integer>(){
			//accept를 구현해야한다.
			@Override
			public void accept(Integer e) {
				System.out.print(e+" ");
			}
		});
		System.out.println();
		//생성자에서 값을 받는게 아닌데 매개변수를 넣을려고 했다.
		//인터페이스는 인스턴스를 만들지 못한다
		
		list.removeIf((e)->{
			return e%2==0||e%3==0;
		});
		
		System.out.println(list); //1,5,7
		System.out.println();
		
		list.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer e) {
				return e%3==0 || e%2==0;
			}
		});
		
		// 지네릭 인터페이스나 매서드나 클래스는
		// 항상 붙여주는 습관을 길들이자
		
		list.replaceAll(new UnaryOperator<>() {
			@Override
			public Integer apply(Integer t) {
				return t*10;
			}
		});
		
		System.out.println(list);//10 50 70
		
		Map<String,Integer> map = new HashMap<>();
		map.put("집", 1234);
		map.put("회사", 2345);
		map.put("학교", 2345);
		map.put("매장", 4567);
		
		map.forEach(new BiConsumer<>() {

			@Override
			public void accept(String t, Integer u) {
				System.out.println(t+u);
			}
			
		});
		
		
	}
}
