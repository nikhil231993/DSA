package leetcode.dynamicprogramming;

public class DP16PartitionSubsetWithMinimumDifference {

    public static void main(String[] args) {

        int[] arr=new int[]{2,3,7};
        int n= arr.length;
        int totalSum=0;
        for(int i=0;i<n;i++)
            totalSum+=arr[i];

        //Tabulation
        //Assuming constraints are 10 raise to 3
        boolean[][] dp=new boolean[n][totalSum+1];
        tabulation(n,totalSum,arr,dp);

        int min=(int)1e9;

        for(int s1=0;s1<=totalSum;s1++){
            if(dp[n-1][s1]==true){
                int s2=totalSum-s1;
                min=Math.min(min,Math.abs(s2-s1));
            }
        }
        System.out.println(min);
    }

    private static void tabulation(int n, int K, int[] arr, boolean[][] dp) {

        for(int i=0;i<n;i++)
            dp[i][0]=true;
        if(arr[0]<=K)
            dp[0][arr[0]]=true;

        for(int i=1;i<n;i++){
            for(int target=1;target<=K;target++){ // we can use target =0 as well
                boolean notpick=dp[i-1][target];
                boolean pick=false;
                if(arr[i]<=target)
                    pick=dp[i-1][target-arr[i]];
                dp[i][target]=notpick|| pick;
            }
        }
    }
}
