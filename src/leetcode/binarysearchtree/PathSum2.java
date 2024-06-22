package leetcode.binarysearchtree;

public class PathSum2 {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		Node root=new Node(5);
		root.left=new Node(4);
		root.right=new Node(8);
		root.right.left=new Node(13);
		root.left.left=new Node(11);
		root.left.left.left=new Node(7);
		root.left.left.right=new Node(2);
		root.right.right=new Node(4);
		root.right.right.right=new Node(1);
		root.right.right.left=new Node(5);

		System.out.println(bst.pathSum(root,22));
	}
}
