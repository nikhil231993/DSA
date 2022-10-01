package leetcode.easy;

public class SingleNumberLeetcode136 {

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 1, 2, 1, 2 };

		System.out.println(singleNumber(arr));
	}

	private static int singleNumber(int[] arr) {

		int result=0;
		for (int i = 0; i < arr.length; i++) {
			result ^= arr[i];
		}
		return result;
	}

}
