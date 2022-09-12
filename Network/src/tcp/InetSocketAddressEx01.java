package tcp;
import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetSocketAddressEx01 {
	public static void main(String[] args) throws UnknownHostException {
/*
		 IP주소(호스트이름)+Port번호 관리하는 추상클래스
		 InetSocketAddress extends SocketAddress(abstract)
*/	
		//#1 InetAddress 객체 생성
		//IP를 저장하는 InetAddress는 정적메서드를 이용해서 객체생성
		InetAddress ia = InetAddress.getByName("www.google.com");
		int port = 10000;
		
		InetSocketAddress isa = new InetSocketAddress(port);
		InetSocketAddress isa2 = new InetSocketAddress(ia,port);
		InetSocketAddress isa3 = new InetSocketAddress("www.google.com",port);
		
		System.out.println(isa);//0.0.0.0/0.0.0.0:10000
		System.out.println(isa2);//www.google.com/142.251.220.36:10000
		System.out.println(isa3);//www.google.com/142.251.220.36:10000
		System.out.println();
		
		//#2.InetAddress 메서드
		System.out.println(isa2.getAddress());
		System.out.println(isa2.getHostName());//www.google.com
		System.out.println(isa2.getPort());//10000
	}
}
