package kr.fileandcharset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
public class EUCKRvsMS949 {
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		
		//EUC-KR vs MS949
		byte[] b1 = "apple".getBytes();
		byte[] b2 = "apple".getBytes("EUC-KR");
		byte[] b3 = "apple".getBytes(Charset.forName("MS949"));
		
		//b2,b3 = 10 b1=15
		System.out.println(b1.length); //5
		System.out.println(b2.length); //5
		System.out.println(b3.length); //5
		//EUC-KR,MS949,UTF-8모두 ASCII는 1byte로 인식
		
		System.out.println(new String(b1));
		System.out.println(new String(b2,"EUC-KR"));
		System.out.println(new String(b1,2,2)); //pl //디폴트만 가능
		System.out.println(new String(b3,"EUC-KR"));
		System.out.println(new String(b3,"MS949"));
		System.out.println(new String(b3));
		System.out.println(new String(b3,"UTF-16"));//error
		//아스키 코드같은 영우에는 공통이기 때문에 아무 상관이 없다.
		
		String str = "강아지봷꿺";
		byte[] h1 = str.getBytes();
		byte[] h2 = str.getBytes("EUC-KR");
		byte[] h3 = str.getBytes("MS949");
		byte[] h4 = str.getBytes("UTF-16");
		
		System.out.println(h1.length); //15
		System.out.println(h2.length); //8
		System.out.println(h3.length); //10
		System.out.println(h4.length); //12
		
		System.out.println(new String(h2,"MS949"));
		System.out.println(new String(h1,"UTF-16"));
		System.out.println(new String(h1,3,3));
		
		for(int i=0 ; i<h1.length ; i+=3) {
			System.out.print(new String(h1,i,3)+" ");
		}
	}
}
