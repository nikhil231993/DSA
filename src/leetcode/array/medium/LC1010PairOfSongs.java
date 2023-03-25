package leetcode.array.medium;

public class LC1010PairOfSongs {

	public static void main(String[] args) {
		int[] time = new int[] { 60, 60, 60 };

		System.out.println(pairDivisible(time));

	}

	private static int pairDivisible(int[] time) {
		int count = 0;
		int[] rest = new int[60];

		for (int t : time) {
			int value = t % 60;
			if (value == 0)
				count += rest[value];
			else {
				count += rest[60 - value];
			}

			rest[value]++;

		}
		return count;
	}

}
