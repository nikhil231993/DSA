package leetcode.slidingwindow.hard;

import java.util.HashMap;

public class LC76MinimumWIndowSubstring {

    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";

        System.out.println(minwindowsubstring(s,t));
    }

    private static String minwindowsubstring(String s, String t) {

        if(s.length() ==0 || t.length()==0 || s.length()<t.length())
            return "";

        int l=0,r=0,count=0;
        int minLength=Integer.MAX_VALUE;
        int startIndex=0;

        HashMap<Character,Integer> m=new HashMap<>();

        for(int i=0;i<t.length();i++){
            Character tC=t.charAt(i);
            m.put(tC,m.getOrDefault(tC,0)+1);
        }

        while(r<s.length()){
            Character rC=s.charAt(r);
            if(m.getOrDefault(rC,0)>0)
                count++;
            m.put(rC,m.getOrDefault(rC,0)-1);

            while(count==t.length()){

                if(minLength>r-l+1){
                    minLength=r-l+1;
                    startIndex=l;
                }
                Character lC=s.charAt(l);
                m.put(lC,m.getOrDefault(lC,0)+1);

                if(m.get(lC)>0)
                    count--;
                l++;
            }
            r++;
        }

        if(minLength==Integer.MAX_VALUE)
            return "";

        String result=s.substring(startIndex,minLength+startIndex);
        return result;

    }
}
