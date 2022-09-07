package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayCompare {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		System.out.println("- 1. 순차적인 추가 -");
		System.out.println("ArrayList  시간: " + add1(al) + " ms");
		System.out.println("LinkedList 시간: " + add1(ll) + " ms");
		
//		System.out.println("- 2. 비순차적인 추가 -");
//		System.out.println("ArrayList  시간: " + add2(al) + " ms");
//		System.out.println("LinkedList 시간: " + add2(ll) + " ms");
//		
//		System.out.println("- 3. 비순차적인 삭제 -");
//		System.out.println("ArrayList  시간: " + remove1(al) + " ms");
//		System.out.println("LinkedList 시간: " + remove1(ll) + " ms");
//		
//		System.out.println("- 4. 순차적인 삭제 -");
//		System.out.println("ArrayList  시간: " + remove2(al) + " ms");
//		System.out.println("LinkedList 시간: " + remove2(ll) + " ms");
		/*
		    - 1. 순차적인 추가 -
			ArrayList  시간: 19 ms
			LinkedList 시간: 138 ms
			- 2. 비순차적인 추가 -
			ArrayList  시간: 1627 ms
			LinkedList 시간: 9 ms
			- 3. 비순차적인 삭제 -
			ArrayList  시간: 1290 ms
			LinkedList 시간: 85 ms
			- 4. 순차적인 삭제 -
			ArrayList  시간: 6 ms
			LinkedList 시간: 20 ms
			- 5. 접근 시간 비교 -
			ArrayList  시간: 3 ms
			LinkedList 시간: 2911 ms
		 */
		System.out.println("- 5. 접근 시간 비교 -");
		System.out.println("ArrayList  시간: " + access(al) + " ms");
		System.out.println("LinkedList 시간: " + access(ll) + " ms");
		
	}
	
	//순차적으로 데이터 추가
	public static long add1(List<Integer> list) {
		long startTime = System.currentTimeMillis();
		for(int i=0 ; i<100000 ; i++) {
			list.add(i);
		}
		long endTime = System.currentTimeMillis();
		
		return endTime-startTime;
	}
	//비순차적으로 데이터 추가
	public static long add2(List<Integer> list) {
		long startTime = System.currentTimeMillis();
		for(int i=0 ; i<10000 ; i++) {
			list.add(500,i);
		}
		long endTime = System.currentTimeMillis();
		
		return endTime-startTime;
	}
	
	//비순자적으로 데이터 삭제
	public static long remove1(List<Integer> list) {
		long startTime = System.currentTimeMillis();
		for(int i=0 ; i<10000 ; i++) {
			list.remove(i);
		}
		long endTime = System.currentTimeMillis();
		
		return endTime-startTime;
	}
	
	//순자적으로 데이터 삭제.
	public static long remove2(List<Integer> list) {
		long startTime = System.currentTimeMillis();
		//list.size()-1인 이유는 size는 배열의 길이이기때문에 -1을 해야한다.
		for(int i=list.size()-1; i>=0; i--) {
			list.remove(i);
		}
		long endTime = System.currentTimeMillis();
		
		return endTime-startTime;
	}
	
	//접근시간비교
	public static long access(List<Integer> list) {
		long startTime = System.currentTimeMillis();
		//list.size()-1인 이유는 size는 배열의 길이이기때문에 -1을 해야한다.
		for(int i=0; i<list.size() ; i++) {
			list.get(i);
		}
		long endTime = System.currentTimeMillis();
		
		return endTime-startTime;
	}
}
