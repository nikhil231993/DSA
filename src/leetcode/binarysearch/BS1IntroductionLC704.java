package leetcode.binarysearch;

public class BS1IntroductionLC704 {

    public static void main(String[] args) {

        //Note: If binary search question comes up in interview tell interviewer first about linear search (brute force)
        //and then move to binary search (optimal)

        int[] nums = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;

        //Approach 1: Iterative
        int ind = binarySearch(nums, target);
        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);

        //Approach 2: Recursive
        ind = searchRecursion(nums, target);
        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }

    private static int binarySearch(int[] nums, int target) {

        int n = nums.length; //size of the array.
        int low = 0, high = n - 1;

        // Perform the steps:
        while (low <= high) {
            int mid = low+ (high - low) / 2;
            if (nums[mid] == target) 
            	return mid;
            else if (target > nums[mid]) 
            	low = mid + 1;
            else 
            	high = mid - 1;
        }
        return -1;

        //TC:O(log n)
        //SC:O(1)
    }

    private static int binarySearchRecursion(int[] nums, int low, int high, int target) {

        if (low > high) return -1; //Base case.

        // Perform the steps:
        int mid = low+ (high - low) / 2;
        if (nums[mid] == target)
            return mid;
        else if (target > nums[mid])
            return binarySearchRecursion(nums, mid + 1, high, target);
        return binarySearchRecursion(nums, low, mid - 1, target);

        //TC:O(log n)
        //SC:O(log n)
    }

    private static int searchRecursion(int[] nums, int target) {
        return binarySearchRecursion(nums, 0, nums.length - 1, target);
    }
}
