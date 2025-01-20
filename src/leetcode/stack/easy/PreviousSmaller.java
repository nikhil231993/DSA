package leetcode.stack.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PreviousSmaller {

    public static void main(String[] args) {

        int[] nums=new int[]{1,5,3,4,6,7,2,8,9};
        Stack<Integer> st=new Stack<>();

		// Approach 1
        findPrevMinimumOfEachElement(nums,st);
        for(int n: nums)
            System.out.println(n);

		System.out.println("#######################################");
		int[] nums1 = new int[] { 1, 5, 3, 4, 6, 7, 2, 8, 9 };

		// Approach 2:
		List<Integer> result = leftSmaller(nums1.length, nums1);
		for (int no : result)
			System.out.println(no);
    }

    private static void findPrevMinimumOfEachElement(int[] nums, Stack<Integer> st) {

        for(int i=nums.length-1;i>=0;i--){
            while (!st.isEmpty() && nums[st.peek()] > nums[i] ){
                int index=st.pop();
                nums[index]=nums[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()){
            nums[st.pop()]=-1;
        }

		//TC:O(N + N)
		//SC:O(N) worst case if it is an increasing array
    }

	private static List<Integer> leftSmaller(int n, int a[]) {

		Stack<Integer> st = new Stack();
		int[] ans = new int[a.length];

		for (int i = a.length - 1; i >= 0; i--) {

			while (!st.isEmpty() && a[st.peek()] > a[i]) {
				ans[st.peek()] = a[i];
				st.pop();
			}
			st.push(i);
		}

		while (!st.isEmpty()) {
			ans[st.pop()] = -1;
		}

		List<Integer> result = Arrays.stream(ans).boxed().collect(Collectors.toList());
		return result;

		//TC:O(N + N)
		//SC:O(N) worst case if it is an decreasing array
	}
}
