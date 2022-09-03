package kr.console;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class BufferedInOutputTestEx01 {
	public static void main(String[] args) {
		File oriImg = new File("C:\\kamser\\book\\images\\studyGroup.png");
		File copyImg1 = new File("C:\\kamser\\book\\images\\studyGroupCopy1.png");
		File copyImg2 = new File("C:\\kamser\\book\\images\\studyGroupCopy2.png");
		System.out.println(oriImg.exists());//true
		
		long start,end,time1,time2;
		
		//NOT BUFFERED
		start = System.nanoTime();
		try(InputStream is = new FileInputStream(oriImg);
				OutputStream os = new FileOutputStream(copyImg1)){
			int data;
			while((data=is.read())!=-1)
				os.write(data);
			os.flush();
			
		} catch (IOException e){}
		end = System.nanoTime();
		time1 = end-start;
		System.out.println("최종 시간 not Buffered : "+time1);//489175300
		
		//USE Buffered
		start = System.nanoTime();
		try(InputStream is = new FileInputStream(oriImg);
			BufferedInputStream bis = new BufferedInputStream(is);
				OutputStream os = new FileOutputStream(copyImg2);
				BufferedOutputStream bos = new BufferedOutputStream(os)){
			int data;
			while((data=bis.read())!=-1)
				bos.write(data);
			bos.flush();
			
		} catch (IOException e){}
		end = System.nanoTime();
		time2 = end-start;
		System.out.println("최종시간 use Buffered : "+time2);//3501900
		
		System.out.println("최종 비율 = "+time1/time2+"배 차이");//차이가 매번 다르긴하지만 70배가  평균
		
	}
}
