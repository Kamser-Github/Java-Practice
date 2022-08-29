package kr.fileandcharset;
import java.io.File;
import java.io.IOException;
public class CreateFileObjectEx02 {
	
	//전날 배운거 복습하기
	public static void main(String[] args) {
		
		File file1 = new File("c:/kamser/temp");
		//해당 하위 폴더/파일 모르지만 존재하는지 여부
		System.out.println(file1.exists());
		//파일인지 확인
		System.out.println(file1.isFile());//false
		//폴더인지 확인
		System.out.println(file1.isDirectory());//true
		//자기 이름 출력
		System.out.println(file1.getName());//temp
		//부모 디렉토리 출력
		System.out.println(file1.getParent());//c://kamser
		//현재 작업(워크스페이스) 출력
		System.out.println(System.getProperty("user.dir")); //ok
		//절대경로 출력
		System.out.println(file1.getAbsolutePath());//ok
		//구분자 사용
		file1 = new File("c:"+File.separator+"kamser"+File.separator+"temp");
		//윈도우 \\ 맥 / 아니면 File.separator;
		//파일 전체 불러와보기
		File file = new File("c:/windows");
		File[] files = file.listFiles();
		
		for(File name : files) {
			System.out.println((name.isDirectory()?"폴더 : ":"파일 : ")+name.getName());
		}
		
		//파일 만들어보기
		File fileTemp = new File("c:/kamser/temp");
		if(!fileTemp.exists()) {
			fileTemp.mkdir();
			System.out.println(fileTemp.exists());
		}
		File fileTxt = new File("c:/kamser/temp/newTxt.txt");
		if(!fileTxt.exists()) {
			try {
				fileTxt.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File fileTemps = new File("c:/kamser/temp/abc/bc/dfd/fdf");
		if(!fileTemps.exists()) {
			fileTemps.mkdirs();
		}
	}
}
