package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetTest {
	public static void main(String[] args) {
		
//		HashSet<Integer> set = new HashSet<Integer>();
//		set.add(10);set.add(20);set.add(30);set.add(40);
//		set.add(80);set.add(70);set.add(60);set.add(50);
//		
//		System.out.println(set.add(11));
//		
//		System.out.println(set);
//		
//		for(int a : set) {
//			System.out.println(a +" ");
//		}
//		
//		Iterator<Integer> it = set.iterator();
//		while(it.hasNext()) {
//			System.out.print(it.next()+" ");
//		}
		
		List<Integer> list = Arrays.asList(10,5,3,7,9);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
}
