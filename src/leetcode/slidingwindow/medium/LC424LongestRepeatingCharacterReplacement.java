package leetcode.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LC424LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        String s = "AAAAABABBBB";
        int  k = 2;

        //Approach 1: Brute
        System.out.println(bruteCharacterReplacement(s,k));

        //Approach 2: Better
        System.out.println(betterCharacterReplacement(s,k));

        //Approach 2: Better optimized to remove 0(26)
        System.out.println(betterCharacterReplacementRemovedLoop(s,k));

        //Approach 3: Best using 'if' instead of 'while'
        System.out.println(bestCharacterReplacement(s,k));
    }

    private static int bestCharacterReplacement(String s, int k) {

        int right=0, left=0, n=s.length(), maxfreq=0 ,maxLen=0;
        int[] arr=new int[26];

        while(right<n){
            arr[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq, arr[s.charAt(right)-'A']);

            if((right-left+1)-maxfreq>k){
                arr[s.charAt(left)-'A']--;
                left++;
            }

            if((right-left+1)-maxfreq<=k){
                maxLen=Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;

        //TC:O(n+n)
        //SC:O(26)
    }

    private static int betterCharacterReplacementRemovedLoop(String s, int k) {

        int right=0, left=0, n=s.length(), maxfreq=0 ,maxLen=0;
        int[] arr=new int[26];

        while(right<n){
            arr[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq, arr[s.charAt(right)-'A']);

            while((right-left+1)-maxfreq>k){
                arr[s.charAt(left)-'A']--;
                left++;
            }

            if((right-left+1)-maxfreq<=k){
                maxLen=Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;

        //TC:O(n+n)
        //SC:O(26)
    }

    private static int betterCharacterReplacement(String s, int k) {

        int right=0, left=0, n=s.length(), maxfreq=0 ,maxLen=0;
        int[] arr=new int[26];

        while(right<n){
            arr[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq, arr[s.charAt(right)-'A']);

            while((right-left+1)-maxfreq>k){
                arr[s.charAt(left)-'A']--;
                for(int i=0;i<26;i++){
                    maxfreq=Math.max(maxfreq, arr[i]);
                }
                left++;
            }

            if((right-left+1)-maxfreq<=k){
                maxLen=Math.max(maxLen, right-left+1);
            }
            right++;
        }
        return maxLen;

        //TC:O(n+n)*O(26)
        //SC:O(26)
    }

    private static int bruteCharacterReplacement(String s, int k) {

        int maxLen=Integer.MIN_VALUE, n=s.length();

        for(int i=0; i<n; i++){
            int[] arr=new int[26];
            int maxFreq=0;

            for(int j=i; j<n ;j++){
                arr[s.charAt(j)-'A']++;
                maxFreq=Math.max(maxFreq, arr[s.charAt(j)-'A']);

                if((j-i+1)-maxFreq <= k){
                    maxLen=Math.max(maxLen, j-i+1);
                }else
                    break;
            }
        }
        return maxLen;

        //TC:O(n*n)
        //SC:O(1)
    }

    private static int characterReplacement(String s, int k) {

        int n=s.length();
        int maxLen=0;
        int left=0, right=0, maxFreq=0;
        Map<Character, Integer> map=new HashMap();
        while(right<n){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            maxFreq=Math.max(maxFreq, map.get(s.charAt(right)));

            if(right-left+1 -maxFreq>k){

                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)
                    map.remove(s.charAt(left));
                left++;
            }
            if(right-left+1 -maxFreq<=k)
                maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
