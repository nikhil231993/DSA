package learningLogic.own;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


public class Time {	

	public static void main(String[] args) throws ParseException {
//		String input="2022-02-15T13:21:04.133Z";
		
//		String isoDatePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
//
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
//
//		String dateString = simpleDateFormat.format(new Date());
//		
//		System.out.println(dateString);
//		
//		System.out.println(Instant.parse("2022-02-15T13:21:04.133Z"));
//		SimpleDateFormat sdf = new SimpleDateFormat(isoDatePattern);
//		sdf.format(input);

		System.out.println("Current time is : "+java.time.LocalDate.now().toString().replace("-", ""));
	}
}
