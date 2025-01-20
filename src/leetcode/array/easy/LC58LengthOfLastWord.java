package leetcode.array.easy;

public class LC58LengthOfLastWord {

	public static void main(String[] args) {

		String s="   fly me   to   the moon  ";

		System.out.println(lengthOfLastWord(s));
		System.out.println(lengthOfLastWordSelf(s));
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

	public static int lengthOfLastWordSelf(String s) {

		int n=s.length();
		int len=0;
		int i=n-1;

		while(i>=0 && s.charAt(i)==' ')
			i--;
		int k=i;

		while(i>=0 && Character.isLetter(s.charAt(i)))
			i--;
		len=k-i;
		return len;
	}
}
