package revision.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 30, 31, 50, 20, 60, 70, 10 };

		// TC:O(N2) i.e O of n sqaure SC:O(1) as it is in place
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}

	}

	private static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int num = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > num) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = num;
		}

	}

}
