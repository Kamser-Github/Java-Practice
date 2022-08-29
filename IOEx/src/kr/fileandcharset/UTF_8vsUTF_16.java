package kr.fileandcharset;

import java.nio.charset.Charset;

public class UTF_8vsUTF_16 {

	public static void main(String[] args) {
		
		String str = "Burger King";
		//중간에 구분자 넣어봤다.
		byte[] b1 = str.getBytes();
		byte[] b2 = str.getBytes(Charset.forName("UTF-16"));
		
		System.out.println(b1.length);//11
		System.out.println(b2.length);//24 
		
		System.out.println("UTF-8");
		for(byte b : b1) {
			System.out.printf("%02X ",b);
		}
		System.out.println();
		System.out.println("=====");
		System.out.println("UTF-16");
		for(byte b : b2) {
			System.out.printf("%02X ",b);
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		String str2 = "BIG 간장삼겹 덮밥";
		//중간에 구분자 넣어봤다.
		byte[] b3 = str2.getBytes();
		byte[] b4 = str2.getBytes(Charset.forName("UTF-16"));
		
		System.out.println(b3.length);//11
		System.out.println(b4.length);//24 
		
		System.out.println("UTF-8");
		for(byte b : b3) {
			System.out.printf("%02X ",b);
		}
		System.out.println();
		System.out.println("=====");
		System.out.println("UTF-16");
		for(byte b : b4) {
			System.out.printf("%02X ",b);
		}
	}

}
