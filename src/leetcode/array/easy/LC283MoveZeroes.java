package leetcode.array.easy;

public class LC283MoveZeroes {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 3, -5, 7 };
		int[] result = maxZerores(arr);
		for (int num : result)
			System.out.println(num);
//TC:O(n)
//SC:O(1)

	}

	private static int[] maxZerores(int[] arr) {
		int i = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != 0) {
				arr[i++] = arr[j];
			}
		}

		while (i < arr.length) {
			arr[i++] = 0;
		}
		return arr;
	}

}
