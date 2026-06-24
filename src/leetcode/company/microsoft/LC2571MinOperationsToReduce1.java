package leetcode.company.microsoft;

public class LC2571MinOperationsToReduce1 {

    public static void main(String[] args) {
        int n = 54;
        System.out.println(minOperations(n));
    }

    private static int minOperations(int n) {
        // if (n <= 1) return n;

        // if ((n & 1) == 0)
        //     return minOperations(n >> 1);

        // if (n == 3 || (n & 3) == 1)
        //     return 1 + minOperations(n - 1);

        // return 1 + minOperations(n + 1);

        int count = 0;

        while (n > 0) {

            // if n is even
            if ((n & 1) == 0) {
                n >>= 1;   // shift to process next bit
            }
            else {
                // if n == 1 OR last two bits are 01
                if (n == 1 || (n & 3) == 1) {
                    n -= 1;
                } else {
                    n += 1;
                }
                count++;
            }
        }

        return count;
    }
}
