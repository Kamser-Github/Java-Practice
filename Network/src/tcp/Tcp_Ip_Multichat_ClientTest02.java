package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Tcp_Ip_Multichat_ClientTest02 {
	public static void main(String args[]) {
		if(args.length!=1) {
			System.out.println("USAGE: java TcpIpMultichatClient 대화명");
			System.exit(0);
		}
		
		try {
			String serverIp = "127.0.0.1";
			//소켓을 생성해서 ip와  포트를 연결
			Socket socket = new Socket(serverIp,7777);
			System.out.println("서버에 연결되었습니다.");
			//여기서 socket은 serverip,port 와 내 hostName과 남는 port정보가 들어잇다.
			Thread sender = new Thread(new ClientSender2(socket,args[0]));
			Thread receiver = new Thread(new ClientReceiver2(socket));
			
			sender.start();
			receiver.start();
		} catch (IOException e) {}
	}//main
	
	static class ClientSender2 extends Thread{
		//보내려면 소켓과 이름
		//그리고 메세지를 작성할 쓰레드
		//그리고 메세지를 받을 쓰레드
		Socket socket;
		DataOutputStream out;
		String name;
		
		ClientSender2(Socket socket, String name){
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch (IOException e) {}
		}
		@Override
		public void run() {
			Scanner sc = new Scanner(System.in);
			try {
				//out!=null이라는건 UnknownHostException없이
				//잘 연결되서 socket끼리 연결이 되었다는 뜻.
				if(out!=null) {
					out.writeUTF("["+name+"]"+sc.nextLine());
				}
			} catch(IOException e) {}
		}
	}
	
	static class ClientReceiver2 extends Thread {
		Socket socket;
		DataInputStream in;
		
		ClientReceiver2 (Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {}
		}
		
		public void run() {
			while(in!=null) {
				try {
					System.out.println(in.readUTF());
				} catch(IOException e) {}
			}
		}
	}
}

