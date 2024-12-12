package leetcode.array.easy;

public class LC122BuySellStock2 {

	public static void main(String[] args) {

		int[] arr = new int[] { 7, 1, 2, 3, 6, 4 };

		System.out.println("Max profit is: ");
		int profit = buySellStock(arr);
		System.out.println(profit);
	}

	private static int buySellStock(int[] arr) {

		int profit=0;
		for(int i=1; i<arr.length; i++) {
			if (arr[i - 1] < arr[i]) {
				profit += arr[i] - arr[i - 1];
			}
		}
		return profit;

		//TC:O(n)
		//SC:O(1)
	}
}
