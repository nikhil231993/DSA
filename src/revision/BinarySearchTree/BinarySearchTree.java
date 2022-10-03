package revision.BinarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree {

	public Node insert(Node root, int value) {
		if(root==null) {
			root = new Node(value);
			return root;
		}
		if(root.data>value){
			root.left=insert(root.left,value);
		}else if(root.data<value) {
			root.right=insert(root.right, value);
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

	public boolean search(Node root, int value) {
		if (root == null)
			return false;

		if (root.data < value) {
			return search(root.right, value);
		} else if (root.data > value) {
			return search(root.left, value);
		} else {
			return true;
		}


	}

	public Node delete(Node root, int value) {

		if (root == null)
			return null;
		if (root.data < value)
			root.right = delete(root.right, value);
		else if (root.data > value)
			root.left = delete(root.left, value);
		else {
			if (root.left == null && root.right == null)
				return null;
			if (root.right == null) {
				return root.left;
			} else if (root.left == null) {
				return root.right;
			}

			Node iS = inOrderSuccessor(root.right);
			root.data = iS.data;
			root.right = delete(root.right, iS.data);
		}
		return root;

	}

	private Node inOrderSuccessor(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	public void printRange(Node root, int lower, int upper) {
		
		if(root==null)
			return;
		if (root.data >= lower && root.data <= upper) {
			printRange(root.left, lower, upper);
			System.out.println(root.data + "-->");
			printRange(root.right, lower, upper);
		} else if (root.data <= lower)
			printRange(root.left, lower, upper);
		else if (root.data >= lower)
			printRange(root.right, lower, upper);

	}

	private ArrayList<Integer> arrList = new ArrayList<Integer>();
	public void rootToLeaf(Node root) {
		if (root == null)
			return;

		arrList.add(root.data);

		if (root.left == null && root.right == null)
			print(arrList);
		else {
			rootToLeaf(root.left);
			rootToLeaf(root.right);
		}

		arrList.remove(arrList.size() - 1);

	}

	private void print(ArrayList<Integer> arrList) {
		for (Integer num : arrList) {
			System.out.print(num + "-->");
		}

	}

}
