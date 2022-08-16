package stream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.Optional;
import java.util.IntSummaryStatistics;
public class StreamJoiningEx2 {
	public static void main(String[] args) {
		Student03[] stuArr = {
				new Student03("강라마", 3, 300),
				new Student03("야라마", 1, 200),
				new Student03("고라마", 2, 100),
				new Student03("박라마", 2, 150),
				new Student03("전라마", 1, 200),
				new Student03("이라마", 3, 290),
				new Student03("최라마", 3, 180)	
			};
		//따로 학생이름을 List에 저장
		List<String> names = Stream.of(stuArr)
				.map(Student03::getName)
				.collect(Collectors.toList());
		//따로 학생의 성적을 List에 저장
		List<Integer> scores = Stream.of(stuArr)
				.map(Student03::getTotalScore)
				.collect(Collectors.toList());
		//따로 학생의 반을 List에 저장
		List<Integer> bans = Arrays.stream(stuArr)
				.map(Student03::getBan)
				.collect(Collectors.toList());
		//Map으로 키와 값을 따로 저장해보기
		Map<String,Integer> nameban = Stream.of(stuArr)
				.collect(Collectors.toMap(Student03::getName,Student03::getBan));
		
		//Stream > Array로 변환
		Student03[] stuArr2 = Stream.of(stuArr)
				.toArray(Student03[]::new);
		//반환값이 Object[]이지만 생성자는 new Student03이기 때문에 가능
		
		//스트림으로 Map<>안에 다시 객체가 들어가게 연습
		Map<String,Student03> stuMap = Stream.of(stuArr)
				.collect(Collectors.toMap(Student03::getName,Function.identity()));
		
		//
		for(String name : stuMap.keySet()) {
			System.out.println(name+" "+stuMap.get(name));
		}
		
		long count = Stream.of(stuArr).collect(Collectors.counting());
		long totalScore = Stream.of(stuArr)
				.collect(Collectors.summingInt(Student03::getTotalScore));
		
		System.out.println("count="+count);
		System.out.println("tatalScore="+totalScore);
		
		totalScore = Stream.of(stuArr)
				.collect(Collectors.reducing(0, Student03::getTotalScore, Integer::sum));
		
		Optional<Student03> topStudent = Stream.of(stuArr)
				.collect(Collectors.maxBy(Comparator.comparing(Student03::getTotalScore)));
		
		IntSummaryStatistics stat = Stream.of(stuArr)
				.collect(Collectors.summarizingInt(Student03::getTotalScore));
		
		String stuNames2 = Stream.of(stuArr)
				.map(Student03::getName)
				.collect(Collectors.joining(",","[","]"));
		System.out.println(stuNames2);
	}
}
class Student03 implements Comparable<Student03> {
	String name;
	int ban;
	int totalScore;

	Student03(String name, int ban, int totalScore) { 
		this.name =name;
		this.ban =ban;
		this.totalScore =totalScore;
	}

	public String toString() { 
	   return String.format("[%s, %d, %d]", name, ban, totalScore).toString(); 
	}

	String getName() { return name;}
	int getBan() { return ban;}
	int getTotalScore() { return totalScore;}

	public int compareTo(Student03 s) {
		return s.totalScore - this.totalScore;
	}
}
