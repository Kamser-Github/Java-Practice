package kr.console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx4 {
	public static void main(String[] args) {
		byte[] inSrc = {1,2,3,4,5,6,7,8,9,10};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream bis = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int data;
		try {
			while(bis.available()>0) {
				data = bis.read(temp);
				bos.write(temp,0,data);
				outSrc = bos.toByteArray();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(Arrays.toString(outSrc));
		
	}
}
