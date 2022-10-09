package rambdapr;

import java.util.ArrayList;
import java.util.function.Consumer;

public class RambdaEx01 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<10 ; i++) {
			list.add(i);
		}
		
//		list.forEach(System.out::print);
		
		list.forEach(e->{
			System.out.print(e*15+" ");
		});
		
		//consumer e-> {} 반환값이 없어야하고
		// 입력만만 있는 함수형 인터페이스
		//단 디폴트나 스태틱매서드는 가능하다.
		
		Consumer<Integer> cs = new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				System.out.println(i*15);
			}
		};
		//함수형 인터페이스는
		//중요한게 인터페이스 매개변수를 잘 생각해야한다.
		
		//list.forEach(cs);
		
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				System.out.println(i*15);
			}
		});
		
		//바로 익명클래스를 집어 넣을수도있고.
		
		
	}
}

