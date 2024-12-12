package leetcode.stack.medium;

import java.util.Stack;

public class LC739DailyTemperatures {

	public static void main(String[] args) {

		int[] temperatures =new int[] {73, 74, 75, 71, 69, 72, 76, 73};

		int[] result = dailyTemperatures(temperatures);
		for (int x : result)
			System.out.println(x);
	}

    public static int[] dailyTemperatures(int[] temperatures) {

        int n=temperatures.length;

        Stack<Integer> st=new Stack();
        int[] ans=new int[n];

        for(int i=0; i<n; i++){

            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                ans[st.peek()]=i-st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;

        //TC:O(n)
        //SC:O(n)
    }
}
