package leetcode.array.medium;

import java.util.HashMap;

public class LC1248NiceSubarray {

    public static void main(String[] args) {

        int[] nums =new int[] {1,1,2,1,1};
        int k = 3;

        //Approach 1: Optimal Refer LC560 for brute force as both are same
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {

        int n=nums.length;

        for(int i=0; i<n;i++){
            if(nums[i]%2==0)
                nums[i]=0;
            else if(nums[i]%2==1)
                nums[i]=1;
        }

        HashMap<Integer, Integer> m=new HashMap();

        int sum=0;
        int count=0;
        for(int i=0;i<n;i++){

            sum+=nums[i];
            if(sum==k)
                count++;

            if(m.containsKey(sum-k)){
                count+=m.get(sum-k);
            }
            m.put(sum,m.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
