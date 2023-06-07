package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class DP45LC1048LongestStringChain {

    public static void main(String[] args) {
        String[] words = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
        Comparator<String> comp=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };

        Arrays.sort(words,comp);
        int n=words.length;

        System.out.println(stringChain(words,n));
        //TC:O(N square * max length of string)+O(NlogN)
        //SC:O(N)dp
    }

    private static int stringChain(String[] words, int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(compare(words[i],words[j]) && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    max=Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }

    private static boolean compare(String second, String first) {
        if(second.length()!=first.length()+1)
            return false;
        int i=0;
        int j=0;
        while(i<second.length()){
            if(j<first.length() && second.charAt(i)==first.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }
        }

        if(i==second.length() && first.length()==j)
            return true;

        return false;
    }
}
