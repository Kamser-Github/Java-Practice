package kr.fileandcharset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransCharset {
	public static void main(String[] args) throws IOException {
		
/*
		 
		 1.해당 파일객체를 만들고
		 해당 파일리스트를 불러오고
		 그 객체 안에있는 목록을 다시 불러와서
		 그 목록을 MS949인걸 UTF-8로 변경후
		 이름 바꿔서 변경
*/
		File file1 = new File("C:\\kamser\\book\\java_hk\\Collection");
		File[] fileParent = file1.listFiles();
		for(int i=0; i<fileParent.length ; i++) {
			File[] fileSon = fileParent[i].listFiles();
			for(int j=0 ; j<fileSon.length ; j++) {
				InputStream is = new FileInputStream(fileSon[j]);
				InputStreamReader isr = new InputStreamReader(is,"MS949");
				OutputStream os = new FileOutputStream(fileSon[j].getParent()+"/new"+fileSon[j].getName());
				OutputStreamWriter osw = new OutputStreamWriter(os,"UTF-8");
				int data;
				while((data=isr.read())!=-1) {
					osw.write(data);
				}
				osw.flush();
			}
		}
		//fileSon이 하나 하나가 다 객체.
		//ms949로 읽어오기
	}
}
