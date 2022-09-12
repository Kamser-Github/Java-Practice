package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tcp_Ip_Server01 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//서버소켓을 생성하여 7777번 포트와 bind 시킨다.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"서버가 준비되었습니다.");
		} catch (IOException e) {}
		
		try {
			System.out.println(getTime()+"연결요청을 기다리고 있습니다.");
			Socket socket = serverSocket.accept();
			
			//소켓의 입력 / 출력 스트림을 얻는다.
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			//원격 소켓(remote socket)에 데이터 주고받는다.
			System.out.println(dis.readUTF());
			dos.writeUTF("[Notice] Test Message1");
			System.out.println(getTime()+"데이터를 전송했습니다.");
			
			//소켓닫기
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {}
		
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
