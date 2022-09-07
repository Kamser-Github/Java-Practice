package collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		System.out.println(list.set(3, 60));
		System.out.println(list);
		
		LinkedList<Student> list2 = new LinkedList<Student>();
		list2.add(new Student(1,3,"둘리"));
		list2.add(new Student(2,2,"둘리1"));
		list2.add(new Student(3,1,"둘리2"));
		list2.add(new Student(1,2,"둘리3"));
		list2.add(new Student(2,1,"둘리4"));
		list2.add(new Student(3,3,"둘리5"));
		list2.add(new Student(2,3,"둘리6"));
		list2.add(new Student(3,2,"둘리7"));
		list2.add(new Student(1,2,"둘리8"));
		list2.add(new Student(2,1,"둘리9"));
		
		System.out.println(list2);
		Collections.sort(list2);
		System.out.println(list2);
		
		//무한 재귀함수에 빠지는 이유가 size()때문인건가.
		for(int i=0 ; i<list2.size() ; i++) {
			if(list2.get(i).compareTo(new Student(2,2,"둘리1"))==0) {
				list2.add(i+1,new Student(2,2,"또치"));
				break;
			}
		}
		
		System.out.println(list2);
	}
}
class Student implements Comparable<Student>{
    int hak;
    int ban;
    String name;
    public Student(int hak,int ban,String name){
        this.hak = hak;
        this.ban = ban;
        this.name = name;
    }

    public boolean compare(Student stu){
        return this.hak==stu.hak&&this.ban==stu.ban;
    }
    
    @Override
    public int compareTo(Student s) {
    	if(this.hak-s.hak>0) {
    		return 1;
    	}
    	else if(this.hak-s.hak==0) {
    		if(this.ban-s.ban>0) {
    			return 1;
    		}
    		else if(this.ban-s.ban<0) {
    			return -1;
    		}
    		else {
    			return 0;
    		}
    	}
    	else {
    		return -1;
    	}
    }
    @Override
    public String toString() {
    	return String.format("%d:%d::%s",hak,ban,name);
    }
    
}

