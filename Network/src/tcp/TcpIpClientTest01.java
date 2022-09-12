package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpClientTest01 {
	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("USAGE: java TcpIpMultichatClient 대화명");
			System.exit(0);
		}
/*
		실시간으로 정보를 주고 받을거기때문에
		싱글 쓰레드를 하면 정보를 받아오고 바로 보내고를 할수가 없다.
		기본으로 접속하려는 사이트의 ip와 포트를 작성하고
		거기에 socket을 지정
		socket에서 오는 out, in을 따로 쓰레드에 지정하여
		console창에 출력및 입력을 할 예정이다.
*/
		String serverIp = "127.0.0.1";
		try {
			Socket socket = new Socket(serverIp,10000);
			Thread write1 = new Thread(new SendThread(socket));
			Thread read1 = new Thread(new ReceiveThread(socket));
			//이제 이 소켓에 정보가 드나들기때문에 쓰레드로 따로 지정해야한다.
			//방법은 Runnable을 구현한 클래스냐
			//아니면 Thread를 상속한 클래스냐를 고르면 된다.
			write1.start();
			read1.start();
		} catch (IOException e) {}
	}
	
	static class SendThread implements Runnable {
		//여기에 보내는 쓰레드릴 작성하기 때문에
		Socket socket = null;
		DataOutputStream out = null;
		
		SendThread(Socket socket){
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {}
			//필드 초기화 완료
		}
		
		@Override
		public void run() {
			//여기에는 채팅을 콘솔에 치면 socket에 보내서 serverSocket에 전달할거다.
			Scanner sc = new Scanner(System.in);
			//여기서 실수했다.
			//굳이 매번 바뀌는 값이 아닌데 while문 안에 넣을 필요가 없고
			//공통으로 쓰는 name이라는 문자열이기 때문에 
			//멤버변수로 빼놓는게 맞다.
			String name = "";
			while(out!=null) {
				try {
					name = "["+socket.getLocalAddress()+"] : ";
					out.writeUTF(name+sc.nextLine());
					out.flush();
				} catch (IOException e) {}
			}
		}
	}
	
	static class ReceiveThread implements Runnable {
		Socket socket ;
		DataInputStream in;
		
		ReceiveThread(Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {}
			//초기화 완료
		}
		
		@Override
		public void run() {
			try {
				while(in!=null) {
					System.out.println(in.readUTF());
				}
			} catch (IOException e) {}
		}
	}
}
