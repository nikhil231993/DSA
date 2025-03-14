package leetcode.string.easy;

public class LC345ReverseVowels {

    public static void main(String[] args) {

        String s = "hello";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {

        char[] word = s.toCharArray();
        int start = 0, end = s.length() - 1;
        String vowels = "aeiouAEIOU";

        while (start < end) {
            
            // Move start pointer until it points to a vowel
            while (start < end && vowels.indexOf(s.charAt(start)) == -1) {
                start++;
            }

            // Move end pointer until it points to a vowel
            while (start < end && vowels.indexOf(s.charAt(end)) == -1) {
                end--;
            }

            // Swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            // Move the pointers towards each other
            start++;
            end--;
        }

        String answer = new String(word);
        return answer;

        //TC:O(n)
        //SC:O(n)
    }
}
