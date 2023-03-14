package leetcode.easy.array;

public class Lc1394LuckyNumber {

	public static void main(String[] args) {
		int[] num = new int[] { 2, 2, 3, 4 };

		int[] num1 = new int[500];

		for (int i = 0; i < num.length; i++)
			num1[num[i]]++;

			for (int i = 0; i < num1.length; i++)
			System.out.println(num1[i]);


	}

}
