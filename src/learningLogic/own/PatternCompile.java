package learningLogic.own;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCompile { 

    public static void main(String[] args) throws IOException
    {
        final String regex = "^(?<name>.*)Begin\\\\s*$";
        final String string = "IndexSectionBegin";
        
        final Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(string);
        
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }}
}
