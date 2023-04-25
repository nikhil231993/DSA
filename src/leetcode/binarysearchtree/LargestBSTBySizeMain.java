package leetcode.binarysearchtree;

class NodeValue {
	public int maxNode, minNode, maxSize;

	NodeValue(int minNode, int maxNode, int maxSize) {
		this.minNode = minNode;
		this.maxNode = maxNode;
		this.maxSize = maxSize;
	}
}
public class LargestBSTBySizeMain {

	public static void main(String[] args) {
		BinarySearchTreeRevision bst = new BinarySearchTreeRevision();

		Node root=new Node(20);
		root.left=new Node(15);
		root.right=new Node(40);
		root.left.left=new Node(14);
		root.left.right=new Node(18);
		root.left.left.right=new Node(17);
		root.left.right.left=new Node(16);
		root.left.right.right=new Node(19);
		root.right.left=new Node(30);
		root.right.right=new Node(60);
		root.right.right.left=new Node(50);

		System.out.println(bst.maxSumBST(root));



	}

}
