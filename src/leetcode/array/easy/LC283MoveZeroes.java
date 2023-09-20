package leetcode.array.easy;

public class LC283MoveZeroes {
	public static void main(String[] args) {
		int[] arr = new int[] { 0,1,0,3,12 };

		//Approach 1 Brute
		int[] r=maxZeroesBrute(arr);
		for (int num : r)
			System.out.println(num);
		System.out.println("#########");

		//Approach 2 Optimal
		int[] result = maxZerores(arr);
		for (int num : result)
			System.out.println(num);
	}

	private static int[] maxZeroesBrute(int[] arr) {
		int n=arr.length;
		int[] result=new int[n];
		int j=0;
		for(int i=0;i<n;i++){
			if(arr[i]!=0)
				result[j++]=arr[i];
		}
		return result;
		//SC:O(n)
		//TC:O(n)
	}

	private static int[] maxZerores(int[] arr) {
		int i = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != 0) {
				arr[i++] = arr[j];
			}
		}
		while (i < arr.length) {
			arr[i++] = 0;
		}
		return arr;
		//TC:O(n)
		//SC:O(1)
	}
}
