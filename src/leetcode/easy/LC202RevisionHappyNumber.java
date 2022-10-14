package leetcode.easy;

import java.util.HashSet;

public class LC202RevisionHappyNumber {

	public static void main(String[] args) {

		System.out.println(happNumberUsingHashSet(19));
		System.out.println(happNumberUsingFloydsCycleMethod(17));
	}

	private static boolean happNumberUsingFloydsCycleMethod(int num) {
		int s = num;
		int f = num;
		do {
			s=sumOfDigitsFunction(num);
			f = sumOfDigitsFunction(sumOfDigitsFunction(f));
			if (s == 1 || f == 1)
				return true;
		} while (s != f);
		return false;
	}

	private static int sumOfDigitsFunction(int num) {

		int a = Integer.MIN_VALUE;
		int sum = 0;
		while (num > 0) {
			int t = num % 10;
			sum += t * t;
			num = num / 10;
		}
		return sum;
	}

	private static boolean happNumberUsingHashSet(int num) {

		HashSet<Integer> set = new HashSet<>();
		while (num != 1) {
			if (set.contains(num))
				return false;
			else {
				set.add(num);
				int sum = 0;
				while (num > 0) {
					
					sum += (num % 10) * (num % 10);
					num = num / 10;
				}
				num = sum;

			}
		}
		return true;

	}

}
