package stream;
import java.util.Comparator;
import java.util.stream.Stream;
public class StreamSortedEx01 {
	
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
							new Student("둘리", 3, 300),
							new Student("짱구", 1, 200),
							new Student("기철", 2, 100),
							new Student("길동", 2, 150),
							new Student("연화", 1, 200),
							new Student("달래", 3, 290),
							new Student("파이리", 3, 180)
						);
//		studentStream.sorted(Comparator.comparing(Student::getBan)
//							.thenComparing(Comparator.naturalOrder()))
//							.forEach(System.out::print);
		studentStream.sorted(Comparator.comparing((Student s)->s.getBan(),new Comparator<Integer>() {
			@Override
			public int compare(Integer s1,Integer s2) {
				return s2-s1;
			}//compare
		}).thenComparing(Comparator.naturalOrder())).forEach(System.out::print);
	}
}

class Student implements Comparable<Student>{
	
	String name;
	int ban;
	int totalScore;
	
	Student(String name,int ban,int totalScore){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	@Override
	public String toString() {
		return String.format("[%s, %d, %d]%n", name,ban,totalScore);
	}
	
	String getName() 	 { return name; }
	int getBan()		 { return ban; }
	int getTotalScore()	 { return totalScore; }
	
	//총점은 내림차순 정렬을 기본으로 한다.
	@Override
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}