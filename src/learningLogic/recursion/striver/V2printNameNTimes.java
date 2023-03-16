package learningLogic.recursion.striver;

public class V2printNameNTimes {

	public static void main(String[] args) {
		recursiveName("test", 5);
		System.out.println("Descending order : ");
		recursiveLinearllyDsc(10);
		System.out.println("Ascending order : ");
		recursiveLinearllyAsc(1);



	}

	private static void recursiveLinearllyAsc(int n) {
		if (n > 10)
			return;
		System.out.println(n);
		recursiveLinearllyAsc(n + 1);
		// TC:O(N)
		// SC:O(N)

	}

	private static void recursiveLinearllyDsc(int n) {
		if (n <= 0)
			return;
		System.out.println(n);
		recursiveLinearllyDsc(n - 1);
		// TC:O(N)
		// SC:O(N)
	}

	private static void recursiveName(String name, int count) {
		if (count <= 0) {
			return;
		}
		System.out.println(name);
		recursiveName(name, --count);
		// TC:O(N)
		// SC:O(N)
	}

}
