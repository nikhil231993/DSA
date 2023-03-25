package leetcode.array.easy;

public class LC121BuySellStock1 {

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));

	}

	private static int maxProfit(int[] prices) {
		int minValue = Integer.MAX_VALUE;
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (minValue > prices[i])
				minValue = prices[i];
			if (prices[i] - minValue > profit)
				profit = prices[i] - minValue;
		}
		return profit;
	}

}
