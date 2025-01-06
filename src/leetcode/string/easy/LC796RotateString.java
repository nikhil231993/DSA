package leetcode.string.easy;

public class LC796RotateString {

    public static void main(String[] args) {

        String s = "abcde", goal = "abced";

        //Approach 1 Not for interview
        System.out.println(rotateString(s,goal));

        //Approach 2: for interview
        System.out.println(rotateStringBetter(s,goal));

        //Approach 3: Self
        System.out.println(rotateStringSelf(s,goal));
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

    public static boolean rotateStringSelf(String s, String goal) {

        int n=s.length(), m=goal.length();
        if(n!=m)
            return false;
        for(int i=0; i<n; i++){
            if(func(s, goal, 0, i))
                return true;
        }
        return false;
    }

    public static boolean func(String s, String goal, int start, int j){

        for(int i=start;i<s.length();i++){
            if(s.charAt(i)==goal.charAt(j%(goal.length()))){
                j++;
            }else return false;
        }
        return true;
    }
}
