package learningLogic.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	Node root;

	public class Node {
		int data;
		Node right;
		Node left;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}

	}

	public void insert(int data) {

		Node node = new Node(data);
		if (root == null) {
			root = node;
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp;
		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.left == null) {
				temp.left = node;
				break;
			} else
				q.add(temp.left);

			if (temp.right == null) {
				temp.right = node;
				break;
			} else
				q.add(temp.right);
		}

	}

	public void inorder(Node temp) {
		if (temp == null)
			return;
		inorder(temp.left);
		System.out.print(temp.data + " ");
		inorder(temp.right);

	}

}
