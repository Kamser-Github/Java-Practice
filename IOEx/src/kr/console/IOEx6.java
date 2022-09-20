package kr.console;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx6 {
	public static void main(String[] args) {
		
		
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		byte[] showArray = null;
		
		try {
			fis = new FileInputStream("src/kr/filetxt/data.dat");
			bos = new ByteArrayOutputStream();
			byte[] tmp = new byte[fis.available()];
			fis.read(tmp);
			bos.write(tmp);
			showArray = bos.toByteArray();
		} catch (IOException e) {
			System.out.println("오류");
		}
		
		System.out.println(Arrays.toString(showArray));
	}
}
