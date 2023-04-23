package leetcode.binarytree;

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

		System.out.println("Deleting a value from binary tree: ");
		bt.deleteFromBinaryTree(bt.root, 20);

		System.out.println("\nLevel order traversal data after replacement with deepest node is : ");
		bt.levelOrderTraversal(bt.root);

		System.out.println();

		// Leetcode
		// LC 102
		System.out.println("Level order Traversal and adding to list:");
		List<List<Integer>> result = bt.levelOrder(bt.root);
		System.out.println(result);

		// Iterative preorder traversal
		System.out.println("Iterative preorder traversal");
		bt.iterativePreOrder(bt.root);

		// Iterative inorder traversal
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
		System.out.println("Boundary traversal: ");
		System.out.println(bt.boundaryTraversal(bt.root));

		// Vertical traversal
		System.out.println();
		bt.insert(60);
		System.out.println("Vertical traversal: ");
		System.out.println(bt.verticalTraversal(bt.root));

		// Top View
		System.out.println();
		bt.insert(70);
		System.out.println("Top View: ");
		System.out.println(bt.topView(bt.root));

		// Bottom View
		System.out.println();
		System.out.println("Bottom View: ");
		System.out.println(bt.bottomView(bt.root));

		// Right View
		System.out.println();
		System.out.println("Right View: ");
		System.out.println(bt.rightViewBinaryTree(bt.root));

		// Left View
		System.out.println();
		System.out.println("Left View: ");
		System.out.println(bt.leftViewBinaryTree(bt.root));

		// Symmetric tree
		System.out.println();
		System.out.println("Symmetric tree: ");
		System.out.println(bt.isSymmetric(bt.root));

		// Symmetric tree
		System.out.println();
		System.out.println("Root to node: ");
		System.out.println(bt.rootToNode(bt.root, 60));

		// Path sum
		System.out.println();
		System.out.println("Path sum: ");
		System.out.println(bt.pathSum(bt.root, 60));

		// Max Wdith of a binary tree
		System.out.println();
		System.out.println("Max Width of a binary tree: ");
		System.out.println(bt.maxWdithOfBinaryTree(bt.root));

		// Children Sum Property
		System.out.println();
		System.out.println("Children Sum Property: ");
		bt.childrenSumProperty(bt.root);

		System.out.println("Level order Traversal and adding to list:");
		List<List<Integer>> r = bt.levelOrder(bt.root);
		System.out.println(r);

		// Nodes at K distance from a given node
		System.out.println();
		System.out.println("Nodes at K distance from given node: ");
		System.out.println(bt.NodesAtKDistanceFromGivenNode(bt.root, bt.root.left, 2));

		// Burn a tree
		System.out.println();
		System.out.println("Burn a tree: ");
		System.out.println(bt.burnTree(bt.root, 100));

		// Count nodes in a Binary tree
		System.out.println();
		System.out.println("Count nodes in a binary tree: ");
		System.out.println(bt.countNodes(bt.root));


	}

}
