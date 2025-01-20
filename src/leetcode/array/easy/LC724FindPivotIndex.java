package leetcode.array.easy;

public class LC724FindPivotIndex {

	public static void main(String[] args) {

		int[] n = new int[] { 1,7,3,6,5,6 };
		
		//Approach 1
		System.out.println(pivotIndex(n));

		//Approach 2: Optimal
		System.out.println(pivotIndexOptimal(n));
	}

	private static int pivotIndexOptimal(int[] nums) {

		 // In this we use mathematical equation to find the solution
		 int total=0;
		 for(int i=0; i<nums.length; i++){
		 	total+=nums[i];
		 }

		 int leftSum=0;
		 for(int i=0; i<nums.length; i++){

		 	if(2*leftSum == total-nums[i])
		 		return i;
		 	leftSum+=nums[i];
		 }
		 return -1;

		 //TC:O(2*n)
		 //SC:O(1)
	}

	public static int pivotIndex(int[] nums) {

		int left = 0, right = 0;
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

		// TC:O(n square)
		// SC:O(n
	}
}
