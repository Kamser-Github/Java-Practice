import java.io.File;
import java.util.stream.Stream;

public class StreamEx04 {
	public static void main(String[] args) {
		File[] fileArr = { 
				new File("Ex1.java"), 
				new File("Ex1.bak"),
				new File("Ex2.java"), 
				new File("Ex1"), 
				new File("Ex1.txt")
			};
		
		Stream<File> fileStream = Stream.of(fileArr);
		//이름만 출력, 중복제거, java파일만
		fileStream.map(File::getName)
				  .filter(s->s.indexOf('.')!=-1)
				  .map(s->s.substring(s.indexOf('.')+1))
				  .map(String::toUpperCase)
				  .distinct()
				  .forEach(System.out::print);
	}
}
