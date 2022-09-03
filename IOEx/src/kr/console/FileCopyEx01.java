package kr.console;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
public class FileCopyEx01 {
	
	public static void main(String[] args) throws IOException {
		//파일 포멧 변경해보기.
		//TXT파일 문자셋 MS949로 저장된걸
		//문자셋 UTF-8로 변경해서 저장
		
		File ms949 = new File("src/kr/filetxt/MS949.txt");
		File utf8 = new File("src/kr/filetxt/UTF-8.txt");
		//있는지 확인
		System.out.println(ms949.exists());//true
		System.out.println(utf8.exists());//true
		//안에 있는 파일 내용을 읽어야한다.
		InputStream fis = new FileInputStream(ms949);
		OutputStream fos = new FileOutputStream(utf8);
		//저장할 파일
		//배운곳까지는 배열의 크기를 정하거나 1byte만 가능하기때문에
		//배열의 크기를 키운다
		byte[] copyArray = new byte[10000];
		int cont = fis.read(copyArray);
		String str = new String(copyArray,0,cont,Charset.forName("MS949"));
		byte[] changeArr = str.getBytes(Charset.defaultCharset());
		fos.write(changeArr);
		
		//성공
	}
}
