package leetcode.math.easy;

public class LC67AddTwoBinary {

	public static void main(String[] args) {
		String a = "1010";
		String b = "1011";
		System.out.println(addBinary(a, b));
	}

	public static String addBinary(String a, String b) {
		int sum = 0;
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		StringBuilder result = new StringBuilder();
		while (i >= 0 || j >= 0) {
			sum = carry;
			if (i >= 0) {
				sum += a.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += b.charAt(j--) - '0';
			}
			result.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) {
			result.append(carry);
		}
		return result.reverse().toString();
		// TC:O(n) where n is the length of larger string
		// SC:O(n+1) where n is the length of the larger string
	}
}
