package geeksForGeeks;

import java.util.Scanner;

public class subArrayWithGivenSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int len = scan.nextInt();
		System.out.println("Enter the elemts of the array: ");
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();
		System.out.println("Enter the sum of the array: ");
		int expecsum = scan.nextInt();
		/*
		 * int count = 0; int sum = 0; for (int i = 0; i < arr.length - 1; i++) { sum +=
		 * arr[i]; if (sum < expecsum) { count++; } else if (sum == expecsum) { int t =
		 * i; System.out.println("Numbers are: "); while (count >= 0) {
		 * 
		 * System.out.println(arr[t]); count--; t--; }
		 * 
		 * } else {
		 * 
		 * i = i - count + 1;
		 * 
		 * count = 0; sum = 0; i--;
		 * 
		 * }
		 * 
		 * }
		 */
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = arr[i];
			for (int j = i+1; j <= arr.length; j++) {
				if (sum == expecsum) {
					int p = j - 1;
					System.out.println("Sum found between numbers: " + i + " and  " + p);
				}
				if(sum > expecsum || j==arr.length)
					break;
				
				sum+=arr[j];
			}
		}
		scan.close();
	}
}
