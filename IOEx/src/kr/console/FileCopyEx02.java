package kr.console;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileCopyEx02 {
	
	public static void main(String[] args) throws IOException {
		//파일 포멧을 한번에 대량으로 변경해보기.
		//File[] files = 파일객체.listFiles()
		//연습 시작
		File file = new File("src/kr/copytest");
		System.out.println(file.exists());//true
		File[] files = file.listFiles();
		for(int i=0; i<files.length ;i++) {
			System.out.println(files[i].getName());
		}
		
		//파일명 추출 완료.
		
		//꺼낸 파일명으로 파일 객체를 만들어야하는데..
		//꺼낼 필요가 없지
		//파일객체[0]~ [length-1]까지 반복문으로 꺼내오고
		//그걸 다시 불러서 조합하기.
		//그걸 다시 분해하기.
		//그걸 다시 복사해서 붙여넣기.
		for(int i=0 ; i<files.length ; i++) {
			byte[] copy = new byte[10000];
			InputStream fis = new FileInputStream(files[i]);
			OutputStream fos = new FileOutputStream(files[i].getParent()+"/n"+files[i].getName());
			int cnt = fis.read(copy);
			String str = new String(copy,0,cnt,Charset.forName("MS949"));
			byte[] change = str.getBytes(Charset.forName("UTF-8"));
			fos.write(change);
		}
		
		//성공.. 뿌듯..
	}
}
