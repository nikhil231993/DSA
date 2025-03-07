package leetcode.array.easy;

public class LC121BuySellStock1 {

	public static void main(String[] args) {

		int[] prices = new int[] { 7, 1, 5, 3, 6, 10 };

		// Approach 1:Brute
		System.out.println(maxProfitBrute(prices));

		//Approach 2:Optimal
		System.out.println(maxProfit(prices));
	}

	private static int maxProfitBrute(int[] prices) {

		int profit=Integer.MIN_VALUE;
		for(int i=0; i<prices.length-1; i++){
			for(int j=i+1; j<prices.length; j++){
				profit=Math.max(profit, prices[j]-prices[i]);
			}
		}
		return profit;

		//TC:O(n square)
		//SC:O(n)
	}

	private static int maxProfit(int[] prices) {

		int minValue = Integer.MAX_VALUE, profit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (minValue > prices[i])
				minValue = prices[i];
			profit = Math.max(prices[i] - minValue, profit);
		}
		return profit;

		// TC:O(n)
		// SC:O(1)
	}
}
