package DataStructures.sorting;

import java.util.Scanner;

public class binarySearchRecursive {
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the size of the array:");
		int size=scan.nextInt();
		int[] arr=new int[size];
		System.out.println("Enter the elements of the array:");
		for(int i=0;i<arr.length;i++)
			arr[i]=scan.nextInt();
		int l=0;
		int r=arr.length-1;
		System.out.println("Enter the value to search:");
		int value=scan.nextInt();
		int x=binarysearch(arr,l,r,value);
		System.out.println("value found at:"+x);
		scan.close();
	}

	private static int binarysearch(int[] arr, int l, int r, int value) {
		int m=(l+r)/2;
		int flag=0;
		while(r>=l)
		{
			if(arr[m]==value)
			{
				flag=1;
				return m;
			}
			else if(arr[m]>value)
				return binarysearch(arr, l, m-1, value);
			else if(arr[m]<value)
			return binarysearch(arr, m+1, r, value);
		}
		if(flag==0)
			System.out.println("not found");
		return -1;
		
	}

}
