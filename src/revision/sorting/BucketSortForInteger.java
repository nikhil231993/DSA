package revision.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSortForInteger {

	public static void main(String[] args) {
		int[] arr = new int[] { 30, 13, 50, 20, 60, 70 };

		// TC:O(N2) i.e O of n sqaure SC:O(1) as it is in place
		bucketSortForInteger(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}

	}

	private static void bucketSortForInteger(int[] arr) {

		int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
		int max = Integer.MIN_VALUE;

		ArrayList<Integer>[] bucket = new ArrayList[numberOfBuckets];

		for (int i = 0; i < numberOfBuckets; i++)
			bucket[i] = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			int idx = (int) Math.ceil((arr[i] * arr.length) / max);
			bucket[idx].add(arr[i]);
		}

		for (int i = 0; i < numberOfBuckets; i++)
			Collections.sort(bucket[i]);

		int index = 0;
		for (int i = 0; i < numberOfBuckets; i++) {
			for (int j = 0; j < bucket[i].size(); j++) {
				arr[index++] = bucket[i].get(j);
			}
		}
	}

}
