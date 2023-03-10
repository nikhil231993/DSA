package DataStructures.sorting;

import java.util.Scanner;

public class selectionSort {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int len = scan.nextInt();
		int[] arr = new int[len];
		System.out.println("enter the elemst of the array: ");
		for (int i = 0; i < arr.length ; i++)
			arr[i] = scan.nextInt();
		int min=0;
		int temp=0;
		int j=0;
		for(int i=0;i<1;i++)
		{
			min=i;
			for( j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[min])
					min=j;
					
			}
			temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
				
		}
		System.out.println("numbers are: ");
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);

		scan.close();
	}

}
