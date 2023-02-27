package leetcode.easy;

public class LC724 {

	public static void main(String[] args) {
		int[] n = new int[] { 2, -1, 1 };
		System.out.println(pivotIndex(n));

	}

	public static int pivotIndex(int[] nums) {
		// int total=0;
		// for(int i=0;i<nums.length;i++){
		// total+=nums[i];
		// }

		// int leftSum=0;
		// for(int i=0;i<nums.length;i++){

		// if(2*leftSum==total-nums[i])
		// return i;
		// leftSum+=nums[i];

		// }
		// return -1;
		int left = 0;
		int right = 0;
		for (int i = 0; i < nums.length; i++) {
			int j = i;

			while (j > 0) {
				left += nums[--j];
			}
			int k = i;
			while (k < nums.length - 1) {
				right += nums[++k];
			}
			if (left == right)
				return i;
			else {
				left = 0;
				right = 0;
			}

		}
		return -1;
	}

}
