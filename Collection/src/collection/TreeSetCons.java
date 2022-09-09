package collection;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class TreeSetCons {
	public static void main(String[] args) {
		TreeSet<Student1> member = new TreeSet<Student1>();
		member.add(new Student1(175,"kang"));
		member.add(new Student1(165,"pack"));
		member.add(new Student1(166,"chan"));
		member.add(new Student1(169,"goo"));
		member.add(new Student1(173,"joo"));
		member.add(new Student1(174,"li"));
		member.add(new Student1(184,"jing"));
		member.add(new Student1(184,"nee"));
		member.add(new Student1(184,"ryu"));
		System.out.println(member);
		
		TreeSet<Student1> member2 = new TreeSet<Student1>(new Comparator<Student1>() {
			@Override
			public int compare(Student1 o1,Student1 o2) {
				if(o1.getHeight() > o2.getHeight()) {
					return 1;
				}
				else if(o1.getHeight() < o2.getHeight()) {
					return -1;
				}
				else {
					//String은 compareTo로 비교
					if(o1.getName().compareTo(o2.getName())>0) {
						return 1;
					}
					else if((o1.getName().compareTo(o2.getName())<0)) {
						return -1;
					}
					else
						return 0;
				}
			}
		});
		
	}
}
class Student1 implements Comparable<Student1> {
	private int height; //2.
	private String name;//2.
	
	public Student1() {} //1.
	public Student1(int height,String name) {
		setHeight(height);
		setName(name);
	}
	
	//get
	public int		getHeight() {return height;}
	public String	getName() 	{return name;}
	//set
	public void	setHeight(int height) {
		if(height<100||height>300) {
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
		this.height = height;
	}//4.
	//set
	public void setName(String name) {
		if(name.length()<1) {
			System.out.println("잘못 기입하셨습니다.");
			return;
		}
		this.name = name;
	}//4.
	
	//set에는 중복검사를 위해 2가지 오버라이딩을 해야한다.
	//1.equals
	@Override
	public boolean equals(Object o) {
		if(o instanceof Student1) {
			if(this.name==((Student1)o).name && this.height==((Student1)o).height) {
				return true;
			}
		}
		return false;
	}
	//2.hashCode()
	@Override
	public int hashCode() {
//		return (height+name).hashCode();
		return Objects.hash(name,height);//jdk 1.8부터 사용가능
	}
	
	@Override
	public int compareTo(Student1 o2) {
		if(this.height > o2.height) {
			return 1;
		}
		else if(this.height < o2.height) {
			return -1;
		}
		else {
			if(this.name.compareTo(o2.name)>0) {
				return 1;
			}
			else if((this.name.compareTo(o2.name)<0)) {
				return -1;
			}
			else
				return 0;
		}
	}
	
	//3.
	@Override
	public String toString() {
		return String.format("%s@%s:%s",this.getClass().getName(),name,height);
	}
}