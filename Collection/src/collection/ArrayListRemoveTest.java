package collection;
import java.util.ArrayList;
import java.util.List;
public class ArrayListRemoveTest {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0 ; i<5 ; i++) {
			list.add(i*10);
		}
		
		System.out.println(list.remove(1));
		System.out.println(list.remove(Integer.valueOf(40)));
		
		for(int i=0 ; i<5 ; i++) {
			list.add(i+3);
		}
		Integer[] ints = list.toArray(new Integer[10]);
		for(Integer a : ints){
			System.out.println(a);
		}
	}
}
