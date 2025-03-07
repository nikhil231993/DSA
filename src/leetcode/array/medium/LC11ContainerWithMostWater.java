package leetcode.array.medium;

public class LC11ContainerWithMostWater {

	public static void main(String[] args) {

		int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(container(height));
	}

	private static int container(int[] height) {

		int left = 0, right = height.length - 1;
		int vol = Integer.MIN_VALUE;
		
		while(left < right) {
			vol = Math.max(Math.min(height[left], height[right]) * (right - left), vol);

			if (height[left]<height[right]) {
				left++;
			} else
				right--;
		}

		return vol;

		//TC:O(n)
		//SC:O(1)
	}
}
