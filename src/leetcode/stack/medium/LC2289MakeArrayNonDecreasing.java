package leetcode.stack.medium;

import java.util.Stack;

class Pair{

    Integer key;
    Integer value;

    public Pair(Integer key, Integer value){
        this.key=key;
        this.value=value;
    }
}

public class LC2289MakeArrayNonDecreasing {

    public static void main(String[] args) {

        int[] nums =new int[] {5,3,4,4,7,3,6,11,8,5,11};
        System.out.println(totalSteps(nums));
    }

    public static int totalSteps(int[] nums) {

        int n=nums.length;

        Stack<Pair> st=new Stack();
        st.push(new Pair(nums[n-1],0));


        int ans=0;
        for(int i=n-2; i>=0; i--){
            int count=0;
            while(!st.isEmpty() && st.peek().key<nums[i]){
                count=Math.max(count+1, st.peek().value);
                st.pop();
            }
            ans=Math.max(ans, count);
            st.push(new Pair(nums[i],count));
        }
        return ans;
    }
}
