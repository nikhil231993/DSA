package leetcode.company.leetcode75Remaining;

import java.util.Arrays;

public class LC1657DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        String word1 = "abc", word2 = "bca";
        System.out.println(closeStrings(word1, word2));
    }

    private static boolean closeStrings(String word1, String word2) {
        int[] ch1=new int[26];
        int[] ch2=new int[26];
        for(int i=0;i<word1.length();i++)
            ch1[word1.charAt(i)-'a']++;
        for(int i=0;i<word2.length();i++)
            ch2[word2.charAt(i)-'a']++;
        for(int i=0;i<26;i++){
            if((ch1[i]==0 && ch2[i]!=0) || ch2[i]==0 && ch1[i]!=0) return false;
        }
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0;i<26;i++)
            if(ch1[i]!=ch2[i])
                return false;
        return true;
    }
}
