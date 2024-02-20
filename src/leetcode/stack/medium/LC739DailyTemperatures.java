package leetcode.stack.medium;

import java.util.Stack;

public class LC739DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures =new int[] {73,74,75,71,69,72,76,73};
		int[] result = dailyTemperatures(temperatures);
		for (int x : result)
			System.out.println(x);

	}

	public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack();
        int[] ans=new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){

            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()]) {
                    stack.peek();
                }
            if(!stack.isEmpty()){
                ans[i]=stack.peek()-i;
            }
            stack.push(i);
        }
 return ans;    
 //SC:O(n)
 //TC:O(n)   
	}

}
