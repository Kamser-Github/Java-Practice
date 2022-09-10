package enumeration;

enum Direction {EAST,SOUTH,WEST,NORTH}

public class EnumTest01 {
	public static void main(String[] args) {
		
		//선언및 초기화 방법
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class,"EAST");
		
		System.out.println("d1="+d1); //d1=EAST
		System.out.println("d2="+d2); //d2=WEST
		System.out.println("d3="+d3); //d3=EAST
		
		System.out.println("d1==d2 ? "+(d1==d2));
		System.out.println("d1==d3 ? "+(d1==d3));
		System.out.println("d1.equals(d3) ? "+d1.equals(d3));
	//	System.out.println("d2> d3 ?"+(d1>d3)); //에러
		System.out.println("d1.comparaTo(d3) ? "+d1.compareTo(d3));
		System.out.println("d1.comparaTo(d2) ? "+d1.compareTo(d2));
		
		switch(d1) {
		case EAST : //Direction.EAST라고 사용 할수가 없다.
			System.out.println("방향은 EAST");
			break;
		case SOUTH :
			System.out.println("방향은 SOUTH");
			break;
		case WEST :
			System.out.println("방향은 WEST");
			break;
		case NORTH :
			System.out.println("방향은 NORTH");
			break;
		default :
			System.out.println("방향이 정해지지않음");
		}
		
		Direction[] dArr = Direction.values();
		for(Direction d : dArr) {
			System.out.printf("%s=%d\n",d.name(),d.ordinal());
		}
/*
		EAST=0
		SOUTH=1
		WEST=2
		NORTH=3
*/
		
	}
}
