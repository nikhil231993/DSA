package kavya.interview;

public class LongSubStrWithoutRepeatCharBrute {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
            System.out.println("res: " + res);
        }

        return res;
    }

    private boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            chars[c]++;
            System.out.println(c + " " + chars[c]);
            if (chars[c] > 1) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        // Your code goes here
        LongSubStrWithoutRepeatCharBrute ob = new LongSubStrWithoutRepeatCharBrute();
        String s = "Hello";
        System.out.println(ob.lengthOfLongestSubstring(s));
    }
}
