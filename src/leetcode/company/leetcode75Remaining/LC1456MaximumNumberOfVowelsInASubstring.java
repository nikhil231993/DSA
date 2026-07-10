package leetcode.company.leetcode75Remaining;

public class LC1456MaximumNumberOfVowelsInASubstring {

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    private static int maxVowels(String s, int k) {
        int n = s.length(), maxLen = 0, left = 0, right = 0;
        int count=0;

        while (right < n){
            if (isVowel(s.charAt(right))){
                count++;
            }

            while (right - left + 1 > k){
                if (isVowel(s.charAt(left))){
                    count--;
                }
                left++;
            }
            if (right - left + 1 <= k){
                maxLen = Math.max(maxLen, count);
            }
            right++;
        }
        return maxLen;
    }

    private static boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        return false;
    }
}
