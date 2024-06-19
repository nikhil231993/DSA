package revision.BinaryTree;

public class BinaryTreeUsingLinkedListMain {

	public static void main(String[] args) {

		BinaryTreeUsingLinkedList bt = new BinaryTreeUsingLinkedList();
		bt.insert(10);
		bt.insert(20);
		bt.insert(30);
		bt.insert(40);
		bt.insert(50);

		System.out.println("In order traversal data is : ");
		bt.inOrderTraversal(bt.root);

		System.out.println("\nPre order traversal data is : ");
		bt.preOrderTraversal(bt.root);

		System.out.println("\nPost order traversal data is : ");
		bt.postorderTraversal(bt.root);

		System.out.println("\nLevel order traversal data is : ");
		bt.levelOrderTraversal(bt.root);

		System.out.println("\nSearching value in Tree:");

		System.out.println("\nUsing preorder traversal");
		bt.inDepthFirstSearch(bt.root, 20);

		System.out.println("\nUsing Level order traversal");
		bt.breadthFirstSearch(bt.root, 50);

		System.out.println("Deleting a value from binary tree: ");
		bt.deleteFromBinaryTree(bt.root, 20);

		System.out.println("\nLevel order traversal data after replacement with deepest node is : ");
		bt.levelOrderTraversal(bt.root);
	}
}
