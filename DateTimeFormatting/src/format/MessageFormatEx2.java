package format;

import java.text.MessageFormat;
import java.text.ParseException;

public class MessageFormatEx2 {
	public static void main(String[] args) {
		String tableName = "member_tbl_02";
		String msg = "INSERT INTO "+tableName
					+" VALUES (''{0}'',''{1}'',{2},''{3}'');";
		Object[][] arguments = {
				{"둘리","02-123-4567",22,"07-09"},
				{"또치","010-4567-4567",33,"03-11"}
		};
		String[] result = new String[arguments.length];
		for(int i=0; i<arguments.length ; i++) {
			result[i] =
					MessageFormat.format(msg, arguments[i]);
		}
		
		//String[] result를 다시 arguments로 변환하기
		//이때 DB에 저장하기위해 문자타입은 ' ' 를 제거하고 새 패턴을 만들어야한다.
		for(int i=0; i<result.length ; i++) {
			System.out.println(result[i]);
		}
		/*
		INSERT INTO member_tbl_02 VALUES ('둘리','02-123-4567',22,'07-09');
		INSERT INTO member_tbl_02 VALUES ('또치','010-4567-4567',33,'03-11');
		*/
		//다시 Object 배열에 넣는 변환을 한다.
		String pattern = "INSERT INTO member_tbl_02 VALUES ({0},{1},{2},{3});";
		MessageFormat mf = new MessageFormat(pattern);
		
		try {
			for(int i=0; i<result.length ; i++) {
				Object[] objs = mf.parse(result[i]);
				for(int j=0 ; j<objs.length ; j++) {
					System.out.print(objs[j]+",");
				}
				System.out.println();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
