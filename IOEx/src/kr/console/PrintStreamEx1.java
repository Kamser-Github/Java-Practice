package kr.console;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintStreamEx1 {
	public static void main(String[] args) {
		File file = new File("src/kr/filetxt/onlyKor.txt");
		
//		try(OutputStream os = new FileOutputStream(file,true);
//			PrintStream ps = new PrintStream(os);){
//			ps.print("빨리 코딩 잘해지고 싶다.");
//			ps.println("자전거 타고 싶다.");
//			ps.append('ㅁ');
//			ps.println(35+"km 막힘없이 자전거 페달을 밟고");
//		}catch(IOException e) {}
		
//		try( PrintStream ps = new PrintStream(file);){
//			ps.println("핸드폰 z플립 이쁘다.");
//			ps.println(99+"만원");
//			ps.printf("%2d개월 무이자 할부", 22).append('G').format("%S", "12월에 돈이 생긴다");
//		}catch(IOException e) {}
		
		//잘써야겠다.
			PrintStream ps = System.out;
			ps.println("핸드폰 z플립 이쁘다.");
			ps.println(99+"만원");
			ps.printf("%2d개월 무이자 할부", 22).append('G').format("%S", "12월에 돈이 생긴다");
		
	}
}
