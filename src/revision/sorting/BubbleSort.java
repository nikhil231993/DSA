package revision.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 30, 13, 50, 20, 60, 70 };

		// TC:O(N2) i.e O of n sqaure SC:O(1) as it is in place
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	private static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

}
