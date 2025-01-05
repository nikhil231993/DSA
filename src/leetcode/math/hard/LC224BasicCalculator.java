package leetcode.math.hard;

import java.util.Stack;

public class LC224BasicCalculator {

    public static void main(String[] args) {

        String s = "1 + 1";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {

        //https://leetcode.com/problems/basic-calculator/discuss/4250990/Java-Solution

        int sign = 1;
        int result = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            int num = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (int) (s.charAt(i) - '0');
                i++;
            }
            result += sign * num;
            if (i >= s.length()) //To avoid index out of bound condition
                break;
            if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * st.pop() + st.pop();
            }
        }
        return result;

        //TC: O(n)
        //SC: O(n)
    }
}
