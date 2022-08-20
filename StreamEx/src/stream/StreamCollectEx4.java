package stream;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student20 {
	String name;
	boolean isMale;
	int hak;
	int ban;
	int score;
	
	Student20(String name,boolean isMale,int hak,int ban,int score){
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban	= ban;
		this.score  = score;
	}
	
	String getName() { return name; }
	boolean isMale() { return isMale; }
	int getHak() 	 { return hak;   }
	int getBan() 	 { return ban;  }
	int getScore()   { return score; }
	
	public String toString() {
		return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남":"여", hak, ban, score); 
	}
	enum Level {
		HIGH, MID, LOW
	}
}


public class StreamCollectEx4 {
	public static void main(String[] args) {
		Student20[] stuArr = {
				new Student20("나자바", true,  1, 1, 300),	
				new Student20("김지미", false, 1, 1, 250),	
				new Student20("김자바", true,  1, 1, 200),	
				new Student20("이지미", false, 1, 2, 150),	
				new Student20("남자바", true,  1, 2, 100),	
				new Student20("안지미", false, 1, 2,  50),	
				new Student20("황지미", false, 1, 3, 100),	
				new Student20("강지미", false, 1, 3, 150),	
				new Student20("이자바", true,  1, 3, 200),	
				new Student20("나자바", true,  2, 1, 300),	
				new Student20("김지미", false, 2, 1, 250),	
				new Student20("김자바", true,  2, 1, 200),	
				new Student20("이지미", false, 2, 2, 150),	
				new Student20("남자바", true,  2, 2, 100),	
				new Student20("안지미", false, 2, 2,  50),	
				new Student20("황지미", false, 2, 3, 100),	
				new Student20("강지미", false, 2, 3, 150),	
				new Student20("이자바", true,  2, 3, 200)	
			};
		System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
		Map<Integer,List<Student20>> stuByBan = Stream.of(stuArr)
				.collect(Collectors.groupingBy(Student20::getBan));
		
		for(List<Student20> ban : stuByBan.values()) {
			for(Student20 stu : ban) {
				System.out.println(stu.getName());
			}
		}
		System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
		Map<Student20.Level,List<Student20>> stuScore = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s->{
						 if(s.getScore()>=200) return Student20.Level.HIGH;
					else if(s.getScore()>=100) return Student20.Level.MID;
					else					   return Student20.Level.LOW;
				}));
		
//		Map<Student20.Level,List<Student20>> stuScore2 = Stream.of(stuArr)
//				.collect(Collectors.groupingBy(s->{
//					if(s.getScore()>=200) return Student20.Level.HIGH;
//					else if(s.getScore()>=100) return Student20.Level.MID;
//					else						return Student20.Level.LOW;
//				}));
//		Map<Integer,List<Student20>> stuHak = Stream.of(stuArr)
//				.collect(Collectors.groupingBy(s->{
//					if(s.getHak()<2) return 1;
//					else 			 return 2;
//				}));
		TreeSet<Student20.Level> keySet = new TreeSet<>(stuScore.keySet());
		for(Student20.Level key : keySet) {
			System.out.println("["+key+"]");
			
			for(Student20 stu : stuScore.get(key)) {
				System.out.println(stu);
			}
			System.out.println();
		}
		//오류가 왜 생기는 걸까
		
		Map<String,List<Student20>> newList = Stream.of(stuArr)
				.collect(Collectors.groupingBy(s->{
					return s.getHak()+"_"+s.getBan();
				}));
		
		for(String a : newList.keySet()) {
			System.out.println(a);
			for(Student20 stu : newList.get(a)) {
				System.out.println(stu);
			}
		}
		
		
	}
}
