package tcp;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
public class TCP_Socket_SeverSocketEx1 {
	public static void main(String[] args) {
		//TCP 통신에서 두 호스트간 입출력 스트립을 제공(실제 통신 객체)하는 클래스
		//#1  Socket 생성
		Socket socket1 = new Socket();
		Socket socket2 = null;
		Socket socket3 = null;
		Socket socket4 = null;
		Socket socket5 = null;
		
		System.out.println(socket1.isConnected());
		
		try {
			socket2 = new Socket("www.naver.com",80);
			//주소를 입력하면 DNS에 접속해서 실제있는 주소인지확인하고 IP를 받아오고
			//그 뒤에 있는 매개변수는 port 값이다.
			//port값도 마찬가지로 server port에 열려있는 값이여야 접속이된다.
			socket3 = new Socket("www.naver.com",80,InetAddress.getLocalHost(),10000);
			//항상 소켓에는 택배처럼 받는곳, 보내는곳 주소(IP,port)가 들어가야하며
			//매개변수로 주어지지 않을경우 LocalHostIP와 미사용 port값이 전달된다.
			socket4 = new Socket(InetAddress.getByName("www.naver.com"),80);
			socket5 = new Socket(InetAddress.getByName("www.naver.com"),80,
											InetAddress.getLocalHost(),10000);
		}
		catch(UnknownHostException e) {}
		catch(IOException e) {}
		
		//#2 Socket 메서드
		//@connect/월격지 주소정보
		//반드시 socket을 사용할때는 보내는곳,받는곳이 들어가야하는데
		//나중에 작성할경우에는 connect로 작성한다.
		try {
			socket1.connect(new InetSocketAddress("www.naver.com",80));
		} catch(IOException e) {}
		System.out.println(socket1.getInetAddress()+":"+socket1.getPort());//www.naver.com/223.130.200.107:80
		
		//@local 주소정보(로컬 주소를 지정한경우, 지정하지않은 경우)
		System.out.println(socket2.getInetAddress()+":"+socket2.getPort());
		System.out.println(socket2.getLocalSocketAddress());
		///182.222.48.247:54652 빈 port를 찾아서 집어넣는다 결국
		System.out.println(socket3.getInetAddress()+":"+socket3.getPort());
		System.out.println(socket3.getLocalSocketAddress());
		///182.222.48.247:10000
		
		//@send/receive 버퍼사이즈
		try {
			System.out.println(socket4.getSendBufferSize()+","+socket5.getReceiveBufferSize());
		} catch (SocketException e) {} //65536,65536
	}
}
