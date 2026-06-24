package leetcode.company.microsoft;

import java.util.Arrays;

public class LC179LargestNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    private static String largestNumber(int[] nums) {
        String strs[] = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
