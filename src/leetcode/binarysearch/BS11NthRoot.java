package leetcode.binarysearch;

public class BS11NthRoot {

    public static void main(String[] args) {

        int n = 3, m = 27;
        System.out.println(NthRoot(n,m));
    }

    public static int NthRoot(int n, int m) {

        int low=1, high=m;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(root(n,m,mid)==1){
                return mid;
            }else if(root(n,m,mid)==2){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }

    public static int root(int k, int n,int mid){

        Long ans=1l;
        for(int i=1;i<=k;i++) {
            ans*=mid;
            if(ans > n)
                return 2;
        }
        if(ans==n)
            return 1;
        return 0;

        //TC:O(log m * k) for loop
        //NOTE:O(log m * log k) .i.e, log k for power exponential method to find root
    }
}
