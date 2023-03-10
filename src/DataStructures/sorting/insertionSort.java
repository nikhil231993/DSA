package DataStructures.sorting;

import java.util.Scanner;

public class insertionSort {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int len = scan.nextInt();
		int[] arr = new int[len];
		System.out.println("Enter the elemts of the arra: ");
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;

			}
			arr[j + 1] = key;
		}
		System.out.println("Numbers after sorting are: ");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		scan.close();
	}

}
