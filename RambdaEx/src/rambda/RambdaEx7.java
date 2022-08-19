package rambda;
@FunctionalInterface
interface MyFunction1{
	void myMethod();
}


public class RambdaEx7 {
	
	public static void main(String[] args) {
		
		MyFunction1 f = ()->{};
		Object obj = (MyFunction1)(()->{});
		String str = ((Object)(MyFunction1)(()->{})).toString();
		//익명 객체기 때문에 이름이 없는데
		//함수형 인터페이스를 구현했기때문에 형변환으로 사용을 할수있던것
		//그래서 바로 Object로 변환하는게 아니라.
		//구현된 MyFunction으로 형변환을 하고
		//다시 Object로 형변환을 하는것.
		MyFunction1 f2 = (MyFunction1)(()->{});
		//이게 원래 람다식 fm모습이고
		//여기서 MyFunction1을 빼고
//		Object f3 = (Object)(()->{});
		//이식의 유형은 인터페이스만 가능하다고 알려준다.
		//마지막 문장이 그래서 가능햇던것
		String str2 = ((Object)(MyFunction1)(()->{})).toString();
		//익명 객체라서 구현했던 MyFunction에 변환하고
		//다시 인터페이스도 Object로 형변환이 가능하니까 돌리고
		//결국 1차로 인터페이스로 형변환을 명시적으로 한다면
		// 그뒤는 다 가능하다는것.
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str2);
	}
}
