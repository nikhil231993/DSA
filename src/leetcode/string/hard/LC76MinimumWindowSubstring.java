package leetcode.string.hard;

import java.util.HashMap;

public class LC76MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";

        //Approach 1 : Brute force Generate all the combinations

        //Approach 2:
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        int startingIndex=-1, right=0, left=0, n=s.length(), count=0;
        Integer minLen=Integer.MAX_VALUE;
        HashMap<Character, Integer> map=new HashMap<>();

        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        while(right<n){

            if(map.getOrDefault(s.charAt(right),0)>0)
                count++;
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)-1);

            while(count==t.length()){// while cannot be replaced with if as we have to shrink it

                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startingIndex=left;
                }
                map.put(s.charAt(left), map.get(s.charAt(left))+1);
                if(map.get(s.charAt(left))>0)
                    count--;
                left++;
            }
            right++;
        }
        return startingIndex==-1?"":s.substring(startingIndex,startingIndex+minLen);
    }
}
