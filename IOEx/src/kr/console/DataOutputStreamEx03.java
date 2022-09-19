package kr.console;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx03 {
	public static void main(String[] args) {
		int[] score = { 100 , 90 , 95 , 85 , 50 };
		
		try {
			FileOutputStream fos = new FileOutputStream("src/kr/filetxt/data.dat");
			DataOutputStream dos = new DataOutputStream(fos);
			
			for(int i=0 ; i<score.length ; i++) {
				dos.writeInt(score[i]);
			}
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
/*
	  	data.dat
	  	
	  	00 00 00 64 / 00 00 00 5A / 00 00 00 55 / 00 00 00 32
	  	     100           90            95			   85	
	  	
	  	int 크기가 4byte고 16진수는 두자리가 1byte다.
	  	
	  	반대로 읽어보겠다.
*/
		
	}
}
