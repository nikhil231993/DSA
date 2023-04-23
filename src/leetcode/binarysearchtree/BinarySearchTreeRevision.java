package leetcode.binarysearchtree;

import revision.BinarySearchTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTreeRevision {

	public revision.BinarySearchTree.Node insert(revision.BinarySearchTree.Node root, int value) {
		if (root == null) {
			root = new revision.BinarySearchTree.Node(value);
			return root;
		}

		if (root.data > value) {
			root.left = insert(root.left, value);
		} else if (root.data < value) {
			root.right = insert(root.right, value);
		}

		return root;
	}

	public void inorder(revision.BinarySearchTree.Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "-->");
			inorder(root.right);
		}

	}

	public void preorder(revision.BinarySearchTree.Node root) {
		if (root != null) {
			System.out.print(root.data + "-->");
			preorder(root.left);
			preorder(root.right);
		}

	}

	public void postorder(revision.BinarySearchTree.Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + "-->");
		}

	}

	public boolean search(revision.BinarySearchTree.Node root, int value) {

		if (root == null)
			return false;
		if (root.data == value)
			return true;
		else if (root.data < value)
			return search(root.right, value);
		else
			return search(root.left, value);
	}

	public revision.BinarySearchTree.Node delete(revision.BinarySearchTree.Node root, int value) {
		if (root == null)
			return null;
		if (root.data < value) {
			root.right = delete(root.right, value);
		} else if (root.data > value)
			root.left = delete(root.left, value);
		else {
			if (root.left == null && root.right == null)
				return null;
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			revision.BinarySearchTree.Node iS = inOrderSuccessor(root.right);
			root.data = iS.data;
			root.right = delete(root.right, iS.data);
		}
		return root;

	}

	private revision.BinarySearchTree.Node inOrderSuccessor(revision.BinarySearchTree.Node root) {
		while (root.left != null)
			root = root.left;
		return root;
	}

	public void printRange(revision.BinarySearchTree.Node root, int l, int u) {
		if(root==null)
			return;
		if(root.data >=l && root.data <=u) {
			printRange(root.left, l,u);
			System.out.print(root.data + "-->");
			printRange(root.right, l,u);
		} else if (root.data <= l) {
			printRange(root.left, l, u);
		} else if (root.data >= u) {
			printRange(root.right, l, u);
		}

	}

	private ArrayList<Integer> arr = new ArrayList<Integer>();

	public void rootToLeaf(revision.BinarySearchTree.Node root) {
		if (root == null)
			return;

		arr.add(root.data);

		if (root.left == null && root.right == null)
			print(arr);
		else {
			rootToLeaf(root.left);
			rootToLeaf(root.right);
		}

		arr.remove(arr.size() - 1);

	}

	private void print(ArrayList<Integer> arr) {
		for (Integer n : arr) {
			System.out.print(n + "-->");
		}
		System.out.println("Next Leaf is:  ");

	}

	public void levelorder(revision.BinarySearchTree.Node root) {
		if(root==null)
			return;
		else {
			Queue<revision.BinarySearchTree.Node> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				revision.BinarySearchTree.Node temp = q.peek();
				q.remove();
				System.out.print(temp.data + "-->");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}

		}

	}

	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

	}

}
