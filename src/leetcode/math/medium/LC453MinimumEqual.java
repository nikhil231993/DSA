package leetcode.math.medium;

public class LC453MinimumEqual {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 3, 7, 8, 11 };

		// Best approach
		System.out.println(minMoves(num));
	}

	public static int minMoves(int[] arr) {
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
