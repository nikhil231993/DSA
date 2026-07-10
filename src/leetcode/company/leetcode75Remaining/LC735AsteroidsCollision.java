package leetcode.company.leetcode75Remaining;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC735AsteroidsCollision {

    public static void main(String[] args) {
       int[]  asteroids = new int[] {3,5,-6,2,-1,4};
       int[] result=asteroidCollision(asteroids);
       for(int num:result)
           System.out.println(num);
    }

    private static int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<n;i++){
            if(asteroids[i]>0) {
                st.push(asteroids[i]);
            } else{

                while(!st.isEmpty() && st.peek()>0 && st.peek() < -asteroids[i])
                    st.pop();
                if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroids[i]);
                } else if (st.peek() ==-asteroids[i]){
                    st.pop();
                }
            }
        }
        int[] result=new int[st.size()];
        int j=st.size()-1;
        while(!st.isEmpty()){
            result[j]=st.pop();
            j--;
        }
        return result;
    }
}
