package leetcode.math.easy;

public class LC231PowerOfTwo {

    public static void main(String[] args) {

        int n=536870912;

        //Approach 1 Brute force
        System.out.println(isPowerOfTwo(n));

        //Approach 2
        System.out.println(isPowerOfTwo1(n));

        //Approach 3
        System.out.println(isPowerOfTwo2(n));

        //Approach 4
        System.out.println(isPowerOfTwo3(n));
    }

    private static boolean isPowerOfTwo3(int n) {
        return n>0 && (n&(n-1))==0;
    }

    private static boolean isPowerOfTwo2(int n) {

        //We count the set bits in this approach
        //https://www.youtube.com/watch?v=OuOwshx2U70&ab_channel=AyushiSharma
        //https://www.youtube.com/watch?v=KJnhAUkxAho&ab_channel=GeeksforGeeks
        //brian kernighan's algorithm

        if(n<0)
            return false;
        int count=0;
        while(n!=0){
            count+=n&1;
            n=n>>1;
        }
        return count==1;
    }

    private static boolean isPowerOfTwo1(int n) {

        //Below method works only till 268435456 and fails after (536870912 onwards) that due to precision error
        //https://leetcode.com/problems/power-of-two/discuss/184262/Java-simple-solution-with-detailed-explaination

        if(n<=0)
          return false;
        return Math.ceil(Math.log(n)/Math.log(2))==Math.floor(Math.log(n)/Math.log(2));
    }

    public static boolean isPowerOfTwo(int n) {

        if(n<=0)
            return false;
        while(n!=1){
            if(n%2==1)
                return false;
            n=n/2;
        }
        return true;

        //TC:O(log n) to  base 2 xas divided by 2
    }
}
