package leetcode.array.easy;

import java.util.Scanner;

public class LC189RotateArray {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.println("No of times to rotate array: ");
		int k = scan.nextInt();
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		k = k % arr.length;  // This when the size of array is less than k


		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, k, arr.length - 1);

		System.out.println("Rotated array is: ");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	private static void reverse(int[] arr, int start, int end) {

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
