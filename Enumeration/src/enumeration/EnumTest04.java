
package enumeration;

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T>{
	
	//T는 MyEnum을 상속받아야 한다.
	static int id = 0;
	int ordinal;
	String name = "";
	
	public int ordinal() {return ordinal;}
	
	MyEnum(String name){
		this.name = name;
		ordinal = id++;
	}
	
	public int compareTo(T t) {
		return ordinal = t.ordinal();
	}
}

abstract class MyTrans extends MyEnum<MyTrans>{
	static final MyTrans BUS = new MyTrans("BUS",100) {
		int fare(int distance ) { return distance*BASIC_FARE;}
	};
	static final MyTrans TRAIN = new MyTrans("BUS",100) {
		int fare(int distance ) { return distance*BASIC_FARE;}
	};
	static final MyTrans SHIP = new MyTrans("BUS",100) {
		int fare(int distance ) { return distance*BASIC_FARE;}
	};
	static final MyTrans AIRPLANE = new MyTrans("BUS",100) {
		int fare(int distance ) { return distance*BASIC_FARE;}
	};
	
	abstract int fare(int distance);
	protected final int BASIC_FARE;
	private MyTrans(String name,int basicFare) {
		super(name);
		BASIC_FARE = basicFare;
	}
	public String name() {return name;}
	public String toString() {return name;}
}

public class EnumTest04 {
	public static void main(String[] args) {
		MyTrans t1 = MyTrans.BUS;
		MyTrans t2 = MyTrans.BUS;
		MyTrans t3 = MyTrans.TRAIN;
		MyTrans t4 = MyTrans.SHIP;
		MyTrans t5 = MyTrans.AIRPLANE;
		
		System.out.printf("t1=%s,%d\n",t1.name(),t1.ordinal());
		System.out.printf("t2=%s,%d\n",t2.name(),t2.ordinal());
		System.out.printf("t3=%s,%d\n",t3.name(),t3.ordinal());
		System.out.printf("t4=%s,%d\n",t4.name(),t4.ordinal());
		System.out.printf("t5=%s,%d\n",t5.name(),t5.ordinal());
		System.out.println("t1==t2 ? "+(t1==t2));
		System.out.println("t1.compareTo(t3)="+ t1.compareTo(t3));
	}
}








