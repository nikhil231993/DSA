package leetcode.array.easy;

import java.util.Scanner;

public class LC189RotateArray {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.println("No of times array has to be right rotated: ");
		int k = scan.nextInt();
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		k = k % arr.length;  // This will help when the size of array is less than k

		int n=arr.length;
		reverse(arr, 0, n - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, k, n - 1);

		System.out.println("Rotated array is: ");
		for (int i = 0; i < n; i++)
			System.out.println(arr[i]);
	}

	private static void reverse(int[] arr, int start, int end) {

		while (start <= end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		//TC:O(N)
		//SC:O(1) as we are not using any extra array
	}
}
