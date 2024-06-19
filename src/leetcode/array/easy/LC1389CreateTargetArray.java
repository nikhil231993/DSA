package leetcode.array.easy;

import java.util.ArrayList;

public class LC1389CreateTargetArray {

    public static void main(String[] args) {

        int[] nums =new int[] {0,1,2,3,4};
        int[] index =new int[] {0,1,2,2,1};

        //Approach 1:
        int[] result=createTargetArray(nums,index);
        for(int n:result)
            System.out.println(n);

        System.out.println("#######");

        //Approach 2
        int[] result1=createTargetArrayWithSpace(nums,index);
        for(int n:result1)
            System.out.println(n);
    }

    public static int[] createTargetArray(int[] nums, int[] index) {

        ArrayList<Integer>arr=new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++){
            arr.add(index[i],nums[i]);
        }
        return arr.stream().mapToInt(a->a).toArray(); //this will become 100% faster in leetcode if we use for to iterate and put into array from list

        //TC:O(n)
        //SC:O(n)
    }

    public static int[] createTargetArrayWithSpace(int[] nums, int[] index) {

        int[] target = new int[nums.length];
        int count = 0;
        while (count < target.length) {
            if (index[count] >= count) {
                target[index[count]] = nums[count];
            }
            else{
                for (int i = count; i > index[count]; i--)
                    target[i] = target[i - 1];
                target[index[count]] = nums[count];
            }
            count++;
        }
        return target;

        //TC:O(n square) worst case
        //SC:O(n)
    }
}
