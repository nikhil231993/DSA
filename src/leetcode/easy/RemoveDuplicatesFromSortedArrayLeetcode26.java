package leetcode.easy;

public class RemoveDuplicatesFromSortedArrayLeetcode26 {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 2, 3, 3, 3, 4, 5, 6, 6, 7 };
		System.out.println("Size of arr after duplicate removal is: ");
		int size = removeDuplicates(arr);
		System.out.println(size);
		for (int i = 0; i < size; i++)
			System.out.println(arr[i]);
	}

	// one way
	private static int removeDuplicates(int[] arr) {
		if (arr.length == 1) {
			System.out.println("Array is invalid");
			return -1;
		}

		int i = 0;
		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}
		return (i + 1);
	}

}
