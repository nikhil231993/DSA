package leetcode.binarysearch.medium;

public class LC29DivideTwoIntegers {

    public static void main(String[] args) {
        int dividend = 10, divisor = 3;

        System.out.println(divideTwoIntegers(dividend,divisor));
    }

    private static int divideTwoIntegers(int dividend, int divisor) {

        if(dividend==Integer.MIN_VALUE && divisor ==-1)
            return Integer.MAX_VALUE;

        int a=Math.abs(dividend);
        int b=Math.abs(divisor);
        int res=0;
        while(a-b>=0){
            int x=0;
            while(a-((b<<1)<<x)>=0){
                x++;
            }
            res=res+(1<<x);
            a=a-(b<<x);
        }

        return (dividend>=0)&& (divisor>=0)?res:-res;
    }
}
