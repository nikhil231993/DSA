package leetcode.array.easy;

public class LC58LengthOfLastWord {

	public static void main(String[] args) {

		System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
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
