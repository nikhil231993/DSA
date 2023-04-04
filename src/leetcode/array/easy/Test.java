package leetcode.array.easy;

import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("###.####");
		System.out.println(df.format(3.70065));
		System.out.println(df.format(3.70074));

//		LinkedList<Integer>[] list = new LinkedList[10];
//		int[] n=new int[] {0,1,0,3,12};
//		int[] response = moveZeroes(n);
//		for (Integer n1 : response)
//			System.out.println(n1);
		
//		System.out.println(3 % 2);
//		LinkedList<Integer> list = new LinkedList<Integer>();
//		System.out.println(list.indexOf(1));
//
//		list.add(1);
//		list.add(2);
//		System.out.println(list.indexOf(1));
//		System.out.println(list.indexOf(2));


			

	}

	public int[] moveZeroes(int[] n) {
		int j = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i] != 0) {
				n[j] = n[i];
				j++;
			}
		}
		while(j<n.length)
			n[j++] = 0;
		return n;
	}

}
