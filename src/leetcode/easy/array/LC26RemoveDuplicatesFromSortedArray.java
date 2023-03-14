package leetcode.easy.array;

public class LC26RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 2 };
		System.out.println("Size of arr after duplicate removal is: ");
		removeDuplicates(arr);
		for (Integer n : arr)
			System.out.println(n);
//		System.out.println(size);
//		for (int i = 0; i < size; i++)
//			System.out.println(arr[i]);
	}

	private static void removeDuplicates(int[] arr) {

		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[j] != arr[i]) {
				arr[++j] = arr[i];
			}
		}

		while (j < arr.length - 1) {
			arr[++j] = 0;
		}

	}

	// one way


}
