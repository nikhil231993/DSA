package leetcode.binarysearchtree;

import revision.BinarySearchTree.BinarySearchTreeRevision;
import revision.BinarySearchTree.Node;

public class BinarySearchTreeMain {

	public static void main(String[] args) {
		revision.BinarySearchTree.BinarySearchTreeRevision bst = new BinarySearchTreeRevision();
		Node root = null;
		root = bst.insert(root, 8);
		System.out.println(root.hashCode());
		root = bst.insert(root, 5);
		System.out.println(root.hashCode());
		root = bst.insert(root, 3);
		System.out.println(root.hashCode());
		root = bst.insert(root, 1);
		System.out.println(root.hashCode());
		root = bst.insert(root, 4);
		System.out.println(root.hashCode());
		root = bst.insert(root, 6);
		System.out.println(root.hashCode());
		root = bst.insert(root, 10);
		System.out.println(root.hashCode());
		root = bst.insert(root, 11);
		System.out.println(root.hashCode());
		root = bst.insert(root, 14);
		System.out.println(root.hashCode());
		System.out.println("Inorder traversal of BST is: ");
		bst.inorder(root);
		System.out.println();
		System.out.println("Value found is: " + bst.search(root, 30));
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
		System.out.println("Levelorder traversal of BST is: ");
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
