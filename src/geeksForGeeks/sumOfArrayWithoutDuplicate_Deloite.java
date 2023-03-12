package geeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class sumOfArrayWithoutDuplicate_Deloite {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size = scan.nextInt();
		System.out.println("Enter the elemst of the array: ");
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();
		Set<Integer> s = new HashSet<Integer>();

		int sum = 0;
		int tempsum = 0;
		int a = 0;
		int i = 0;
		for (i = 0; i < arr.length; i++) {

			if (!s.contains(arr[i])) {
				s.add(arr[i]);
				sum += arr[i];
			} else {
				if (sum > tempsum) {
					tempsum = sum;
				}

				sum = 0;
				sum += arr[i];
			}

		}
		if (tempsum > sum)
			sum = tempsum;

		System.out.println("Sum is: " + sum);
		scan.close();

	}
}
