package leetcode.array.easy;

public class SecondLargestAndsecondSmallest {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,4,7,7,5};
        System.out.println("Second Largest: " +secondLargest(nums));
        System.out.println("Second Smallest: " +secondSmallest(nums));

        //TC:O(n) for both
        //SC:O(n)
    }

    private static int secondSmallest(int[] nums) {
        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<smallest){
                secondSmallest=smallest;
                smallest=nums[i];
            }else if(nums[i]<secondSmallest &&nums[i]!=smallest){
                secondSmallest=nums[i];
            }
        }
        return secondSmallest;
    }

    private static int secondLargest(int[] nums) {
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>largest){
                secondLargest=largest;
                largest=nums[i];
            }else if(nums[i]>secondLargest && nums[i]!=largest){
                secondLargest=nums[i];
            }
        }
        return secondLargest;
    }
}
