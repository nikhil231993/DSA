package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeUsingLinkedListMain {

	public static void main(String[] args) {

		BinaryTreeUsingLinkedList bt = new BinaryTreeUsingLinkedList();
		bt.insert(10);
		bt.insert(20);
		bt.insert(30);
		bt.insert(40);
		bt.insert(50);
//		bt.insert(60);

		System.out.println("Inorder traversal data is : ");
		bt.inOrderTraversal(bt.root);

		System.out.println("\nPre order traversal data is : ");
		bt.preOrderTraversal(bt.root);

		System.out.println("\nPost order traversal data is : ");
		bt.postorderTraversal(bt.root);

		System.out.println("\nLevel order traversal data is : ");
		bt.levelOrderTraversal(bt.root);

		System.out.println("\nSearching value in BT(Binary Tree) Using Inorder Traversal:");
		bt.inDepthFirstSearch(bt.root, 50);

		System.out.println("\nSearching value in BT Using Level order Traversal");
		bt.breadthFirstSearch(bt.root, 50);

		System.out.println("Deleting a value from BT: ");
		bt.deleteFromBinaryTree(bt.root, 20);

		System.out.println("\nLevel order traversal data after replacement with deepest node is : ");
		bt.levelOrderTraversal(bt.root);

		System.out.println();

		// Leetcode
		// LC 102
		System.out.println("Level order Traversal and adding to list: ");
		List<List<Integer>> result1 = bt.levelOrder(bt.root);
		System.out.println(result1);

		// Iterative preorder traversal
		System.out.println("Iterative preorder traversal: ");
		List<Integer> ans=bt.iterativePreOrder(bt.root);
		System.out.println(ans);

		// Iterative inorder traversal
		System.out.println();
		System.out.println("Iterative inorder traversal: ");
		List<Integer> iterInOrder = bt.iterativeInOrder(bt.root);
		System.out.println(iterInOrder);

		// Iterative postorder traversal using 2 stack
		System.out.println();
		System.out.println("Iterative postorder traversal using two stack: ");
		List<Integer> postOrder = bt.iterativPostOrder(bt.root);
		System.out.println(postOrder);

		// Iterative postorder traversal using 1 stack
		System.out.println();
		System.out.println("Iterative postorder traversal using one stack: ");
		List<Integer> postOrderUsing1Stack = bt.iterativPostOrderUsing1Stack(bt.root);
		System.out.println(postOrderUsing1Stack);

		// Iterative preorder, inorder and postorder traversal using 1 stack
		System.out.println();
		System.out.println("Iterative preorder, inorder and postorder traversal using 1 stack: ");
		List<List<Integer>> allInOne = bt.allTraversalsStack(bt.root);
		System.out.println(allInOne);

		// Max Depth
		System.out.println();
		System.out.println("Max Depth Recursive: ");
		System.out.println(bt.maxDepthRecursive(bt.root)); // can be done using iterative traversal as well
		//worst case is complete binary tree in iterative
		//worst case is skewed tree in recursive traversal

		// Max Depth Iterative
		System.out.println();
		System.out.println("Max Depth Iterative: ");
		System.out.println(bt.maxDepthIterative(bt.root));

		// Is Balanced
		System.out.println();
		System.out.println("Is balanced: ");
		System.out.println(bt.isBalanced(bt.root));

		// Diameter BT
		//It is the longest path between any two nodes and this path
		//does not need to pass through root
		System.out.println();
		System.out.println("Diameter: ");
		System.out.println(bt.diameter(bt.root));

		// Max Path BT
		System.out.println();
		System.out.println("Max Path Sum: ");
		System.out.println(bt.maxPath(bt.root));

		//Same Tree Video 19 can be done using level order traversal also

		// Zig zag traversal
		System.out.println();
		System.out.println("Zig Zag Traversal: ");
		System.out.println(bt.zigZag(bt.root));

		// Boundary traversal
		System.out.println();
		System.out.println("Boundary Traversal: ");
		System.out.println(bt.boundaryTraversal(bt.root));

		// Vertical traversal
		System.out.println();
		bt.insert(60);
		System.out.println("Vertical Traversal: ");
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
		System.out.println(bt.rightViewBinaryTree(bt.root)); // we can use level order but TC is O(n)  and SC:O(n)
		//Recursive SC is less

		// Left View
		System.out.println();
		System.out.println("Left View: ");
		System.out.println(bt.leftViewBinaryTree(bt.root));

		// Symmetric tree
		System.out.println();
		System.out.println("Symmetric tree: ");
		System.out.println(bt.isSymmetric(bt.root));

		// Root To Node
		System.out.println();
		System.out.println("Root to node: ");
		System.out.println(bt.rootToNode(bt.root, 60));

		//Root To Leaf Paths
		System.out.println();
		System.out.println("All paths from root to leafs are :");
		List<List<Integer>> paths= new ArrayList<>();
		bt.rootToLeafs(paths, bt.root, new ArrayList<>());
		System.out.println(paths);

		System.out.println("Level order Traversal and adding to list. This is just to verify above result is correct or not ");
		List<List<Integer>> result2 = bt.levelOrder(bt.root);
		System.out.println(result2);

		// Path sum
		System.out.println();
		System.out.println("Path sum: ");
		System.out.println(bt.pathSum(bt.root, 60));

		// Max Width of a binary tree
		System.out.println();
		System.out.println("Max Width of a binary tree: ");
		System.out.println(bt.maxWdithOfBinaryTree(bt.root));

		// Children Sum Property
		System.out.println();
		System.out.println("Children Sum Property: ");
		bt.childrenSumProperty(bt.root);

		System.out.println("Level order Traversal and adding to list:");
		List<List<Integer>> r1= bt.levelOrder(bt.root);
		System.out.println(r1);

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

		// Morris Traversal inorder
		System.out.println();
		System.out.println("Inorder Morris traversal: ");
		System.out.println(bt.inorderMorris(bt.root));

		// Morris Traversal inorder
		System.out.println();
		System.out.println("Preorder Morris traversal: ");
		System.out.println(bt.preorderMorris(bt.root));

		// Flatten BT using Recursion
		System.out.println();
		System.out.println("Flatten BT using Recursion: ");
		bt.flattenRecursion(bt.root);

		// Flatten BT using Iteration
		System.out.println();
		System.out.println("Flatten BT using Iteration: ");
		bt.flattenIteration(bt.root);

		// Flatten BT using Morris Traversal
		System.out.println();
		System.out.println("Flatten BT using Morris Traversal: ");
		bt.flattenMorris(bt.root);
	}
}
