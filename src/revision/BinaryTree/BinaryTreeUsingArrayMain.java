package revision.BinaryTree;

public class BinaryTreeUsingArrayMain {

	public static void main(String[] args) {

		System.out.println("\nCreating a blank Array to store Binary Tree...");
		BinaryTreeUsingArray bt = new BinaryTreeUsingArray(10);

		System.out.println("\nInserting 10 values in the Tree...");
		for (int i = 1; i <= 10; i++) {
//			System.out.println("Inserted: " + i);
			bt.insert(i);
		}

		// Level order Traversal
		System.out.println("\nLevel-order Traversal:");
		bt.levelOrder();

		// Pre order Traversal
		System.out.println("\n\nPre-order Traversal:");
		bt.preOrder(1);

		// Post order Traversal
		System.out.println("\n\nPost-order Traversal:");
		bt.postOrder(1);

		// In order Traversal
		System.out.println("\n\nIn-order Traversal:");
		bt.inOrder(1);

		// Search for value in Tree
		System.out.println("\n\nSearching value 500 in the tree...");
		bt.search(500);

		// Search for value in Tree
		System.out.println("Searching value 40 in the tree...");
		bt.search(40);

		// Delete value from Tree
		System.out.println("\nDeleting node 5from the tree...");
		bt.delete(5);

		// Delete value from Tree
		System.out.println("Deleting node 4 from the tree...");
		bt.delete(4);

		// Level order Traverse
		System.out.println("\nLevel-order Traversal:");
		bt.levelOrder();

		// Delete the entire Tree
		System.out.println("\n\nDeleting the entire Tree...");
		bt.deleteTree();
	}
}
