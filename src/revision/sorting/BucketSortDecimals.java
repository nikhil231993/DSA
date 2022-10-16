package revision.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSortDecimals {

	public static void main(String[] args) {
		float[] arr = new float[] { (float) 0.30, (float) 0.13, (float) 0.50, (float) 0.20, (float) 0.60,
				(float) 0.70 };

		// TC:O(N2) i.e O of n sqaure SC:O(1) as it is in place
		bucketSortDecimals(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}


	}

	private static void bucketSortDecimals(float[] arr) {
		int n = arr.length;
		ArrayList<Float>[] buckets = new ArrayList[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			buckets[i]=new ArrayList<Float>();
		}

		for (int i = 0; i < arr.length; i++) {
			int idx = (int) (n * arr[i]);
			buckets[idx].add(arr[i]);
		}

		for (int i = 0; i < buckets.length; i++) {
			Collections.sort(buckets[i]);
		}
		
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<buckets[i].size();j++) {
				arr[index++] = buckets[i].get(j);
			}
		}


	}

}
