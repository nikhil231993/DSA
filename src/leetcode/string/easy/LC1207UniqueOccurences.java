package leetcode.string.easy;

import java.util.*;

public class LC1207UniqueOccurences {

    public static void main(String[] args) {

        int[] arr =new int[] {1,2,2,1,1,3};

        //Approach 1
        System.out.println(uniqueOccurrences(arr));

        //Approach 2: This is optimal
        System.out.println(uniqueOccurrencesOneApproach2(arr));

        //Approach 3
        System.out.println(uniqueOccurrencesApproach3(arr));
    }

    private static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int n:arr){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        HashSet<Integer> s=new HashSet<>(map.values());
        return map.size()==s.size();

        //TC:O(n)
        //SC:O(2n)
    }

    private static boolean uniqueOccurrencesOneApproach2(int[] arr) {

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

        //TC: O(N).
        //We iterate over the array arr to find the frequency and store them in the hash map freq.
        //Then, we insert these frequencies in the hash set freqSet, which has the insertion complexity of O(1).
        //Hence, the total time complexity is equal to O(N)

        //SC:O(2*N)
        //We are storing the N frequencies in the hash map freq that takes O(1) space for each element.
        //We also store the frequency count in the hash set. Therefore, the total space complexity is equal to O(N).
    }

    private static boolean uniqueOccurrencesApproach3(int[] arr) {

        int[] result=new int[2001];
        for(int i:arr){
            result[i+1000]++;
        }
        Arrays.sort(result);
        for(int i=0; i<result.length-1; i++){
            if(result[i]!=0 && result[i]==result[i+1])
                return false;
        }
        return true;

        //TC:O(2001 log 2001)
        //SC:O(2000)
    }
}
