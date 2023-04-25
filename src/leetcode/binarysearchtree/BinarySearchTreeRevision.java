package leetcode.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinarySearchTreeRevision {

	public Node insert(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		if (root.data > value) {
			root.left = insert(root.left, value);
		} else if (root.data < value) {
			root.right = insert(root.right, value);
		}

		return root;
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + "-->");
			inorder(root.right);
		}

	}

	public void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data + "-->");
			preorder(root.left);
			preorder(root.right);
		}

	}

	public void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + "-->");
		}

	}

	public boolean search(Node root, int value) {

		if (root == null)
			return false;
		if (root.data == value)
			return true;
		else if (root.data < value)
			return search(root.right, value);
		else
			return search(root.left, value);
	}

	public Node delete(Node root, int value) {
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

			Node iS = inOrderSuccessor(root.right);
			root.data = iS.data;
			root.right = delete(root.right, iS.data);
		}
		return root;

	}

	private Node inOrderSuccessor(Node root) {
		while (root.left != null)
			root = root.left;
		return root;
	}

	public void printRange(Node root, int l, int u) {
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

	public void rootToLeaf(Node root) {
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

	public void levelorder(Node root) {
		if(root==null)
			return;
		else {
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while (!q.isEmpty()) {
				Node temp = q.peek();
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

	public  int maxSumBST(Node root) {
		return largestBSTSubtreeHelper(root).maxSize;
	}

	private  NodeValue largestBSTSubtreeHelper(Node root) {
		// An empty tree is a BST of size 0.
		if (root == null) {
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		// Get values from left and right subtree of current tree.
		NodeValue left = largestBSTSubtreeHelper(root.left);
		NodeValue right = largestBSTSubtreeHelper(root.right);

		// Current node is greater than max in left AND smaller than min in right, it is a BST.
		if (left.maxNode < root.data && root.data < right.minNode) {
			// It is a BST.
			return new NodeValue(  Math.min(root.data, left.minNode),Math.max(root.data, right.maxNode),left.maxSize + right.maxSize + 1);
		}

		// Otherwise, return [-inf, inf] so that parent can't be valid BST
		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,
				Math.max(left.maxSize, right.maxSize));
	}

	public void inorderRecoverBST(Node root, List<Integer> list) {

		if(root==null)
			return;
		inorderRecoverBST(root.left,list);
		list.add(root.data);
		inorderRecoverBST(root.right,list);
	}

	//below elements are used to recover BST
	private Node first;
	private Node last;
	private Node middle;
	private Node prev;
	public void recover(Node root) {
		prev=new Node(Integer.MIN_VALUE);
		inorderRecover(root);

		if(first!=null && last!=null){
			int t=first.data;
			first.data=last.data;
			last.data=t;
		}else if(first!=null && middle!=null){
			int t=first.data;
			first.data=middle.data;
			middle.data=t;
		}
	}

	private void inorderRecover(Node root) {
		if(root==null)
			return;

		inorderRecover(root.left);
		if(prev!=null && root.data<prev.data){
			if(first==null){
				first=prev;
				middle=root;
			}else
				last=root;
		}
		prev=root;
		inorderRecover(root.right);
	}
}
