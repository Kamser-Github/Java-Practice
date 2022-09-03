package kr.console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.io.OutputStream;
public class SystemStreamEx01 {
	public static void main(String[] args) throws IOException {
		//콘솔창에 입력을 하면
		//그걸 받아와서 저장하고
		//그걸 다시 print해보기
		InputStream is = System.in;
		int data=0;
		while((data=is.read())!='\r') {
			System.out.print((char)data);
		}
		is.read();
		/*
		 ab dffef adfasfsa fsd fas fdsa fa fa da
		 ab dffef adfasfsa fsd fas fdsa fa fa da
		 엔터 치기 전까지 다 입력이 된다.
		*/
		System.out.println();
		
		byte[] byteArray1 =  new byte[100]; 
		int cnt = is.read(byteArray1);
		//cnt에는 \r \n도 포함되어잇다
		String str = new String(byteArray1,0,cnt,Charset.forName("UTF-8"));
		System.out.print(str+"count : "+cnt);
		//asdf 입력 = > conunt : 6;
		System.out.println();
		//출력해보기
		OutputStream os = System.out;
		os.write('a');
		os.write('a');
		os.write('a');
		os.write('a');
		os.flush();
		System.out.println();
		os.write(byteArray1);
		os.flush();
		
		
		
	}
}
