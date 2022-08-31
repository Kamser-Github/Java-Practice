package kr.fileandcharset;

import java.io.File;
import java.nio.charset.Charset;
import java.io.IOException;

public class CreateCharsetEx01 {
	
	public static void main(String[] args) throws IOException {
		//지금까지 배운거 복습
		/*
		 * 파일 객체 
		 * 
		 * 파일객체를 생성하려면 주소가 필요하고
		 * 
		 * 그 주소를 객체로 입력해서 만들려고하는 파일을 따로 지목해도 되고
		 * 아예 처음부터 문자열로 입력해도 된다
		 * 
		 * 이때 윈도우는 \\ / File.separator
		 * 맥은 \
		 * 공통은 File.separator 을 구분자로 사용한다
		 * 
		 * 예
		 * 
		 * File file = new File();
		 * 일반 인스턴스 생성하는거처럼 하지만
		 * 생성자 함수안에 어디에 생성할건지 입력을 해줘야한다
		 * String 문자열로 입력
		 * 아니면 또다른 파일 객체와 자손 객체를 스트링으로 넣어도 된다.
		 * 
		 * 파일 객체는 말 그대로
		 * 
		 * 거기를 지점으로 어떤 작업을 할건지 기초 공사를 준비하는것
		 * 
		 * 문자셋은 우리가 문자열 작업을 할때 컴퓨터에게 받을때나 줄때
		 * 2진법으로 줘야하는데 우리가 보기편하게 16진수로  표현해서 입력을하고
		 * 
		 * 받을때도 어던 문자셋으로 받을지 입력을 해주는 방식이다.
		 * 
		 * ACSII코드 방식은 EUC-KR,MS949가 잇고
		 * 모두 한글은 2byte씩
		 * 영어는 1byte씩이다.
		 * 
		 * EUC-KR은 2350자만 한글로 준비되어잇고
		 * MS949는 11,172자? 정도가 전부 준비가 되어잇어
		 * UTF-8은 한글은 3byte 영어는 1byte로 분해하고 조합한다
		 * 이때 위 3개는 전부 영어는 1byte로 하기 때문에
		 * 영어끼리는 어떤 문자셋을 사용해도 문자열 깨짐이 없으나
		 * UTF-16은 모든 문자를 2byte로 표현하기때문에 영어도 깨진다
		 * 특이점이 하나더 있는데 UTF-16은 문자열 맨 앞에 문자해석에대한
		 * 정보가 있는 FE FF라는 2byte가 추가로 붙는다
		 * 따라서 글자수 * 2 + 2가 되는것
		 * 
		 * 문자열중에 한글은 "강아지뙗쐟어"
		 * 를 4개의 문자셋으로 해석을하면
		 * EUC-KR을 제외하고는 전부 올바르게 분해를 하며
		 * EUC-KR은 강아지 ?? 어 만 분해를 하고
		 * 나저미 뙗쇓은 인식을 못해 ? 로 1byte로 읽는다.
		 * 여기서 문자열이기 때문에 스트링 매서드를 사용하는데
		 * 문자셋을 바로 입력을하면 만약에 지원을 하지않는 문자셋일경우
		 * 일어나는 UnsupportedEncodingException이 발생하기때매문에
		 * 문자열 스태틱 메서드
		 * Charset.forName("문자셋")을 입력하는게 좋다
		 * 위와 같이 안했을겨우 try catch문으로 예외를 처리해야하며
		 * 
		 * 이게 지원하는 문자인지 아닌지는
		 * isSupported()라는 매서드로 확인해본다
		 * 
		 * 그리고 모두 영어건 한글이건 자기 포멧에 맞는걸로 파일이 생기는데
		 * MS949는 특이하게 영어는 UTF-8로 저장하지만
		 * 한글은 ANSI로 포멧으로 저장한다.
		 * 
		 */
		
		//파일 생성
		File file1 = new File("c:/kamser/temp");
		//file = > java.io.File로 호출한다
		//문자열 생성
		Charset cs1 = Charset.forName("UTF-8");
		//해당 주소의 절대경로
		System.out.println(file1.getAbsolutePath());
		//현재 작업스페이스의 상대경로 출력해보기
		System.out.println(System.getProperty("user.dir"));
		//파일 자손이 존재 여부 확인
		System.out.println(file1.exists()); //true 잇따
		//이게 폴더인지 파일인지 확인
		System.out.println(file1.isDirectory());
		System.out.println(file1.isFile());
		//폴더 생성
		System.out.println(file1.mkdir());
		//폴더 전체다 생성
		System.out.println(file1.mkdirs());
		//파일 생성
		System.out.println(file1.createNewFile());
		//예외 처리를 해야한다.
		//IOException을 처리해야한다.
		//해당 위치에 모든 파일/폴더 불러오기
		File[] files = file1.listFiles();
		//해당 디렉토리에 잇는 모든걸 다 갖고온다.
		//getName,getParent 등이 있다.
		String str = "왜저뤫!";
		Charset ms949 = Charset.forName("MS949");
		Charset euckr = Charset.forName("EUC-KR");
		Charset utf16 = Charset.forName("UTF-16");
		
		//문자열을 byte[] 객체로 분해를 한다.
		byte[] b0 = str.getBytes("ms949");
		byte[] b1 = str.getBytes(ms949);
		byte[] b2 = str.getBytes(euckr);
		byte[] b3 = str.getBytes(utf16);
		byte[] utf = str.getBytes();//디폴트
		//뽀갠걸 다시 조합하기
		String a1 = new String(b0,ms949);
		//영어,ASCII면 3개가 UTF-9와 /똑같다
		//이때 뽀갠 문자셋으로 다시 조합해야한다.
		String a1r = new String(b0,utf16);
		System.out.println(a1);//왜저뤫!
		System.out.println(a1r);//뿖샺这� 이렇게 오류가 생긴다.
		//뽀갠문자 한문자씩 읽어보기
		for(int i=0 ; i<3 ; i++) {
			//여기서 한글은 2byte,utf-8 =>3byte로 나누기때문에
			//한글자를 인식하려면 length가 2, 3단위여야 가능하다.
			//그리고 기본 문자셋(현재UTF-8)로 읽는다
			System.out.println(new String(utf,i*3,3));
		}
		
		//여기서 마지막 느낌표는 1byte로 인식했기때문에
		//중간에서 잘랐다.
		//해당 문자셋이 지원하는지 확인해봐야한다.
		System.out.println(Charset.isSupported("UTF-8"));//true!
		
		
	}
}
