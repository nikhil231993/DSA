package leetcode.stack.lb;

import java.util.Arrays;
import java.util.Stack;

public class V57LC85MaximalRectangle {

    public static void main(String[] args) {

        int n = 4, m = 4;
        int[][] M = new int[][]{{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};

        System.out.println(maxArea(M, n, m));
    }

    public static int maxArea(int M[][], int n, int m) {

        int maxArea=largestRectangleArea(M[0]);

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(M[i][j]==1){
                    M[i][j]=M[i][j]+M[i-1][j];
                }else
                    M[i][j]=0;
            }
            maxArea=Math.max(maxArea, largestRectangleArea(M[i]));
        }
        return maxArea;
    }

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
            while (!rightMinStack.isEmpty() && arr[rightMinStack.peek()] >= arr[i]) {
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
}
