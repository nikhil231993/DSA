package learningLogic.own;

import java.util.LinkedList;
import java.util.List;

public class DTest {

	public static void main(String[] args) {
		char board[][] = { { '.', '.', '.', 'Q' }, { '.', '.', '.', '.' }, { '.', '.', '.', '.' },
				{ '.', '.', '.', '.' } };
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		System.out.println(res);
	}

}
