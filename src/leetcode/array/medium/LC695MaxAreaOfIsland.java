package leetcode.array.medium;

public class LC695MaxAreaOfIsland {

	public static void main(String[] args) {

		int[][] grid = new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
		                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
		                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
		                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
		                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
		                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
								{0,0,0,0,0,0,0,1,1,0,0,0,0}};

		int maxArea = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int areaCalculated = calculateArea(grid, 0, i, j, grid.length, grid[0].length);
				maxArea = Math.max(areaCalculated, maxArea);
			}
		}
		System.out.println(maxArea);

		// we can also do by below approach

		int[][] grid1 = new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}};

		System.out.println(maxAreaOfIsland(grid1));
	}

	public static int maxAreaOfIsland(int[][] grid) {

		int n=grid.length;
		int m=grid[0].length;
		int[][] visited=new int[n][m];
		int max=-1;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				int[] count=new int[1];
				if(grid[i][j]==1)
					recursion(i, j, n, m, grid, count, visited);
				max=Math.max(max, count[0]);
			}
		}
		return max;
	}

	private static void recursion(int i, int j, int n, int m, int[][] grid, int[] count, int[][] visited){

		if(i<0 || i>=n || j<0 || j>=m ||grid[i][j]!=1||visited[i][j]==1)
			return;
		count[0]++;
		visited[i][j]=1;
		recursion(i+1, j, n, m, grid, count, visited);
		recursion(i-1, j, n, m, grid, count, visited);
		recursion(i, j+1, n, m, grid, count, visited);
		recursion(i, j-1, n, m, grid, count, visited);
	}

	public static int calculateArea(int[][] grid, int area, int i, int j, int n, int m) {

		if (i >= grid.length || i < 0 || j < 0 || j >= grid[0].length)
			return area;

		if (grid[i][j] == 0)
			return area;

		area++;
		grid[i][j] = 0;

		area = calculateArea(grid, area, i + 1, j, n, m);
		area = calculateArea(grid, area, i - 1, j, n, m);
		area = calculateArea(grid, area, i, j + 1, n, m);
		area = calculateArea(grid, area, i, j - 1, n, m);

		return area;

		//SC:O(1)
		//TC:O(n*m)
	}
}
