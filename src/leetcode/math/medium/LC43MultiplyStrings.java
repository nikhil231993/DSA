package leetcode.math.medium;

public class LC43MultiplyStrings {

	public static void main(String[] args) {

		String num1 = "123";
		String num2 = "456";
		System.out.println(multiply(num1, num2));
	}

	private static String multiply(String num1, String num2) {
		int n = num1.length();
		int m = num2.length();

		if (n == 0 || m == 0)
			return "0";

		if (num1.equals("0") || num2.equals("0"))
			return "0";

		int n1 = n- 1, n2 = m - 1;
		int[] result = new int[n + m];

		for (int i = n1; i >= 0; i--) {
			for (int j = n2; j >= 0; j--) {
				result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				result[i + j] += result[i + j + 1] / 10;
				result[i + j + 1] = result[i + j + 1] % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		int j = 0;

		while (j < result.length && result[j] == 0)
			j++;
		while (j < result.length) {
			sb.append(result[j++]);
		}

		return sb.toString();

		//Time complexity: O(M*N)
		//During multiplication, we perform N operations for each of the M digits of the second number,
		//so we need M⋅N time for it.
		//Space complexity: O(M+N).
	}
}
