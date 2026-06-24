package leetcode.company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class LC93IPAddress {

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> result=restoreIpAddresses(s);
        System.out.println(result);
    }

    private static List<String> restoreIpAddresses(String s) {

        if(s.length()==0) return new ArrayList<>();
        int n=s.length();
        if(n>12) return new ArrayList<>();
        List<String> ans=new ArrayList<>();

        func(0, 0, s, "", ans, n);
        return ans;
        //TC:O(3 raise to 4) as the max choices for is 3 at each stage and max depth of tree is for 4 which is 4 parts
    }

    private static void func(int i, int parts, String s, String sb, List<String> ans, int n){
        if(i==n && parts==4){
            ans.add(sb.substring(0, sb.length()-1));
            return;
        }

        if(i>=n || parts>4)
            return;

        if(i+1<=n)
            func(i+1, parts+1, s, sb+s.substring(i, i+1) +("."), ans, n);
        if(i+2<=n && isValid(s.substring(i, i+2)))
            func(i+2, parts+1, s, sb+s.substring(i, i+2)+("."), ans, n);

        if(i+3<=n && isValid(s.substring(i, i+3)))
            func(i+3, parts+1, s, sb+s.substring(i, i+3)+("."), ans, n);
    }

    private static boolean isValid(String s){
        if(s.charAt(0)=='0')
            return false;
        int num=Integer.parseInt(s);
        if(num>255)
            return false;
        return true;
    }
}
