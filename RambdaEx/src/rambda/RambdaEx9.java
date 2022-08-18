package rambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class RambdaEx9 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0 ; i<10 ; i++) {
			//list.add(Integer.valueOf(i));
			list.add(i);
		}
		
		//List의 메소드중 forEach(Consumer)
		//입력은 있고 출력값은 없다
		//void accept();
		list.forEach(i->System.out.println(i+""));
		
		//list
		list.removeIf(x-> x%2==0 || x%3==0);
		//여기에 들어간건 predicate
		//조건식으로 값을받아서 boolean을 반환
		
		//list
		
		list.replaceAll(i->i*10);
		//Function<T>; T를 받아서 return T
		//값 변경이 가능하다는것
		//안에 들어있는 UnaryOperator는 입력값과 반환값이 같다.
		
		Map<String,String> map = new HashMap<>();
		map.put("1", "2");
		map.put("2", "3");
		map.put("3", "4");
		map.put("4", "5");
		
		//map 인터페이스로
		//default 매서드이다
		//action.accept(k, v); 값과 키를 꺼내준다는거같다.
		//여기서 action만 지정해주면된다
		//accept는 인자로 k와 v를 받을건데
		map.forEach((k,v)->{System.out.println(k + v);});
	}
}
