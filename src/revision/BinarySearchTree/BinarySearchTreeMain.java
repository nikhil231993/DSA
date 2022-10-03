package revision.BinarySearchTree;

public class BinarySearchTreeMain {

	public static void main(String[] args) {
		BinarySearchTreeRevision bst = new BinarySearchTreeRevision();
		Node root = null;
		root = bst.insert(root, 8);
		root = bst.insert(root, 5);
		root = bst.insert(root, 3);
		root = bst.insert(root, 1);
		root = bst.insert(root, 4);
		root = bst.insert(root, 6);
		root = bst.insert(root, 10);
		root = bst.insert(root, 11);
		root = bst.insert(root, 14);
		System.out.println("Inorder traversal of BST is: ");
		bst.inorder(root);
		System.out.println();
		System.out.println("Value found is: " + bst.search(root, 30));
		System.out.println("Delete a node: ");
		bst.delete(root, 5);
		System.out.println("Tree after deletion is: ");
		bst.inorder(root);
		System.out.println();
		System.out.println("Printing range: ");
		bst.printRange(root, 3, 11);
		System.out.println();
		System.out.println("Root to Leaf path: ");
		bst.rootToLeaf(root);
	}

}
