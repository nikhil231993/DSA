package leetcode.hard.recursion;

import java.util.ArrayList;
import java.util.List;

public class LC51NQueens {

	public static void main(String[] args) {
		int n = 4;

		List<List<String>> queen = new ArrayList();
		solve(queen, n);

//		for (List<String> s : queen)
		System.out.println(queen);

	}

	private static void solve(List<List<String>> queen, int n) {
		char[][] board = new char[n][n];
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '.';
			}
		}

		dfs(board, queen, 0);
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
