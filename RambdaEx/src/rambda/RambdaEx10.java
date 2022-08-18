package rambda;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
public class RambdaEx10 {
	
	public static void main(String[] args) {
		Supplier<Integer> s = ()->5;
		//입력값음 없고 출력만있다.
		//작업을 할때 도움을 준다.
		//반복작업
		Consumer<Integer> c = i-> System.out.println(i);
		//입력은 받지만 출력은 안한다.
		//이때 값을 꺼내오는 역할을 한다.
		Predicate<Integer> p = e-> e%2==0 ;
		//참과 거짓을 나누게하는 람다식.
		//Collectors.partitioningBy에서 첫번째 매개변수타입이다.
		Function<Integer,Integer> f = i->i/10*10;
		//첫번째 인자로 입력,두번째 인자타입으로 반환
		//입력과 출력이 같으면 UnaryOperator;
		//매개변수가 2개면 BinaryOperator;
		//입력값이 2개면 대부분 Bi가 붙는다.
		//입력과 출력이 같으면 Operator 뒤에 잇다.
		
	}
}
