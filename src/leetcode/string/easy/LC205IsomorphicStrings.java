package leetcode.string.easy;

import java.util.Arrays;
import java.util.HashMap;

public class LC205IsomorphicStrings {

    public static void main(String[] args) {

        String s = "ab", t = "aa";

        //Approach 1
        System.out.println(isIsomorphic(s,t));

        //Approach 2
        System.out.println(isIsomorphicBetter(s,t));


    }

    public static boolean isIsomorphicSelf(String s, String t) {

        int n=s.length();
        int m=t.length();
        int[] sh=new int[256];
        Arrays.fill(sh, -1);
        int[] th=new int[256];
        Arrays.fill(th, -1);

        for(int i=0;i<n;i++){
            int cs=s.charAt(i);
            int ts=t.charAt(i);
            if(sh[cs]!=th[ts])
                return false;
            sh[cs]=i;
            th[ts]=i;
        }
        return true;
    }

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> m1=new HashMap();
        HashMap<Character, Character> m2=new HashMap();

        for(int i=0;i<s.length();i++){

            char s1=s.charAt(i);
            char t1=t.charAt(i);
            if(m1.containsKey(s1)){
                if(m1.get(s1)!=t1)
                    return false;
            }else if(m2.containsKey(t1)){
                if(m2.get(t1)!=s1)
                    return false;
            }
            m1.put(s1,t1);
            m2.put(t1,s1);
        }

        return true;

        // TC:O(n)
        // SC:O(256 * 2)
    }

    public static boolean isIsomorphicBetter(String s, String t) {

        int[] ch1=new int[256];
        int[] ch2=new int[256];

        for(int i=0;i<s.length();i++){

            char cha1=s.charAt(i);// Integer value of the character is stored in array
            char cha2=t.charAt(i);

            if(ch1[cha1]!=ch2[cha2])
                return false;
            ch1[cha1]=i+1; // store the index plus one to know where the character existed in last iteration of the character
            ch2[cha2]=i+1; // if we assign only i then aa, ab will fail
        }

        return true;

        //TC:O(n)
        //SC:O(256 * 2)
    }
}
