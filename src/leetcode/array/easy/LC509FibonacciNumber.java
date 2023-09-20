package leetcode.array.easy;

public class LC509FibonacciNumber {

    public static void main(String[] args) {
        int n=8;
        //Approach 1 recursion
        System.out.println(fib(n));

        //Approach 2 Iterative
        System.out.println(fibIterative(n));
    }

    private static int fibIterative(int n) {
        int a=0;
        int b=1;
        while(n!=0){
            int c=a+b;
            a=b;
            b=c;
            n--;
        }
        return a;
        //SC:O(1)
        //TC:O(n)
    }

    public static int fib(int n) {
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;
        return fib(n-1)+fib(n-2);
        //TC:O(2 raise to n)
        //SC:O(log(n))
    }
}
