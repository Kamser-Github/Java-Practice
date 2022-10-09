package kr.fileandcharset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) {
		String ansi = "C:/Users/yousd/Desktop/ms949.txt";
		final int NOT_UTF8 = 65533;
		File file = new File(ansi);
		
		boolean isUTF8 = true;
		
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		FileReader fr = null;
//		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)){
			 while(br.ready()&&isUTF8) {
				 String checkCharset = br.readLine();
				 final int CHECK_LENGTH = checkCharset.length();
				 /*
				  * 파일을 읽어서
				  * 거기서 char일 비교해서 하나라도 65533이면
				  * ms949로 문자셋을 변경해서 일기
				  */
				 for(int i=0 ; i<CHECK_LENGTH ;i++) {
					if(checkCharset.charAt(i)==NOT_UTF8) {
						isUTF8=false;
						break;
					}
				 }
				 System.out.println(isUTF8);
			 }
			 if(!isUTF8) {
				//MS949로 돌리기
				 fis = new FileInputStream(file);
				 isr = new InputStreamReader(fis,"MS949");
//				 br = new BufferedReader(isr);
				 fos = new FileOutputStream(file);
				 osw = new OutputStreamWriter(fos,"UTF-8");
				 bw = new BufferedWriter(osw);
				 while(br.ready()) {
					 bw.write(br.readLine());
				 }
			 }
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("읽기 실패");
		}
	}
}
