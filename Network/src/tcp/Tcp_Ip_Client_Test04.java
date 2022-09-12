package tcp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Tcp_Ip_Client_Test04 {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			
			//소켓을 생성하여 연결을 요청
			Socket socket = new Socket(serverIp,7777);
			
			System.out.println("서버에 연결 되었습니다.");
			Sender1 sender1 = new Sender1(socket);
			Receiver1 receiver1 = new Receiver1(socket);
			
			sender1.start();
			receiver1.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
