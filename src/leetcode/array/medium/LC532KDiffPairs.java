package leetcode.array.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC532KDiffPairs {

    public static void main(String[] args) {

        int[] nums =new int[] {3,1,4,1,5};
        int k = 2;

        //Approach 1: Brute (user 2 for loops)

        //Approach 2: Better Use for loop and binary Search

        //Approach 3: Two pointer
        System.out.println(findPairsBetter(nums, k));

        //Approach 4: Optimal
        System.out.println(findPairsOptimal(nums, k));
    }

    public static int findPairsBetter(int[] nums, int k) {

        int n=nums.length;

        Arrays.sort(nums);

        int i=0;
        int j=i+1;

        int count=0;
        while(i<j && i< n && j< n){
            if(nums[j]-nums[i]==k){
                count++;
                i++;
                j++;

            while(j<n && nums[j]==nums[j-1])
                j++;
            }else if(nums[j]-nums[i]<k)
                j++;
            else{
                i++;
                if(i==j)
                    j++;
            }
        }
        return count;

        //TC:O(nlogn)
        //SC:O(1)
    }

    public static int findPairsOptimal(int[] nums, int k) {

        int n=nums.length;

        HashMap<Integer, Integer> map=new HashMap();

        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        int count=0;
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            int x=m.getKey();
            if((k>0 && map.containsKey(x+k))||(k==0 && map.get(x)>1)){ // Since we have already added the values in map it can be x+k or x-k
                count++;
            }
        }
        return count;

        // TC:O(n)
        // SC:O(n)
    }
}
