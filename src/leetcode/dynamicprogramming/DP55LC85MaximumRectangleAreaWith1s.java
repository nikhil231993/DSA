package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Stack;

public class DP55LC85MaximumRectangleAreaWith1s {

    public static void main(String[] args) {

        char[][] matrix = new char[][]{{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};

        int[] heights=new int[matrix[0].length];//Since column > row
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0')
                    heights[j]=0;
                else
                    heights[j]++;
            }
            int area=largestRectangleArea(heights);
            max=Math.max(max,area);
        }
        System.out.println("Max area is:" + max);

        //TC:O(n * (m * time complexity of calculation code))
    }

    public static int largestRectangleArea(int[] arr) {

        int n = arr.length;
        Stack<Integer> leftMinStack = new Stack<Integer>();
        Stack<Integer> rightMinStack = new Stack<Integer>();

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        Arrays.fill(leftMin, -1);
        Arrays.fill(rightMin, n);

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
