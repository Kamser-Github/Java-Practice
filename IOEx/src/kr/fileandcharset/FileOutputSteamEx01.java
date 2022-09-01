package kr.fileandcharset;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.nio.charset.Charset;
public class FileOutputSteamEx01 {
	
	public static void main(String[] args) throws IOException  {
		/*
		 * FileOutputStream은 상위클래스 OutputStream을 상속해서
		 * write를 구현한 클래스이다.
		 * 다형성으로 맞춰서 사용할수있게
		 * OutputStream으로 사용할수 있고
		 * 
		 * 특이점은 파일이 없으면 만들어서 작업을 한다.
		 * 실험해볼거 1. 파일이 만들어지는데 폴더도 없으면 어떻게 될까.
		 * 
		 */
		//현재 작업위치를 출력해보기 복습
		System.out.println(System.getProperty("user.dir"));
		//C:\kamser\workspace_java\IOEx
		
		//상대 경로로 객체 생성하기
		File outFile1 = new File("src/kr/filetxt/OutOnlyEng.txt");
		//해당 파일이 있는지 확인해복
		System.out.println(outFile1.exists());//false //없다고 나온다
		//파일 객체로 OutputStream을 만들어보기
		// 프로그램에서 -> 파일로 가는게 out이다
		OutputStream os1 = new FileOutputStream(outFile1);
		//os1 변수에는 FileOutputStream 객체의 주소가 있고
		//그 객체 주소에는 변수로 filePath가 들어있다.
		//os1의 오버라이딩된것을 사용하면
		//동적 바인딩으로 실행될때 OutputStream의 write가 아니라
		//오버라이딩된 메서드를 실행하게된다.
		
		os1.write('j');
		//int a 라고 나오지만
		//실상은 1byte만 사용할수 있다. 하위 1byte만 읽기 때문이다
		//숫자를 넣어보자
		os1.write(49);
		//인식이 된다.
		//안될줄 알앗는데 생각해보니까
		//해당 문자를 숫자로 변환해서 저장하는거니까
		//번호를 입력해도 된다.
		//즉 배열도 마찬가지로 거기에 숫자를 입력하면 될거같다.
		os1.close();
		
		//실험으로 만약에 상위 폴더가 없는 폴더라면 어떻게 될까
		File outFile2 = new File("src/kr/filetxt/OutOnlyEng.txt");
//		OutputStream os2= new FileOutputStream(outFile2);
		//해당 폴더를 찾을수 없다고 에러가 발생한다.
		//이럴때 객체의 주소는 실제 있어야하는 주소가 들어가야한다.
		//그럼 File메서드 중에서 부모의 주소를 가져올수가 있는데
		//그걸로 폴더를 생성해서.만들어도 될거같다.
		System.out.println(outFile2.exists());
		//
		//영어는 간단하고 byte가 고정이기 때문에
		//한글로 연습해보겠다.
		//하나하나 계속 입력하기엔 어렵기 때문에
		//입력장치를 가져와서 해보겟다.
		Scanner sc = new Scanner(System.in);
		
		//write는 매개변수로 byte 배열로도 입력이 가능하다
		//우리가 배열을 고정으로 만들면 글자는 한글자씩 입력을 해야한다.
		byte[] korWord = new byte[3];
		for(int i=0 ; i<0 ; i++) {
			/*
			 * 말을 한글자씩 입력해서 엔터를 해야하는데
			 * 콘솔창에는 엔터가 2개로 인식이 된다.
			 * 먼저 String을 분해하는 getBytes()를 사용해야하고.
			 * 그걸다시 write에 담아야한다.
			 * 
			 */
			String str = sc.nextLine();
			korWord = str.getBytes();
//			os2.write(korWord);
			//강아지는귀엽고깜직하 까지 입력을 했더니 됐다.
			//여기서 엔터도 인식하게 하려면...
			//next()를 사용해야한다.
			
		}
		//os2.flush();
		//os2.close();
		
		OutputStream os3= new FileOutputStream(outFile2,true);
		//로 이어쓰기하겟다.
		/*
		 * 내가 하고 싶은건 엔터를 치면 그대로 엔터로 새행이 되는것.
		 */
//		for(int i=0 ; i<30 ; i++) {
//			System.out.print((i+1)+"번째 마디를 입력");
//			String str2 = sc.nextLine();
//			os3.write(str2.getBytes());
//			System.out.println("count = "+i);
//		}
		//next()는 구분자로 끊기때문에 불편하다
		
		/*
		 * 내가 콘솔에 채팅을 친걸 TXT에 저장
		 * TXT에 저장한걸 다시 가져와서 콘솔에 출력해보겟다.
		 */
		for(int i=0 ; i<5 ; i++) {
			String str = sc.nextLine();
			os3.write(str.getBytes());
		}
		
		//노래 가사를 5마디를 적어보겟다 사이에 특스 문자를 껴서
		
		//다시 불러서 콘솔에 출력해보기.
		//불러오면
		InputStream is1 = new FileInputStream(outFile1);
		//read로 읽기는 안되고
		//read(byte[] a)로 가져와야하는데..
		//read는 다 읽으면 -1를 반환하고
		//그러면 반복문을 돌려서 -1을 나올때까지하는데
		//여기서 byte단위는 3단위로읽어야한다.
		int cnt = 0;
		while((cnt=is1.read(korWord))!=-1) {
			//korWord에 읽은 데이터값이 저장.
			//그걸 다시 조합
			String str = new String(korWord,Charset.defaultCharset());
			System.out.print(str);
			System.out.println("count = "+cnt);
		}
		//읽어올때 에러가 생긴다..
		/*
		 * 여기서 read에 byte[] 배열이 들어오는데
		 * 어떻게 해야 올바르게 가져올수잇을까..
		 * 배열에 숫자를 담아서 그걸 다시 유니코드로 조합해서 사용..
		 * ASCII면 read로 읽고.
		 * 그 외면 read(byte[]로 읽고)
		 */
	}
}
