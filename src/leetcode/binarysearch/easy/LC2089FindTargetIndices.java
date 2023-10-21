package leetcode.binarysearch.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2089FindTargetIndices {

    public static void main(String[] args) {
       int[] nums =new int[] {1,2,5,2,3};
       int target = 2;
        System.out.println(targetIndices(nums,target));
    }

    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list=new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(target==nums[i])
                list.add(i);
        }
        return list;
    }
}
