package leetcode.slidingwindow.medium;

import java.util.HashMap;
import java.util.HashSet;

public class gfgLongestKUniqueCharactersSubstring {

    public static void main(String[] args) {

        String s = "aabacbebebe"; int k = 3;

        //Approach 1: Brute
        //using n square

        //Approach 2: Better
        // same as below but using while loop in line 42

        //Approach 3: Best
        System.out.println(func(s,k));

        //In this Longest Subarray or Substring of length == k we can do it directly
        //i.e., we do not have to evaluate k and k-1 as it is asking for longest
        //only if we need to find no of subarray or substring of exactly k we need k or k-1
    }

    public static int func(String s, int k){

        HashSet<Character> set=new HashSet();
        for(int i=0; i<s.length(); i++)
            set.add(s.charAt(i));
        if(set.size()<k)
            return -1;

        int maxLen=-1;
        int right=0, left=0;
        HashMap<Character, Integer> map= new HashMap<>();
        int n=s.length();

        while(right<n){

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            if(map.size()>k){ // we can use while loop also here
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

        //TC:O(n)
        //SC:O(1)
    }
}
