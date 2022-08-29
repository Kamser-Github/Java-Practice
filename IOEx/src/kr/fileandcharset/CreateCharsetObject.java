package kr.fileandcharset;

import java.nio.charset.Charset;

public class CreateCharsetObject {
	public static void main(String[] args) {
		
		Charset cs0 = Charset.defaultCharset();
		//현재 기본이 UTF-8이다.
		Charset cs1 = Charset.forName("UTF-16");
		Charset cs2 = Charset.forName("MS949");
		Charset cs3 = Charset.forName("EUC-KR");
		
		System.out.println(cs0);
		System.out.println(cs1);
		System.out.println(cs2);
		System.out.println(cs3);
		
		System.out.println("*******");
		
		System.out.println(Charset.isSupported("UTF-16"));
		System.out.println(Charset.isSupported("MS949"));
		System.out.println(Charset.isSupported("EUC-KR"));
	}
}
