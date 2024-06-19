package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC349IntersectionOfTwoArrays {

    public static void main(String[] args) {

		// Here in Leetcode the question is about without duplicate that is why we add
		// conditions in line 43 and 67

		// For video https://www.youtube.com/watch?v=wvcQg43_V8U we are even including
		// duplicate values

        int[] nums1 =new int[] {1,2,2,1};
        int[] nums2 =new int[] {2,2};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n=nums1.length;
        int m=nums2.length;

		// Approach 1 Brute
		int[] ans = uniqueBrute(n, m, nums1, nums2, new ArrayList<>());
		for (int num : ans)
			System.out.println(num);
		
		System.out.println("####################");

		// Approach 2 Optimal
		int[] result = uniqueIntersection(n, m, nums1, nums2, new ArrayList<>());

		for (int num : result)
			System.out.println(num);
    }

	private static int[] uniqueBrute(int n, int m, int[] nums1, int[] nums2, List<Integer> arrayList) {

		int[] visited = new int[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((nums1[i] == nums2[j] && visited[j] == 0)
						&& (arrayList.isEmpty() || arrayList.get(arrayList.size() - 1) != nums1[i])) {
					arrayList.add(nums1[i]);
                    visited[j]=1;
					break;
				}

				if (nums1[i] < nums2[j]) {
					break;
				}
			}
		}

		return arrayList.stream().mapToInt(a -> a).toArray();
	}

	private static int[] uniqueIntersection(int n, int m, int[] nums1, int[] nums2, List<Integer> r) {

        int i=0,j=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
				if (r.isEmpty() || r.get(r.size() - 1) != nums1[i]) {
                    r.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        int k=0;
        int[] n1=new int[r.size()];
        for(Integer num:r)
            n1[k++]=num;

        return n1;

        //TC:O(nlogn)+(mlogm)
        //SC:O(n+m)
    }
}
