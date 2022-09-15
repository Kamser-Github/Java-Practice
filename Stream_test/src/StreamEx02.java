import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx02 {
	public static void main(String[] args) {
		Stream<Student2> studentStream = Stream.of(
				new Student2("이자바", 3, 300),
				new Student2("학자바", 1, 200),
				new Student2("안자바", 2, 100),
				new Student2("박자바", 2, 150),
				new Student2("소자바", 1, 200),
				new Student2("나자바", 3, 290),
				new Student2("황자바", 3, 180)
			);
		//Stream<T> stream = Stream.of(T...t);
		Stream<Student2> studentStream2 = Arrays.stream(new Student2[] {
				new Student2("이자바", 3, 300),
				new Student2("학자바", 1, 200),
				new Student2("안자바", 2, 100),
				new Student2("박자바", 2, 150),
				new Student2("소자바", 1, 200),
				new Student2("나자바", 3, 290),
				new Student2("황자바", 3, 180)
		});
		
		//스트림으로 정렬하고 출력해보기
		//여기서 sorted안에는 comparator를 구현한 애가 와야하는데.
		//구현하지 않아도 Comparator static 메서드로 정렬기준을 제시할수있다.
		studentStream.sorted(Comparator.comparing(Student2::getBan)
					 .thenComparing(Comparator.naturalOrder()))
				     .forEach(System.out::println);
		//여기서 Comparator<T> Comparable 구현해야한다.
		//기본 정렬은 comparable이 기준이 된다.
		System.out.println("---");
		studentStream2.sorted()
					 .forEach(System.out::println);
		
	}
}
class Student2 implements Comparable<Student2>{
	private static int nullNo;
	
	private String name;
	private int ban;
	private int totalScore;
	
	Student2(){
		this("이름없음"+nullNo,0,0);
	}
	Student2(String name,int ban,int totalScore){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
		nullNo++;
	}
	
	//getter
	public String getName() { return name; }
	public int getBan() { return ban; }
	public int getTotalScore() { return totalScore; }
	
	@Override
	public String toString() {
		return String.format("[%s,%d,%3d]", name,ban,totalScore);
	}
	
	@Override //내림차순
	public int compareTo(Student2 s1) {
		return s1.totalScore -this.totalScore;
	}
	
}