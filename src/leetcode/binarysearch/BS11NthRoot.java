package leetcode.binarysearch;

public class BS11NthRoot {

    public static void main(String[] args) {
       int n = 2, m = 9;
        System.out.println(NthRoot(n,m));
    }

    public static int NthRoot(int n, int m)
    {
        int low=0;

        int high=m;
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
        for(int i=1;i<=k;i++)
        {
            ans*=mid;
            if(ans > n)
                return 2;
        }
        if(ans==n)
            return 1;
        return 0;

        //TC:o(log m * k) for loop
        //o(log m * log k) log k for exponential
    }
}
