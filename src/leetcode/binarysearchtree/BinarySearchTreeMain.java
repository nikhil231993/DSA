package leetcode.binarysearchtree;

public class BinarySearchTreeMain {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		Node root = null;
		root = bst.insert(root, 8);
//		System.out.println(root.hashCode());
		root = bst.insert(root, 5);
//		System.out.println(root.hashCode());
		root = bst.insert(root, 3);
//		System.out.println(root.hashCode());
		root = bst.insert(root, 1);
//		System.out.println(root.hashCode());
		root = bst.insert(root, 4);
//		System.out.println(root.hashCode());
		root = bst.insert(root, 6);
//		System.out.println(root.hashCode());
		root = bst.insert(root, 10);
//		System.out.println(root.hashCode());
		root = bst.insert(root, 11);
//		System.out.println(root.hashCode());
		root = bst.insert(root, 14);
//		System.out.println(root.hashCode());

		//Using video solution L44
		root=bst.insertIterative(root, 16);

		//Code for search is generic in Striver's code. Have not written that code. Please refer video
		System.out.println();
		System.out.println("Search using preorder order: ");
		System.out.println("Value found is: " + bst.search(root, 30));

		System.out.println();
		System.out.println("Search using level order: ");
		System.out.println("Value found is: " + bst.searchLevel(root, 30));

		//Ceil in a binary tree using recursion
		int[] ceil=new int[1];
		bst.ceil(root, ceil,12);
		System.out.println("Ceil value using recursion:");
		System.out.println(ceil[0]);

		bst.findCeilUsingQueue(root, 12);
		System.out.println("Ceil value using queue:");
		System.out.println(ceil[0]);

		//Ceil using Iterative solution. This is video solution L41
		System.out.println("Ceil value using iterative: ");
		System.out.println(bst.ceilIterative(root,12));

		//Floor using Iterative solution L42
		System.out.println("Floor value using iterative:");
		System.out.println(bst.floorIterative(root,12));

		//Kth Smallest element
		System.out.println("Kth smallest element:");
		System.out.println(bst.kthSmallestElement(root,3));

		//Kth Smallest element
		System.out.println("Kth largest element:");
		System.out.println(bst.kthLargestElement(root,9));

		//Valid BST
		System.out.println("Valid BST:");
		System.out.println(bst.validBST(root));

		//LCA BST
		System.out.println("LCA BST:");
		System.out.println(bst.lcaBST(root,3,10));

		System.out.println("LCA BST Iterative:");
		System.out.println(bst.lowestCommonAncestor(root,3,10));

		//Inorder Successor BST
		System.out.println("Inorder successor BST:");
		System.out.println(bst.inorderSuccessorBST(root,6));

		//Inorder Predecessor BST
		System.out.println("Inorder predecessor BST:");
		System.out.println(bst.inorderPredecessorBST(root,6));

		//Two Sum BST
		System.out.println("Two Sum BST:");
		//1st approach
		//find inorder and then use 2 pointer so TC :O(n)+O(n) SC:O(n)
		System.out.println(bst.twoSumBST(root,20));

		System.out.println("Inorder traversal of BST is: ");
		bst.inorder(root);

		//LC44
		System.out.println("Delete a node: ");
		bst.delete(root, 5);
		System.out.println("Tree after deletion is: ");
		System.out.println("Inorder traversal of BST is: ");
		bst.inorder(root);

		System.out.println();
		System.out.println("Preorder traversal of BST is: ");
		bst.preorder(root);
		System.out.println();
		System.out.println("Postorder traversal of BST is: ");
		bst.postorder(root);
		System.out.println();
		System.out.println("Level order traversal of BST is: ");
		bst.levelorder(root);

		System.out.println("Printing range: ");
		bst.printRange(root, 3, 11);
		System.out.println();
		System.out.println("Root to Leaf path: ");
		bst.rootToLeaf(root);
		System.out.println("Maximum depth of tree: ");
		System.out.println(bst.maxDepth(root));
	}
}
