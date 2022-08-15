package stream;

import java.util.stream.Stream;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;


public class StreamMayToPrimitiveEx1 {
	
	public static void main(String[] args) {
		Student1[] stuArr = {
				new Student1("둘리", 3, 300),
				new Student1("또치", 1, 200),
				new Student1("희동", 2, 100),
				new Student1("르르", 2, 150),
				new Student1("민아", 1, 200),
				new Student1("새무", 3, 290),
				new Student1("일파", 3, 180)	
			};
		Stream<Student1> stuStream = Stream.of(stuArr);
		IntStream stuScoreStream = stuStream.mapToInt(Student1::getTotalScore);
		//Integer인 값을 int로 변환해서 스트림을 만들엇다.
		
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		//IntSummaryStatistics을 반환하는 매서드
		//IntSummaryStatistics 변수로
		//count,sum,min.max가 들어있어서
		//get으로 제한없이 추출 가능하다.
		
		System.out.println("count = "+stat.getCount());
		System.out.println("sum="+stat.getSum());
		System.out.printf("average=%.2f%n", stat.getAverage());
		System.out.println("min="+stat.getMin());
		System.out.println("max="+stat.getMax());
		
		//원래 이 매서드가 없었으면
		//한번쓰고 다시 충전하고 다시 써야하는데
		//클래스로 반환해서 계속 사용이 가능하다.
		
	}
}

class Student1 implements Comparable<Student1>{
	
	String name;
	int ban;
	int totalScore;
	Student1(String name, int ban,int totalScore){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d ,%d]%n", name,ban,totalScore);
	}
	
	String getName()		{ return name; }
	int getBan()			{ return ban; }
	int getTotalScore()		{ return totalScore; }
	@Override
	public int compareTo(Student1 s) {
		return s.totalScore-this.totalScore;
	}
}