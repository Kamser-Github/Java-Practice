package kr.console;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.io.OutputStream;

public class CombineFilterEX01 {
	public static void main(String[] args) {
		//필터 2개 써보기
		File file = new File("src/kr/filetxt/prData.data");
		System.out.println(file.exists());
		
		//FileOutputStream.Buffered를 끼얹고 ,Data로 마무리하는
		try(OutputStream os = new FileOutputStream(file,true);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			DataOutputStream dos = new DataOutputStream(bos);)
		{
			dos.writeInt(550);
			dos.writeDouble(13.4);
			dos.writeUTF("행복");
			dos.writeFloat(550);
			dos.writeChar('a');
			dos.writeBoolean(true);
			dos.flush();
			
		}catch(IOException e) {}
		
		
		//이렇게 필터 여러개를 사용이 가능한데 
		//중요한건 마지막 필터의 메서드를 어느걸 쓸거냐에 따라서
		//필터 순서가 중요해진다.
		
		//읽어보기
		try(InputStream is = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(is);
			DataInputStream dis = new DataInputStream(bis)){
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
			System.out.println(dis.readFloat());
			System.out.println(dis.readChar());
			System.out.println(dis.readBoolean());
		}catch(IOException e) {}
		
		//순서가 중요해진다.
	}
}
