package stream;

import java.util.List;
import static java.util.stream.Collectors.*;
import java.util.IntSummaryStatistics;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Optional;

public class StreamJoiningEx1 {
	public static void main(String[] args) {
		Student02[] stuArr = {
				new Student02("강라마", 3, 300),
				new Student02("야라마", 1, 200),
				new Student02("고라마", 2, 100),
				new Student02("박라마", 2, 150),
				new Student02("전라마", 1, 200),
				new Student02("이라마", 3, 290),
				new Student02("최라마", 3, 180)	
			};
		//학생이름을 따로 뽑아서 List에 저장
		List<String> stuNames = Stream.of(stuArr)
							.map(Student02::getName)
							.collect(toList());
		System.out.println(stuNames);
		
		//Stream > Array;
		Student02[] stuArr2 = Stream.of(stuArr).toArray(Student02[]::new);
		
		for(Student02 s : stuArr2) {
			System.out.println(s);
		}
		
		//스트림을 Map<String,Student>으로 변환, 학생 이름이 key값
		Map<String,Student02> stuMap = Stream.of(stuArr)
					.collect(toMap(s->s.getName(),p->p));
		
		for(String name : stuMap.keySet()) {
			System.out.println(name+"-"+stuMap.get(name));
		}
		
		long count = Stream.of(stuArr).collect(counting());
		long totalScore = Stream.of(stuArr)
							.collect(summingInt(Student02::getTotalScore));
		System.out.println("count = "+count);
		System.out.println("totalScore = "+totalScore);
		
		totalScore = Stream.of(stuArr)
						   .collect(reducing(0,Student02::getTotalScore,Integer::sum));
		System.out.println("totalScore = "+totalScore);
		
		Optional<Student02> topStudent = Stream.of(stuArr)
									.collect(maxBy(Comparator.comparingInt(Student02::getTotalScore)));
		System.out.println("topStudent = "+topStudent.get());
		
		IntSummaryStatistics stat = Stream.of(stuArr)
							.collect(summarizingInt(Student02::getTotalScore));
		
		System.out.println(stat);
		
		String stuNames2 = Stream.of(stuArr)
							.map(Student02::getName)
							.collect(joining(",","[","]"));
		
		System.out.println(stuNames2);
	}
}
class Student02 implements Comparable<Student02>{
	private String name;
	private int ban;
	private int totalScore;
	
	Student02(String name,int ban,int totalScore){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	@Override
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
	}
	
	String getName() 	{ return name;}
	int getBan() 		{ return ban;}
	int getTotalScore() { return totalScore;}
	
	@Override
	public int compareTo(Student02 s) {
		return s.totalScore - this.totalScore;
	}
}
