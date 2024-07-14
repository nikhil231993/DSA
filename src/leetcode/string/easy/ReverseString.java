package leetcode.string.easy;

public class ReverseString {

	public static void main(String[] args) {

		String name = "Nikhil";

		char[] arr = new char[name.length()];
		int start = 0, end = name.length() - 1;

		while (start <= end) {
			char c = name.charAt(start);
			arr[start] = name.charAt(end);
			arr[end] = c;
			start++;
			end--;
		}
		for (char c : arr)
			System.out.print(c);
	}
}
