package kr.console;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO_Ex01 {
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("C:\\kamser\\workspace_java\\IOEx\\src\\kr\\filetxt\\onlyKor.txt");
			System.out.println(fis.available());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
