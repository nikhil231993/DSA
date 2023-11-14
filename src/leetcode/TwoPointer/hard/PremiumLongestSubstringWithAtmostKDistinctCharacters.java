package leetcode.TwoPointer.hard;

import leetcode.heap.striver.KthSmallestElement;

import java.util.HashMap;

public class PremiumLongestSubstringWithAtmostKDistinctCharacters {

    public static void main(String[] args) {
        String s="abcddefg";
        int k=3;
        System.out.println(kDistinctChars(k,s));
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
