package stream;
import java.util.stream.Stream;
import java.io.File;
public class StreamMapEx1 {
	
	public static void main(String[] args) {
		
		File[] fileArr = {
					new File("Ex1.java"),
	                new File("Ex1"),
	                new File("Ex1.bak"),
	                new File("Ex2.java"),
	                new File("Ex1.txt")
			};
		Stream<File> fileStream = Stream.of(fileArr);
		
		//map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<String> filenameStream = fileStream.map(File::getName);
		filenameStream.forEach(System.out::println);
		
		//이제 filenameStream은 사용하지 못한다.
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
				  .filter(s->s.indexOf('.')!=-1)
				  .map(s->s.substring(s.indexOf('.')+1))
				  .map(String::toUpperCase)
				  .distinct()
				  .forEach(System.out::println);
		System.out.println();
				  
		fileStream = Stream.of(fileArr);
		//자바인 파일만 파일명으로 꺼내기
		fileStream.map(File::getName)
				  .filter(s->s.indexOf(".java")!=-1)
				  .map(s->s.substring(0, s.indexOf(".java")))
				  .forEach(System.out::println);
	}
}