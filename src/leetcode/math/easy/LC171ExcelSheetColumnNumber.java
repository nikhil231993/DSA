package leetcode.math.easy;

public class LC171ExcelSheetColumnNumber {

	public static void main(String[] args) {
		String s="ABC";
		System.out.println(titleToNumber(s));
	}
	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + s.charAt(i) - 'A' + 1;
		}
		return result;
		// TC:O(n)
		// SC:O(1)
	}
}
