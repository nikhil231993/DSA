package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class TestSubset {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 2, 3 };
		List<List<Integer>> list = new ArrayList();

		subset(num, list, 0, new ArrayList());
		System.out.println(list);

	}
	
	public static void subset(int[] num,List<List<Integer>> list, int index, List<Integer> arr) {
		if (index == num.length) {
			list.add(new ArrayList(arr));
			return;
		}

		arr.add(num[index]);
		subset(num, list, index + 1, arr);
		arr.remove(arr.size() - 1);
		subset(num, list, index + 1, arr);
	}

}
