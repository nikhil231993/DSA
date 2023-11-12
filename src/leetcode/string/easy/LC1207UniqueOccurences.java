package leetcode.string.easy;

import java.util.HashMap;
import java.util.HashSet;

public class LC1207UniqueOccurences {

    public static void main(String[] args) {
        int[] arr =new int[] {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int n:arr){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        HashSet<Integer> s=new HashSet<>(map.values());
        return map.size()==s.size();
        //TC:O(n)
        //SC:O(2n)
    }
}
