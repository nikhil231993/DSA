package leetcode.company.leetcode75Remaining;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC2352EqualRowAndColumnPairs {

    public static void main(String[] args) {
        int[][] grid =new int[][] {{3,2,1},{1,7,6},{2,7,7}};

        //Approach 1
        System.out.println(equalPairs(grid));

        //Approach 2
        System.out.println(equalPairsApproach2(grid));

        //Approach 3
        System.out.println(equalPairsApproach3(grid));
    }

    private static int equalPairs(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int count=0;

        for(int r=0; r<n; r++){
            for(int c=0;c<m;c++){
                boolean isEqual=true;
                for(int i=0;i<n;i++){
                    if(grid[r][i]!=grid[i][c]) {
                        isEqual=false;
                        break;
                    }
                }
                if(isEqual) count++;
            }
        }
        return count;
    }

    private static int equalPairsApproach2(int[][] grid) {
        Map<String, Integer> rowString=new HashMap<>();
        int n=grid.length;
        for(int r=0;r<n;r++){
            String row= Arrays.toString(grid[r]);
            rowString.put(row, rowString.getOrDefault(row, 0)+1);
        }
        int count=0;
        for(int r=0;r<n;r++){
            int[] col=new int[n];
            for(int c=0;c<n;c++){
                col[c]=grid[c][r];
            }
            count+=rowString.getOrDefault(Arrays.toString(col), 0);
        }
        return count;
    }

    private static int equalPairsApproach3(int[][] grid) {
        Map<String, Integer> rowString=new HashMap<>();
        Map<String, Integer> colString=new HashMap<>();
        int n=grid.length;

        int count=0;
        for(int r=0;r<n;r++){
            StringBuilder row=new StringBuilder();
            StringBuilder col=new StringBuilder();
            for(int c=0;c<n;c++){
                row.append(grid[r][c]);
                col.append(grid[c][r]);
                row.append("*");
                col.append("*");
            }
            String r1=row.toString(), c1=col.toString();
            rowString.put(r1, rowString.getOrDefault(r1, 0)+1);
            colString.put(c1, colString.getOrDefault(c1, 0)+1);
        }

        for(String s: rowString.keySet()){
            if(colString.containsKey(s))
                count+=rowString.get(s)* colString.get(s);
        }
        return count;
    }
}
