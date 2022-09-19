package kr.console;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx01 {
	public static void main(String[] args) {
		File file = new File("src/kr/filetxt/test1.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos,5);
			for(int i='1'; i<='9'; i++) {
				bos.write(i);
			}
			fos.close();
		} catch (IOException e) {
			System.out.println("저장 실패");
		}
		//12345
	}
}
