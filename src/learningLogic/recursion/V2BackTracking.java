package learningLogic.recursion;

public class V2BackTracking {

	public static void main(String[] args) {
		System.out.println("Ascending order : ");
		backTrackingSmallToBig(3);
		System.out.println("Descending order : ");
		backTrackingBigToSmall(1);

	}

	private static void backTrackingBigToSmall(int times) {
		if (times > 3)
			return;
		backTrackingBigToSmall(times + 1);
		System.out.println(times);
		// TC:O(N)
		// SC:O(N)

	}

	private static void backTrackingSmallToBig(int times) {
		if (times < 1)
			return;
		backTrackingSmallToBig(times - 1);
		System.out.println(times);

		// TC:O(N)
		// SC:O(N)

	}

}
