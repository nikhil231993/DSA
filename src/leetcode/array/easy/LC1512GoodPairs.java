package leetcode.array.easy;

import java.util.HashMap;

public class LC1512GoodPairs {

    public static void main(String[] args) {
        
       int[] nums =new int[] {5,5,5,5,5};
       
       //Approach 1: Brute
       System.out.println(numIdenticalPairs(nums));
       
       //Approach 2: Better Good for interview
        System.out.println(numIdenticalPairsBetter(nums));

        //Approach 3: Optimal
        System.out.println(numIdenticalPairsOptimal(nums));
    }

    private static int numIdenticalPairsBetter(int[] nums) {

        int n=nums.length;

        HashMap<Integer, Integer> map=new HashMap<>();

        int count=0;
        for(int i=0; i<n; i++){

            if(map.containsKey(nums[i]))
                count+=map.get(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        return count;

        //TC:O(n)
        //SC:O(n) worst case
    }

    public static int numIdenticalPairs(int[] nums) {
        
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
        }
        return count;

        //TC:O(n square)
        //SC:O(1)
    }

    public static int numIdenticalPairsOptimal(int[] A) {

        int res = 0, count[] = new int[101];
        for (int a: A) {
            res += count[a]++;
        }
        return res;

        //TC:O(n)
        //SC:O(1)
    }
}
