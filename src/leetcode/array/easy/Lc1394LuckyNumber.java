package leetcode.array.easy;

public class Lc1394LuckyNumber {

	public static void main(String[] args) {

		int[] num = new int[]{2, 2, 3, 4};
		System.out.println(findLucky(num));
	}

	public static int findLucky(int[] arr) {

		int[] res=new int[501];
		int max=-1;
		for(int no:arr){
			res[no]++;
		}

		for(int no:arr){
			if(no==res[no])
				max=Math.max(max,no);
		}
		return max;

		//TC:O(n)
		//SC:O(500)
	}
}
