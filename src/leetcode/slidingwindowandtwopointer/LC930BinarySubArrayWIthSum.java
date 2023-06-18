package leetcode.slidingwindowandtwopointer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LC930BinarySubArrayWIthSum {

    public static void main(String[] args) {
        int[] nums=new int[]{1,0,0,0,0};
        int goal=0;
        System.out.println(numSubarraysWithSum(nums,goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {

        int sum=0;
        int count=0;
        HashMap<Integer,Integer> m=new LinkedHashMap<>();
        m.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            // if(sum==k){
            //     count++;
            // }
            if (m.containsKey(sum - goal)) {
                count+=m.get(sum-goal);
            }
            m.put(sum,m.getOrDefault(sum,0)+1);
        }
        return count;

    }
}
