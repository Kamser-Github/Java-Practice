package stream;

import java.util.stream.Stream;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

class Student {
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	Student(String name,boolean isMale,int hak ,int ban,int score){
		this.name	= name;
		this.isMale	= isMale;
		this.hak	= hak;
		this.ban	= ban;
		this.score  = score;
	}
	String	getName()  { return name;}
	boolean isMale()   { return isMale;}
	int		getHak()   { return hak;}
	int		getBan()   { return ban;}
	int		getScore() { return score;}
	
	public String toString() {
		return String.format("[%s, %s, %d학년 %d반, %3d점]",
				name, isMale ? "남" : "여" , hak , ban , score);
	}
	
	//groupingBy()에서 사용 예정
	enum Level { HIGH , MID , LOW } //성적을 상,중.하
}

public class StreamCollectEx1 {
	
	public static void main(String[] args) {
		
		Student[] stuArr = {
				new Student("나자바", true,  1, 1, 300),	
				new Student("김지미", false, 1, 1, 250),	
				new Student("김자바", true,  1, 1, 200),	
				new Student("이지미", false, 1, 2, 150),	
				new Student("남자바", true,  1, 2, 100),	
				new Student("안지미", false, 1, 2,  50),	
				new Student("황지미", false, 1, 3, 100),	
				new Student("강지미", false, 1, 3, 150),	
				new Student("이자바", true,  1, 3, 200),	
				new Student("나자바", true,  2, 1, 300),	
				new Student("김지미", false, 2, 1, 250),	
				new Student("김자바", true,  2, 1, 200),	
				new Student("이지미", false, 2, 2, 150),	
				new Student("남자바", true,  2, 2, 100),	
				new Student("안지미", false, 2, 2,  50),	
				new Student("황지미", false, 2, 3, 100),	
				new Student("강지미", false, 2, 3, 150),	
				new Student("이자바", true,  2, 3, 200)	
			};
		
		System.out.println("1. 단순분할(성별로 분할)");
		Map<Boolean,List<Student>> stuBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(Student::isMale));
		//Map.get(boolean key)를 입력해서 리스트를 받아옴
		List<Student> maleStudent	= stuBySex.get(true);
		List<Student> femaleStudent = stuBySex.get(false);
		
		//System.out.println(maleStudent); 쭉 붙어서 나온다.
		for(Student a : maleStudent) {
			System.out.println(a);
		}
		for(Student a : femaleStudent) {
			System.out.println(a);
		}
		
		System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
		Map<Boolean,Long> stuNumSex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(
						Student::isMale,Collectors.counting()));
		//두번째 조건으로도 값이 들어가진다.
		System.out.println("남학생 수 :"+stuNumSex.get(true));
		System.out.println("여학생 수 :"+stuNumSex.get(false));
		
		System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
		Map<Boolean,Optional<Student>> topStuScoreSex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(
						Student::isMale,
						Collectors.maxBy(Comparator.comparing(Student::getScore))));
				//maxBy는 Comparator를 구현한 애가 오거나
				//그게 아니면 comparing으로 기준값을 정해주면된다.
		System.out.println("남학생 1등 : "+topStuScoreSex.get(true).orElse(null));
		//만약에 학생이 없어서 null이 발생할경우 orElse(null)을 넣어줘서 null이 출력되게한다,
		System.out.println("여학생 1등 : "+topStuScoreSex.get(false).orElse(null));
		
		System.out.printf("%n4. 다중분할(성별 , 불합격자 100점이하)%n");
		
		Map<Boolean,Map<Boolean,Long>> failedStuSex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(
						Student::isMale,
						Collectors.partitioningBy(
								s->s.getScore()<100,
								Collectors.counting())));
		System.out.println("남자 불합격자 수 : "+failedStuSex.get(true).get(true));
		System.out.println("여자 불합격자 수 : "+failedStuSex.get(false).get(true));
		
	}
}
