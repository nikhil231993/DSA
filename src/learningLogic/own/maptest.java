package learningLogic.own;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.HashAttributeSet;


public class maptest {

	public static boolean isValidDate(String d)
    {
        String regex = "\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1-2]\\d|3[0-1])T(?:[0-1]\\d|2[0-3]):[0-5]\\d:[0-5]\\d(?:\\.\\d+|)(?:Z|(?:\\+|\\-)(?:\\d{2}):?(?:\\d{2}))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
  
    public static void main(String args[])
    {
        System.out.println(isValidDate("10/12/2016"));
        System.out.println(isValidDate("2022-02-15T13:21:04Z"));
    }
}
