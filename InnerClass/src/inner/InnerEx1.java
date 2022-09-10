package inner;

class A {
	int a = 10;
	
	class B {
		int a = 20;
		
		void method1() {
			System.out.println("B인스턴스 메서드");
			System.out.println(a);
			System.out.println(A.this.a);
		}
		
	}
}

public class InnerEx1 {
	
}
