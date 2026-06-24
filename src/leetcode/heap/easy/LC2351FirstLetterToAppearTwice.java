package leetcode.heap.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC2351FirstLetterToAppearTwice {

    public static void main(String[] args) {

        String s="abccbaacz";

        //Approach 1:
        System.out.println(repeatedCharacter(s));

        //Approach 2: More correct in terms of handling the default return using exception
        System.out.println(repeatedCharacterOptimised(s));
    }

    private static char repeatedCharacter(String s) {

        Map<Character, Integer> m=new HashMap();

        for(int i=0; i<s.length(); i++){
            if(m.containsKey(s.charAt(i)))
                return s.charAt(i);
            else
                m.put(s.charAt(i),i);
        }
        return 'a';

        //TC:O(n) in chase all characters are unique
        //SC:O(n)
    }

    public static char repeatedCharacterOptimised(String s) {

        Map<Character, Integer> m=new HashMap();

        for(int i=0; i<s.length(); i++){
            if(m.containsKey(s.charAt(i)))
                return s.charAt(i);
            else
                m.put(s.charAt(i),i);
        }
        throw new IllegalArgumentException();

        //TC:O(n) in chase all characters are unique
        //SC:O(n)
    }

    private char repeatedCharacterSet(String s) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)))
                return s.charAt(i);
            set.add(s.charAt(i));
        }
        return 'a';
    }

    private char repeatedCharacterArray(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1)
                return s.charAt(i);
            arr[s.charAt(i)-'a']++;
        }
        return 'a';
    }
}
