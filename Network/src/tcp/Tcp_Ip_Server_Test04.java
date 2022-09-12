package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Tcp_Ip_Server_Test04 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			//서버 소켓을 생성하여 7777번 포트와 bind한다.
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			socket = serverSocket.accept();
			
			Sender1 sender = new Sender1(socket);
			Receiver1 receiver = new Receiver1(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Sender1 extends Thread {
	Socket socket;
	DataOutputStream dos;
	String name;
	
	Sender1 (Socket socket){
		this.socket = socket;
		try {
			//여기소켓에는 Client의 정보가 들어가 잇다.
			dos = new DataOutputStream(socket.getOutputStream());
			name = "["+socket.getInetAddress()+":"+socket.getPort()+"]";
			//보내는 사람의 정보를 저장한다.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(dos!=null) {
			try {
				dos.writeUTF(name+sc.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Receiver1 extends Thread {
	Socket socket;
	DataInputStream dis;
	
	Receiver1(Socket socket){
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(dis!=null) {
			try {
				System.out.println(dis.readUTF());
			} catch(IOException e) {}
		}
	}
}