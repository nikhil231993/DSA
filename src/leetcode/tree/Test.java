package leetcode.tree;

public class Test {
	static Node target;

	public static void main(String[] args) {
		mappping();
		System.out.println(target.data);
	}

	private static void mappping() {
		Node n = new Node(10);
		target = n;

	}

}
