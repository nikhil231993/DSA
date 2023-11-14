package leetcode.string.easy;

public class LC796RotateString {

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        //Approach 1 Not for interview
        System.out.println(rotateString(s,goal));
        //Approach 2
        System.out.println(rotateStringBetter(s,goal));
    }

    public static boolean rotateString(String s, String goal) {
        return s.length()==goal.length() && (s+s).contains(goal);
        //TC:O(n square)
        //SC:O(n) extra space s
    }

    public static boolean rotateStringBetter(String s, String goal) {
        if(s == null || goal == null) {
            //throw exception on A and B both being null?
            return false;
        }
        if(s.length() != goal.length()) {
            return false;
        }
        if(s.length() == 0) {
            return true;
        }
        for(int i = 0; i < s.length(); i++) {
            if(rotateString(s, goal, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean rotateString(String A, String B, int rotation) {
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != B.charAt((i+rotation)%B.length())) {
                return false;
            }
        }
        return true;
    }
}
