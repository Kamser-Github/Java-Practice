import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEX03 {
	public static void main(String[] args) {
		File[] fileArr = { 
				new File("Ex1.java"), 
				new File("Ex1.bak"),
				new File("Ex2.java"), 
				new File("Ex1"), 
				new File("Ex1.txt")
			};
		
		Stream<File> fileStream = Stream.of(fileArr);
		Stream<String> fileNames = fileStream.map(File::getName);
		fileNames.forEach(System.out::println);
		
		fileStream = Arrays.stream(fileArr);
		
		fileStream.map(File::getName)
				  .filter(e->e.indexOf('.')!=-1)
				  .map(s->s.substring(s.indexOf('.')+1))
				  .map(String::toUpperCase)
				  .distinct()
				  .forEach(System.out::print);
	}
}
