package tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Tcp_Ip_Client_Test05 {
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("127.0.0.1",8888);
			
			Sender2 sender = new Sender2(socket);
			Receiver2 receiver = new Receiver2(socket);
			
			sender.start();
			receiver.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
