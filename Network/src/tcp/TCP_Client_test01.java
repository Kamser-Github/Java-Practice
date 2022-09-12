package tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Client_test01 {
	public static void main(String[] args) {
		InetAddress ia = null;
		try {
		ia = InetAddress.getByAddress("MyIP",new byte[] {127,0,0,1});
		} catch(UnknownHostException e) {}
		
		System.out.println("<<Client>>");
		Socket socket = null;
		try {
			socket = new Socket(ia,10000);
			System.out.println("접속완료");
			System.out.println("접속 주소 server:"+socket.getInetAddress()+":"+socket.getPort());
			DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			
			dos.writeUTF("안녕하세요");
			dos.flush();
			String str = dis.readUTF();
			
			System.out.println("server : "+str);
		}catch (IOException e) {}
		
	}
}
