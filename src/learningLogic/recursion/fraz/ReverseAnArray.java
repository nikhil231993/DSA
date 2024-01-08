package learningLogic.recursion.fraz;

public class ReverseAnArray {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 2, 3, 4, 5 };
		// reverse(num, 0);
		reverseTest(num, 0);
		for (int n : num)
			System.out.println(n);
	}

	private static void reverseTest(int[] num, int i) {
		if (i == num.length / 2)
			return;
		if (i < num.length / 2) {
			int temp = num[i];
			num[i] = num[num.length - 1 - i];
			num[num.length - 1 - i] = temp;
			reverse(num, i + 1);
		}
	}

	private static void reverse(int[] num, int i) {
		if (i == num.length / 2)
			return;

		int temp = num[i];
		num[i] = num[num.length - 1 - i];
		num[num.length - 1 - i] = temp;
		reverse(num, i + 1);

		// SC:O(n/2) which is equal to O(n)
		// TC:O(n/2) which is equal to O(n)
	}
}
