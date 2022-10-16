package revision.sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 30, 31, 50, 20, 60, 70, 10 };

		// TC:O(N2) i.e O of n sqaure SC:O(1) as it is in place
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;

		}

	}

}
