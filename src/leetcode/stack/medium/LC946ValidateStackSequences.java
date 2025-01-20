package leetcode.stack.medium;

import java.util.Stack;

public class LC946ValidateStackSequences {

    public static void main(String[] args) {

       int[] pushed =new int[] {1,2,3,4,5};
       int[] popped =new int[] {4,5,3,2,1};

       System.out.println(validateStackSequences(pushed,popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> st=new Stack();

        int j=0;
        for(int i=0; i<pushed.length;){ // we can write i++ here also. There is no difference

            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
            i++;
        }
        return st.isEmpty();

        // TC:O(2*n)
        // SC:O(n)
    }
}
