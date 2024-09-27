package leetcode.math.medium;

public class LC453MinimumEqual {

	//Reference material: https://www.geeksforgeeks.org/minimum-number-increment-operations-make-array-elements-equal/
	//Best explanation: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/1678915/5-lines-code-or-c%2B%2B-or-easy-understanding-or-explained

	public static void main(String[] args) {

		int[] num = new int[] { 1,2,3,4 };

		// Approach 1
		System.out.println(minMoves(num));

		// Approach 2 logical and better than first
		System.out.println(minMovesDec(num));
	}

	private static int minMovesDec(int[] num) {

		//Here instead of increasing n-1 by 1 to make all numbers equal, we decrease 1 element by 1
		//to make it equal to minimum number as that is the minimum we can reach.
		//Step 1: so find the minimum
		//Step 2: Subtract that number from each and add it

		int min=Integer.MAX_VALUE;
		for(int n:num)
			min=Math.min(min, n);

		int ans=0;
		for(int n:num){
			ans+=n-min;
		}
		return ans;

		// SC:O(1)
		// TC:O(n)
	}

	public static int minMoves(int[] arr) {

		//This is same as next solution but little difficult to understand
		//Here also we decrement elements by 1 instead of increasing n-1 by 1 as both are same
		//Consider a[0] is minimum then (a[0]-a[0]+a[1]-a[0]+a[2]-a[0])= sum of n number -n * a[0]

		int arraySum, smallest, arr_size = arr.length;
		arraySum = 0;
		smallest = arr[0];
		for (int i = 0; i < arr_size; i++) {
			if (arr[i] < smallest)
				smallest = arr[i];

			// find array sum
			arraySum += arr[i];
		}
		int minOperation = arraySum - arr_size * smallest;
		return minOperation;

		// SC:O(1)
		// TC:O(n)
	}
}
