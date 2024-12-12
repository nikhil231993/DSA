package leetcode.recursion.hard;

public class LC37SudokuSolver {

	//A sudoku puzzle can have multiple answers

	public static void main(String[] args) {

		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		solve(board);

		// SC:O(1) as no extra space is used
		// TC:O(9 n2) as each column can have 9 values and there is n2 cells

		int i = 0;
		for (char[] c : board) {
			System.out.print("Row " + i++ + "--> ");
			System.out.println(c);
			System.out.println(" ");
		}
	}

	public static boolean solve(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;

							if (solve(board))
								return true;
							else
								board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValid(char[][] board, int row, int col, char c) {

		for (int i = 0; i < 9; i++) {

			if (board[row][i] == c)
				return false;
			if (board[i][col] == c)
				return false;
			if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + i % 3] == c)
				return false;
		}
		return true;
	}
}
