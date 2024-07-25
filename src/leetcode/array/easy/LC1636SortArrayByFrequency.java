package leetcode.array.easy;

import java.util.*;

class Node2{

	protected int num;
	protected  int freq;

	public Node2(int num, int freq){
		this.num=num;
		this.freq=freq;
	}
}

public class LC1636SortArrayByFrequency {

	public static void main(String[] args){

		int[] nums = new int[]{2,3,1,3,2};

		int[] result=frequencySort(nums);
		for(int n:result)
			System.out.println(n);

//		int[] num = new int[] { -1, 1, -6, 4, 5, -6, 1, 4, 1 };
//		List<Integer> list = new ArrayList<>();
//		for (int i = 0; i < num.length; i++)
//			list.add(num[i]);
//		Comparator<Integer> com = new LC1636ComparList();
//			Collections.sort(list, com);
////		int[] nums = sortByFrequencey(num);
//		for (Integer n : list) {
//			System.out.print(n);
//		}
//
//	}

//	public static int[] sortByFrequencey(int[] nums) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int num : nums) {
//			map.put(num, map.getOrDefault(num, 0) + 1);
//		}
//
//		List<Integer> list = new ArrayList<>(map.keySet());
//		Collections.sort(list, (a, b) -> {
//			return (map.get(a) == map.get(b)) ? b - a : map.get(a) - map.get(b);
//		});
//
//		int[] res = new int[nums.length];
//		int i = 0;
//		for (int num : list) {
//			for (int j = 0; j < map.get(num); j++) {
//				res[i++] = num;
//			}
//		}
//		return res;
//
//	}
	}

	public static int[] frequencySort(int[] nums) {

		HashMap<Integer, Integer> map=new HashMap();
		for(int i=0;i< nums.length;i++){
			map.put(nums[i], map.getOrDefault(nums[i],0)+1);
		}

		PriorityQueue<Node2> pq=new PriorityQueue<Node2>((a, b)->a.freq==b.freq?b.num-a.num:a.freq-b.freq);

		for(Map.Entry<Integer, Integer> m: map.entrySet()){
			pq.offer(new Node2(m.getKey(), m.getValue()));
		}

		int[] result=new int[nums.length];
		int k=0;
		while(!pq.isEmpty()){
			Node2 v=pq.poll();
			int n1=v.num;
			int freq=v.freq;
			for(int i=0;i<freq;i++){
				result[k++]=n1;
			}
		}
		return result;
	}
}
