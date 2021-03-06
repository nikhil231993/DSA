package learningLogic.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinkedListRevision {

	public Node root;

	class Node {
		private Node left;
		private Node right;
		private int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void insert(int data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.peek();
			queue.remove();

			if (temp.left == null) {
				temp.left = node;
				return;
			} else {
				queue.add(temp.left);
			}

			if (temp.right == null) {
				temp.right = node;
				return;
			} else {
				queue.add(temp.right);
			}
		}

	}

	public void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + "-->");
			inOrderTraversal(node.right);
		}

	}

	public void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.data + "-->");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}

	}

	public void postorderTraversal(Node node) {
		if (node != null) {
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.data + "-->");
		}
	}

	public void levelOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node temp = queue.peek();
			queue.remove();
			System.out.print(temp.data + "-->");
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}

	}
	
	private int count=0;

	public void inDepthFirstSearch(Node node, int value) {
		if (node == null) {
			return;
		} else if (node != null) {
			if (node.data == value) {
				System.out.println("Value is found at: " + count +" and value is :"+node.data);
				return;

			}
			count++;
			inDepthFirstSearch(node.left, value);
			inDepthFirstSearch(node.right, value);
		}

	}

	public void breadthFirstSearch(Node root, int value) {
		int count=0;
		if(root==null)
			return;
		else {
			Queue<Node> q=new LinkedList<Node>();
			q.add(root);
			while(!q.isEmpty()) {
				
				Node temp=q.peek();
				q.remove();
				if(temp.data==value) {
					System.out.println("Value is found at: " + count +" and value is :"+temp.data);
					return;
				}
				count++;
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
		
	}
}
