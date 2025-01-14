package leetcode.binarysearch.easy;

public class LC1351CountNegativeNumbersInGrid {

    public static void main(String[] args) {

        int[][] grid=new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegative(grid));
    }

    private static int countNegative(int[][] grid) {

        int row=grid.length-1;
        int n=grid[0].length;
        int column=0, count=0;

        while(row>=0 && column<n){
            if(grid[row][column]<0) {
                count+=n-column;
                row--;
            }else{
                column++;
            }
        }
        return count;

        // TC:O(m+n)
        // SC:O(1)
    }
}
