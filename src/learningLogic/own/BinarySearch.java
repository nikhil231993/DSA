package learningLogic.own;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of the array:");
		int size=sc.nextInt();
		System.out.println("The no are:");
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
			arr[i]=sc.nextInt();
		System.out.println("Enter the value to search for:");
		int value=sc.nextInt();
		Arrays.sort(arr);
		int pos=binarySearch(0,size-1,value,arr);
		if (pos==0 || pos ==-1)
			System.out.println("No is not found in the array");


	}

	private static int binarySearch(int start,int end, int value,int[] arr) {
	
		if(end >=start) {
		int mid=(start+end)/2;
		if(arr[mid] ==value) {
			System.out.println("----Found----");
			return mid;
		}
		else if (arr[mid]<value) {
			System.out.println("-----Greater----");
			return binarySearch(mid+1, end, value, arr);
		}
		else if (arr[mid]>value) {
			System.out.println("----Lesser----");		
			return binarySearch(start, mid-1, value, arr);
		}
		}
		
		return -1;
		
				
	}

}
