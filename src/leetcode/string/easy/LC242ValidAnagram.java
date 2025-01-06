package leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;

public class LC242ValidAnagram {

    public static void main(String[] args) {

        String s = "rac", t = "car";

        //Approach 1
        System.out.println(isAnagram(s,t));

        //Approach 2
        System.out.println(isAnagramApproach2(s,t));
    }

    public static boolean isAnagram(String s, String t) {

        int[] ch1=new int[26];
        int[] ch2=new int[26];
        int n1=s.length(), n2=t.length();

        if(n1!=n2)
            return false;
        for(int i=0;i<n1;i++){
            ch1[s.charAt(i)-'a']++;
            ch2[t.charAt(i)-'a']++;
        }
        for(int k=0;k<ch1.length;k++){
            if(ch1[k]!=ch2[k])
                return false;
        }
        return true;

        //TC:O(255)
        //SC:O(255)
    }

    public static boolean isAnagramApproach2(String s, String t) {

        Map<Character, Integer> map=new HashMap();
        for(int i=0; i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        int count=0;
        for(int i=0; i<t.length();i++){
            if(map.getOrDefault(t.charAt(i),0)>0){
                map.put(t.charAt(i), map.get(t.charAt(i))-1);
                count++;
            }
        }
        return count==t.length() && count == s.length();

        //TC: O(t+s)
        //SC: O(t)
    }
}
