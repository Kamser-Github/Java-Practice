package stream;

import java.util.stream.Stream;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Optional;

class Student11 {
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	Student11(String name,boolean isMale,int hak ,int ban,int score){
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
public class StreamCollectEx2 {
	public static void main(String[] args) {
		Student11[] stuArr = {
				new Student11("나자바", true,  1, 1, 300),	
				new Student11("김지미", false, 1, 1, 250),	
				new Student11("김자바", true,  1, 1, 200),	
				new Student11("이지미", false, 1, 2, 150),	
				new Student11("남자바", true,  1, 2, 100),	
				new Student11("안지미", false, 1, 2,  50),	
				new Student11("황지미", false, 1, 3, 100),	
				new Student11("강지미", false, 1, 3, 150),	
				new Student11("이자바", true,  1, 3, 200),	
				new Student11("나자바", true,  2, 1, 300),	
				new Student11("김지미", false, 2, 1, 250),	
				new Student11("김자바", true,  2, 1, 200),	
				new Student11("이지미", false, 2, 2, 150),	
				new Student11("남자바", true,  2, 2, 100),	
				new Student11("안지미", false, 2, 2,  50),	
				new Student11("황지미", false, 2, 3, 100),	
				new Student11("강지미", false, 2, 3, 150),	
				new Student11("이자바", true,  2, 3, 200)	
			};
		System.out.println("1. 단순분할(성별로 분할)");
		Map<Boolean,List<Student11>> stuBySex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(
						Student11::isMale));
		List<Student11> stuMale = stuBySex.get(true);
		List<Student11> stuFemale = stuBySex.get(false);
		for(Student11 a : stuMale) {
			System.out.println(a);
		}
		
		System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
		Map<Boolean,Long> stuCounting = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(
						Student11::isMale,
						Collectors.counting()));
		//두번째 조건으로 값이 들어가진다.
		System.out.println("남학생수 : "+stuCounting.get(true));
		System.out.println("여학생수 : "+stuCounting.get(false));
		
		System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
		Map<Boolean,Student11> topStuSex = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(
						Student11::isMale,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Student11::getScore)), 
								Optional<Student11>::get)));
		System.out.println(topStuSex.get(true));
		System.out.println(topStuSex.get(false));
		
		System.out.printf("%n4. 다중분할(성별 , 불합격자 100점이하)%n");
		Map<Boolean,Map<Boolean,Long>> failedStu = Stream.of(stuArr)
				.collect(Collectors.partitioningBy(
						Student11::isMale,
						Collectors.partitioningBy(s->s.getScore()<=100,
								Collectors.counting())));
		System.out.println(failedStu.get(true).get(true));
	}
}
