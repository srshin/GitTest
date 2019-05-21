package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateToString(Date d) {
		String s ; 
		SimpleDateFormat sd = new SimpleDateFormat("yyyy년도-MM월-dd일 hh:mm:ss");
		s = sd.format(d);
		return s; 
		
	}
}
