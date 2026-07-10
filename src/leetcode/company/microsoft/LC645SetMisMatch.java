package leetcode.company.microsoft;

import java.util.HashSet;
import java.util.Set;

public class LC645SetMisMatch {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,4};
        System.out.println(findErrorNums(nums));
    }

    private static int[] findErrorNums(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        int duplicateNumber=0;
        for(int i=0;i<n;i++){
            if(set.contains(nums[i]))
                duplicateNumber=nums[i];
            else
                set.add(nums[i]);
        }
        int xor=0;
        for(int i=0;i<n;i++){
            xor^=nums[i];
            xor^=i+1;
        }
        int missingNumber=xor^duplicateNumber;
        return new int[]{duplicateNumber, missingNumber};
    }
}
