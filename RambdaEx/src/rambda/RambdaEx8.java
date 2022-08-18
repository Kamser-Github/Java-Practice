package rambda;
@FunctionalInterface
interface MyFunction2{
	void myMethod();
}
class Outer2 {
	int val = 10; //
	
	class Inner {
		int val = 20;
		
		void method(int i) {
			int val = 30;
			
			MyFunction2 f = () ->{
				System.out.println("             i :" + i);
				System.out.println("           val :" + val);
				System.out.println("      this.val :" + ++this.val);
				System.out.println("Outer.this.val :" + ++Outer2.this.val);	
			};
			
			f.myMethod();
		}
	}
}


public class RambdaEx8 {
	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		Outer2.Inner inner = outer.new Inner();
		inner.method(100);
		//i = 지역변수로 한번 쓰고 사라지는것
		//100 ,30 this.면 자기 참조변수니까 20
		//그리고 외부 클래스 는 클래스 명을 붙이면 된다.
	}
}
