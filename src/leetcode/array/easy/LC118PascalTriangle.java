package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC118PascalTriangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the rows : ");
		int n = scan.nextInt();

		//1st problem Calculate ncr for one column and row
		//7c3
		int r=5;
		int c=3;
		System.out.println("For Specific row and column: ");
		System.out.println(binomialCoefficient(r-1,c-1));
		System.out.println("##################");

		//2nd problem to calculate for 1 row
		System.out.println("##################");
		//Brute Force
		System.out.println("Printing row:");
		System.out.println(rowPascalBruteForce(30));
		//Best Approach
		System.out.println(rowPascal(30));
		System.out.println("##################");

		//3rd problem
//		pascalsTriangle(n);
		System.out.println("##################");
//		System.out.println(pascalsTriangleList(n));
//		System.out.println("##################");
		// Best Approach
		System.out.println(pascalsTriangleListMin(n));
		System.out.println("##################");
		scan.close();

	}

	private static int binomialCoefficient(int n, int r) {

		int res = 1;
		if (r > n - r)
			r = n - r;

		for (int i = 0; i < r; i++) {
			res *= (n - i);
			res /= (i + 1);

		}
		return res;
		//TC:O(r)
		//SC:O(1)

	}

	private static List<Integer> rowPascalBruteForce(int n) {

		List<Integer> listRow=new ArrayList();
		for(int c=1;c<=n;c++){
			int res=binomialCoefficient(n-1,c-1);
			listRow.add(res);
		}
		return listRow;
		//TC:O(n*r)
		//SC:O(1)
	}

	private static List<List<Integer>> pascalsTriangleListMin(int n) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		for (int row = 1; row <= n; row++) {
					re.add(rowPascal(row));
			// SC:O(n2)
			// TC:O(n2)
		}
		return re;
	}

	private static List<Integer> rowPascal(int n) {
		List<Integer> row = new ArrayList<Integer>();
		int re = 1;
		row.add(re);
		for (int i = 1; i < n; i++) {
			re *= (n - i);
			re /= (i);
			row.add(re);
		}
		// SC:O(1)
		// TC:O(n)
		return row;
	}

//	private static List<List<Integer>> pascalsTriangleList(int n) {
//		List<List<Integer>> result = new ArrayList<>();
//		List<Integer> pre = new ArrayList<Integer>();
//		for (int r = 0; r < n; r++) {
//			List<Integer> row = new ArrayList<Integer>();
//			for (int c = 0; c <= r ; c++) {
//
//				if (c == 0 || c == r) {
//					row.add(1);
//				} else
//					row.add(pre.get(c - 1) + pre.get(c));
//
//			}
//			pre = row;
//			result.add(row);
//		}
//
//		return result;
//
//		//SC:O(n square)
//		// TC:O(n square)
//
//
//	}

//	private static void pascalsTriangle(int n) {
//		for (int row = 0; row < n; row++) {
//			for (int col = 0; col <= row; col++) {
//				System.out.print(binomialCoefficient(row, col) + " ");
//
//			}
//			System.out.println();
//		}
//
//		// TC:O(n rasie 3)
//		// SC: O(1)
//
//	}




}
