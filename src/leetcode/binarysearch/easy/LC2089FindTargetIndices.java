package leetcode.binarysearch.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2089FindTargetIndices {

    public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 5, 2, 3 };
		int target = 2;

		// Approach 1: Brute
		System.out.println(targetIndices(nums, target));

		// Approach 2: Better
		System.out.println(targetIndicesOptimised(nums, target));
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

	public static List<Integer> targetIndicesOptimised(int[] nums, int target) {

		List<Integer> list = new ArrayList();
		Arrays.sort(nums);
		int firstPosition = -1, lastPosition = -1;

		firstPosition = firstOccurrence(nums, target);
		lastPosition = lastOccurrence(nums, target);

		if (lastPosition == -1 && firstPosition == -1)
			return list;
		for (int i = firstPosition; i <= lastPosition; i++)
			list.add(i);

		return list;
	}

	private static int lastOccurrence(int[] nums, int target) {

		int low = 0, high = nums.length - 1;
		int ans = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				ans = mid;
				low = mid + 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;

		// TC:O(log n)
		// SC:O(1)
	}

	private static int firstOccurrence(int[] nums, int target) {

		int low = 0, high = nums.length - 1;
		int ans = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				ans = mid;
				high = mid - 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;

		// TC:O(log n)
		// SC:O(1)
	}
}
