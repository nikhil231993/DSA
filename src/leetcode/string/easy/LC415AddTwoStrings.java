package leetcode.string.easy;

public class LC415AddTwoStrings {

	public static void main(String[] args) {

		String num1="11";
		String num2 = "123";
		System.out.println(addStrings(num1, num2));
	}

	public static String addStrings(String num1, String num2) {

		StringBuilder result = new StringBuilder();
		int i = num1.length() - 1, j = num2.length() - 1;
		int carry = 0, sum = 0;

		while (i >= 0 || j >= 0) {
			sum = carry;

			if (i >= 0)
				sum += num1.charAt(i--) - '0';
			if (j >= 0)
				sum += num2.charAt(j--) - '0';
			result.append(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0)
			result.append(carry);
		return result.reverse().toString();

		//SC:O(n+1) n will be the length of the largest string
		//TC:O(n)
	}
}
