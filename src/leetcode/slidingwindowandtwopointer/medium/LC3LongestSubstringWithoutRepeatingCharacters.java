package leetcode.slidingwindowandtwopointer.medium;

import java.util.HashMap;
import java.util.HashSet;

public class LC3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        //Brute force: generate all substring using kadane's algo which is O(N cube) which Striver has done it seems

        String s="takeUforward";

        //First using hashset
        //Step 1: have l and r at start position
        //Step 2: If set does not contain character at r add it in set and calculate len and move r by 1
        //Step 3: If set has character present at r then delete the character at position of l and move left;

        System.out.println(setCalculation(s));

        //Second using map to improve the TC to O(N)
        //Step 1: Create a hashmap to store character and its position
        //Step 2: if map contains character increase the left to present character at right +1 or left
        //Step 3: then calculate len and increase right and add new index of present character into the map

        System.out.println(mapCalculation(s));
    }

    private static int mapCalculation(String s) {

        HashMap<Character,Integer> map=new HashMap<>();
        int left=0, right=0;
        int len=0;

        while(right<s.length()){
            if(map.containsKey(s.charAt(right)))
                left=Math.max(map.get(s.charAt(right))+1,left);

            map.put(s.charAt(right),right);
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;

    }

    private static int setCalculation(String s) {

        HashSet<Character> hs=new HashSet<>();

        int left=0, right=0;
        int len=0;
        while(right<s.length()){
            if(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }else{
                hs.add(s.charAt(right));
                len=Math.max(len,right-left+1);
                right++;
            }
        }
        return len;
        //TC:O(2N)
        //SC:O(N)
    }
}
