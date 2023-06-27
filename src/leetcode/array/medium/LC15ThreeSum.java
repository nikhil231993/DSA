package leetcode.array.medium;

import java.util.*;

public class LC15ThreeSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] n = new int[] { -1, 0, 1, 2, -1, -4 };

		//Brute
		List<List<Integer>> r = threeSum(n);
		System.out.println(r);

		//Better
		List<List<Integer>> re1=betterThreeSum(n);
		System.out.println(re1);

		//Optimal
		List<List<Integer>> re = threeSumNCubeSpaceComplexity(n);
		System.out.println(re);
		scan.close();
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
		List<List<Integer>> list=new ArrayList<>();

		for(List<Integer> l: s)
			list.add(l);

		return list;

		//TC:O(N square log (size of set))
	}

	private static List<List<Integer>> threeSumNCubeSpaceComplexity(int[] n) {
		Arrays.sort(n);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < n.length; i++) {
			if (i != 0 && (n[i] == n[i - 1]))
				continue;
			for (int j = i + 1; j < n.length; j++) {
				if (j != i + 1 && (n[j] == n[j - 1]))
					continue;
				for (int k = j + 1; k < n.length; k++) {
					List<Integer> r = new ArrayList<Integer>();
					if (k != j + 1 && (n[k] == n[k - 1]))
						continue;

					if (n[i] + n[j] + n[k] == 0) {
						r.add(n[i]);
						r.add(n[j]);
						r.add(n[k]);
						result.add(r);
					}
				}

		}
		}
		return result;

		//TC:O(n cube)
		//SC:(no of triplets)
	}

	private static List<List<Integer>> threeSum(int[] n) {
		Arrays.sort(n);
		List<List<Integer>> t=new ArrayList<List<Integer>>();
		for (int i = 0; i < n.length - 2; i++) {
			if (i == 0 || (i > 0 && n[i] != n[i - 1])) {
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
		}
		return t;

		//TC:O(nlog n) for sorting + (n*n)
		//SC:O(no of unique triplets)
	}

}
