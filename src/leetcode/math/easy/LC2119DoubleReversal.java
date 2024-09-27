package leetcode.math.easy;

public class LC2119DoubleReversal {

    public static void main(String[] args) {

       int num = 526;

        //Approach 1: Brute
        System.out.println(isSameAfterReversals(num));

        //Approach 2: Better
        System.out.println(better(num));

        //Approach 3: Best
        System.out.println(best(num));
    }

    private static boolean best(int num) {

        return num==0 || num % 10 !=0;
    }

    private static boolean better(int num) {

        return num==0 || !String.valueOf(num).endsWith("0");
    }

    public static boolean isSameAfterReversals(int num) {

        int n=num;
        for(int i=0;i<2;i++)
            num=reverseInteger(num);
        return n==num;
    }

    private static int reverseInteger(int n) {

        int ans = 0;
        while (n != 0) {
            if(ans > Integer.MAX_VALUE/10 || ans < Integer.MIN_VALUE/10)
                return 0;
            ans = ans * 10 + n % 10;
            n = n / 10;
        }
        return ans;

        // TC:O(n) where n is the length of the integer
        // SC:O(1)
    }
}
