package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LC349UnionOfTwoArrays {

    public static void main(String[] args) {

        int n = 5;
        int[] arr1 =new int[] {1, 2, 3, 4, 5};

		int m = 3;
        int[] arr2=new int[] {1, 2, 3};

		//Approach 1: Brute
		int[] ans = findUnionBrute(n, m, arr1, arr2);
		for (int num : ans)
			System.out.println(num);

		System.out.println("#######################");

		//Approach 2: Optimal
		int[] result = findUnion(n, m, arr1, arr2, new ArrayList<>());
		for (int num : result)
			System.out.println(num);
    }

	private static int[] findUnionBrute(int n, int m, int[] arr1, int[] arr2) {

		Set<Integer> s = new LinkedHashSet<>();
		for (int i = 0; i < n; i++) {
			s.add(arr1[i]);
		}

		for (int i = 0; i < m; i++) {
			s.add(arr2[i]);
		}

		int[] ans = new int[s.size()];
		int i = 0;
		for (Integer num : s) {
			ans[i++] = num;
		}

		Arrays.sort(ans);

		return ans;

		//TC:O(n log n) as log n is the time taken to add element in worst case + O(n log n) for sorting
		//SC:O(n) + O(n) set and array space
	}

	private static int[] findUnion(int n, int m, int[] arr1, int[] arr2, List<Integer> list) {

        int i=0;
        int j=0;

        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
				if (list.isEmpty() || list.get(list.size() - 1) != arr1[i]) {
                    list.add(arr1[i]);
                }
                i++;
            }else{
				if (list.isEmpty() || list.get(list.size() - 1) != arr2[j]) {
                    list.add(arr2[j]);
                }
                j++;
            }
        }

        while(i < n){
			if (list.isEmpty() || list.get(list.size() - 1) != arr1[i]) {
                list.add(arr1[i]);
            }
            i++;
        }
        while(j < m){
			if (list.isEmpty() || list.get(list.size() - 1) != arr2[j]) {
                list.add(arr2[j]);
            }
            j++;
        }
		return list.stream().mapToInt(a -> a).toArray();

        //TC:O(n+m)
        //SC:O(n+m)
    }
}
