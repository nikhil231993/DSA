package leetcode.recursion.striver;

public class L3Factorial {

    public static void main(String[] args) {

        int n=5;
        System.out.println(factorialFunctional(1,n));
        factorialParamterized(1,n,1);
    }

    private static void factorialParamterized(int i, int n,int r) {

        if(i>n){
            System.out.println(r);
            return;
        }
        //r=r*i;
        factorialParamterized(i+1,n,r*i);

        //TC:O(N)
        //SC:O(N)
    }

    private static int factorialFunctional(int i, int n) {

        if(i==n)
            return 5;
        return i*factorialFunctional(i+1,n);
        //TC:O(N)
        //SC:O(N)
    }
}
