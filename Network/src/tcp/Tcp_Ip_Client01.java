package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class Tcp_Ip_Client01 {
	public static void main(String[] args) {
		
		try {
			String serverIp = "127.0.0.1";
			
			System.out.println("서버에 연결중입니다. 서버 IP:"+serverIp);
			//소켓을 생성하여 연결을 요청
			Socket socket = new Socket(serverIp,7777);
			
			//소켓으로 입력스트립을 얻는다.
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			//소켓으로 출력스트림을 얻는다.
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			//데이터를 보내고 받는다.
			dos.writeUTF("안녕하세요 !!");
			dos.flush();
			
			//데이터를 받는다.
			String str = dis.readUTF();
			System.out.println("서버로부터 받은 메세지 :"+str);
			System.out.println("연결을 종료합니다.");
			
			//스트림과 소켓을 닫는다.
			dis.close();
			dos.close();
			socket.close();
			System.out.println("연결이 종료되었습니다.");
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(IOException ie){
			ie.printStackTrace();
		}
		
		
	}
}
