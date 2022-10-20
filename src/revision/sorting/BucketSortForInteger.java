package revision.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSortForInteger {

	public static void main(String[] args) {
		int[] arr = new int[] { 40, 10, 30, 80, 70, 20, 60, 50, 100 };

//		 TC:O(N2) i.e O of n sqaure SC:O(1) as it is in place
		bucketSortForInteger(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		//System.out.println(Math.ceil(0.3));

	}

	private static void bucketSortForInteger(int[] arr) {

		int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
		System.out.println("Number of buckets is: " + numberOfBuckets);
		int max = Integer.MIN_VALUE;

		ArrayList<Integer>[] bucket = new ArrayList[numberOfBuckets];
		
		for(int i=0;i<arr.length;i++) {
			if (max<arr[i]) {
				max = arr[i];
			}
		}

		System.out.println("MAx value is :" + max);
		for (int i = 0; i < numberOfBuckets; i++)
			bucket[i] = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			int idx = (int) Math.ceil((float) (arr[i] * numberOfBuckets) / max);
			bucket[idx - 1].add(arr[i]);
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
