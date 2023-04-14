package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeUsingLinkedList {

	Node root;

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
			
			if(temp.right==null) {
				temp.right = node;
				return;
			}else {
				queue.add(temp.right);
			}
		}
	}

	public void inOrderTraversal(Node root) {
		if (root == null)
			return;
		else {
			inOrderTraversal(root.left);
			System.out.print(root.data + "-->");
			inOrderTraversal(root.right);
		}

	}

	public void preOrderTraversal(Node root) {
		if (root == null)
			return;
		else {
			System.out.print(root.data + "-->");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}

	}

	public void postorderTraversal(Node root) {
		if (root == null)
			return;
		else {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + "-->");
		}

	}

	public void levelOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
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

	}

	private int pos = 0;
	public void inDepthFirstSearch(Node root, int data) {
		if (root == null) {
			return;
		} else {
			pos++;

			if (root.data == data) {
				System.out.println("value is found at: " + pos);
				return;
			}
			inDepthFirstSearch(root.left, data);
			inDepthFirstSearch(root.right, data);
		}

	}

	public void breadthFirstSearch(Node root, int data) {
		if (root == null) {
			return;
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			int loc=0;
			while (!queue.isEmpty()) {
				loc++;
				Node temp = queue.peek();
				queue.remove();
				if(temp.data==data) {
					System.out.println("value is found at: " + loc);
					return;
				}
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}

	}

	public void deleteFromBinaryTree(Node root, int value) {

		if (root == null)
			return;
		else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {

				Node temp = queue.peek();
				queue.remove();
				if (temp.data == value) {
					Node deep = deepestNode();
					System.out.println();
					System.out.println("Deepest node is: " + deep.data);
					temp.data = deep.data;
					deleteDeepestNode(root);

				}
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}

	}

	private void deleteDeepestNode(Node root) {
		if(root==null) 
			return;
		else {
			Queue<Node> queue=new LinkedList<Node>();
			queue.add(root);
			Node previousNode=null;
			Node currentNode=null;
			while (!queue.isEmpty()) {
				previousNode = currentNode;
				currentNode = queue.peek();
				queue.remove();
				if(currentNode.left==null) {
					previousNode.right=null;
							return;
				}
				if (currentNode.right == null) {
					currentNode.left=null;
					return;
				}

				queue.add(currentNode.left);
				queue.add(currentNode.right);
			}
		}
		

	}

	private Node deepestNode() {
		Node temp=null;
		if (root == null) {
			return null;
		} else {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {
				temp = queue.peek();
				queue.remove();
				System.out.print(temp.data + "-->");
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);

			}
		}
		return temp;
	}

	public List<List<Integer>> levelOrder(Node root) {
		if (root == null)
			return new ArrayList<>();

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		List<List<Integer>> list = new ArrayList<>();

		while (!q.isEmpty()) {
			List<Integer> l = new ArrayList();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node temp = q.poll();
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
				l.add(temp.data);
			}
			list.add(l);
			// TC:O(n) as we have to parse all elements
			// SC:O(n) as we havr to store all elements also we do not consider l list as
			// its small;

		}
		return list;

	}

}
