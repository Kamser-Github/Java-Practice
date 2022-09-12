package kr.fileandcharset;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ChangeCharsetEx1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("C:/kamser/book/java_source");
		File[] files = file.listFiles();
		for(int i=0 ; i<files.length ; i++) {
			File[] inFiles = files[i].listFiles();
			for(int j=0 ; j<inFiles.length ; j++) {
				InputStreamReader isr = new InputStreamReader(new BufferedInputStream(new FileInputStream(inFiles[j])),"MS949");
				OutputStream os = new FileOutputStream(inFiles[j].getParent()+"/new"+inFiles[j].getName());
				OutputStreamWriter osw = new OutputStreamWriter(new BufferedOutputStream(os),"UTF-8");
				int data;
				while((data=isr.read())!=-1) {
					osw.write(data);
				}
				osw.flush();
			}
			
		}
	}
}
