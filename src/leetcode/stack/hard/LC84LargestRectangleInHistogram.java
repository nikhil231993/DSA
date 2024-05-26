package leetcode.stack.hard;

import java.util.Arrays;
import java.util.Stack;

public class LC84LargestRectangleInHistogram {

	public static void main(String[] args) {

		int[] arr = new int[] { 2,1,5,6,2,3 };
		System.out.println(largestRectangleArea(arr));
	}

	// Using increasing stack approach
	public static int largestRectangleArea(int[] arr) {

		int n = arr.length;
		Stack<Integer> leftMinStack = new Stack();
		Stack<Integer> rightMinStack = new Stack();

		int[] leftMin = new int[n];
		int[] rightMin = new int[n];

		Arrays.fill(rightMin, n);
		Arrays.fill(leftMin, -1);

		// next smaller
		for (int i = 0; i < n; i++) {
			while (!rightMinStack.isEmpty() && arr[rightMinStack.peek()] > arr[i]) {
				int index = rightMinStack.pop();
				rightMin[index] = i;
			}
			rightMinStack.push(i);
		}

		// prev smaller
		for (int i = n - 1; i >= 0; i--) {
			while (!leftMinStack.isEmpty() && arr[leftMinStack.peek()] > arr[i]) {
				int index = leftMinStack.pop();
				leftMin[index] = i;
			}
			leftMinStack.push(i);
		}

		int area = 0;
		for (int i = 0; i < n; i++) {
			area = Math.max(area, (rightMin[i] - leftMin[i] - 1) * arr[i]);
		}
		return area;
	}

	// Below is easy Hello world approach

	public static int largestRectangleAreaHelloWorld(int[] arr) {

		int n = arr.length;
		Stack<Integer> leftMinStack = new Stack<Integer>();
		Stack<Integer> rightMinStack = new Stack<Integer>();

		int[] leftMin = new int[n];
		int[] rightMin = new int[n];

		// prev smaller
		for (int i = 0; i < n; i++) {

			while (!leftMinStack.isEmpty() && arr[leftMinStack.peek()] >= arr[i]) {
				leftMinStack.pop();
			}
			if (leftMinStack.isEmpty()) {
				leftMin[i] = -1;
			} else {
				leftMin[i] = leftMinStack.peek();
			}
			leftMinStack.push(i);
		}

		// next smaller
		for (int i = n - 1; i >= 0; i--) {

			while (!rightMinStack.isEmpty() && arr[rightMinStack.peek()] >= arr[i]) {
				rightMinStack.pop();
			}
			if (rightMinStack.isEmpty()) {
				rightMin[i] = n;
			} else {
				rightMin[i] = rightMinStack.peek();
			}
			rightMinStack.push(i);
		}

		int area = 0;
		for (int i = 0; i < n; i++) {
			area = Math.max(area, (rightMin[i] - leftMin[i] - 1) * arr[i]);
		}
		return area;
	}
}
