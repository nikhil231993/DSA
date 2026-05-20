package leetcode.array.medium;

public class LC11ContainerWithMostWater {

	public static void main(String[] args) {

		int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(container(height));
	}

	private static int container(int[] height) {

		int left = 0, right = height.length - 1;
		int maxVolume = Integer.MIN_VALUE;
		
		while(left < right) {
			maxVolume = Math.max(Math.min(height[left], height[right]) * (right - left), maxVolume);

			if (height[left]<height[right]) {
				left++;
			} else
				right--;
		}

		return maxVolume;

		//TC:O(n)
		//SC:O(1)
	}
}
