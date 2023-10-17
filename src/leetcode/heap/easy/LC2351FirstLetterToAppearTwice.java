package leetcode.heap.easy;

import java.util.HashMap;
import java.util.Map;

public class LC2351FirstLetterToAppearTwice {

    public static void main(String[] args) {
        String s="abccbaacz";
        System.out.println(repeatedCharacter(s));
    }

    public static char repeatedCharacter(String s) {
        Map<Character, Integer> m=new HashMap();
        for(int i=0;i<s.length();i++){
            if(m.containsKey(s.charAt(i)))
                return s.charAt(i);
            else
                m.put(s.charAt(i),i);
        }
        return 'a';
        //TC:O(n) in chase all characters are unique
        //SC:O(n)
    }
}
