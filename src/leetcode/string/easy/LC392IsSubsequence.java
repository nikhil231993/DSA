package leetcode.string.easy;

public class LC392IsSubsequence {

    public static void main(String[] args) {

        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    private static boolean isSubsequence(String s, String t) {

        if(s.length()==0)
            return true;
        int i=0, j=0, n1=s.length(), n2=t.length();
        while( i < n1 && j < n2 ){  // i<n1 is also not needed
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else
                j++;
        }
        return i==n1;

        //TC: O(N+M) where n is the length of the largest string
        //SC: O(1)
    }
}
