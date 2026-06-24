package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class DP45LC1048LongestStringChain {

    public static void main(String[] args) {

        String[] words = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};

        // Arrays.sort(words, (a, b) -> a.compareTo(b)); // Sorts lexicographically
        // System.out.println(Arrays.toString(words)); // Output: [cxbc, pcxbc, pcxbcf, xb, xbc]

        // Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        // Arrays.sort(words, (a,b)->a.length()-b.length());
        // Sort by length first, then lexicographically for equal length

//        Arrays.sort(words, (a, b) -> {
//            if (a.length() != b.length()) {
//                return Integer.compare(a.length(), b.length());
//            }
//            return a.compareTo(b);
//        });

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

    private static boolean compare(String current, String previous) {

        if(current.length()!=previous.length()+1)
            return false;
        int curr=0;
        int prev=0;
        while(curr<current.length()){ // bigger string
            if(prev<previous.length() && current.charAt(curr)==previous.charAt(prev)){
                curr++;
                prev++;
            }else {
                curr++;
            }
        }

        if(curr==current.length() && previous.length()==prev)
            return true;

        return false;
    }
}
