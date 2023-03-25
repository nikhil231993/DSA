package leetcode.array.easy;

public class LC169MajorityElement {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(majorityElement(nums));

	}

	private static int majorityElement(int[] nums) {
		int count = 0;
		int maj = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0)
				maj = nums[i];
			if (maj != nums[i])
				count--;
			else
				count++;
		}
		return maj;
	}

}
