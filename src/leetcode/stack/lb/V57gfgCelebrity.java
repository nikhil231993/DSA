package leetcode.stack.lb;

import java.util.Stack;

public class V57gfgCelebrity {

    public static void main(String[] args) {

        int N = 3;
        int[][] M = new int[][] {{0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}};

        //Approach 1: n square where each element checks row and column

        //Approach 2: n + m
        System.out.println(celebrity(M, N));
    }

    static int celebrity(int M[][], int n) {

        Stack<Integer> st=new Stack();
        for(int i=0; i<n; i++)
            st.push(i);

        while(st.size()>1){
            int a=st.pop();
            int b=st.pop();

            if(knows(a,b,M))
                st.push(b);
            else
                st.push(a);

        }
        int candidate=st.pop();

        for(int i=0;i<n;i++){
            if(M[candidate][i]!=0 && candidate!=i)
                return -1;
        }

        for(int i=0;i<n;i++){
            if(M[i][candidate]!=1 && candidate!=i)
                return -1;
        }
        return candidate;
    }


    public static boolean knows(int a, int b, int M[][]){

        if(M[a][b]==1)
            return true;
        return false;

        //TC:O(N)
        //SC:O(N)
    }
}
