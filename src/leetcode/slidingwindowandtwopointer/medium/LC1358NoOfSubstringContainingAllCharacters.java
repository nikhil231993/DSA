package leetcode.slidingwindowandtwopointer.medium;

import java.util.HashMap;

public class LC1358NoOfSubstringContainingAllCharacters {

    public static void main(String[] args) {
        String s = "abcabc";

        System.out.println(count(s));
    }

    //Step 1: Take left and right pointers
    //Step 2:Create a map or an array for a, b, b
    //Step 3:Take count by adding left as we calculate for future.
    private static int count(String s) {
        int count=0;
        int n=s.length();
        HashMap<Character, Integer> m=new HashMap<>();
        int l=0,r=0;
        while(r<n){
            Character rc=s.charAt(r);
            m.put(rc,m.getOrDefault(rc,0)+1);

            while(m.getOrDefault('a',0)>0 && m.getOrDefault('b',0)>0 && m.getOrDefault('c',0)>0){
                Character lc=s.charAt(l);
                m.put(lc,m.get(lc)-1);
                l++;
            }
            count+=l;
            r++;
        }
        return count;
    }
}
