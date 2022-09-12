package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Tcp_Ip_Server_Test05 {
	public static void main(String[] args) {
/*
		서버에서는
		서버 소켓을 만들어야하고
		서버 소켓은 포트 하나를 온전히 다 사용한다.
		왜냐하면 하나의 포트에 서버 소켓을 여러개 사용할경우에
		누구 서버 소켓으로 들어간건지 알수없기 때문에
		서버 소켓은 포트 하나를 사용한다.
*/	
		//서버소켓과 소켓은 따로 main()메서드 안에서 선언한다.
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			//serverSocket에 포트를 지정한다
			serverSocket = new ServerSocket(8888);
			//서버소켓에 안전하게 접속을 하면
			//socket변수에 담는다.
			socket = serverSocket.accept();
			System.out.println("연결이 완료 되었습니다.");
			//소켓에 담으면
			//우리는 쓰레드를 나누어서
			//하나는 받기만하는 쓰레드를 만들고
			//하나는 쓰기만하는 쓰레드를 나누어서 돌린다.
			Sender2 sender = new Sender2(socket);
			Receiver2 receiver = new Receiver2(socket);
			sender.start();
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Sender2 extends Thread {
	//소켓의 정보에는 발신자와 수신자가 전부 들어있다.
	Socket socket;
	DataOutputStream dos;
	String name;
	
	//생성자 만들때 소켓을 받는다.
	Sender2 (Socket socket){
		this.socket = socket;
		//소켓을 받았으니 이 소켓에 있는 정보와
		//name을 초기화한다.
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			name = "["+socket.getLocalAddress()+":"+socket.getLocalPort()+"]";
		} catch (IOException e) {}
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(dos!=null) {
			try{
				dos.writeUTF(name+sc.nextLine());
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

//받는 쓰레드
class Receiver2 extends Thread {
	Socket socket;
	DataInputStream dis;
	
	Receiver2 (Socket socket){
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			while(dis!=null) {
				System.out.println(dis.readUTF());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}