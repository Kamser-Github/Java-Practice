package kr.fileandcharset;
import java.io.File;
import java.io.IOException;
public class CreateFileObjectEx01 {
	public static void main(String[] args) {
		//#1-1 C 드라이브 내에 temp 폴더 생성( 없는 경우에 )
		File fileTemp = new File("c:/kamser/temp");
		System.out.println(fileTemp.exists()); //false 없다는뜻
		//exists exist-존재하다.뜻
		//false이면 존재하지 않다는 뜻이고 만들면된다.
		if(!fileTemp.exists()) {
			fileTemp.mkdir(); //만들어졌다.
								//만들어지면 ture 실패하거나 이미 존재하면 false 반환
		}
		//#1-2 파일 객체 생성( 실체파일 생성 );
		File newTextFile = new File("c:/kamser/temp/newText.txt");
		if(!newTextFile.exists()){
			//파일이 존재하지 안으면
			try{
				newTextFile.createNewFile();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println(newTextFile.exists());
			//파일이 안전하게 생성되서 1-1과 1-2 모두 ture가 나왓다.
		}
		
		System.out.println(newTextFile.getAbsoluteFile());
		
		//#2 파일 구분자
		//윈도우 버전 윈도우는 \t \n \r등 제어문자 때문에 \\두번쓴다
		File newFile1 = new File("c:\\kamser\\temp\\newText.txt");
		//mac 버전 / 슬래쉬로 구분한다.
		File newFile2 = new File("c:/kamser/temp/newText.txt");
		//공용 버전
		File newFile3 = new File("c:"+File.separator+"kamser"+File.separator+"temp"+File.separator+"newText.txt");
		
		//현재 윈도우는 위 3가지다 사용이 가능하다.
		
		System.out.println(newFile1.exists()); //true
		System.out.println(newFile2.exists()); //true
		System.out.println(newFile3.exists()); //true
		System.out.println("-------------");
		
		//3-1 절대경로 최 상위 디렉토리부터 내려온다.
		File newFile4 = new File("c:/kamser/temp/newText.txt");
		File newFile5 = new File("c:/kamser/temp2/newText2.txt");
		System.out.println(newFile4.getAbsolutePath());
		System.out.println(newFile5.getAbsolutePath());
		//해당 객체의 절대경로를 출력한다.
		//이때 해당 객체의 경로는 존재 유무가 중요한게 아니다.
		//객체에서 역할로 사용될때 그때에만 있으면 된다.
		/*c:\kamser\temp\newText.txt
		 *c:\kamser\temp2\newText2.txt
		 */
		
		//3-2 상대경로
		System.out.println(System.getProperty("user.dir"));
		//C:\kamser\workspace_java\IOEx
		//현재 작업중인 디렉토리를 가리킨다.
		File newFile6 = new File("newFile1.txt");
		File newFile7 = new File("dbd/newFile1.txt");
		//현재 저기 위치에 아무것도 없다.
		System.out.println(newFile6.getAbsolutePath());
		//C:\kamser\workspace_java\IOEx\newFile1.txt
		System.out.println(newFile7.getAbsolutePath());
		//C:\kamser\workspace_java\IOEx\dbd\newFile1.txt
		//해당위치에 객체를 만들경우 경로를 알려준다.
		
		//#1. 파일 객체 생성
		File file = new File("c:/windows");
		
		//#2. 파일메서드
		System.out.println("절대 경로: "+file.getAbsolutePath());
		System.out.println("폴더 세요? :"+file.isDirectory());
		System.out.println("파일 세요? :"+file.isFile());
		System.out.println("파일/폴더 이름 : "+file.getName());
		System.out.println("파일/폴더 상위폴더 : "+file.getParent());
		/*  new File("c:/windows")
			절대 경로: c:\windows 
			폴더 세요? :true
			파일 세요? :false
			파일/폴더 이름 : windows
			파일/폴더 상위폴더 : c:\
		 */
		//#2-1 self 
		File file2 = new File(System.getProperty("user.dir"));
		System.out.println(file2.getAbsolutePath());
		//C:\kamser\workspace_java\IOEx
		System.out.println(file2.isDirectory());
		System.out.println(file2.isFile());
		System.out.println(file2.getName());
		System.out.println(file2.getParent());
		
		File newfile1 = new File("c:/kamser/temp/abc");
		System.out.println(newfile1.exists());//false
		if(!newfile1.exists()) {
			newfile1.mkdir();
		}
		System.out.println(newfile1.mkdir());//만들어지면 ture 있으면 false
		File newfile2 = new File("c:/kamser/temp/bcd/cde");
		System.out.println(newfile2.mkdir()); //false
		//여기서 안만들어진 이유는 cde를 만들려고하는데 bcd 폴더가 존재하지않기때문
		System.out.println(newfile2.mkdirs()); //true;
		//그걸 한방에 해결해주는 매서드가 mkdirs()다 상위폴더까지 만들어준다.
		
		//파일명 읽어보기
		File[] files = file.listFiles();
		//file은 객체가 c:/windows로 잡혀있고
		//거기있는 모든 파일/폴더를 읽어와서
		//files라는 객체배열에 담을것이다.
		
		for(File fileName : files) {
			System.out.println((fileName.isDirectory()?"폴더 :":"파일 "+fileName.getName()));
		}
		
	}
}
