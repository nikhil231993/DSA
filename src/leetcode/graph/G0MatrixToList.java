package leetcode.graph;

import java.util.*;

public class G0MatrixToList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the no of Vertices");
        int n = scanner.nextInt();
        System.out.println("Enter the no of Edges");
        int m = scanner.nextInt();
        int[][] matrix = new int[n+1][n+1];
        createMatrix(matrix,m,n, scanner);
        List<List<Integer>> adjList = new ArrayList<>();
        convertMatrixToList(matrix, adjList, n, m);
        List<Integer> bfs = new ArrayList<>();
        System.out.println("BFS Traversal");
        System.out.println(bfs(matrix, bfs, 1));
        List<Integer> dfs = new ArrayList<>();
        int[] visited = new int[n+1];
        System.out.println("DFS Traversal");
        dfs(matrix, dfs, 1, visited);
        System.out.println(dfs);
    }

    private static void dfs(int[][] matrix, List<Integer> dfs, int node, int[] visited) {
        visited[node] = 1;
        dfs.add(node);
        for (int i = 1;i<matrix.length;i++) {
            if (matrix[node][i] == 1 && visited[i] == 0) {
                dfs(matrix, dfs , i, visited);
            }
        }
    }

    private static List<Integer> bfs(int[][] matrix, List<Integer> bfs, int node) {
        int n = matrix.length;
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        queue.add(node);
        visited[node] =1;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            bfs.add(curNode);
            for (int i =1;i<n; i++) {
                if (matrix[curNode][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }
        return bfs;
    }

    private static void convertMatrixToList(int[][] matrix, List<List<Integer>> adjList, int n, int m) {
        for (int i =0;i<=n;i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1;i<=n;i++) {
            for (int j =1;j<=n;j++) {
                if (matrix[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    //adjList.get(j).add(i);
                }
            }
        }
        System.out.println("Printing Adjacency List");
        for (List<Integer> list : adjList) {
            System.out.println(list);
        }
    }

    private static void createMatrix(int[][] matrix, int m, int n, Scanner scanner) {
        System.out.println("Enter Edge values");
        for (int i=1; i<=m ; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        System.out.println("Print Matrix");
        for (int i=0;i<=n;i++) {
            for (int j=0;j<=n;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
