package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpServerTest03 {
	HashMap<String,DataOutputStream> clients;
	
	public TcpIpServerTest03() {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
	}
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println(" 대기중..");
			while(true) {
				socket = serverSocket.accept();
				System.out.println("연결 완료"+socket.getInetAddress()+":"+socket.getPort());
				//이제 socket에 대해서 정보를 읽을건 따로 쓰레드로 관리
			}
			
		}catch(IOException e) {}
	}
	
	private void sentToAll(String msg) {
		//msg가 들어오면 모든 HashMap에 전달
		Iterator<String> it = clients.keySet().iterator();
		while(it.hasNext()) {
			try{
				DataOutputStream out = clients.get(it.next());
				out.writeUTF(msg);
				out.flush();
			}catch (IOException e) {}
		}
	}
	//내부클래스
	class Receiver14 extends Thread{
		//socket의 정보를 다 받아야한다.
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		String name;
		
		Receiver14(Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {//초기화를 했으니 관리를 하기위해 map에 저장하는 메서드
			try{
				name = in.readUTF();
				clients.put(name, out);
				
				//이제 socket에서 정보가 들어오면 모든 정보를 다시 
				//clients에 재배포할 예정
				while(out!=null) {
					sentToAll(name+in.readUTF());
				}
			} catch (IOException e) {}
		}
	}
	public static void main(String[] args) {
		new TcpIpServerTest03().start();
	}
}
