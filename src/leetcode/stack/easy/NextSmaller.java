package leetcode.stack.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class NextSmaller {

    public static void main(String[] args) {
    	
        int[] nums=new int[]{1,5,3,4,6,7,2,8,9};

        // Approach 1 : Brute force which is n square in TC where we have two loops

		// Approach 2
		findNextMinimumOfEachElement(nums, new Stack<>());
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]);
        
		System.out.println("###################################");

        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(4);
        arr.add(3);
        
		// Approach 3
		ArrayList<Integer> ans = nextSmallerElement(arr, arr.size());
        		
        for(Integer n: ans)
        	System.out.println(n);
    }

    private static void findNextMinimumOfEachElement(int[] nums, Stack<Integer> st) {

        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                int index=st.pop();
                nums[index]=nums[i];
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            nums[st.pop()]=-1;
        }

        //TC:O(N + N)
        //SC:O(N) worst case if it is an increasing array
    }

	public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {

		Stack<Integer> st = new Stack();

		int[] arr1 = new int[arr.size()];

		for (int i = 0; i < arr.size(); i++) {

			while (!st.isEmpty() && arr.get(st.peek()) > arr.get(i)) {
				arr1[st.peek()] = arr.get(i);
				st.pop();
			}
			st.push(i);
		}

		while (!st.isEmpty())
			arr1[st.pop()] = -1;

		ArrayList<Integer> result = (ArrayList<Integer>) Arrays.stream(arr1).boxed().collect(Collectors.toList());
//		for (Integer n1 : arr1)
//			result.add(n1);
//      int[] example1 = list.stream().mapToInt(i->i).toArray();

		return result;
	}
}
