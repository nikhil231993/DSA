package leetcode.company.microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1365HowManyNumbers {

    public static void main(String[] args) {
        int[] nums =new int[] {8,1,2,2,3};
        int[] result=smallerNumbersThanCurrent(nums);
        for(int no:result)
            System.out.println(no);
    }

    private static  int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] dup = nums.clone();
        Arrays.sort(dup);
        for (int i = 0; i < dup.length; i++) {
            if (!map.containsKey(dup[i])) {
                map.put(dup[i], i);
            }
        }
        int[] ans = new int[nums.length];
        for (int i= 0; i < nums.length; i++) {
            ans[i] = map.get(nums[i]);
        }
        return ans;
    }
}
