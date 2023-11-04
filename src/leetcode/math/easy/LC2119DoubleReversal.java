package leetcode.math.easy;

public class LC2119DoubleReversal {

    public static void main(String[] args) {
       int num = 526;
       System.out.println(isSameAfterReversals(num));
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
