package kr.console;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx01 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		//스코어 총합구하기.
		int sum = 0;
		int score = 0;
		try {
			fis = new FileInputStream("src/kr/filetxt/data.dat");
			dis = new DataInputStream(fis);
			
			while(true) {
				score = dis.readInt();
				System.out.println("점수 : "+score);
				sum+=score;
			}
		} catch (EOFException e) {
			System.out.println("총합은 = "+sum);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dis!=null)
					dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
