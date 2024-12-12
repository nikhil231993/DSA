package leetcode.array.easy;

public class LC58LengthOfLastWord {

	public static void main(String[] args) {

		String s="   fly me   to   the moon  ";

		System.out.println(lengthOfLastWord(s));
	}

	public static int lengthOfLastWord(String s) {

		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ')
				count++;
			if (s.charAt(i) == ' ' && count != 0)
				break;
		}
		return count;
	}
}
