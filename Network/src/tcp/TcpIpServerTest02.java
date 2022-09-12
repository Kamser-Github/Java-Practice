package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/*
	ServerSocket은 포트 1개에만 연결 가능
	포트 1개에 연결해서 accept()를 하게 되면
	Socket이 반환되는데
	여기서 따로 저장을 하지 않으면
	Socket이 나올때마다 새로운 쓰레드에 집어넣는다.
	거기서 Socket의 정보를 메인 클래스에 보관하고
	Socket에서 write 할때마다 InputStream으로 받아
	모든 socket에다가 다시 write를 한다.
	이렇게 되면
	해당 포트로 연결된 모든 Client는 자신의 채팅과 다른 사람의 채팅을 전부 볼수잇는데
	여기서 synchronizeMap으로 오류가없게 한다.
	
	이때 Thread를 상속한 내부 클래스는
	socket의 dis,dos를 모두 받아야한다.
	여기서 받은걸로 전달을하고 정보를 받아야하기 때문에.
	
*/
public class TcpIpServerTest02 {
	private HashMap<String,DataOutputStream> clients;
	//여기에 특정포트로 들어온 모든 client의 socket을 보관할 예정
	
	public TcpIpServerTest02 () {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
		//동기화 설정
	}
	//서비스 시작
	public void start() {
		//해당 매서드를 시작하면 특정포트를 열어놓는다.
		ServerSocket serverSocket = null;
		//여기에 client의 socket을 보관
		Socket socket = null;
			//무한으로 열어놓고 포트를 대기시킨다.
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("서버가 연결되었습니다.");
			//accept() 대기를 무한히
			while(true) {
				socket = serverSocket.accept();
				System.out.println("연결이 되었습니다.");
				//특정 쓰레드로 전송.
				ReceiveClient receive = new ReceiveClient(socket);
				receive.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//메세지 전달 채팅 메서드 내부전용 메서드
	private void tellConnectAll(String msg) {
		//이터레이터로 모든 객체 불러오기
		Iterator<String> it = clients.keySet().iterator();
		while(it.hasNext()) {
			//ketSet으로 모든 객체에 써서 전달.
			try {
				DataOutputStream out = clients.get(it.next());
				//out에 연결되어있는 socket에 writeUTF를 하면
				//Client가 가진 socket의 InputStream에 전달된다.
				out.writeUTF(msg);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//내부클래스
	class ReceiveClient extends Thread{
		Socket socket ;
		DataInputStream in;
		DataOutputStream out;
		
		ReceiveClient(Socket socket){
			//소켓을 받으면
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			//필드 초기화완료.
		}
		
		//Thread를 상속했기때문에 받은 정보를 저장및 정보전달
		@Override
		public void run() {
			String name = "";
			try {
				name = in.readUTF();//처음 정보를 name으로 지정
				clients.put(name, out); //데이터 추가
				System.out.println(name+"님이 접속하셨습니다.");
				System.out.println("현재 접속자는 "+clients.size());
				
				//이제 정보 전달
				while(out!=null) { //out이 빈 객체가 아니라 정보가 들어있다면
					//모든 client에게 메세지를 받고 
					// 그 모든 메세지를 다시 clients에게 전달하려면
					tellConnectAll(in.readUTF());
				}
			} catch(IOException e) {}
		}
	}
	public static void main(String[] args) {
		new TcpIpServerTest02().start();
	}
}
