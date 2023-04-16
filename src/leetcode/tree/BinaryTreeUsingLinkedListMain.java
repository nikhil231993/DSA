package leetcode.tree;

import java.util.List;

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
		System.out.println("\nUsing inorder traversal");
		bt.inDepthFirstSearch(bt.root, 50);
		System.out.println("\nUsing Level order traversal");
		bt.breadthFirstSearch(bt.root, 50);
		System.out.println("Deleting a value from bianry tree: ");
		bt.deleteFromBinaryTree(bt.root, 20);
		System.out.println("\nLevel order traversal data after replacement with deepest node is : ");
		bt.levelOrderTraversal(bt.root);

		System.out.println();

		// Leetcode
		// LC 102
		List<List<Integer>> result = bt.levelOrder(bt.root);
		System.out.println(result);

		// Iterative preorder trversal
		System.out.println("Iterative preorder traversal");
		bt.iterativePreOrder(bt.root);

		// Iterative inorder trversal
		System.out.println();
		System.out.println("Iterative inorder traversal");
		List<Integer> iterInOrder = bt.iterativeInOrder(bt.root);
		System.out.println(iterInOrder);

		// Iterative postorder trversal using 2 stack
		System.out.println();
		System.out.println("Iterative postorder traversal using two stack");
		List<Integer> postOrder = bt.iterativPostOrder(bt.root);
		System.out.println(postOrder);

		// Iterative postorder trversal using 1 stack
		System.out.println();
		System.out.println("Iterative postorder traversal using one stack");
		List<Integer> postOrderUsing1Stack = bt.iterativPostOrderUsing1Stack(bt.root);
		System.out.println(postOrderUsing1Stack);

		// Iterative preorder, inorder and postorder trversal using 1 stack
		System.out.println();
		System.out.println("Iterative postorder traversal using one stack");
		List<List<Integer>> allInOne = bt.allTraversalsStack(bt.root);
		System.out.println(allInOne);

		// Max Depth
		System.out.println();
		System.out.println("Max Depth Recursive: ");
		System.out.println(bt.maxDepthRecursive(bt.root));

		// Max Depth Iterative
		System.out.println();
		System.out.println("Max Depth Iterative: ");
		System.out.println(bt.maxDepthIterative(bt.root));

		// Is Balanced
		System.out.println();
		System.out.println("Is balanced: ");
		System.out.println(bt.isBalanced(bt.root));

		// Diameter BT
		System.out.println();
		System.out.println("Diameter: ");
		System.out.println(bt.diameter(bt.root));

		// Max Path BT
		System.out.println();
		System.out.println("Max Path: ");
		System.out.println(bt.maxPath(bt.root));

		// Zig zag traversal
		System.out.println();
		System.out.println("Zig zag: ");
		System.out.println(bt.zigZag(bt.root));

		// Boundary traversal
		System.out.println();
		System.out.println("Zig zag: ");
		System.out.println(bt.boundaryTraversal(bt.root));

	}

}
