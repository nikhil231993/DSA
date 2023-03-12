package geeksForGeeks_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class pairOfSumInArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the size of the array: ");
		int len = scan.nextInt();
		int[] arr = new int[len];
		System.out.println("Enter the elemets of the array: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println("Enter the sum to seacrched: ");
		int sumtocheck = scan.nextInt();
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sumtocheck) {
					if (!((hm.containsKey(arr[i]) && hm.containsValue(arr[j]))
							|| (hm.containsKey(arr[j]) && hm.containsValue(arr[i])))) {
						hm.put(arr[i], arr[j]);

					}

				}
			}
		}
		Set<Map.Entry<Integer, Integer>> s=hm.entrySet();
		for(Entry<Integer, Integer> maps:s)
		{
			System.out.println("values are: "+maps.getKey()+" "+maps.getValue());
		}
		scan.close();

	}

}
