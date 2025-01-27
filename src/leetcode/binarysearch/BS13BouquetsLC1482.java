package leetcode.binarysearch;

public class BS13BouquetsLC1482 {

    public static void main(String[] args) {

//        int[] bloomDay =new int[] {1,10,3,10,2};
//        int m = 3, k = 1;

        int[] bloomDay=new int[]{7,7,7,7,13,11,12,7};
        int m=2, k=3;
        System.out.println(minDays(bloomDay,m,k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {

        int n=bloomDay.length;
        if(n < m*k)
            return -1; // Make sure to check these kind of edge cases
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            min=Math.min(min, bloomDay[i]);
            max=Math.max(max, bloomDay[i]);
        }
        int low=min, high=max, ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isPossible(bloomDay,m,k,mid)){
                ans=mid;
                high=mid-1;
            }else
                low=mid+1;
        }
        return ans;
    }

    public static boolean isPossible(int[] bloomDay, int m, int k, int mid){

        int count=0, noOfBouquets=0;

        for(int i=0;i<bloomDay.length;i++){
            if(mid>=bloomDay[i])
                count++;
            else {
                noOfBouquets+=count/k;
                count=0;
            }
        }
        noOfBouquets+=count/k;

        if(noOfBouquets>=m)
            return true;
        return false;
    }

    // TC:O(n * log (max-min+1)) i.e., 7-13
    // SC:O(1)
}
