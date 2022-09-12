package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Tcp_Ip_Multichat_ServerTest01 {
	//갑자기 심화과정..
	HashMap<String,DataOutputStream> clients;
	
	Tcp_Ip_Multichat_ServerTest01(){
		clients = new HashMap<String,DataOutputStream>();
		Collections.synchronizedMap(clients);
	}
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			
			while(true){
				socket = serverSocket.accept();
				System.out.println(""+socket.getInetAddress()+":"+socket.getPort()+"에서 접속하셨습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//start()
	
	void sendToAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				DataOutputStream dos = clients.get(it.next());
				dos.writeUTF(msg);
			} catch(IOException e) {}
		}//while
	}//sendToAll
	
	public static void main(String args[]) {
		new Tcp_Ip_Multichat_ServerTest01().start();
	}
	
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream dis;
		DataOutputStream dos;
		
		ServerReceiver(Socket socket){
			this.socket = socket;
			try{
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {}
		}
		@Override
		public void run() {
			String name = "";
			try {
				name = dis.readUTF();
				sendToAll("#"+name+"님이 들어오셨습니다.");

				clients.put(name, dos);
				System.out.println("현재 서버접속자 수는 "+ clients.size()+"입니다.");

				while(dis!=null) {
					sendToAll(dis.readUTF());
				}
			} catch (IOException e) {
				//ignore
			} finally {
				sendToAll("#"+name+"님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]");
				System.out.println("현재 접속자 수는"+clients.size()+"입니다.");
			}
		}
	}
}
