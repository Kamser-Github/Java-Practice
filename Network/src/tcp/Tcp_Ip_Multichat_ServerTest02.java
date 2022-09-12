package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Tcp_Ip_Multichat_ServerTest02 {
	HashMap<String,DataOutputStream> clients;
	
	Tcp_Ip_Multichat_ServerTest02(){
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
	}
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			//포드 연결해주고
			System.out.println("서버가 시작되었습니다.");
			
			while(true) {
				//연결대기로 무한 반복문 걸고
				socket = serverSocket.accept();
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]");
				//연결완료 되면
				//HashMap에 키,값 추가해서 넣어주고
				ServerReceiver1 thread = new ServerReceiver1(socket);
				thread.start();
			}
		} catch (IOException e) {}
	}//start();
	
	void sendToAll(String msg) {
		//it은 결국  id를 말하는거고
		Iterator<String> it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				//결국 client가 채팅을 칠때마다
				//모든 말을 다 out.writeUTF()로 다 작성하면
				//된다.
				//여기서 get(key)로 해당 소켓에다가 다 글을 쓰는것. 나 포함
				DataOutputStream out = clients.get(it.next());
				out.writeUTF(msg);
			} catch(IOException e) {}
		}
	}
	
	public static void main(String[] args) {
		new Tcp_Ip_Multichat_ServerTest02().start();
	}
	
	//내부 클래스
	//외부 클래스와 밀접한 관계로
	//Thread를 상속해서 HashMap에 추가할 매서드를 가지고 있음.
	//여기서 이게 없다면 하나의 main으로 싱글스레드로 돌아가야됨.
	class ServerReceiver1 extends Thread {
		//내부 멤버인 HashMap을 보충하기 위한 클래스
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		ServerReceiver1 (Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch(IOException e) {}
		}
		
		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#"+name+"님이 들어오셨습니다");
				
				clients.put(name,out);
				System.out.println("현재 접속자 수는 "+clients.size());
				
				while(in!=null) {
					sendToAll(in.readUTF());
				}
			} catch(IOException e) {
			} finally {
				sendToAll("#"+name+"님이 나가셨습니다");
				clients.remove(name);
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]");
				System.out.println("현재 서버 접속자 수는 "+clients.size());
			}
		}
	}
}
