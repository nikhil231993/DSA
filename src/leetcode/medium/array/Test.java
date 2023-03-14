package leetcode.medium.array;

public class Test {

	public static void main(String[] args) {
		String c = "N";
		int[] a = new int[27];
		for(int i=0;i<c.length();i++) {
			a[c.charAt(i) - 'A']++;
		}

		for (int i = 0; i < 27; i++)
			System.out.println((char) (i + 65));

	}

}
