package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TCPipServerEx01 {
	HashMap<String,DataOutputStream> clients;
	
	TCPipServerEx01(){
		clients = new HashMap<String,DataOutputStream>();
		Collections.synchronizedMap(clients);
	}
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]");
				ServerReceiver9 thread = new ServerReceiver9();
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void sendToAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)clients.get(it.next());
				out.writeUTF(msg);
			} catch(IOException e) {}
		}
	}
	public static void main(String[] args) {
		new TCPipServerEx01().start();
	}
	
	class ServerReceiver9 extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		ServerReceiver9(Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch(IOException e) {}
		}
		@Override
		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#"+name+"님이 들어오셨습니다.");
				
				clients.put(name,out);
				System.out.println("접속자수"+clients.size());
				
				while(in!= null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {}
			finally {
				sendToAll("#"+name+"님이 나가셨습니다.");
				clients.remove(name);
			}
		}
	}
	
}