package tcp;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class TCP_Server_test02 {
	public static void main(String[] args) {
/*
		이 java 파일의 목적
		1.server 1개
		2.client 2개
		3.Client가 server에 접속해서 데이터를 교류하면
		server 소켓 1에서 소켓 2로 넘겨주어
		4.Client 1, 2가 서로 교류하게 하는것. 
*/	
		//포트 2개를 열어야함 포트당 접속가능 IP는 한개
		
		//포트 배정하기
		
		System.out.println("수신 대기중");
		
		Thread run1 = new Thread(()->{
			ServerSocket serverSocket1 = null;
			try {
				serverSocket1 = new ServerSocket(10000);
			}catch (IOException e) {
				System.out.println("소켓을 현재 사용중 입니다.");
			}
			
			try {Socket socket1 = serverSocket1.accept();
			}
			catch(IOException e) {}
			
		});
		Thread run2 = new Thread(()->{
			ServerSocket serverSocket2 = null;
			try {
				serverSocket2 = new ServerSocket(20000);
			}catch (IOException e) {
				System.out.println("소켓을 현재 사용중 입니다.");
			}
			try {Socket socket2 = serverSocket2.accept();
				
			}
			catch(IOException e) {}
		});
		run1.start();
		run2.start();
//		try {
//			//원래대로라면 Tread로 각자 다른곳에서 받아야한다.
//			Socket socket1 = serverSocket1.accept();
//			Socket socket2 = serverSocket2.accept();
//			
//			System.out.println(serverSocket1.getLocalPort()+" 접속 = "+socket1.getInetAddress()+":"+socket1.getPort());
//			System.out.println(serverSocket2.getLocalPort()+" 접속 = "+socket2.getInetAddress()+":"+socket2.getPort());
//			
//			//IO
//			//Input
//			DataInputStream disPort1 = new DataInputStream(new BufferedInputStream(socket1.getInputStream()));
//			DataInputStream disPort2 = new DataInputStream(new BufferedInputStream(socket2.getInputStream()));
//			
//			//output
//			DataOutputStream dosPort1 = new DataOutputStream(new BufferedOutputStream(socket1.getOutputStream()));
//			DataOutputStream dosPort2 = new DataOutputStream(new BufferedOutputStream(socket2.getOutputStream()));
//			
//			
//		} catch (IOException e) {}
		
	}
}
