package leetcode.twopointer.striver;

import java.util.HashMap;

public class V12MinimumWindowSubstringLC76 {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";

        //Approach 1 : Brute force Generate all the combinations
        System.out.println(minWindowBrute(s, t));

        //Approach 2:
        System.out.println(minWindow(s, t));
    }

    private static String minWindowBrute(String s, String t) {

        int ns=s.length();
        int nt=t.length();
        int startIndex=-1;
        int minLen=Integer.MAX_VALUE;

        for(int i=0; i<ns;i++){

            int count=0;
            int[] ch=new int[256];
            for(int j=0; j<nt; j++)
                ch[t.charAt(j)-'A']++;
            for(int k=i; k<ns; k++){

                if(ch[s.charAt(k)-'A']>0)
                    count++;
                ch[s.charAt(k)-'A']--;
                if(count==nt){
                    if(minLen>(k-i+1)){
                        minLen=k-i+1;
                        startIndex=i;
                        break;
                    }
                }
            }
        }
        return startIndex==-1?"":s.substring(startIndex, startIndex+minLen);
    }

    public static String minWindow(String s, String t) {

        int startingIndex=-1, right=0, left=0, n=s.length(), count=0;
        Integer minLen=Integer.MAX_VALUE;
        HashMap<Character, Integer> map=new HashMap<>();

        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        while(right<n){

            if(map.getOrDefault(s.charAt(right),0)>0)
                count++;
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)-1);

            while(count==t.length()){ // while cannot be replaced with if as we have to shrink it

                if(right-left+1<minLen){
                    minLen=right-left+1;
                    startingIndex=left;
                }
                map.put(s.charAt(left), map.get(s.charAt(left))+1);
                if(map.get(s.charAt(left))>0)
                    count--;
                left++;
            }
            right++;
        }
        return startingIndex==-1?"":s.substring(startingIndex,startingIndex+minLen);
    }
}
