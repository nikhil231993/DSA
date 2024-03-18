package leetcode.array.medium;

import java.util.*;

public class LC15ThreeSum {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] n = new int[] { -1, 0, 1, 2, -1, -4 };

		//Approach 1: Brute
		List<List<Integer>> r = threeSumBrute(n);
		System.out.println(r);

		//Approach 2: Better
		List<List<Integer>> re1=betterThreeSum(n);
		System.out.println(re1);

		//Approach 3: Optimal
		List<List<Integer>> re = optimalSolution(n);
		System.out.println(re);
		scan.close();
	}

	private static List<List<Integer>> optimalSolution(int[] n) {

		Arrays.sort(n);

		List<List<Integer>> t=new ArrayList();

		for (int i = 0; i < n.length - 2; i++) {
			if (i > 0 && n[i] == n[i - 1])
				continue;

				int l = i + 1;
				int h = n.length - 1;
				int sum = 0 - n[i];
				while (l < h) {
					if (n[l] + n[h] == sum) {
						t.add(Arrays.asList(n[i], n[l], n[h]));
						while (l < h && n[l] == n[l + 1])
							l++;
						while (l < h && n[h] == n[h - 1])
							h--;

						l++;
						h--;
					}
					else if (n[l] + n[h] < sum)
						l++;
					else
						h--;
				}
		}
		return t;

		//TC:O(nlog n) for sorting + (n*n)
		//SC:O(no of unique triplets)
	}

	private static List<List<Integer>> threeSumBrute(int[] arr) {

		Set<List<Integer>> st = new HashSet<>();

		int n=arr.length;

		// check all possible triplets:
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
						Collections.sort(temp);
						st.add(temp);
					}
				}
			}
		}

		// store the set elements in the answer:
		List<List<Integer>> ans = new ArrayList<>(st);
		return ans;

		//TC: O(N3 * log(no. of unique triplets)), where N = size of the array.
		//SC: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
	}

	private static List<List<Integer>> betterThreeSum(int[] nums) {

		Set<List<Integer>> s=new HashSet<>();
		for(int i=0;i<nums.length;i++){
			Set<Integer> threeDigits=new HashSet<>();

			for(int j=i+1;j<nums.length;j++){
				int third=-(nums[i]+nums[j]);
				if(threeDigits.contains(third)){
					List<Integer> r=new ArrayList<>();
					r.add(nums[i]);
					r.add(nums[j]);
					r.add(third);
					Collections.sort(r);
					s.add(r);
				}
				threeDigits.add(nums[j]);
			}
		}

		List<List<Integer>> ans = new ArrayList<>(s);

		return ans;

		//TC:O(N square log (size of set))
		//SC:(N) for hashSet + O(2*N) list as well as set for storing data
	}
}
