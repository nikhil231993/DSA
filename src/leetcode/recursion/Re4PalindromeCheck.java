package leetcode.recursion;

public class Re4PalindromeCheck {

    public static void main(String[] args) {
        String s="malayalama";
        System.out.println(check(0,s.length(),s));

    }

    private static boolean check(int i, int length, String s) {

        if(i>=length/2)
            return true;
        if(s.charAt(i)!=s.charAt(length-i-1))
            return false;
        return check(i+1,length,s);
        //TC:O(N/2) where N is the length of the string
        //SC:O(N/2) where N is the length of the string
    }
}
