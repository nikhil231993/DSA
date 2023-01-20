package learningLogic;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternMatcher {

	public static void main(String[] args) {

		ArrayList<String> qryParams = new ArrayList<>();
		Matcher matcher = Pattern.compile("@\\w+").matcher("select * from LamPRO s WHERE s.category = @Category");
		while (matcher.find()) {
			qryParams.add(matcher.group());
		}
		System.out.println(qryParams);
	}
	

	
	

}
