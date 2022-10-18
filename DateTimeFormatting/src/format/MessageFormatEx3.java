package format;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Scanner;

public class MessageFormatEx3 {
	public static void main(String[] args) {
		String tableName = "member_tbl_02";
		String fileName = "data4.txt";
		String msg = "INSERT INTO "+tableName+" VALUES ({0},{1},{2},{3});";
		
		try {
			Scanner sc = new Scanner(new File(fileName));
			String pattern = "{0},{1},{2},{3}";
			MessageFormat mf = new MessageFormat(pattern);
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				Object[] objs = mf.parse(line);
				System.out.println(MessageFormat.format(msg, objs));
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
}
