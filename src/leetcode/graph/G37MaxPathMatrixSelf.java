package leetcode.graph;

import java.util.PriorityQueue;

public class G37MaxPathMatrixSelf {

    public static void main(String[] args) {
        int[][] heights = new int[][]{{2, 3, 1}, {1, 6, 2}, {1, 1, 1}};
        int[] source = new int[]{0, 0};
        int[] dest = new int[]{2, 2};

        System.out.println(maxPAth(heights, source, dest));
    }

    private static int maxPAth(int[][] heights, int[] source, int[] dest) {

        PriorityQueue<PairG37> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        int n = heights.length;
        int m = heights[0].length;

        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = (int) 1e9;
            }
        }

        //SET ABSOLUTE DIFF FOR SOURCE AS 0
        diff[source[0]][source[1]] = heights[source[0]][source[1]];

        //row and col are 0 as it is mentioned it starts from 0,0
        pq.offer(new PairG37(diff[source[0]][source[1]], source[0], source[1]));

        int[] xaxis = new int[]{1, 0, -1, 0};
        int[] yaxis = new int[]{0, -1, 0, 1};

        while (!pq.isEmpty()) {
            int distance = pq.peek().diff;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.poll();

            if (row == dest[0] && col == dest[1])
                return distance;

            for (int k = 0; k < 4; k++) {
                int nrow = row + xaxis[k];
                int ncol = col + yaxis[k];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    if (distance + heights[nrow][ncol] < diff[nrow][ncol]) {

                        diff[nrow][ncol] = distance + heights[nrow][ncol];
                        pq.offer(new PairG37(diff[nrow][ncol], nrow, ncol));
                    }
                }
            }
        }
        return -1;
    }
}
