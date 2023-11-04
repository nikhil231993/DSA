package leetcode.math.easy;

public class LC168ExcelSheetColumnTitle {

	public static void main(String[] args) {

		int columnNumber = 674;
		System.out.println(convertToTitle(columnNumber));
	}

	public static String convertToTitle(int columnNumber) {
		StringBuilder result = new StringBuilder();
		while (columnNumber != 0) {
			char ch = (char) ('A' + (columnNumber - 1) % 26);
			result.append(ch);
			columnNumber = (columnNumber - 1) / 26;
		}
		return result.reverse().toString();
		// TC:log(n) base 26 as we are dividing by 26
		// SC:log(n) base 26 as we are dividing by 26
	}
}
