package leetcode.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class LC52NQueens2 {

	//TC:O(N! * N (This is the for loop for construct)) as 1st column after getting selected will have n-1 for next column and so on
	// we run the loop of n positions in each column
	public static void main(String[] args) {

		int n = 4;

		//1st Approach
		System.out.println(totalNQueens(n));

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

		solveSecondApproach(queenSecond, board, leftRow, lowerDiagonal, upperDiagonal, 0);
		System.out.println(queenSecond.size());
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

	public static int totalNQueens(int n) {

		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}

		List<List<String>> result = new ArrayList();
		dfs(result, board, 0);

		return result.size();
	}

	public static void dfs(List<List<String>> result, char[][] board, int col) {

		if (col == board.length) {
			result.add(construct(board));
			return;
		}

		for (int row = 0; row < board.length; row++) {
			if (isSafeToBePlaced(board, row, col)) {
				board[row][col] = 'Q';
				dfs(result, board, col + 1);
				board[row][col] = '.';
			}
		}
	}

	public static boolean isSafeToBePlaced(char[][] board, int row, int col) {

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
			dupRow++;
			dupCol--;
		}
		return true;
	}

	public static List<String> construct(char[][] board) {
		List<String> l = new ArrayList();

		for (char[] c : board) {
			String s = String.valueOf(c);
			l.add(s);
		}
		return l;
	}
}
