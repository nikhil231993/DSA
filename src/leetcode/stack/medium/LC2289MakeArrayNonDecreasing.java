package leetcode.stack.medium;

import java.util.Stack;

class Pair{

    Integer key;
    Integer count;

    public Pair(Integer key, Integer count){
        this.key=key;
        this.count=count;
    }
}


public class LC2289MakeArrayNonDecreasing {

    public static void main(String[] args) {

        int[] nums =new int[] {10,1,2,3,4,6,1,2,3};
        System.out.println(totalSteps(nums));
    }

    public static int totalSteps(int[] nums) {

        int n=nums.length;

        Stack<Pair> st=new Stack();

        int ans=0;
        for(int i=n-1; i>=0; i--){
            int count=0;
            while(!st.isEmpty() && st.peek().key<nums[i]){
                count=Math.max(count+1, st.peek().count);
                st.pop();
            }
            ans=Math.max(ans, count);
            st.push(new Pair(nums[i],count));
        }
        return ans;

        //TC:O(n)
        //SC:O(n)
    }
}
