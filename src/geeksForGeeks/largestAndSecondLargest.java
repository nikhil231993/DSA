package geeksForGeeks;

import java.util.Scanner;

public class largestAndSecondLargest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("NEter the size of the array: ");
		int size = scan.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter the array to be scanned: ");
		for (int i = 0; i < size; i++)
			arr[i] = scan.nextInt();
		int max = 0;
		int secmax = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i] > max) {
				secmax = max;
				max = arr[i];

			} else if (arr[i] < max && arr[i] > secmax && arr[i] != max) {
				secmax = arr[i];
			}
		}
		System.out.println("Largest number is: " + max);
		System.out.println("Second largest number is: " + secmax);
		scan.close();
	}

}
