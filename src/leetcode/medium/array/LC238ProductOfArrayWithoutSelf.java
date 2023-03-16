package leetcode.medium.array;

import java.util.Arrays;

public class LC238ProductOfArrayWithoutSelf {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };

		// int[] r = product(nums);

		// Better Approach
		//int[] r = productBetter(nums);

		// in same for loop
		int[] r = productBetterSameLoop(nums);

		for (Integer n : r)
			System.out.println(n);

	}

	private static int[] productBetterSameLoop(int[] nums) {
		int[] ans = new int[nums.length];
		Arrays.fill(ans, 1);
		int p1=1;
		int p2=1;
		
		
		for(int i=0;i<nums.length;i++) {
			ans[i]*=p1;
			p1 *= nums[i];
			int j = nums.length - i - 1;
			ans[j] *= p2;
			p2 *= nums[j];

		}
		return ans;
	}

	private static int[] productBetter(int[] nums) {
		int[] ans = new int[nums.length];
		int p1 = 1;
		for (int i = 0; i < nums.length; i++) {
			ans[i] = p1;
			p1 *= nums[i];
		}

		int p2 = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			ans[i] *= p2;
			p2 *= nums[i];
		}
		return ans;
		// SC:O(n)
		// TC:O(n)
	}

	private static int[] product(int[] nums) {
        int product=1;
		int[] response = new int[nums.length];
        for(int i=0;i<nums.length;i++){
           product=1;
           for(int j=0;j<nums.length;j++){

               if(i!=j){
                   product*=nums[j];
               }
           }
			response[i] = product;
           
        }

		return response;
        //SC:O(1)
		// TC:O(n2)
	}

}
