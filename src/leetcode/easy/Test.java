package leetcode.easy;

public class Test {

	public static void main(String[] args) {
		int[] n=new int[] {0,1,0,3,12};
		int[] response = moveZeroes(n);
		for (Integer n1 : response)
			System.out.println(n1);
			

	}

	private static int[] moveZeroes(int[] n) {
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
