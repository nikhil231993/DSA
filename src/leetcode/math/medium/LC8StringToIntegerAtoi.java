package leetcode.math.medium;

public class LC8StringToIntegerAtoi {

	public static void main(String[] args) {
		//String s = "2147483648";
		String s = "+1";
		System.out.println(myAtoi(s));
	}

	public static int myAtoi(String s) {

		int i = 0;
		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		if (s.length() == i)
			return 0;

		int sign = 1;
		if (s.charAt(i) == '-') {
			sign = -1;
			i++;
		} else if (s.charAt(i) == '+') {
			sign = 1;
			i++;
		}
		long ans = 0;
		while (i < s.length() && ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57)) {
			ans = ans * 10 + s.charAt(i) - '0';
			if (sign == 1 && ans > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			if (sign == -1 && -1 * ans < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			i++;
		}
		return (int) ans * sign;
	}
}
