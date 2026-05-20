package leetcode.array.easy;

public class Lc1394LuckyNumber {

	public static void main(String[] args) {

		int[] num = new int[]{2, 2, 3, 4};
		System.out.println(findLucky(num));
	}

	public static int findLucky(int[] arr) {

		int[] res=new int[501];
		int max=-1;
		for(int no : arr){
			res[no]++;
		}

		for(int no : arr){
			if(no == res[no])
				max=Math.max(max,no);
		}
		return max;

		// TC:O(n)
		// SC:O(500)
	}

	private int findLuckyAlternative(int[] arr) {
		int n=arr.length;
		int[] result=new int[501];
		for(int i=0;i<n;i++)
			result[arr[i]]++;
		int max=-1;
		for(int i=0; i<=500; i++){
			if(result[i]!=0 && result[i]==i)
				max=Math.max(max, i);
		}
		return max;
	}
}
