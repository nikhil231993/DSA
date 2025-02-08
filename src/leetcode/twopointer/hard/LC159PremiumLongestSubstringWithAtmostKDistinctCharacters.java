package leetcode.twopointer.hard;

import java.util.HashMap;
import java.util.HashSet;

public class LC159PremiumLongestSubstringWithAtmostKDistinctCharacters {

    public static void main(String[] args) {

        String s="abcddefg";
        int K=3;

        //This is old code, no need to learn this. Learn below three approaches
        System.out.println(kDistinctChars(K,s));

        //Approach 1: Brute
        System.out.println(bruteLongest(s,K));

        //Approach 2: Better
        System.out.println(betterLongest(s,K));

        //Approach 3: Best
        System.out.println(bestLongest(s,K));
    }

    private static int bestLongest(String s, int k) {

        Integer maxLen=Integer.MIN_VALUE;
        int right=0, left=0;
        HashMap<Character, Integer> map= new HashMap<>();
        int n=s.length();

        while(right<n){

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            if(map.size()>k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)
                    map.remove(s.charAt(left));
                left++;
            }
            if(map.size()<=k)
                maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;

        //TC:O(n) *  log (256)  This is for map
        //SC:O(k)
    }

    private static int betterLongest(String s, int k) {

        Integer maxLen=Integer.MIN_VALUE;
        int right=0, left=0;
        HashMap<Character, Integer> map= new HashMap<>();
        int n=s.length();

        while(right<n){

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)
                    map.remove(s.charAt(left));
                left++;
            }
            if(map.size()<=k)
                maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;

        //TC:(O(N)+O(N))*  log (256)  This is for map
        //SC:O(K)
    }

    private static int bruteLongest(String s, int k) {

        Integer maxLen=Integer.MIN_VALUE;
        int n=s.length();

        for(int i=0; i<n; i++){
            HashSet<Character> set=new HashSet<>();

            for(int j=i; j<n; j++){
                set.add(s.charAt(j));
                if(set.size()<=k){
                    maxLen=Math.max(maxLen, j-i+1);
                }else
                    break;
            }
        }
        return maxLen;

        //TC:O(n square) *  log (256)  This is for map
        //SC:O(k
    }

    public static int kDistinctChars(int k, String str) {
        return subArrayWithAtmostTwo(k, str);
    }

    private static int subArrayWithAtmostTwo(int k, String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int len=0;
        int minIndex=0;
        while(right<s.length()){
            char chRight=s.charAt(right);
            map.put(chRight,map.getOrDefault(chRight,0)+1 );
            if(map.size()<=k && right-left+1>len){
                len=right-left+1;
                minIndex=left;//Just in case string is to be returned
            }
            while(map.size()>k){
                char chLeft=s.charAt(left);
                if(map.get(chLeft)==1)
                    map.remove(chLeft);
                else if(map.get(chLeft)>1)
                    map.put(chLeft, map.get(chLeft)-1);
                left++;
                if(map.size()==k && right-left+1>len){
                    len=right-left+1;
                    minIndex=left;//Just in case string is to be returned
                }
            }
            right++;
        }
        return len;
    }
}
