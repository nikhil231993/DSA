package leetcode.company.leetcode75Remaining;

public class LC1071GCDStrings {

    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    private static String gcdOfStrings(String str1, String str2) {

        if(!(str1+str2).equals(str2+str1)) return "";
        int gcd=gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int gcd(int x, int y){
        if(y==0) return x;
        return gcd(y, x%y);
    }
}
