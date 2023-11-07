package leetcode.string.easy;

public class LC392IsSubsequence {

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        int i=0;
        int j=0;
        int n1=s.length();
        int n2=t.length();
        while(i<n1 && j<n2){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
            if(i==n1)
                return true;
        }
        return false;

    }
}
