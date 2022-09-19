package kr.console;

import java.io.*;

public class DataOutputStreamEx01 {
	public static void main(String[] args) {
		FileOutputStream fos;
		DataOutputStream dos;
		
		try {
			fos = new FileOutputStream("src/kr/filetxt/data.dat");
			dos = new DataOutputStream(fos);
			
			dos.writeInt(12);
			dos.writeFloat(1.2f);
			dos.writeBoolean(false);
			
			dos.close();
		} catch (IOException e) {}
	}
}
