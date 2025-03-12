package leetcode.slidingwindow.medium;

import java.util.HashMap;

public class gfgCountOccurencesOfAnagrams {

    public static void main(String[] args) {

        String txt = "forxxorfxdofr";
        String pat = "for";

        //Approach 1: Brute using two for loops

        //Approach 2: Better using while loop

        //Approach 3: Best
        System.out.println(minWindow(pat, txt));
    }

    public static int minWindow(String pat, String txt) {

        int right=0, left=0, n=txt.length(), count=0, ans=0;
        HashMap<Character, Integer> map=new HashMap<>();

        for(int i=0; i<pat.length(); i++){
            map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i),0)+1);
        }

        while(right < n){
            if(map.getOrDefault(txt.charAt(right),0)>0)
                count++;
            map.put(txt.charAt(right), map.getOrDefault(txt.charAt(right),0)-1);

            if(right-left+1==pat.length()){ //while can be used but it will be better approach
                if(count==pat.length())
                    ans++;
                map.put(txt.charAt(left), map.get(txt.charAt(left))+1);
                if(map.get(txt.charAt(left))>0)
                    count--;
                left++;
            }
            right++;
        }
        return ans;

        //TC:O(n)
        //SC:O(n)
    }
}
