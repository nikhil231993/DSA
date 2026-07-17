package leetcode.company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2150 {

    public static void main(String[] args) {
       int[] nums = new int[] {10,6,5,8};
        System.out.println(findLonely(nums));
    }

    private static List<Integer> findLonely(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        if(n==1) return new ArrayList<>(Arrays.asList(nums[0]));
        if(nums[0]!=nums[1] && nums[1]!=nums[0]+1)
            list.add(nums[0]);

        for(int i=1;i<n-1;i++){
            if(nums[i]==nums[i+1] || nums[i]==nums[i-1])  continue;
            if(nums[i]!=nums[i-1]+1 && nums[i]!=nums[i+1]-1)
                list.add(nums[i]);
        }
        if(nums[n-2]!=nums[n-1] && nums[n-2]!=nums[n-1]-1)
            list.add(nums[n-1]);
        return list;
    }
}
