package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpServerTest01 {
	
	HashMap<String,DataOutputStream> clients;
	
	public TcpIpServerTest01() {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
	}
	
	public static void main(String[] args) {
		/*
		 * 서로 채팅 치게하려면
		 * Clinet 1 -> out -> Client2(Socket.in) 되어야하는거니까
		 * 실시간으로 되려면
		 * 쓰레드로 client1 쓰는거 받는거 따로 thread로 나누고
		 * 마찬가지로 client2도 쓰는거 받는거 따로 thread로 나누고
		 */
		
//		ServerSocket serverSocket = null;
//		Socket socket = null;
//		try {
//			serverSocket = new ServerSocket(10000);
//			System.out.println("연결중입니다...");
//			while(true) {
//				socket = serverSocket.accept();
//				System.out.println("연결 완료입니다.");
//				
//			}
//		}catch(IOException e) {}
	}
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("서버가 열렸습니다.");
			while(true) {
				socket = serverSocket.accept();
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+" 접속");
				
			}
		}catch(IOException e) {}
	}
	
	public void outChatAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();
		while(it.hasNext()) {
			try {
				DataOutputStream out = clients.get(it.next());
				out.writeUTF(msg);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	class ReceiverTwo extends Thread {
		DataOutputStream out;
		Socket socket;
		String name;
		
		ReceiverTwo(Socket socket){
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				name = "["+socket.getInetAddress()+"]";
			} catch (IOException e) {}
		}
		
		public void run() {
			clients.put(name,out);
			DataInputStream in = null;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			while(out!=null) {
				try {
					outChatAll(in.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

