package leetcode.array.easy;

import java.util.ArrayList;

public class LC1389CreateTargetArray {

    public static void main(String[] args) {

        int[] nums =new int[] {0,1,2,3,4};
        int[] index =new int[] {0,1,2,2,1};

        //Approach 1:
        int[] result=createTargetArray(nums,index);
        for(int n:result)
            System.out.print(n);

        System.out.println();
        System.out.println("#######");

        //Approach 2:
        int[] result1=createTargetArrayWithSpace(nums,index);
        for(int n:result1)
            System.out.print(n);
    }

    public static int[] createTargetArray(int[] nums, int[] index) {

        ArrayList<Integer>arr=new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            arr.add(index[i],nums[i]);
        }
        return arr.stream().mapToInt(a->a).toArray(); //this will become 100% faster in leetcode if we use for to iterate and put into array from list

        //TC:O(n)
        //SC:O(n)
    }

    public static int[] createTargetArrayWithSpace(int[] nums, int[] index) {

        int[] target = new int[nums.length];
        int i = 0;
        while (i < index.length) {
            for (int k = target.length - 1; k > index[i]; k--)
                target[k] = target[k - 1];
            target[index[i]] = nums[i];
            i++;
        }
        return target;

        //TC:O(n square) worst case
        //SC:O(n)
    }
}
