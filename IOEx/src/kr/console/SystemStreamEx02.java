package kr.console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.io.OutputStream;
public class SystemStreamEx02 {
	public static void main(String[] args) throws IOException {
		
		//콘솔에 입력한거 다시 콘솔로 바로 출력해보기
		InputStream is = System.in;
		OutputStream os = System.out;
		
		byte[] byteArray = new byte[100];
		
		int cnt = is.read(byteArray);
		//콘솔에서 읽은 정보의 byte 개수는
		//cnt에 저장되고 정보는 배열에 숫자로 기록
		os.write(byteArray);
		os.flush();
		
		//굳
		
	}
}
