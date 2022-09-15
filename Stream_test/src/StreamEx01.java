import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx01 {
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
					new Student("이자바", 3, 300),
					new Student("학자바", 1, 200),
					new Student("안자바", 2, 100),
					new Student("박자바", 2, 150),
					new Student("소자바", 1, 200),
					new Student("나자바", 3, 290),
					new Student("황자바", 3, 180)
				);
//		studentStream.sorted(Comparator.comparing(Student::getName)
//					 .thenComparing(Comparator.comparing(Student::getBan)))
//		.forEach(System.out::println);
		
		studentStream.sorted(Comparator.comparing(Student::getBan)//먼저 반 별로 정렬
					 .thenComparing(Comparator.naturalOrder()))//기본정렬
					 .forEach(System.out::println);
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
		return String.format("[%s, %d, %d]",name,ban,totalScore);
	}
	
	String getName()     { return name;}
	int getBan()         { return ban;}
	int getTotalScore()  { return totalScore;}
	
	//Comparable
	@Override
	public int compareTo(Student s1) {//성적 높은순으로
		return this.totalScore - s1.totalScore;
	}
}