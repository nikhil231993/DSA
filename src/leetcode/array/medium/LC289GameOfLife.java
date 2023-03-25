package leetcode.array.medium;

public class LC289GameOfLife {

	public static void main(String[] args) {
		int[][] game = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		
		int n=game.length;
		int m=game[0].length;
		game(game, n, m);

		for (int[] row : game)
			System.out.println(row[0] + " " + row[1] + " " + row[2]);
		System.out.println();

	}

	private static void game(int[][] game, int n, int m) {
		int[] x_axis = new int[] { 0, 0, 1, 1, 1, -1, -1, -1 };
		int[] y_axis = new int[] { 1, -1, 1, 0, -1, 1, 0, -1 };
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int neighbour=0;
				for(int k=0;k<8;k++) {
					int row = i + x_axis[k];
					int col = j + y_axis[k];
					
					if ((row >= 0 && col >= 0 && row < n && col < m) && (Math.abs(game[row][col]) == 1))
							neighbour++;
				}
				
				if (game[i][j] == 1 && (neighbour < 2 || neighbour > 3))
					game[i][j] = -1;
				if (game[i][j] == 0 && neighbour == 3)
					game[i][j] = 2;

			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(game[i][j]>=1)
					game[i][j] = 1;
				else
					game[i][j]=0;
			}
		}
		// SC:O(i)
		// TC:O(n2)

	}

}
