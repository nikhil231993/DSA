package leetcode.array.easy;

import java.util.ArrayList;

public class LC1389CreateTargetArray {

    public static void main(String[] args) {
        int[] nums =new int[] {0,1,2,3,4};
        int[] index =new int[] {0,1,2,2,1};
        int[] result=createTargetArray(nums,index);
        for(int n:result)
            System.out.println(n);
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer>arr=new ArrayList<Integer>();
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){

            arr.add(index[i],nums[i]);
        }
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}
