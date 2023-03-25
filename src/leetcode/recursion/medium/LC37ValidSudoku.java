package leetcode.recursion.medium;

public class LC37ValidSudoku {

	public static void main(String[] args)

	{
		char[][] board=new char[][] {{'5','3','.','.','7','.','.','.','.'}
				,{'6','.','.','1','9','5','.','.','.'}
						,{'.','9','8','.','.','.','.','6','.'}
						,{'8','.','.','.','6','.','.','.','3'}
						,{'4','.','.','8','.','3','.','.','1'}
						,{'7','.','.','.','2','.','.','.','6'}
						,{'.','6','.','.','.','.','2','8','.'}
						,{'.','.','.','4','1','9','.','.','5'}
						,{'.','.','.','.','8','.','.','7','9'}};
						
						//2nd Input
		char[][] board1 = new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' }
						,{'6','.','.','1','9','5','.','.','.'}
				, { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(solveSudoku(board1));
	}

	public static boolean solveSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] != '.') {
					char c = board[i][j];
					if (!isValid(i, j, board, c)) {
						return false;
					}
				}
			}
		}

		// TC:O(N cube) as isValid runs inside
		// SC:O(1) no extar space
		return true;
	}

	public static boolean isValid(int row, int col, char[][] board, char c) {

		for (int i = 0; i < 9; i++) {

			if (i != col && board[row][i] == c)
				return false;
			if (i != row && board[i][col] == c)
				return false;
			int lastRow = 3 * (row / 3) + (i / 3);
			int lastCol = 3 * (col / 3) + (i % 3);
			if (lastRow != row && lastCol != col && board[lastRow][lastCol] == c)
				return false;
		}
		return true;
	}

}
