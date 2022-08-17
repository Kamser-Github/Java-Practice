package stream;
import java.util.Map;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;
import java.util.Set;

class Student12 {
	
	String name;
	boolean isMale; // 성별
	int hak;		// 학년
	int ban;		// 반
	int score;

	Student12(String name, boolean isMale, int hak, int ban, int score) { 
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
		return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남":"여", hak, ban, score); 
	}
	//열거형
	enum Level { HIGH, MID, LOW }
}

public class StreamCollectGroup01 {
	
	public static void main(String[] args) {
		Student12[] stuArr = {
				new Student12("나자바", true,  1, 1, 300),	
				new Student12("김지미", false, 1, 1, 250),	
				new Student12("김자바", true,  1, 1, 200),	
				new Student12("이지미", false, 1, 2, 150),	
				new Student12("남자바", true,  1, 2, 100),	
				new Student12("안지미", false, 1, 2,  50),	
				new Student12("황지미", false, 1, 3, 100),	
				new Student12("강지미", false, 1, 3, 150),	
				new Student12("이자바", true,  1, 3, 200),	
				new Student12("나자바", true,  2, 1, 300),	
				new Student12("김지미", false, 2, 1, 250),	
				new Student12("김자바", true,  2, 1, 200),	
				new Student12("이지미", false, 2, 2, 150),	
				new Student12("남자바", true,  2, 2, 100),	
				new Student12("안지미", false, 2, 2,  50),	
				new Student12("황지미", false, 2, 3, 100),	
				new Student12("강지미", false, 2, 3, 150),	
				new Student12("이자바", true,  2, 3, 200)	
			};
		
		System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
		Map<Integer, List<Student12>> stuByBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student12::getBan));
		//다시 적어보기
		Map<Integer, List<Student12>> stuByBan2 = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student12::getBan));
		//다시 곱씹으면서 적기
		Map<Integer, List<Student12>> stuByBan3 = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student12::getBan));
		//다시 되새김질
		Map<Integer, List<Student12>> stuByBan4 = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student12::getBan));
		//Integer는 groupingBy안의 Function으로 분류를 하고
		//분류를 하면 기본인 toList()로 나누어서 Map에 저장
		
		System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
		Map<Student12.Level,List<Student12>> stuByLevel = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s->{
						 if(s.getScore()>=200) return Student12.Level.HIGH;
					else if(s.getScore()>=100) return Student12.Level.MID;
					else 					   return Student12.Level.LOW;
				}));
		
		//음미해보기
		Map<Student12.Level,List<Student12>> stuByLevel2 = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s->{
					if(s.getScore()>=200)		return Student12.Level.HIGH;
					else if(s.getScore()>=100)  return Student12.Level.MID;
					else 						return Student12.Level.LOW;
				}
				));
		//다시 음미해보기
		Map<Student12.Level,List<Student12>> stuByLevel3 = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s->{
					if(s.getScore()>=200) return Student12.Level.HIGH;
					else if(s.getScore()>=100) return Student12.Level.MID;
					else 					   return Student12.Level.LOW;
				}
				));
		
		System.out.printf("%n4. 다중그룹화(학년별, 반별)%n");
		Map<Integer,Map<Integer,List<Student12>>> stuByHakAndBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student12::getHak,
						Collectors.groupingBy(Student12::getBan)
						));
		//다시 음미
		Map<Integer,Map<Integer,List<Student12>>> stuByHakAndBan2 = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student12::getHak,
						Collectors.groupingBy(Student12::getBan)
						));
		//다시 음미
		Map<Integer,Map<Integer,List<Student12>>> stuByHakAndBan3 = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student12::getHak,
						Collectors.groupingBy(Student12::getBan)
						));
		
		System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
		Map<Integer,Map<Integer,Student12>> topStuByHakAndBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student12::getHak,
						Collectors.groupingBy(Student12::getBan,
								Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparingInt(Student12::getScore)),
										Optional::get
									)
								)
						));
		//collectingAndThen은 껍데기안에 있는걸 꺼내준다.
		System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
		Map<String,Set<Student12.Level>> stuByScoreGroup = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s-> s.getHak()+"-"+s.getBan(),
						Collectors.mapping(s->{
							if(s.getScore()>=200) return Student12.Level.HIGH;
							else if(s.getScore()>=100) return Student12.Level.MID;
							else		return Student12.Level.LOW;
						},Collectors.toSet()
						)));
		
	}
}
