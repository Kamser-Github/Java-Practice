package tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tcp_Thread01 implements Runnable{
	ServerSocket serverSocket;
	Thread[] threadArr;
	public static void main(String args[]) {
		// 5개의 쓰레드를 생성하는 서버를 생성한다.
		Tcp_Thread01 server = new Tcp_Thread01(5);
		server.start();
	} // main
	public Tcp_Thread01(int num) {
		try {
			//서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(7777);
			System.out.println();
			
			threadArr = new Thread[num];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		for(int i=0 ; i< threadArr.length ; i++) {
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	@Override
	public void run() {
		try {
			System.out.println(getTime()+"가 연결 요청을 기다린다.");
			Socket socket = serverSocket.accept();
			System.out.println(getTime()+socket.getInetAddress()+"로 연결요청이 들어왔습니다.");
			
			//소켓의 출력스트림을 얻는다.
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			//원격 소켓(remote socket)에 데이터를 보낸다.
			dos.writeUTF("Test Message1 from Server.");
			System.out.println(getTime()+"데이터 전송");
			
			//스르팀과 소켓을 닫는다.
			dos.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//현재시간을 문자열로 반환하는 함수
	static String getTime() {
		String name = Thread.currentThread().getName();
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		
		return f.format(new Date())+name;
	}
}
