package leetcode.binarysearch;

public class BS15ShipCapacityLC1011 {

    public static void main(String[] args) {

       int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
       int days = 5;
       System.out.println(shipWithinDays(weights,days));
    }

    public static int shipWithinDays(int[] weights, int days) {

        //Step 1: find the max value
        //Step 2: find the sum of the total weight of the packages

        int totalWeights=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
            totalWeights+=weights[i];
        }
        int low=max;
        int high=totalWeights;
        int ans=0;
        while(low<=high){//log n
            int mid=low+(high-low)/2;
            if(isPossible(mid,weights,days)){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int total, int[] weights, int days){

        int count=1;
        int sum=0;

        for(int i=0;i< weights.length;i++){//o(n)
            sum+=weights[i];
            if(sum>total){
                count++;
                sum=weights[i];
            }
        }
        if(count<=days)
            return true;
        return false;

        //TC:o(log(maxsum-min+1)*n)
        //SC:O(1)
    }
}
