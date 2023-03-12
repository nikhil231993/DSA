package DataStructures.sorting;


import java.util.Scanner;

public class quickSort {
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size=scan.nextInt();
		int[] arr=new int[size];
		System.out.println("Enter the elements of the array:");
		for(int i=0;i<arr.length;i++)
			arr[i]=scan.nextInt();
		int l=0;
		int r=arr.length-1;
		quickSorting(arr,l,r);	
		print(arr,l,r);
		scan.close();
	}
	
	private static void print(int[] arr, int l, int r) {
		System.out.println("sorted values are:");
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

	}

	private static void quickSorting(int[] arr, int l, int r) {
		if(l<r)
		{
			int q=partition(arr,l,r);
			quickSorting(arr, l, q-1);
			quickSorting(arr, q+1, r);
		}
		
	}

	private static int  partition(int[] arr, int l, int r) {
		int pivot=arr[r];
		int i=l-1;
		for(int j=l;j<r;j++)
		{
			if(pivot>arr[j])
			{
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
			int temp=arr[i+1];
			arr[i+1]=arr[r];
			arr[r]=temp;
		
		return i+1;
	}

}
