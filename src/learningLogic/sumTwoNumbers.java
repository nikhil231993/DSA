package learningLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class sumTwoNumbers {

	public static void main(String[] args) {
		
		int arr[]= new int [] {2,7,11,15};
		int targte=9;
		int a[]=twoSum(arr,targte);
		for(int aq :a)
			System.out.println(aq);

	}

	public static int[] twoSum(int[] arr, int target) {

		 HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(map.containsKey(target-arr[i]))
				return new int[]{map.get(target-arr[i]),i};
			else
				map.put(arr[i],i);
		}
		System.out.println(map);
		return new int[]{};
	}

}
