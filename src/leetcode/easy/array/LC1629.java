package leetcode.easy.array;

public class LC1629 {

	public static void main(String[] args) {
		int[] arr = new int[] { 12, 23, 36, 46, 62 };
		String s = "spuda";
		System.out.println(slowestKey(arr, s));

	}

	private static char slowestKey(int[] arr, String s) {
		char c = s.charAt(0);
		int time = arr[0];
		for (int i = 1; i < arr.length; i++) {

			int diff = arr[i] - arr[i - 1];
			if (diff > time) {
				time = diff;
				c = s.charAt(i);

			}
			if (diff == time) {
				c = s.charAt(i);
			}
		}
		return c;
	}

}
