package collection;

import java.util.Objects;

public class EqualsTest {
	
	public static void main(String[] args) {
		A a1 = new A(3);
		A a2 = new A(3);
		
		System.out.println(a2==a1);
		System.out.println(a1.equals(a2));
		
		// hashCode;
		System.out.println(new A(3)); //3
		System.out.println(new B(3)); //22
		System.out.println(new C(3)); //3
		System.out.println(new D(3)); //379619aa
	}
}
class A {
	int data ;
	public A (int data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		return data;
	}
}

class B {
	int data ;
	public B (int data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		return Objects.hash(data);
	}
}

class C {
	int data ;
	public C (int data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		return Integer.valueOf(data).hashCode();
	}
}

class D {
	int data ;
	public D (int data) {
		this.data = data;
	}
}
