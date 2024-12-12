package leetcode.stack.medium;

public class LC556NextGreaterElement3 {

	public static void main(String[] args) {

		int n = 123521;
		System.out.println(nextGreaterElement(n));
	}

	public static int nextGreaterElement(int n) {

		char[] ch = String.valueOf(n).toCharArray();
		int idx1 = -1;
		int idx2 = -1;

		int n1 = ch.length;
		for (int i = n1 - 2; i >= 0; i--) {
			if (ch[i] < ch[i + 1]) { // first dip from the left
				idx1 = i;
				break;
			}
		}
		if (idx1 == -1)
			return -1;
		else {
			for (int i = n1 - 1; i >= 0; i--) {
				if (ch[i] > ch[idx1]) {
					idx2 = i;
					break;
				}
			}
		}
		swap(idx1, idx2, ch);
		reverse(idx1 + 1, ch.length - 1, ch);

		StringBuilder sb = new StringBuilder();
		for (char c : ch)
			sb.append(c);

		long val = Long.parseLong(sb.toString());
		return (val <= Integer.MAX_VALUE) ? (int) val : -1;
	}

	private static void swap(int idx1, int idx2, char[] ch) {

		char temp = ch[idx1];
		ch[idx1] = ch[idx2];
		ch[idx2] = temp;
	}

	private static void reverse(int start, int end, char[] ch) {

		while (start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
	}

}
