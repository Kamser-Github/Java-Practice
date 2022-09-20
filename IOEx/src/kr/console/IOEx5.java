package kr.console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx5 {
	public static void main(String[] args) {
		
		//ByteArrayOutputStream. 재 복습
		
		byte[] input = {1,2,3,4,5,6,7,8,9,10,11};
		byte[] output = null;
		byte[] temp = null;
		
		ByteArrayInputStream bis = new ByteArrayInputStream(input);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int data = 0;
		
		data = bis.read(input,0,5);
		bos.write(input,0,5);
		System.out.println("temp = "+Arrays.toString(bos.toByteArray()));
		bos.write(input,1,4);
		System.out.println("temp = "+Arrays.toString(bos.toByteArray()));
		bos.write(input,2,3);
		System.out.println("temp = "+Arrays.toString(bos.toByteArray()));
		bos.write(input,3,3);
		System.out.println("temp = "+Arrays.toString(bos.toByteArray()));
		
		
		output = bos.toByteArray();
		
		System.out.println("output = {"+Arrays.toString(output)+"}");
		System.out.println("bos = {"+Arrays.toString(output)+"}");
	}
}
