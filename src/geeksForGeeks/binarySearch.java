package geeksForGeeks;

import java.util.Scanner;

public class binarySearch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int size = scan.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the value to seacrh:  ");
		int value = scan.nextInt();
		int start = 0;
		int end = size - 1;
		System.out.println("enter the values in array: ");
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}

		System.out.println("elemt found at: " + binarysearch(arr, start, end, value));
		scan.close();
	}

	private static int binarysearch(int[] arr, int start, int end, int value) {
		int mid = start + end / 2;

		if (end >= start) {
			if (value < arr[mid]) {
				end = mid - 1;
				return binarysearch(arr, start, end, value);
			} else if (value > arr[mid]) {
				start = mid + 1;
				return binarysearch(arr, start, end, value);
			} else
				return mid;
		}
		return -1;
	}

}
