package leetcode.company.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC761SpecialBinaryString {

    public static void main(String[] args) {
        String s = "11011000";
        System.out.println(makeLargestSpecial(s));
    }

    private static String makeLargestSpecial(String s) {
        int n=s.length();
        int count=0, start=0;
        List<String> specialSubStrings=new ArrayList();
        for(int i=0;i<n;i++){

            if(s.charAt(i)=='1')
                count++;
            else
                count--;
            if(count==0){
                String specialSubString="1"+makeLargestSpecial(s.substring(start+1, i))+"0";
                specialSubStrings.add(specialSubString);
                start=i+1;
            }
        }

        Collections.sort(specialSubStrings, Collections.reverseOrder());

        StringBuilder sb=new StringBuilder();
        for(String str: specialSubStrings)
            sb.append(str);
        return sb.toString();

        //TC:O(n sqaure)
    }
}
