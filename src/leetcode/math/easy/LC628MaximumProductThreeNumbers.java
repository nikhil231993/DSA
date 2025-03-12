package leetcode.math.easy;

import java.util.PriorityQueue;
import java.util.Arrays;

public class LC628MaximumProductThreeNumbers {

	public static void main(String[] args) {

		int[] num = new int[] { -10, -2, -3, 4 };

		//Approach 1: In this we use n cube that is 3 for loops and try all combinations to find the max product

		//Approach 2: Leetcode
		System.out.println(maximumProductLeetcode(num));

		//Approach 3
		System.out.println(maximumProduct(num));

		//Approach 4
		System.out.println(maximumProductBetter(num));
	}

	public static int maximumProductLeetcode(int[] nums) {

		Arrays.sort(nums);
		return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
		//First two numbers can be negative so we multiply those two and last positive number
		//Or we get answer by multiplying top 3 positive numbers
	}

	private static int maximumProduct(int[] num) {

		// 2st Approach is to use min heap and maxheap but here it will be TC: (nlogn) as
		// insertion and deletion in a heap takes log n time

		PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();

		for(int n:num){
			maxHeap.offer(n);
			minHeap.offer(n);
		}

		int max1=maxHeap.poll();
		int max2=maxHeap.poll();
		int max3=maxHeap.poll();

		int min1=minHeap.poll();
		int min2=minHeap.poll();

		return Math.max(max1 * max2 * max3, max1 * min1 * min2);
	}

	public static int maximumProductBetter(int[] nums) {

		// 2nd approach is specific to this case where we need to find only 3 no

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = nums[i];
			} else if (nums[i] > max2) {
				max3 = max2;
				max2 = nums[i];
			} else if (nums[i] > max3) {
				max3 = nums[i];
			}

			if (nums[i] < min1) {
				min2 = min1;
				min1 = nums[i];
			} else if (nums[i] < min2) {
				min2 = nums[i];
			}
		}
		return Math.max( max1 * max2 * max3, max1 * min1 * min2 );

		// SC:O(1)
		// TC:O(n)
	}
}
