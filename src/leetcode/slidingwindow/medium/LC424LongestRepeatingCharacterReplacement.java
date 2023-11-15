package leetcode.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class LC424LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(longest(s,k));

        //Best way

        System.out.println(longestWithoutMap(s,k));
    }

    private static int longestWithoutMap(String s, int k) {

        int left=0;
        int len=0;
        int[] ch=new int[26];
        int maxFrequency=0;
        for(int i=0;i<s.length();i++){
           int fre=++ch[s.charAt(i)-'A'];
            maxFrequency=Math.max(fre,maxFrequency);
            while(i-left+1-maxFrequency>k){
                ch[s.charAt(left)-'A']--;
                left++;
            }
            len=Math.max(len,i-left+1);
        }
        return len;

        //TC:O(n)
    }

    private static int longest(String s, int k) {

        int left=0;
        int len=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            int maxFrequency=find(map);

            while(i-left+1-maxFrequency>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            len=Math.max(len,i-left+1);
        }
        return len;

        //TC:O(26*n) as at the max map can have 26 characters
    }

    private static int find(HashMap<Character, Integer> map) {

        int max=0;
        for(Map.Entry<Character,Integer> m:map.entrySet())
            max=Math.max(max,m.getValue());
        return max;
    }
}
