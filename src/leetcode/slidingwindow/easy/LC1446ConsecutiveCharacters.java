package leetcode.slidingwindow.easy;

public class LC1446ConsecutiveCharacters {

    public static void main(String[] args) {

        String s = "abbcccddddeeeeedcba";

        System.out.println(maxPower(s));
        System.out.println(maxPowerSelf(s));
    }
    public static int maxPowerSelf(String s) {

        int count=1, max=1;
        int n=s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1))
                count++;
            if(s.charAt(i)!=s.charAt(i-1))
                count=1;
            max=Math.max(max, count);
        }
        return max;
    }


    public static int maxPower(String s) {

        int n=s.length(), count=0, maxLen=-1;
        char prev=' ';

        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            if(c==prev){
                count++;
            }else{
                count=1;
                prev=c;
            }
            maxLen=Math.max(maxLen, count);
        }
        return maxLen;

        //TC:O(n)
        //SC:O(1)
    }
}
