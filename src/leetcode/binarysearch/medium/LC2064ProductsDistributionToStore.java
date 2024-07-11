package leetcode.binarysearch.medium;

public class LC2064ProductsDistributionToStore {

    public static void main(String[] args) {

        int[] quantities=new int[]{11,6};
        int n=6;
        System.out.println(minimizedMaximum(n,quantities));
    }

    public static int minimizedMaximum(int n, int[] quantities) {

        int low=1, high=Integer.MIN_VALUE;
        for(int i=0;i<quantities.length;i++){
            high=Math.max(high, quantities[i]);
        }

        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid, quantities, n)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int mid, int[] quantities, int n){

        int count=0;
        for(int i=0;i<quantities.length;i++){
            count+=Math.ceil((double) quantities[i]/(double)mid);
        }
        if(count<=n)
            return true;
        return  false;

        //TC: log (max element)* n
        //SC: O(1)
    }
}
