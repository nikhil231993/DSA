package leetcode.array.easy;

public class LC733FloodFill {

	public static void main(String[] args) {
		int[][] image = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr=1;
		int sc=2;
		int newColor=10;

		System.out.println("Before colouring");
		for (int[] rows : image)
			System.out.println(rows[0] + " " + rows[1] + " " + rows[2]);
		
		image(image, sr, sc, image[sr][sc], newColor);

		System.out.println("After colouring");
		for (int[] rows : image)
			System.out.println(rows[0] + " " + rows[1] + " " + rows[2]);
	}

	private static void image(int[][] image, int sr, int sc, int oldColor, int newColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor)
			return;
		image[sr][sc] = newColor;
		image(image, sr + 1, sc, oldColor, newColor);
		image(image, sr - 1, sc, oldColor, newColor);
		image(image, sr, sc + 1, oldColor, newColor);
		// TC:O(n*m) worst case where we haev to color everything
		// SC:O(n*m) stack has all the elements

	}

}
