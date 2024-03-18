package leetcode.binarysearch.medium;

public class LC2226MaximumCandies{

    public static void main(String[] args) {

        int[] candies=new int[]{4,7,5};
        int k=4;
        System.out.println(maximumCandies(candies,k));
    }

    public static int maximumCandies(int[] candies, long k) {

        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            high=Math.max(high, candies[i]);
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid, candies, k)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;

    }
    public static boolean isPossible(int mid, int[] candies, long n){

        long count=0;
        for(int i=0;i<candies.length;i++){
            count+=candies[i]/mid;
        }
        if(count>=n)
            return true;
        return  false;

        //TC: log (max element)* n
        //SC: O(1)
    }
}
