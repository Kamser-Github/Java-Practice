package kr.console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.io.OutputStream;
public class SystemStreamEx03 {
	public static void main(String[] args) throws IOException {
		
		//콘솔에 입력한거 다시 콘솔로 바로 출력해보기
		InputStream is = System.in;
		OutputStream os = System.out;
		
		//이제 한국어로 해볼 차례
		//한국어는 문자셋이 중요하다.
		//현재 디폴트 Charset 확인
		System.out.println(Charset.defaultCharset());//UTF-8

		byte[] byteKor = new byte[100];
		int cnt = is.read(byteKor);
		os.write(byteKor,3,7);
		os.flush();
		System.out.println("count = "+cnt);
		//한국어를 읽으려면 무조건 줄을 한꺼번에 다 일어야한다.
		
	}
}
