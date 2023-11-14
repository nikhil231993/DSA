package leetcode.string.hard;

import java.util.HashMap;

public class LC76MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {

        //Step 1: Create a hashmap of the pattern
        //Step 2: have 2 pointers right amd left
        //Step 3: Parse string s and if teh character is present on map increase count.
        //Step 4: if present or not present decrease the count in map
        //Step 5: if count==length of small string then move left pointer and do above in reverse

        if(s.length()==0 || t.length()==0)
            return "";

        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        String result="";
        int left=0, right=0, len=Integer.MAX_VALUE, count=0, minIndex=-1;

        while(right< s.length()){
            char rightChar=s.charAt(right);
            if(map.getOrDefault(rightChar,0)>0)
                count++;
            map.put(rightChar, map.getOrDefault(rightChar,0)-1);

            while(count==t.length()){
                char leftChar=s.charAt(left);

                if(right-left+1<len){
                    len=right-left+1;
                    minIndex=left;
                }

                map.put(leftChar, map.getOrDefault(leftChar,0)+1);
                if(map.get(leftChar)>0){
                    count--;
                }
                left++;
            }
            right++;
        }

        if(len==Integer.MAX_VALUE)
            return "";

        return s.substring(minIndex, minIndex+len);
        //TC:O(2N)
        //SC:O(n) result+O(t) for map
    }
}
