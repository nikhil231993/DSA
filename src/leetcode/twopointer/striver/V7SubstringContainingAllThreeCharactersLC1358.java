package leetcode.twopointer.striver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;

public class V7SubstringContainingAllThreeCharactersLC1358 {

    public static void main(String[] args) {

        //String s = "aaacb";
        String s = "bbacba";

        //Approach 1: Brute
        System.out.println(bruteNumberOfSubstrings(s));

        //Approach 2: Better is slight modification of brute
        System.out.println(betterNumberOfSubstrings(s));

        //Approach 3: Best
        System.out.println(bestNumberOfSubstrings(s));

        //Approach 4: Using Two Pointer
        System.out.println(bestNumberOfSubstringsApproach(s));

        //we cannot use "if" instead of "while" as in counting we will miss some subarrays. Take an example and try out
        //Finding Longest length we can use as its to find max length
    }

    private static int bestNumberOfSubstringsApproach(String s) {

        int atleastThree=bestLongest(s, 3);
        int lessThanThree=bestLongest(s, 2);
        return atleastThree-lessThanThree;
    }

    private static int bestLongest(String s, int k) {

        int count=0;
        int right=0, left=0;
        HashMap<Character, Integer> map= new HashMap<>();
        int n=s.length();

        while(right<n){

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)
                    map.remove(s.charAt(left));
                left++;
            }
            if(map.size()<=k)
                count+=right-left+1;
            right++;
        }
        return count;

        //TC:O(n) *  log (256)  This is for map
        //SC:O(k)
    }

    private static int betterNumberOfSubstrings(String s) {

        int count=0;
        int n=s.length();

        for(int i=0; i<n; i++){

            HashSet<Character> set=new HashSet<>();
            for(int j=i; j<n; j++){

                set.add(s.charAt(j));
                if(set.size()==3){
                    count+= (n-j);// we can add count =count+n-j and then breakout as all the strings after that also satisfy the condition
                    break;
                }
            }
        }
        return count;

        //TC:O(n square)
        //SC:O(3)
    }

    private static int bruteNumberOfSubstrings(String s) {

        int count=0;
        int n=s.length();

        for(int i=0; i<n; i++){

            HashSet<Character> set=new HashSet<>();
            for(int j=i; j<n; j++){

                set.add(s.charAt(j));
                if(set.size()==3){
                    count++; // we can add count =count+n-j and then breakout a all the strings after that also satisfy the condition
                }
            }
        }
        return count;

        //TC:O(n square)
        //SC:O(3)
    }

    private static int bestNumberOfSubstrings(String s) {

        int[] arr=new int[3];
        Arrays.fill(arr, -1);

        int count=0, n=s.length();

        for(int i=0;i<n;i++){

            arr[s.charAt(i)-'a']=i;
            if(arr[0]!=-1 && arr[1]!=-1 && arr[2]!=-1){
                count+=Math.min(arr[0], Math.min(arr[1],arr[2])) +1;
            }
        }

        return count;

        //TC:O(n)
        //SC:O(3)
    }
}
