package leetcode.company.microsoft;

import java.util.Random;

public class LC528RandomPickWeight {

    class Solution {

        int[] prefixSum;
        Random random;

        public Solution(int[] w) {
            random=new Random();
            int n=w.length;
            prefixSum=new int[n];
            prefixSum[0]=w[0];
            for(int i=1;i<n;i++)
                prefixSum[i]=prefixSum[i-1]+w[i];
        }

        public int pickIndex() {
            int randomIndex=random.nextInt(prefixSum[prefixSum.length-1])+1;
            return bs(randomIndex, prefixSum);
        }

        private int bs(int target, int[] arr){
            int low=0, high=arr.length-1;
            int ans=arr.length;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid]>=target){
                    ans=mid;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return ans;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
