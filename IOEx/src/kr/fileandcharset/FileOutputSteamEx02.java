package kr.fileandcharset;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.io.IOException;

public class FileOutputSteamEx02 {
	public static void main(String[] args) throws IOException {
		//작업 폴더 확인
		System.out.println(System.getProperty("user.dir"));
		
		File testFile = new File("src/kr/filetxt/OutOnlyEng.txt");
		//파일 여부 확인
		System.out.println(testFile.exists());//true
		
		//인풋 스트림
		InputStream is = new FileInputStream(testFile);
		
		//read, read byte[] read byte[] offset
//		int data = 0;
//		byte[] byteArray1 = new byte[18];
//		while(data!=-1) {
//			data = is.read(byteArray1);
//			String str ="";
//			if(data>0) 
//				str = new String(byteArray1,0,data,Charset.defaultCharset());
//			System.out.print(str);
//			System.out.println("count = "+is.available());
//		}
	
		int data = 0;
		String str = "고!세!구";
		byte[] arr =str.getBytes();
		System.out.println(arr.length);
		for(int i=0; i<arr.length ; i++) {
			System.out.printf("%X ",arr[i]);
		}
	}
}
