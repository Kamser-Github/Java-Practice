package rambda;

@FunctionalInterface
interface MyFunction{
	void run();
}

public class RambdaEx06 {
	
	static MyFunction getMyFunction() {
		MyFunction a = new MyFunction() {
			@Override
			public void run() {
				System.out.println("달리다.");
			}
		};
		return a;
	}
	
	static void MyFunctioning(MyFunction a) {
		a.run();
	}
	
	public static void main(String[] args) {
		
		MyFunction aa = ()-> System.out.println("달려!!");
		MyFunctioning(()->System.out.println("삐용"));
		
	}
}
