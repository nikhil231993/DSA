package leetcode.slidingwindowandtwopointer.hard;

import java.util.HashMap;

public class PremiumLongestSubstringWithKUnqiueCharacters {

    public static void main(String[] args) {
        String s="aabacbebebe";
        int K = 3;

        System.out.println(longest(s,K));
    }

    private static int longest(String s, int k) {
        int n=s.length();
        int len=0;
        HashMap<Character,Integer> m=new HashMap<>();
        int l=0,r=0;

        while(r<n){
            Character rc=s.charAt(r);
           if(m.containsKey(rc)){
               m.put(rc,m.get(rc)+1);
           }else{

               while(m.size()>=k){
                   Character lc=s.charAt(l);
                   if(m.get(lc)==1)
                       m.remove(lc);
                   else
                       m.put(lc,m.get(lc)-1);
                   l++;
               }
               m.put(rc,1);
           }
            if(m.size()==k)
                len=Math.max(len,r-l+1);
           r++;
        }
        return len;
    }
}
