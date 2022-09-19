package kr.fileandcharset;

import java.io.*;

public class ChangeCharsetEx2 {
	public static void main(String[] args) {
		
		File file = new File("C:\\kamser\\book\\java_hk\\IO");
		File[] files = file.listFiles();
		//파일 읽어서 새 파일에 문자셋 변경해서 작성하기
		try {
			for(int i=0 ; i<files.length ; i++) {
				String parent = files[i].getParent();
				String name = files[i].getName();
				InputStreamReader isr = new InputStreamReader(new FileInputStream(files[i]),"MS949");
				OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(parent+"/new"+name),"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osr);
				
				String data = "";
				while((data=br.readLine())!=null) {
					bw.write(data);
					bw.write('\n');
				}
				bw.flush();
				bw.close();
				br.close();
				isr.close(); 
				osr.close();
			}
			System.out.println("저장 성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
