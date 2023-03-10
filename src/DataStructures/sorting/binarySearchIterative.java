package DataStructures.sorting;

import java.util.Scanner;

public class binarySearchIterative {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size = scan.nextInt();
		int[] arr = new int[size];
		System.out.println("enter the elments of the array:");
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();
		System.out.println("Ente the element to search:");
		int value = scan.nextInt();
		int l = 0;
		int r = arr.length - 1;
		int m = 0;
		int flag = 0;
		while (r >= l) {
			m = (l + r) / 2;
			if (arr[m] == value) {
				System.out.println("value found at:" + (m));
				flag = 1;
				break;
			} else if (arr[m] < value)
				l = m + 1;
			else if (arr[m] > value)
				r = m - 1;
		}
		if (flag == 0)
			System.out.println("value not found");
		scan.close();
	}

}
