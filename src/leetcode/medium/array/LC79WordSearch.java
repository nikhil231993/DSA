package leetcode.medium.array;

public class LC79WordSearch {

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		int n=board.length;
		int m=board[0].length;
		System.out.println(mainSearch(n, m, board, word));

	}

	private static boolean mainSearch(int n, int m, char[][] board, String word) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (search(i, j, n, m, board, word, 0))
						return true;

				}
					
			}
		}
		return false;
	}

	private static boolean search(int i, int j, int n, int m, char[][] board, String word, int k) {
		if (k == word.length())
			return true;
		if(i<0||j<0||i>=n||j>=m||board[i][j]!=word.charAt(k))
			return false;
		char ch=board[i][j];
		board[i][j]='#';
				
		boolean op1=search(i+1, j, n, m, board, word, k+1);
		boolean op2 = search(i - 1, j, n, m, board, word, k + 1);
		boolean op3 = search(i, j + 1, n, m, board, word, k + 1);
		boolean op4 = search(i, j - 1, n, m, board, word, k + 1);
		board[i][j] = ch;
		
		return op1 || op2 || op3 || op4;

	}

}
