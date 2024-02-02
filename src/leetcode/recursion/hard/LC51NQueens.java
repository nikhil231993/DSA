package leetcode.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class LC51NQueens {

	public static void main(String[] args) {

		int n = 4;

		// 1st approach
		List<List<String>> queen = new ArrayList();
		solve(queen, n);
		System.out.println(queen);

		System.out.println("######################################");

		// 2nd Approach
		List<List<String>> queenSecond = new ArrayList();
		char[][] board = new char[n][n];
		int[] leftRow = new int[n];
		int[] lowerDiagonal = new int[2 * n - 1];
		int[] upperDiagonal = new int[2 * n - 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}

		// solve(queen, n);
		solveSecondApproach(queenSecond, board, leftRow, lowerDiagonal, upperDiagonal, 0);
		System.out.println(queenSecond);

		// TC:O(N!) * N (This is the for loop for construct)  as due to isSafe method only on possible places recursive call is
		// made whereas in permutations everytime recursive call is made
		// SC:O(N2)(space to store matrix) +O(N)(height of the recursion tree)
	}

	public static void solveSecondApproach(List<List<String>> queen, char[][] board, int[] leftRow, int[] lowerDiagonal,
			int[] upperDiagonal, int col) {

		if (col == board.length) {
			queen.add(construct(board));
			return;
		}
		for (int row = 0; row < board.length; row++) {

			if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0
					&& upperDiagonal[board.length - 1 + col - row] == 0) {
				leftRow[row] = 1;
				lowerDiagonal[row + col] = 1;
				upperDiagonal[board.length - 1 + col - row] = 1;
				board[row][col] = 'Q';
				solveSecondApproach(queen, board, leftRow, lowerDiagonal, upperDiagonal, col + 1);
				leftRow[row] = 0;
				lowerDiagonal[row + col] = 0;
				upperDiagonal[board.length - 1 + col - row] = 0;
				board[row][col] = '.';
			}
		}
	}

	private static void solve(List<List<String>> queen, int n) {

		char[][] board = new char[n][n];
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = '.';
			}
		}

		dfs(board, queen, 0);
		//TC:O(n*m) + O(n!) * (3n)
		//SC:O(n*m) + O(col length) for auxiliary space
	}

	private static void dfs(char[][] board, List<List<String>> queen, int col) {

		if (col == board.length) {
			queen.add(construct(board));
			return;
		}
		
		for (int row = 0; row < board.length; row++) {
			if (isSafe(board, col, row)) {
				board[row][col] = 'Q';
				dfs(board, queen, col + 1);
				board[row][col] = '.';
			}
		}
	}

	private static boolean isSafe(char[][] board, int col, int row) {

		int dupRow = row;
		int dupCol = col;
		while (dupRow >= 0 && dupCol >= 0) {
			if (board[dupRow][dupCol] == 'Q')
				return false;
			dupRow--;
			dupCol--;
		}
		
		 dupRow = row;
		 dupCol = col;
		
		while (dupCol >= 0) {
			if (board[dupRow][dupCol] == 'Q')
				return false;
			dupCol--;
		}
		dupRow = row;
		dupCol = col;
		while (dupRow < board.length && dupCol >= 0) {
			if (board[dupRow][dupCol] == 'Q')
				return false;
			dupCol--;
			dupRow++;
		}
		return true;
	}

	private static List<String> construct(char[][] board) {

		List<String> rowFull=new ArrayList<String>();
		
		for(char[]  c: board) {
			String s=String.valueOf(c);
			rowFull.add(s);
		}
		return rowFull;
	}
}
