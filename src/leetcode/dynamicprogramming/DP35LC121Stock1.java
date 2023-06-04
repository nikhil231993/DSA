package leetcode.dynamicprogramming;

public class DP35LC121Stock1 {
    public static void main(String[] args) {
        int[] prices =new int[] {7,1,5,3,6,4};
        System.out.println(solution(prices));
    }

    private static int solution(int[] prices) {
        int min=prices[0];
        int profit=Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-min;
            profit= Math.max(profit,cost);
            min=Math.min(min,prices[i]);
        }
        return profit;
        //TC:O(N)
        //SC:O(1)
    }
}
