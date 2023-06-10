package leetcode.array.medium;

public class LC1423MaximumPointsYouCanObtainFromCards {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 1 };
		int k = 3;
		System.out.println(maxPoints(nums, k));

	}

	private static int maxPoints(int[] nums, int k) {

		int n=nums.length;
		int sum=0;
		for(int i=0;i<k;i++){
			sum=sum+nums[i];
		}

		int p1=k-1;
		int p2=n-1;
		int resultInitial=sum;
		while(p1>=0){
			sum=sum-nums[p1];
			p1--;
			sum=sum+nums[p2];
			p2--;
			resultInitial=Math.max(resultInitial,sum);
		}
		return resultInitial;
	}

//	private static int maxPoints(int[] nums, int k) {
//		int total = 0;
//
//		for (int i = 0; i < nums.length; i++) {
//			total += nums[i];
//			nums[i] = total;
//		}
//		int ans=0;
//		int max=0;
//		for (int i = 0; i <= k; i++) {
//			int j = i + 3;
//			if(i==0) {
//				ans=nums[j];
//			}else {
//				ans=nums[j]-nums[i-1];
//			}
//			
//			max=Math.max(total-ans, max);
//		}
//		return max;
//
//		// SC:O(1)
//		// TC:O(n)
//	}

}
