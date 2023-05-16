package leetcode.graph;

import java.util.HashMap;
import java.util.Map;

public class G53LC947Stones {
    public static void main(String[] args) {
        int[][] stones =new int[][] {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(stonesRemoved(stones));
    }

    private static int stonesRemoved(int[][] stones) {
        int n=stones.length;//This is no of stones
        //Find out the dimensions of matrix. Consider the max values or row and col as dimensions
        int maxr=0;
        int maxc=0;
        for(int[] r:stones){
            maxr=Math.max(maxr,r[0]);
            maxc=Math.max(maxc,r[1]);
        }

        //Do the union considering columns as an extension of row
        DisjointSetBySize ds=new DisjointSetBySize(maxr+maxc+1);//Since Disjointset class handles n+1 so we give only +1

        //Map to store only row and columns having stones so that it can be used in findParent function
        Map<Integer,Integer> map=new HashMap<>();
        for(int[] r: stones){
            int row=r[0];
            int col=r[1]+maxr+1;
            ds.unionBySize(row,col);
            map.put(row,1);
            map.put(col,1);
        }

        //count separate components
        int count=0;

        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            if(ds.findParent(m.getKey())==m.getKey()){
                count++;
            }
        }
        return n-count;

        //Time Complexity: O(N), where N = total no. of stones.
        //Here we have just traversed the given stones array several times. And inside those loops, every operation
        //is apparently taking constant time. So, the time complexity is only the time of traversal of the array.

        //Space Complexity: O(2* (max row index + max column index)) for the parent and size array inside the Disjoint Set
        // data structure.
    }
}
