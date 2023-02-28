package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC118PascalTriangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the rows : ");
		int n = scan.nextInt();
		
		// pascalsTriangle(n);

		// System.out.println(pascalsTriangleList(n));

		// Best Approach
		System.out.println(pascalsTriangleListMin(n));

		System.out.println(rowPascal(n));

		scan.close();

	}

	private static List<List<Integer>> pascalsTriangleListMin(int n) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		for (int row = 0; row < n; row++) {
			int c = 1;
			List<Integer> r = new ArrayList<Integer>();
			for (int col = 0; col <= row; col++) {
				r.add(c);
				c = c * (row - col);
				c = c / (col + 1);
			}
			re.add(r);

			// SC:O(1)
			// TC:O(n2)
		}
		return re;
	}

	private static List<Integer> rowPascal(int n) {
		List<Integer> row = new ArrayList<Integer>();
		int re = 1;
		row.add(re);
		for (int i = 0; i < n; i++) {
			re *= (n - i);
			re /= (i + 1);
			row.add(re);
		}
		// SC:O(n)
		// TC:O(n)
		return row;
	}

	private static List<List<Integer>> pascalsTriangleList(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> pre = new ArrayList<Integer>();
		for (int r = 0; r < n; r++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int c = 0; c <= r; c++) {

				if (c == 0 || c == r) {
					row.add(1);
				} else
					row.add(pre.get(c - 1) + pre.get(c));

			}
			pre = row;
			result.add(row);
		}

		return result;
		
		//SC:O(n square)
		// TC:O(n square)


	}

	private static void pascalsTriangle(int n) {
		for (int row = 0; row < n; row++) {
			for (int col = 0; col <= row; col++) {
				System.out.print(binomialCoefficient(row, col) + " ");

			}
			System.out.println();
		}

		// TC:O(n rasie 3)
		// SC: O(1)

	}

	private static int binomialCoefficient(int row, int col) {

		int res = 1;
		if (col > row - col)
			col = row - col;

		for (int i = 0; i < col; i++) {
			res *= (row - 1);
			res /= (i + 1);

		}
		return res;

	}

}
