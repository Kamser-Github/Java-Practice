package kr.console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx2 {
	public static void main(String[] args) {
		byte[] inSrc = {1,2,3,4,5,6,7,8,9};
		byte[] outSrc = new byte[inSrc.length];
		
		ByteArrayInputStream bis = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int data = 0;
		
		while((data=bis.read())!=-1) {
			bos.write(data);
		}
		
		outSrc = bos.toByteArray();
		System.out.println(Arrays.toString(outSrc));
		System.out.println(Arrays.toString(inSrc));
	}
}
