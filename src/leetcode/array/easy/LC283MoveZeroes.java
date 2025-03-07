package leetcode.array.easy;

public class LC283MoveZeroes {

	public static void main(String[] args) {

		int[] arr = new int[] { 0,1,0,3,12 };

		//Approach 1:Brute
		int[] r=maxZeroesBrute(arr);
		for (int num : r)
			System.out.println(num);
		System.out.println("#########");

		//Approach 2: Optimal
		int[] result = maxZerores(arr);
		for (int num : result)
			System.out.println(num);
		System.out.println("#########");

		//Approach 3: Best
		int[] result1 = maxZeroresBest(arr);
		for (int num : result1)
			System.out.println(num);
	}

	private static int[] maxZeroesBrute(int[] arr) {

		int n=arr.length, j=0;
		int[] result=new int[n];
		for(int i=0;i<n;i++){
			if(arr[i]!=0)
				result[j++]=arr[i];
		}
		return result;

		//TC:O(n)
		//SC:O(n)
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

	private static int[] maxZeroresBest(int[] nums) {

		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {

				int temp=nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
				i++;
			}
		}
		return nums;

		//TC:O(n)
		//SC:O(1)
	}
}
