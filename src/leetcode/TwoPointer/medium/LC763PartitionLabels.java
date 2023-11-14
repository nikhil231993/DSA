package leetcode.TwoPointer.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC763PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {

        //Step 1: Create a map with last index of each character
        //Step 2: use max indicator to know the last occurence of a particular letter
        //Step 3: the moment u reach last letter then that is the string length

        HashMap<Character, Integer> map=new HashMap();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch, i);
        }

        int prev=-1;
        int max=0;
        List<Integer> list=new ArrayList<>();

        for(int i=0; i<s.length();i++){
            char ch=s.charAt(i);
            max=Math.max(map.get(ch),max);
            if(max==i){
                list.add(max-prev);
                prev=max;
            }
        }
        return list;
        //TC:O(2n)
        //SC:O(n) for map in worst case + O(n) for list
    }
}
