package learningLogic.recursion;

public class V4ReverseArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		reverseArray(arr);
		print(arr);

		// Reverse using recursion
		System.out.println("Using recursion");
		reverseArrayRecursion(arr, 0);
		print(arr);
		System.out.println("Recursion using two pointers");
		reverseArrayRecursionUsingTwoPointers(arr, 0, arr.length - 1);
		print(arr);

	}

	private static void reverseArrayRecursionUsingTwoPointers(int[] arr, int start, int end) {
		if (end > start) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			reverseArrayRecursionUsingTwoPointers(arr, start + 1, end - 1);
		} else {
			return;
		}

	}

	private static void reverseArrayRecursion(int[] arr, int i) {
		if (i > (arr.length / 2) - 1)
			return;

		int temp = arr[i];
		arr[i] = arr[arr.length - 1 - i];
		arr[arr.length - 1 - i] = temp;
		
		reverseArrayRecursion(arr, ++i);

	}

	private static void print(int[] arr) {
		for (Integer n : arr)
			System.out.println(n);

	}

	private static void reverseArray(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {

			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;

		}

	}

}
