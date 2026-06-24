package leetcode.company.microsoft;

import java.util.Arrays;

public class ValidPalindrome4LC1216 {

    public static void main(String[] args) {
        String s = "abcdeca";
        int k = 2;
        System.out.println(isValidPalindrome(s, k));

        System.out.println(isValidPalindromeMemoization(s, k));
    }

    private static boolean isValidPalindromeMemoization(String s, int k) {
        int n = s.length();
        // 2D DP array: dp[left][right] stores min deletions needed for s[left...right]
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMinDeletionsMemoization(s, 0, n - 1, dp) <= k;
    }

    private static boolean isValidPalindrome(String s, int k) {
        int count=getMinDeletions(s, 0, s.length() - 1);
        if(count<=k)
                return true;
        return false;
    }

    private static int getMinDeletions(String s, int left, int right) {
        // Base Case: An empty string or a single character is already a palindrome (0 deletions needed)
        if (left >= right) {
            return 0;
        }

        // Scenario 1: The characters at both pointers match.
        // No deletion needed here, move both pointers inward.
        if (s.charAt(left) == s.charAt(right)) {
            return getMinDeletions(s, left + 1, right - 1);
        }

        // Scenario 2: Mismatch. We must simulate a deletion.
        // We try deleting the left character OR deleting the right character,
        // and take the path that yields the minimum deletions (+1 for the current deletion).
        else {
            int deleteLeft = getMinDeletions(s, left + 1, right);
            int deleteRight = getMinDeletions(s, left, right - 1);

            return 1 + Math.min(deleteLeft, deleteRight);
        }
    }

    private static int getMinDeletionsMemoization(String s, int left, int right, int[][] dp) {
        // Base case 1: Single character or empty string requires 0 deletions
        if (left >= right) {
            return 0;
        }

        // Return cached result if it exists
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        // Case 1: Characters match, move both pointers inward for free
        if (s.charAt(left) == s.charAt(right)) {
            dp[left][right] = getMinDeletionsMemoization(s, left + 1, right - 1, dp);
        }
        // Case 2: Mismatch. Delete either left or right character (+1 operation)
        else {
            int deleteLeft = getMinDeletionsMemoization(s, left + 1, right, dp);
            int deleteRight = getMinDeletionsMemoization(s, left, right - 1, dp);
            dp[left][right] = 1 + Math.min(deleteLeft, deleteRight);
        }

        return dp[left][right];
    }
}
