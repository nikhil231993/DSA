package leetcode.binarysearch;

public class BS11NthRoot {

    public static void main(String[] args) {

        int n = 3, m = 27;

        //Approach 1(Brute): Pow Exponentiation or two loops as per video
        System.out.println(NthRootBrute(n, m));

        //Approach 2: Best
        System.out.println(NthRoot(n,m));
    }

    public static long func(int b, int exp) {

        long  ans = 1;
        long base = b;
        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                ans = ans * base;
            } else {
                exp /= 2;
                base = base * base;
            }
        }
        return ans;
    }

    public static int NthRootBrute(int n, int m) {

        //Use linear search on the answer space:
        for (int i = 1; i <= m; i++) {
            long val = func(i, n);
            if (val == (long)m) return i;
            else if (val > (long)m) break;
        }
        return -1;
        //TC:O(m log n ) log is for power exponentiation or else if it normal way it will be O(m*n)
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

    public static int root(int k, int n, int mid){

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
