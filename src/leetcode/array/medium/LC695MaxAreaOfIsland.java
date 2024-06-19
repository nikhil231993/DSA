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
				int areaCalculated = calculateArea(grid, 0, i, j);
				maxArea = Math.max(areaCalculated, maxArea);
			}
		}
		System.out.println(maxArea);
	}

	public static int calculateArea(int[][] grid, int area, int i, int j) {

		if (i >= grid.length || i < 0 || j < 0 || j >= grid[0].length)
			return area;

		if (grid[i][j] == 0)
			return area;

		area++;
		grid[i][j] = 0;
		area = calculateArea(grid, area, i + 1, j);
		area = calculateArea(grid, area, i - 1, j);
		area = calculateArea(grid, area, i, j + 1);
		area = calculateArea(grid, area, i, j - 1);

		return area;

		// SC:O(1)
		// TC:O(n*m)
	}
}
