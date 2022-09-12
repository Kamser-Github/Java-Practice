package tcp;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
public class TCP_Server_test01 {
	public static void main(String[] args) {
		System.out.println("<<server>>");
		ServerSocket serverSocket = null;
		try {
		serverSocket = new ServerSocket(10000);
		} catch (IOException e) {
			System.out.println("해당 포트를 사용할수 없습니다.");
			System.exit(0);
		}
		System.out.println("접속 대기중");
		try {
		Socket socket = serverSocket.accept();
		System.out.println("Client 연결 수락");
		System.out.println("접속 Client 주소"+socket.getInetAddress()+":"+socket.getPort());
		DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		
		System.out.println(socket.getInetAddress()+":"+socket.getPort());
		String str = dis.readUTF();
		System.out.println(str);
		dos.writeUTF("어서오세요");
		dos.flush();
		} catch (IOException e) {}
		
	}
}
