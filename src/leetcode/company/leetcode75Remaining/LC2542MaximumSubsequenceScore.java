package leetcode.company.leetcode75Remaining;

import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int num1;
    int num2;

    public Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}

public class LC2542MaximumSubsequenceScore {

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;

        System.out.println(maxScore(nums1, nums2, k));
    }

    private static long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }

        // Sort by nums2 in descending order
        Arrays.sort(pairs, (a, b) -> b.num2 - a.num2);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0;
        long ans = 0;

        for (Pair pair : pairs) {

            sum += pair.num1;
            pq.offer(pair.num1);

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                ans = Math.max(ans, sum * pair.num2);
            }
        }

        return ans;
    }
}