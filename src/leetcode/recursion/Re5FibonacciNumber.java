package leetcode.recursion;

public class Re5FibonacciNumber {

    public static void main(String[] args) {
        int n=5;

		// Recursion
		System.out.println(fibonacci(n));

		// Iterative
        System.out.println(fib(n));
    }

	private static int fib(int n) {

        int f1=0;
        int f2=1;
        if(n==0 || n==1)
            return n;
        if(n==2)
            return n-1;
        int f3=0;
		for (int i = 2; i < n; i++) {
            f3=f2+f1;
            f1=f2;
            f2=f3;
        }
		return f2;
		// TC:O(N)
		// SC:O(N)
    }

    private static int fibonacci(int n) {
            if(n<=1)
                return n;
            return fibonacci(n-1)+fibonacci(n-2);

		// Tc:O(2 raise to N)
		// Tc:O(log N) where log N is the height of the tree
        }
}
