package format;

import java.text.MessageFormat;

public class MessageFormatEx01 {
	public static void main(String[] args) {
		String msg = "Name : {0} "
					+ "\nTel: {1} "
					+ "\nAge: {2} "
					+ "\nBirthday: {3}";
		Object[] arguments = {
			"둘리","02-1234-1234","25","04-15"	
		};
		
		String result =
				MessageFormat.format(msg, arguments);
		System.out.println(result);
	}
}
