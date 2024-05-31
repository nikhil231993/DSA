package leetcode.string.easy;

public class LC1903LargestOddNumberSubString {

    public static void main(String[] args) {
        String num = "35427";
        System.out.println(largestOddNumber(num));
    }

    public static String largestOddNumber(String num) {

        int n=num.length()-1;
        for(int i=n;i>=0;i--){
            int no=num.charAt(i)-'0';
            if(no%2==1)
                return num.substring(0, i+1);
        }
        return "";

        //TC:O(n)
        //SC:O(1)
    }
}
