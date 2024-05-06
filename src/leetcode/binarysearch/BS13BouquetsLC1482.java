package leetcode.binarysearch;

public class BS13BouquetsLC1482 {

    public static void main(String[] args) {

        int[] bloomDay =new int[] {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay,m,k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {

        int n=bloomDay.length;
        if(n< m*k)
            return -1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min, bloomDay[i]);
            max=Math.max(max, bloomDay[i]);
        }
        int low=min;
        int high=max;
        int ans=-1;
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
        int count=0;
        int noOfBouquets=0;

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

    //TC:O(log (max-min+1)*n)
    //SC:O(1)
}
