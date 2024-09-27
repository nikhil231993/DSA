package leetcode.math.medium;

public class LC43MultiplyStrings {

	public static void main(String[] args) {

		String num1 = "123";
		String num2 = "456";
		System.out.println(multiply(num1, num2));
	}

	public static String multiply(String num1, String num2) {

		if (num1.length() == 0 || num2.length() == 0)
			return "0";
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		int n1 = num1.length() - 1, n2 = num2.length() - 1;
		int[] result = new int[num1.length() + num2.length()];

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
	}
}
