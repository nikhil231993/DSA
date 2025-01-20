package leetcode.array.easy;

public class LC1752CheckIfSortedArray {

    public static void main(String[] args) {

        int[] nums =new int[] {3,4,5,1,2};
        System.out.println(check(nums));
    }

    //Step 1: We should have only 1 pair where next element is less than previous
    //Step 2: 5,1 will give 1 and nothing else should give 1
    //Step 3: even last element should be less than 1st element
    //Step 4: If all elements are 0 then count is 0

    public static boolean check(int[] nums) {

        int count=0, n=nums.length;
        for(int i=1; i<n;i++){
            if(nums[i-1]>nums[i])
                count++;
        }

        if(nums[n-1] > nums[0])
            count++;

        if(count<=1)
            return true;
        return false;

        // TC:O(n)
        // SC:O(1)
    }
}
