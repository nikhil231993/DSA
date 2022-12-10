package revision.AVL;

import java.util.LinkedList;
import java.util.Queue;

public class UsingRootAVLTree {

	Node root;

	public void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.key + "-- >");
			preOrder(root.left);
			preOrder(root.right);
		}

	}


	public void levelOrderTraversal(Node root) {
		if(root==null) {
			System.out.println("AVL Tree is empty ");
			return;
		}
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp=q.peek();
			q.remove();
			System.out.print(temp.key + "-->");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}

	}

	public void breadthFirstSearch(Node root, int value) {
		if (root == null) {
			System.out.println("AVL Tree is empty ");
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.peek();
			q.remove();
			if (temp.key == value) {
				System.out.println("Element is found");
				return;
			}
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}
		System.out.println("Element is not found");

	}

	void insertValue(int data) {
		
		root = insert(root, data);
	}

	public Node insert(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}
		if (root.key > value) {
			root.left = insert(root.left, value);
		} else if (root.key < value) {
			root.right = insert(root.right, value);
		} else
			return root;
		
		root.height = 1 + Math.max(height(root.left), height(root.right));
		
		int balance = getBalance(root);

		if (balance > 1) {
			if (value < root.left.key) {
				return rightRotate(root);
			} else if (value > root.left.key) {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		} else if (balance < -1) {
			if (value > root.right.key) {
				return leftRotate(root);
			} else if (value < root.right.key) {
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}

		return root;

	}

	Node leftRotate(Node y) {
		Node x = y.right;
		Node T2 = x.left;

		x.left = y;
		y.right = T2;

		y.height = 1 + Math.max(height(y.left), height(y.right));
		x.height = 1 + Math.max(height(x.left), height(x.right));

		return x;
	}

	Node rightRotate(Node x) {
		Node y = x.left;
		Node T2 = y.right;
		
		y.right = x;
		x.left = T2;

		y.height = 1 + Math.max(height(y.left), height(y.right));
		x.height = 1 + Math.max(height(x.left), height(x.right));

		return y;
	}


	private int getBalance(Node node) {
		if (node == null)
			return -1;
		return height(node.left) - height(node.right);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		return node.height;
	}

	public Node deleteNode(Node node, int value) {
		if (node == null) {
			System.out.println("AVL tree is empty");
			return null;
		}
		if (value > node.key) {
			node.left = deleteNode(node.left, value);
		} else if (value < node.key) {
			node.right = deleteNode(node.right, value);
		} else {
			if (node.left == null && node.right == null)
				return null;
			else if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;

			Node iS = successor(node.right);
			node.key=iS.key;
			node.right = deleteNode(node.right, iS.key);
		}

//		if (node == null)
//			return node;

		node.height = 1 + Math.max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1) {
			if (value < node.left.key) {
				return rightRotate(node);
			} else if (value > node.left.key) {
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		} else if (balance < -1) {
			if (value > node.right.key) {
				return leftRotate(node);
			} else if (value < node.right.key) {
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}

		return node;

	}

	private Node successor(Node node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

}
