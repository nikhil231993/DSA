package leetcode.TwoPointer.hard;

import java.util.HashMap;
public class PremiumLongestSubStringWithTwoDistinctCharacters {

    public static void main(String[] args) {
        String s="ninninja";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        return subArrayWithAtmostTwo(s,2);
    }

    private static int subArrayWithAtmostTwo(String s, int k) {
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
