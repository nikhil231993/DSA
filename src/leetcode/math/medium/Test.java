package leetcode.math.medium;

public class Test {

	public static void main(String[] args) {

		int[][] mat=new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
		int count=0;
		for(int[] p1: mat){
			for(int[] p2: mat){
				if(p1==p2)
					count++;
			}
		}
		System.out.println(count);

		System.out.println(-11%10);

		System.out.println(8<<2);

		System.out.println(Math.random());
		System.out.println((char) ('A' + 10/2));
	}
}
