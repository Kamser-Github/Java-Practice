package tcp;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.SocketException;
public class TCP_Socket_SeverSocketEx2 {
	public static void main(String[] args) {
/*
		Binding vs. Connect
		-Binding은 수신 호스트에서 연결요청이 들어온 경우
		 		  해당 데이터를 전달할 연결 포트를 지정해주는것
		-Connect는 원격지 특정 주소로 연결을 수행하는것.
		 
*/
		//ServerSocket TCP 통신에서 Socket으로부터의
		//연결 요청을 수락하는 서버역할의 클래스
		
		//#1. ServerSocket 객체 생성
		ServerSocket serverSocket1 = null;
		ServerSocket serverSocket2 = null;
		try {
			//특정포트 바인딩없이 단순히 객체만 생성(추후 binding필요)
			serverSocket1 = new ServerSocket();
			//매개변수로 입력된 port로 바인딩된 ServerSocket 생성
			//ServerSocket으로 연결요청이 오면 바인딩된 port로 전달
			serverSocket2 = new ServerSocket(20000);
		} catch (IOException e) {}
		
		//#2.ServerSocket 매서드
		//@binding
		System.out.println(serverSocket1.isBound());//false
		System.out.println(serverSocket2.isBound());//true;
		//io.File에서는 exists() 원격지가 연결되어있는지는 isConnected();
		try {
			serverSocket1.bind(new InetSocketAddress("127.0.0.1",10000));
		} catch (IOException e) {}
		System.out.println(serverSocket1.isBound());//true
		System.out.println(serverSocket2.isBound());//true
		
		//@사용중인 TCP포트 확인하기(CMD : netstat -a)
		/*
		for(int i=0 ; i<65536 ; i++) {
			try {
				ServerSocket serverSocket = new ServerSocket(i);
			} catch (IOException e) {
				System.err.println(i+"번째 포트 사용중...");
			}
		}
		*/
		//@accept() /setSotimeout() / getSoTimeout()
		//Client로부터 TCP 접속대기 (일반적으로 쓰레드 사용)
		try {
			serverSocket1.setSoTimeout(2000);
/*
			연결요청 리스닝 시간 : 
			Socket으로 부터의 연결요청을 리스닝(listening)하는 시간의 설정 및 가져오기
			setSoTimeout(0) 무한대기 상태.
*/
		} catch (SocketException e) {}
		try {
			Socket socket = serverSocket1.accept();
/*
			연결요청 수락:
			연결요청이 수락 된 후 통신을 위한 Socket 객체리턴
			(연결수락까지 설정된 timeout 시간만큼 blocking) 
*/
		} catch (IOException e) {
			try {
				System.out.println(serverSocket1.getSoTimeout()+"ms 시간이 지나 종료");
			} catch (IOException e1) {}
		}
	}
}
