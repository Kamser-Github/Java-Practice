package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class LinkedHashSetEx1 {
	public static void main(String[] args) {
		
		LinkedHashSet<Integer> list = new LinkedHashSet<>();
		list.spliterator();
		
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for(int i=0 ; i<10 ;i++) {
			tree.add(10*i);
		}
		
		SortedSet<Integer> set = tree.headSet(50);
		List<Integer> li = new ArrayList<>(set);
		Collections.sort(li);
	}
}
