package kr.fileandcharset;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.nio.charset.Charset;
public class IOFileEx01 {
	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		
		File inTxt = new File("./src/kr/filetxt/onlyEng.txt");
		System.out.println(inTxt.exists());
		
		//읽어보기
		//InputStream은 추상 클래스이기때문에
		//read()를 구현한 FileInputStream,FilterInputStream을 사용
		
		InputStream is1= new FileInputStream(inTxt);
		//현재 기본 문자셋은 UTF-8
		
		//read는 반환타입이 int형으로 하위 1바이트에 정보를 저장해서 반환한다.
		
		int data=0;
		while((data=is1.read())!=-1) {//read는 항상 양수이고 더이상 읽을 데이터가 업을때 -1을 반환
			System.out.print((char)data+" ");
			System.out.println("남은 바이트 수:"+is1.available());//남은 바이트 숫자
		}
		System.out.println();
		
		//단위로 읽어보기
		//read(byte[] b) read(byte[] b,offset,length)
		
		//바이트배열을 넣어주면 거기에 읽은 데이터를 집어넣고 넣은 바이트수를 int로 반환한다.
		//아 그리고 스트림이기때문에 한바퀴 돌면 끝이나 다시 채워야한다.
		is1= new FileInputStream(inTxt);
		int count = 0;
		byte[] byteArray1 = new byte[5];
		
		while((count=is1.read(byteArray1))!=-1) {
			for(int i=0; i<count ; i++) {
				System.out.print((char)byteArray1[i]);
			}
			System.out.println(":count = "+count);
		}
		System.out.println();
		
		//특정 부분만 읽어보기
		is1= new FileInputStream(inTxt);
		byte[] byteArray2 = new byte[9];//이때 offset,length의 합보다 길어야한다.
		count = 0;
		count = is1.read(byteArray2,2,6);
		//2칸 비우고 앞에서부터 문자열길이 6까지 읽겟다.
		//현재 바이트 단위로 뽀개져 있는 상태
		//컴퓨터는 2진수로 저장되어있는 상태이기때문에
		//우리가 다시 조합해야한다.
		//조합할때는 문자열매서드를 활용한다.
		String str = new String(byteArray2,0,9,Charset.defaultCharset());
		System.out.println(str);
		//' '' 'FileIn' '
		//2칸띄고 길이6 다시 1칸비우고.
		
		//이제는 한글 읽어보기
		File fileKor = new File("./src/kr/filetxt/onlyKor.txt");
		System.out.println(fileKor.exists());
		InputStream isKor = new FileInputStream(fileKor);
		//한글을 읽을때에는 항상 문자셋이 무엇인지가 중요하다
		//UTF-8만 3byte
		//UTF-16은 맨앞 2byte는 문자정보
		//나머지는 2byte인데 EUC-KR은 문법이 맞지않는 한글은 제외
		
		System.out.println(Charset.defaultCharset());//UTF-8 확인
		
		//단위단위로 읽어야하기때문에
		//byte[]로 해야하며 UTF-8 // 단위는 3byte
		byte[] korRead = new byte[6];
		//그럼 이배열에 값을 바이트로 나뉜걸 옴겨 담는다
		int cnt=0;
		str = "";
		while((cnt=isKor.read(korRead))!=-1) {
			str = new String(korRead,Charset.defaultCharset());
			System.out.print(str);
			System.out.println(": count = "+cnt);
		}
		//여기서 문제가 생긴다.
		//배열을 0으로 초기화 하고 넣는게 아니라
		//덮어씌우는 형식이기 때문에
		//띄어 쓰기 하면 망가 짐' ' 이 되어야하는데
		//띄어 쓰기 하면 망가 짐가 이 된다.
		//전에 망가 에서 '가' 지워지지 않고 남아잇다는것으로
		//cnt에는 안들어가지면 데이터에는 남아있기때문에
		isKor = new FileInputStream(fileKor);
		while((cnt=isKor.read(korRead))!=-1) {
			str = new String(korRead,0,cnt,Charset.defaultCharset());
			System.out.print(str);
			System.out.println(": count = "+cnt);
		}
		//이렇게 cnt까지 읽어야한다.
		File fileSuffle = new File("./src/kr/filetxt/SuffleEngKor.txt");
		System.out.println(fileSuffle.exists());
		//한글과 영어 특스문자 ASCII가 섞여잇다.
		InputStream is4 = new FileInputStream(fileSuffle);
		byte[] suffle = new byte[3];
		byte[] suffle2 = new byte[6];
		
		cnt = 0;
		while((cnt=is4.read(suffle))!=-1) {
			str = new String(suffle,Charset.forName("UTF-8"));
			System.out.print(str);
			System.out.println(": count = "+cnt);
		}
		System.out.println();
		/*
		이: count = 3
		1�: count = 3
		� �: count = 3
		��a: count = 3
		해: count = 3
		$��: count = 1
		이렇게 오류가 생긴다..
		
		어떻게 해결해야할까..
		한글은 3바이트로 묶어야하고
		ASCII는 1바이트로 묶어야하는데..
		 */
	}
}
