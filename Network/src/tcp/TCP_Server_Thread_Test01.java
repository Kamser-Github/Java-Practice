package tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server_Thread_Test01 {
	public static void main(String[] args) {
		
		
		Thread portThread1 = new Thread(()->{
			ServerSocket ss = null;;
			try {
				ss = new ServerSocket(10000);
			}catch (IOException e) {}
			try {
				Socket socket = ss.accept();
				DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				
				String str = dis.readUTF();
				System.out.println(str);
				dos.writeUTF("어서오세요");
				dos.flush();
				
				dis.close();
				dos.close();
			}catch (IOException e) {}
			
		});
		Thread portThread2 = new Thread(()->{
			ServerSocket ss = null;;
			try {
				ss = new ServerSocket(20000);
			}catch (IOException e) {}
			try {
				Socket socket = ss.accept();
				DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				
				String str = dis.readUTF();
				System.out.println(str);
				dos.writeUTF("어서오세요");
				dos.flush();
				
				dis.close();
				dos.close();
			}catch (IOException e) {}
			
		});
		portThread1.start();
		portThread2.start();
	}
}
