package kr.console;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx3 {
	public static void main(String[] args) throws IOException {
		
		byte[] input = {1,2,3,4,5,6,7,8,9,10};
		byte[] output = null;
		byte[] temp = new byte[input.length];
		byte[] temp2 = new byte[input.length];
		byte[] output2 = null;
		ByteArrayInputStream bai = new ByteArrayInputStream(input);
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		
		int data = 0;
		bai.mark(0);
		bai.read(temp,0,temp.length);
		bao.write(temp,5,5);
		
		output = bao.toByteArray();
		
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(output));
		System.out.println(Arrays.toString(temp));
			
		bai.reset();
		bai.read(temp2,0,temp2.length);
		System.out.println("bao length"+bao.size());
		bao.write(temp2,0,temp2.length);
		
		output2 = bao.toByteArray();
		
		System.out.println(Arrays.toString(temp2));
		System.out.println(Arrays.toString(output2));
		
		//뒤에 추가로 누적되서 저장된다.
	}
}
