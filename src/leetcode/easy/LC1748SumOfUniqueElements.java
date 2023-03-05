package leetcode.easy;

public class LC1748SumOfUniqueElements {

	public static void main(String[] args) {
		
		int[] nums = new int[] { 1, 1, 1, 1, 1 };
		System.out.println(sumOfUnique(nums));

	}

	public static int sumOfUnique(int[] nums) {
		int[] counts = new int[101];
		for (int num : nums)
			counts[num]++;
		int sum = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == 1)
				sum += i;
		}
		return sum;
		// SC:O(n)
		// TC:O(n)

	}

}
