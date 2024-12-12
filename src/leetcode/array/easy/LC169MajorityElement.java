package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC169MajorityElement {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };

		//Approach 1:
		System.out.println(majorityElementBrute(nums));

		//Approach 2:
		System.out.println(majorityElement(nums));

		//Approach 3:Optimal
		System.out.println(majorityElementOptimal(nums));
	}

	private static int majorityElementBrute(int[] nums) {

		 Arrays.sort(nums);
		 return nums[nums.length/2];

		 //After sorting since element is majority in array it will be present at middle position
		//TC:O(1)
		//SC:O(1)
	}

	public static int majorityElement(int[] nums) {

		int size=nums.length/2;
		HashMap<Integer,Integer> map=new HashMap<>();

		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i],map.get(nums[i])+1);
			}else{
				map.put(nums[i],1);
			}
		}
		int no=0;
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			if(entry.getValue() > size){
				no=entry.getKey();
			}
		}
		return no;

		//TC:O(N)
		//SC:O(N)
	}

	private static int majorityElementOptimal(int[] nums) {

		//Step 1: Moore's Voting Algo
		int count = 0, maj = 0;
		for (int i = 0; i < nums.length; i++) {

			if (count == 0)
				maj = nums[i];
			if (maj != nums[i])
				count--;
			else
				count++;
		}

		//Step 2: Do this only if there is no guarantee of maj element exist
		int c=0;
		for (int i=0;i<nums.length;i++){
			if(nums[i]==maj)
				c++;
		}
		if(c > nums.length/2)
			return maj;
		return -1;

		//TC:O(N)
		//SC:O(1)
	}
}
