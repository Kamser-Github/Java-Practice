import java.util.Optional;

public class TestFile {
	
	public static void main(String[] args) {
		Optional<String> optVal = Optional.<String>empty();
		System.out.println(optVal.toString());
	}
}
