package DataStructures.sorting;

import java.util.Scanner;

public class bubbleSort {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the szie of the array: ");
		int len = scan.nextInt();
		int[] arr = new int[len];
		System.out.println("enter the numbers in the array: ");
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();
		int temp = 0;
		int count=0;
		for (int i = 0; i < arr.length-1; i++) {
			
			for (int j = 0; j < arr.length-i-1; j++) {
				
				if (arr[j] > arr[j + 1]) {
					count++;
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;

				}
			}
		}
		System.out.println("Elemts after ordering are: ");
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		
		System.out.println("no of times loops runs is: "+count);
		scan.close();
	}

}
