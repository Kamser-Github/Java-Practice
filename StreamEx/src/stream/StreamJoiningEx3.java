package stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.List;
import java.util.Map;
import java.util.IntSummaryStatistics;
public class StreamJoiningEx3 {
	
	public static void main(String[] args) {
		
		Student04[] stuArr = {
				new Student04("강라마", 3, 300),
				new Student04("야라마", 1, 200),
				new Student04("고라마", 2, 100),
				new Student04("박라마", 2, 150),
				new Student04("전라마", 1, 200),
				new Student04("이라마", 3, 290),
				new Student04("최라마", 3, 180)	
			};
		//객체 배열을 Stream으로 변환하고 그걸 List로 필요한 부분만 만들기
		//배열을 스트림으로 만든다.
		Stream.of(stuArr);
		//스트림에서 이름으로만 모아논 List<String>을 만들것이다.
		//이름만 따로 꺼내본다.
		Stream.of(stuArr).map(Student04::getName);
		//객체 스트림에서 문자열 스트림으로 변환했다.
		List<String> names = Stream.of(stuArr).map(Student04::getName).toList();
		System.out.println(names);
		//collect()로 변환해본다.
		List<String> names2 = Stream.of(stuArr).map(Student04::getName).collect(Collectors.toList());
		List<String> names3 = Stream.of(stuArr).map(Student04::getName).collect(Collectors.toList());
		
		//Map으로 학생이름,학생 정보로 정보 정리해보기
		Map<String,Student04> map = Stream.of(stuArr)
				.collect(Collectors.toMap(Student04::getName,Function.identity()));
		
		for(String name : map.keySet()) {
			System.out.println(name+" "+map.get(name));
		}
		
		//
		long count = Stream.of(stuArr)
				.collect(Collectors.counting());
		long totalScore = Stream.of(stuArr)
				.collect(Collectors.summingInt(Student04::getTotalScore));
		totalScore = Stream.of(stuArr)
				.collect(Collectors.reducing(0, Student04::getTotalScore, Integer::sum));
		
		IntSummaryStatistics stat = Stream.of(stuArr)
				.collect(Collectors.summarizingInt(Student04::getTotalScore));
		
		String stuNames2 = Stream.of(stuArr)
				.map(Student04::getName)
				.collect(Collectors.joining(",", "[", "]"));
	}
}
class Student04{
	private String name;
	private int ban;
	private int totalScore;
	
	Student04(String name,int ban,int totalScore){
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
	
	
}
