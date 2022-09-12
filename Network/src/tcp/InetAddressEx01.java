package tcp;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressEx01 {
	public static void main(String[] args) throws UnknownHostException,IOException {
		//@1-1 원격지 IP 
		InetAddress ia1 = InetAddress.getByName("www.google.com");
		System.out.println(ia1);//www.google.com/142.250.207.68
		InetAddress ia2 = InetAddress.getByAddress(new byte[] {(byte)142,(byte)250,(byte)207,68});
		InetAddress ia3 = InetAddress.getByAddress("구글",new byte[] {(byte)142,(byte)250,(byte)207,68});
		System.out.println(ia3);//구글/142.250.207.68
		/*
		 * getByName()은 해당 호스트이름+IP주소 저장
		 * 	객체를 만드는 시점에 실제 해당 호스트 이름이 DNS에 정확이 있어야함
		 * 그 외에는 객체를 만드는 시점에서 정확한 IP인지는 중요하지 않다.
		 * File객체 처럼.
		 */
		
		//ia1은 직접 해당 사이트를 가서 IP를 가져오기때문에
		//해당 사이트가 없을경우 예외처리를 해야하고.
		//ia2,ia3는 이미 IP주소가 있기때문에 예외 처리를 하지 않아도 된다.
		
		//@1-2 로컬/루프백 IP 자기 자신이 나오는 IP
		InetAddress ia4 = InetAddress.getLocalHost();
		InetAddress ia5 = InetAddress.getLoopbackAddress();//localhost/127.0.0.1
		System.out.println(ia4);
		System.out.println(ia5);
		
		//@1-3. 하나의 호스트가 여러 개의 IP를 가지고 있는 경우.
		InetAddress[] ia6 = InetAddress.getAllByName("www.naver.com");
		System.out.println(Arrays.toString(ia6));
		System.out.println();
		
		//@2-1 호스트와 IP 알아내기
		byte[] address = ia1.getAddress();
		System.out.println(Arrays.toString(address));//[-84, -39, 25, 4]
		//오버플로우 때문에 직관성이 떨어진다.
		System.out.println(ia1.getHostAddress());//172.217.25.4
		System.out.println(ia1.getHostName());//www.google.com
		System.out.println(ia2.getHostName());//hkg12s32-in-f4.1e100.net
		//ia2는 InetAddress에는 IP정보만 들어있어서 호스트이름은 나오지 않는다.
		
		//@2-2저장 주소의 특징알아내기 (InetAddress에 들어온 IP의)
		System.out.println(ia1.isReachable(1000));//구글은 된다.
		System.out.println(ia6[0].isReachable(1000));//네이버는 통신이 안된다.
		System.out.println(ia1.isLoopbackAddress());//해당 주소가 루프백 주소인지
		System.out.println(InetAddress.getByAddress(new byte[]{127,0,0,1}).isLoopbackAddress());//true
		System.out.println(ia1.isMulticastAddress());//멀티캐스트 아이피? 
		System.out.println(InetAddress.getByAddress(new byte[]{(byte)225,(byte)225,(byte)225,(byte)225}).isMulticastAddress());
		
	}
}
