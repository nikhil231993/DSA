package leetcode.string.easy;

import java.util.*;

public class LC1207UniqueOccurences {

    public static void main(String[] args) {

        int[] arr =new int[] {1,2,2,1,1,3};

        //Approach 1
        System.out.println(uniqueOccurrences(arr));

        //Approach 2
        System.out.println(uniqueOccurrencesOneApproach2(arr));

        //Approach 3
        System.out.println(uniqueOccurrencesApproach3(arr));
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

    public static boolean uniqueOccurrencesOneApproach2(int[] arr) {

        Map<Integer, Integer> freqMap = new HashMap<>();    // maps element in arr to number of occurrences in arr
        for (int currInt : arr) {
            freqMap.put(currInt, freqMap.getOrDefault(currInt, 0) + 1);
        }

        // check whether all values in the map are unique
        Set<Integer> seen = new HashSet<>();

        for (int currValue : freqMap.values()) {
            if (seen.contains(currValue)) {
                return false;     //terminate as soon as a duplicate is detected
            } else {
                seen.add(currValue);
            }
        }
        return true;
    }

    public static boolean uniqueOccurrencesApproach3(int[] arr) {

        int[] result=new int[2001];
        for(int i:arr){
            result[i+1000]++;
        }
        Arrays.sort(result);
        for(int i=0;i<result.length-1;i++){
            if(result[i]!=0 && result[i]==result[i+1])
                return false;
        }
        return true;

        //TC: O(2001 log 2001)
        //SC: O(2000)
    }
}
