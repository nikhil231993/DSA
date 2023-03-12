package DataStructures.sorting;

import java.util.Scanner;

public class mergeSort {
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the size of the arrs:");
		int size=scan.nextInt();
		int[] arr=new int[size];
		System.out.println("enter the value in the array:");
		for(int i=0;i<arr.length;i++)
			arr[i]=scan.nextInt();
		int l=0;
		int r=arr.length-1;
		mergesort(arr,l,r);
		print(arr,l,r);
		scan.close();
	}

	private static void print(int[] arr, int l, int r) {
	System.out.println("Sorted va;ues are:");
	for(int i=0;i<arr.length;i++)
		System.out.println(arr[i]);
	}

	private static void mergesort(int[] arr, int l, int r) {
		if(r>l)
		{
			int m=(l+r)/2;
			mergesort(arr, l, m);
			mergesort(arr, m+1, r);
			merge(arr,l,m,r);
		}
		
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int n1=m-l+1;
		int n2=r-m;
		int[] l1=new int[n1];
		int[] r1=new int[n2];
		for(int i=0;i<n1;i++)
			l1[i]=arr[l+i];
		for(int j=0;j<n2;j++)
			r1[j]=arr[m+1+j];

		int i=0,j=0,k=l;
		while(i<n1 && j<n2)
		{
			if(l1[i]>=r1[j])
			{
				arr[k]=r1[j];
				j++;
			}else if(l1[i]<=r1[j])
			{
				arr[k]=l1[i];
				i++;
			}
			k++;
		}
		while(i<n1)
		{
			arr[k]=l1[i];
			i++;
			k++;
		}
		
		while(j<n2)
		{
		arr[k]=r1[j];
		j++;
		k++;
		}
	}

}
