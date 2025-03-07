package leetcode.array.extra;

public class gfgSecondLargestAndSecondSmallest {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,4,7,7,5};
        int[] result = getSecondOrderElements(nums);

        System.out.println("SecondLargest: "+ result[0]);
        System.out.println("SecondSmallest: "+ result[1]);
    }

    public static int[] getSecondOrderElements(int[] nums) {

        Integer max=Integer.MIN_VALUE, secondMax=Integer.MIN_VALUE;
        Integer smallest=Integer.MAX_VALUE, secondSmallest=Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){

            if(nums[i] > max){
                secondMax=max;
                max=nums[i];
            }else if(nums[i] > secondMax && nums[i] != max){
                secondMax = nums[i];
            }
            if(nums[i] < smallest){
                secondSmallest = smallest;
                smallest = nums[i];
            }else if(nums[i] < secondSmallest && nums[i] != smallest){
                secondSmallest = nums[i];
            }
        }
        return new int[]{ secondMax, secondSmallest };

        //TC:O(n)
        //SC:O(1)
    }
}
