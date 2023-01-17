package learningLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class sumTwoNumbers {

	private int a;

	public static void main(String[] args) {
		
		List<Object> a = new ArrayList<Object>();
		a.add(1.0);
		a.add(2.0);
		a.add("");
		a.add("String");
		a.add(1.02136E-09);
		a.add(5.0);
		a.add(0);
		a.removeIf(item -> item == null || "".equals(item) || item instanceof String);

		List<Double> list = (List) a;



		System.out.println(list);
		System.out.println(Math.min(0.5E-10, 1.02136E-09));

		double x[] = new double[list.size()];
		for (int i = 0; i < x.length; i++) {
			x[i] = list.get(i).doubleValue();
			System.out.println(x[i]);
		}
		System.out.println(getMax(x, 0, x.length - 1));

//		
//		int arr[]= new int [] {2,7,11,15};
//		int targte=9;
//		int a[]=twoSum(arr,targte);
//		for(int aq :a)
//			System.out.println(aq);
//		sumTwoNumbers n = new sumTwoNumbers();
//		n.test();

	}

	private void test() {
		int b = a;
		System.out.println(b);
		System.out.println(a);

	}

	public static double getMax(final double[] numbers, final int a, final double n) {

		return a >= numbers.length ? n : Math.max(n, getMax(numbers, a + 1, numbers[a] > n ? numbers[a] : n));
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
