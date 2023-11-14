package leetcode.TwoPointer.medium;

import java.util.HashMap;
import java.util.Map;

public class LC424LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        //Approach 1
        System.out.println(characterReplacement(s, k));
        //Approach 2 we do while loop processing only when maxFre is more because we want to make length-maxFreq<=k
        System.out.println(characterReplacementBetter(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int len=0;
        HashMap<Character ,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            int left=0;
            int maximum=maxi(map);

            while(i-left+1-maximum>k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            len=Math.max(i-left+1,len);
        }
        return len;
        //TC:O(2N*26)
        //SC:O(26)
    }

    public static int characterReplacementBetter(String s, int k) {
        int len=0;
        int maximum=0;
        HashMap<Character ,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            int left=0;
             //This need not be reduced as to increase length we need to have larger frequency
            maximum=Math.max(maximum, map.get(s.charAt(i)));

            while(i-left+1-maximum>k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            len=Math.max(i-left+1,len);
        }
        return len;
        //TC:O(2N)
        //SC:O(26)
    }

    public static int maxi(HashMap<Character, Integer> map){
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> m: map.entrySet()){
            max=Math.max(max, m.getValue());
        }
        return max;
    }
}
