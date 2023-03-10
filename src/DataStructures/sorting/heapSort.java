package DataStructures.sorting;

import java.util.Scanner;

public class heapSort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size = scan.nextInt();
		System.out.println("Enter the values of the array:");
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scan.nextInt();
		int l=0,n=arr.length;
		sort(arr,l,n);
		print(arr,l,n);
		scan.close();
	}

	private static void print(int[] arr, int l, int r) {
		System.out.println("values are:");
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		
	}

	private static void sort(int[] arr, int l, int n) {
		
		for(int i=arr.length/2-1;i>=0;i--)
			maxheapify(arr,n,i);
		
		for(int i=n-1;i>0;i--)
		{
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			maxheapify(arr, i, 0);
		}
		
		
	}

	private static void maxheapify(int[] arr, int n, int i) {
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		if( l<n && arr[largest]<arr[l])
			largest=l;
		if(r<n && arr[largest]<arr[r])
			largest=r;
		if(largest!=i)
		{
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			maxheapify(arr, n, largest);
		}
	}

}
